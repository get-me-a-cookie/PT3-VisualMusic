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

public class Model_Musique implements Runnable {

	private SourceDataLine line;
	private AudioInputStream audioInputStream;	
	private AudioFormat audioFormat;
	private boolean pause = false;

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
		} 
		catch (LineUnavailableException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	} 

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
			int bytesRead=0;			
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

	
	
	public void setPause() {
		this.pause = !pause;
	}	

	public boolean isPause() {
		return pause;
	}

	/*
	 * public SourceDataLine getLine() {
		return line;
	}
	*/
	/* Transformation de Fourier */
	public static double[][] TransformationFourier( double[][] tableau){
		/* Longueur de notre signal doit être un multiple de 2*/
		int longueurSignal = tableau.length;
		
		/* fin de l'appel récursif */
		double[][] tampon = new double [longueurSignal][1];
				if (longueurSignal==1) return tampon;
		
		/* Préparation des données pour faire Fourier */
		int longueurSignalDiviser2 = longueurSignal/2;
		double[][] transformationFourier = new double[longueurSignal][2];
		
		/* Déclaration des tableaux double avec leur taille */
		double[][] pair = new double[longueurSignalDiviser2][2];
		double[][] impair = new double[longueurSignalDiviser2][2];	
		
		/* Coupe le signal en termes d'indices pairs et impairs */
		for(int i=0; i < longueurSignalDiviser2; i++) {
			pair[i] = tableau[2*i];
			impair[i] = tableau[2*i+1];
			
		}
		
		/* Calcul recursif de la fonction */
		pair = 	TransformationFourier(pair);
		impair = 	TransformationFourier(impair);
			
		/* Reconstruction des valeurs par Fourier */
		for(int i = 0; i < longueurSignal; i++) {
			transformationFourier[i][0] = pair[i%longueurSignalDiviser2][0] 
					+ impair[i%longueurSignalDiviser2][0]*Math.cos(2*Math.PI*i/longueurSignal) 
					 + impair[i%longueurSignalDiviser2][1]*Math.sin(2*Math.PI*i/longueurSignal);
			
			transformationFourier[i][1] = pair[i%longueurSignalDiviser2][1] 
					+ impair[i%longueurSignalDiviser2][1]*Math.cos(2*Math.PI*i/longueurSignal) 
					 - impair[i%longueurSignalDiviser2][0]*Math.sin(2*Math.PI*i/longueurSignal);
		}
		return transformationFourier;
				
		}
 
}
