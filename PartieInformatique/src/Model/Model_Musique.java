package Model;

import java.io.File;
import java.io.IOException;
import java.util.Observable;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.UnsupportedAudioFileException;

import flanagan.complex.Complex;
import flanagan.math.FourierTransform;

/** 
 * Classe de type Model, connu uniquement par la Classe "Model"
 * 
 * Sert à faire du MultiThreading et ainsi permettre la lecture 
 * 	audio tous en étant en possibilité d'affecté celle ci ou l'IG
 * 	en général
 * 	C'est à dire que sans MultiThreading, il était impossible de
 * 	faire pause quand une musique se lancé
 * 
 * Cette classe conserne uniquement la lecture de la musique à partir
 * 	d'un fichier audio composé uniquement de données brutes
 * 
 * Hérite de Observable afin de pouvoir notifié les observer de Model
 * 	quand la fréquence change
 * 	Concrètement, elle n'a qu'un observer, le model.
 * 
 * @author 
 * Goodwin
 * 	Création et implémentation de la classe entière
 */
public class Model_Musique extends Observable implements Runnable {

	/**
	 * Ligne permettant l'écoute audio
	 * Sort en son, ce qu'il y a écrit dedans
	 */
	private SourceDataLine line;

	/**
	 * Sert à transformer le fichier ouvert en 
	 * fichier avec lecture multimédia possible
	 * 
	 * Courant d'entrée audio
	 */
	private AudioInputStream audioInputStream;

	/**
	 * Réfère tous les champs spécifique au format audio
	 */
	private AudioFormat audioFormat; 

	/**
	 * Fréquence transmise aux vues en prenant la 
	 * fréquence maximale d'un son
	 * 
	 * Une FFT est réaliser préalablement pour obtenir 
	 * toutes les fréquences d'un son
	 */
	private double frequence;

	/**
	 * Fast Fourier Tranformation / Tranformé rapide de Fourrier
	 * 
	 * Sert à passer du signal temporel de la musique
	 * au spectre fréquentiel
	 */
	private FourierTransform FFT;

	/**
	 * Définis si la lecture doit être en pause ou non
	 * 
	 * true  : la lecture s'arrète
	 * false : la lecture continue/commence
	 */
	private boolean pause;

	/**
	 * Définis si un fichier à été chargé (initialisé) et convertis en line
	 */
	private boolean load;

	/**
	 * Le model de l'application
	 * 
	 * Sert a pouvoir créé des erreurs et a pouvoir le donné en observer
	 */
	private Model model;

	/**
	 * Constructeur de la classe
	 * 
	 * Ajoute le model en observer afin de pouvoir actualiser
	 * l'affichage dès que la fréquence change
	 */
	public Model_Musique(Model m) {

		super();

		model = m;

		FFT = new FourierTransform();

		pause = true;
		load = false;

		this.addObserver(model);

	}

	/**
	 * Initialise la lecture de la musique
	 * 	A éxécuter avant la méthode Thread.start(), sinon erreur
	 * 
	 * @param file : le fichier audio a ouvrir
	 */
	public void initialisation(File file){

		try {

			audioInputStream = AudioSystem.getAudioInputStream(file);

		} 

		catch (UnsupportedAudioFileException e) {

			model.setErreur(e);
			return;

		} 

		catch (IOException e) {

			model.setErreur(e);
			return;

		}

		audioFormat = audioInputStream.getFormat();

		DataLine.Info info = new DataLine.Info(SourceDataLine.class, audioFormat);

		try {

			line = (SourceDataLine) AudioSystem.getLine(info);
			load = true;

		} 

		catch (LineUnavailableException e) {

			model.setErreur(e);
			return;

		} 		
	} 

	/**
	 * Modifie le volume (gain) de la musique
	 * @param volume
	 */
	public void setVol(float volume) {

		FloatControl control = (FloatControl) line.getControl(FloatControl.Type.MASTER_GAIN);
		control.setValue((float) (20 * Math.log10(volume)));

	}

	/**
	 * Méthode de l'interface parente Runnable
	 * 	permettant l'execution de la méthode Thread.start()
	 * 
	 * Lit la musique en créant un buffer de byte
	 * 
	 * Enfin quand la lecture et finis, ferme le fichier
	 */
	public void run() {	

		pause = false;

		try {

			line.open(audioFormat);

			model.setVolume(model.getVolume());

		} 

		catch (LineUnavailableException e) {

			model.setErreur(e);
			return;

		} 	
		
		catch (Exception e) {

			model.setErreur(e);
			return;

		} 	

		line.start();

		try {

			byte bytes[] = new byte[audioFormat.getSampleSizeInBits()*1024];	//taille de l'echantillon * 1024
			int bytesRead = 0;

			while (!pause) {

				bytesRead = audioInputStream.read(bytes, 0, bytes.length);

				if (bytesRead != -1) {	//si il y a des octets lus

					Complex[] comp = new Complex[bytesRead];	//taille = nb de bytes lus

					for (int index_dans_tableau = 0; 
							index_dans_tableau < bytesRead;
							index_dans_tableau ++) {

						comp[index_dans_tableau] = new Complex(bytes[index_dans_tableau]);

					}

					FFT.setData(comp);
					FFT.transform();
					frequence = 0;
					Complex[] tableau_complexe_temporaire = FFT.getTransformedDataAsComplex();

					double complexMax = Double.MIN_VALUE;

					for (int index_dans_tableau = 0; 
							index_dans_tableau < tableau_complexe_temporaire.length;
							index_dans_tableau ++) {

						double complexTemporaire = Math.abs(tableau_complexe_temporaire[index_dans_tableau].getReal());
						if (complexMax < complexTemporaire) complexMax = complexTemporaire ;

					}

					frequence = complexMax;

					setChanged();
					notifyObservers();

					line.write(bytes, 0, bytesRead);

				}

				else break;

			}			
		} 

		catch (IOException io) {

			model.setErreur(io);
			return;

		} 	

		this.reset();

	}

	/**
	 * Permet de mettre en pause ou en lecture
	 * 
	 * @param b
	 * true  : sera mis en pause
	 * false : sera mis en lecture
	 */
	public void setPause(boolean b) {

		this.pause = b;

	}	

	/**
	 * Permet d'obtenir le format du fichier
	 * 
	 * @return le format du fichier
	 */
	public AudioFormat getAudioFormat() {

		return audioFormat;

	}

	/**
	 * Permet d'obtenir la fréquence actuelle du fichier audio
	 * 
	 * @return la fréquence de la musique 
	 */
	public double getFrequence() {

		return frequence;

	}

	/**
	 * Informe de l'état de la pause
	 * 
	 * @return un boolean informant de l'état de la pause
	 * true  : fichier en pause
	 * false : fichier en lecture
	 */
	public boolean isPause() {

		return pause;

	}

	/**
	 * La méthode permet de connaitre
	 * si la musique est chargé
	 * 
	 * @return
	 * true : fichier chargé
	 * false : fichier non chargé
	 */
	public boolean isLoad() {

		return load;

	}

	/**
	 * Remet tous les argument à null
	 * Afin de remettre à zéro lorsque l'utilisateur
	 * presse "stop" par exemple
	 */
	public void reset() {

		if(!pause) {

			pause = true;
			audioFormat = null;
			audioInputStream = null;
			line.close();
			line = null;
			load = false;

		}
	}	


}
