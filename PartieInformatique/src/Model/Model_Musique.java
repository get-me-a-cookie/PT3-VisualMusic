package Model;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.UnsupportedAudioFileException;

/** 
 * 
 * @author goodw
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
 */
public class Model_Musique implements Runnable {

	//TODO javadoc
	private SourceDataLine line;
	private AudioInputStream audioInputStream;	
	private AudioFormat audioFormat; 

	/**
	 * Définis si la lecture doit être en pause ou non
	 * true  -> la lecture s'arrète
	 * false -> la lecture continue/commence
	 */
	private boolean pause = true;

	/**
	 * Définis si un fichier à été chargé et convertis en line
	 */
	private boolean load = false;

	/**
	 * Initialise la lecture de la musique
	 * 	A éxécuter avant la méthode Thread.start(), sinon erreur
	 * 
	 * @param file -> le fichier audio a ouvrir
	 * @return un boolean, afin de voir si la préparation
	 * 	c'est bien passé
	 */
	public boolean initialisation(File file){

		try {
			audioInputStream = AudioSystem.getAudioInputStream(file);
		} 
		catch (UnsupportedAudioFileException e) {
			e.printStackTrace();
			return false;
		} 
		catch (IOException e) {
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
			e.printStackTrace();
			return;
		}

		line.start();

		try {
			byte bytes[] = new byte[1024];

			int bytesRead = 0;			
			while (((bytesRead = audioInputStream.read(bytes, 0, bytes.length)) != -1)
					&& !pause) {
				line.write(bytes, 0, bytesRead);
			}
		} 
		catch (IOException io) {
			io.printStackTrace();
			return;
		}

		line.close();
	}

	/**
	 * Permet de mettre en pause ou en lecture
	 * 
	 * true  -> sera mis en pause
	 * false -> sera mis en lecture
	 */
	public void setPause(boolean b) {
		this.pause = b;
	}	

	/**
	 * Informe de l'état de la pause
	 * 
	 * @return un boolean informant de l'état de la pause
	 * true  -> fichier en pause
	 * false -> fichier en lecture
	 */
	public boolean isPause() {
		return pause;
	}

	/**
	 * @return the load
	 */
	public boolean isLoad() {
		return load;
	}

	/*
	 * public SourceDataLine getLine() {
		return line;
	}
	 */

}
