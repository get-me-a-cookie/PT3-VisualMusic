package Model;

import java.io.File;
import java.io.IOException;
import java.util.Observable;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.UnsupportedAudioFileException;

import flanagan.complex.Complex;
import flanagan.math.FourierTransform;

/** 
 *
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
 * 
 * @author goodw
 */
public class Model_Musique extends Observable implements Runnable {

	//TODO voir pour pré-load la musique
	
	/**
	 * Ligne permettant l'écoute audio
	 * Sort en son, ce qu'il y a écrit dedans
	 */
	private SourceDataLine line;
	
	/**
	 * Sert à transformer le fichier ouvert en 
	 * fichier ouvert à la lecture multimédia
	 * 
	 * Courant d'entrée audio
	 */
	private AudioInputStream audioInputStream;
	
	/**
	 * Réfère tous les champs spécifique qu format audio
	 */
	private AudioFormat audioFormat; 
	
	/**
	 * Stock les fréquences des octects lus lors 
	 * de l'écoute de la musique
	 */
	private double frequence;
	
	/**
	 * Tranformé rapide de Fourrier
	 * Sert à passer du signal temporel de la musique
	 * au spectre fréquentiel
	 */
	private static FourierTransform FFT = new FourierTransform();

	/**
	 * Définis si la lecture doit être en pause ou non
	 * true  : la lecture s'arrète
	 * false : la lecture continue/commence
	 */
	private boolean pause = true;

	/**
	 * Définis si un fichier à été chargé (initialisé) et convertis en line
	 */
	private boolean load = false;

	/**
	 * ajoute le model en observer afin de pouvoir actualiser
	 * l'affichage dès un changement de fréquence
	 */
	public Model_Musique(Model m) {
		
		super();
		this.addObserver(m);
		
	}

	/**
	 * Initialise la lecture de la musique
	 * 	A éxécuter avant la méthode Thread.start(), sinon erreur
	 * 
	 * @param file : le fichier audio a ouvrir
	 * @return un boolean, afin de voir si la préparation
	 * 	c'est bien passé
	 */
	public boolean initialisation(File file){

		try {
			
			audioInputStream = AudioSystem.getAudioInputStream(file);
			
		} 
		
		catch (UnsupportedAudioFileException e) {
			//TODO message d'erreur
			e.printStackTrace();
			return false;
			
		} 
		
		catch (IOException e) {
			//TODO message d'erreur
			
			e.printStackTrace();
			return false;
			
		}

		audioFormat = audioInputStream.getFormat();

		DataLine.Info info = new DataLine.Info(SourceDataLine.class, audioFormat);

		try {
			
			line = (SourceDataLine) AudioSystem.getLine(info);
			load = true;
			
		} 
		
		catch (LineUnavailableException e) {

			//TODO message d'erreur
			e.printStackTrace();
			return false;
			
		}
		
		return true;
		
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
			
		} 
		
		catch (LineUnavailableException e) {

			//TODO message d'erreur
			e.printStackTrace();
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
					
					for (int index_dans_tableau = 0; 
							index_dans_tableau < tableau_complexe_temporaire.length;
							index_dans_tableau ++) {
						
						frequence = frequence + Math.abs(tableau_complexe_temporaire[index_dans_tableau].getReal());
					
					}
					
					frequence = frequence / tableau_complexe_temporaire.length; //valeur absolue
					
					setChanged();
					notifyObservers();
					
					line.write(bytes, 0, bytesRead);
					
				}
				
				else break;
				
			}
			
			this.reset();
			
		} 
		
		catch (IOException io) {

			//TODO message d'erreur
			io.printStackTrace();
			return;
			
		}
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
	 * @return le format du fichier
	 */
	public AudioFormat getAudioFormat() {
		
		return audioFormat;
		
	}

	/**
	 * Permet d'obtenir la fréquence actuelle du fichier audio
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
	 * @return the load
	 * La méthode permet de connaitre
	 * si la musique est chargé
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
