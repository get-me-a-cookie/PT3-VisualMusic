package Model;

import java.applet.Applet;
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

//TODO Javadoc, contenu
public class Model extends Observable {

	File fichier;

	//Séparation de l'ouverture d'un fichier de la lecture et de la préparation à la lecture
	//Ici juste ouverture
	AudioInputStream audioInputStream;
	AudioFormat audioFormat;
	//Ici préparation à la lecture
	DataLine.Info info;
	SourceDataLine line;

	public void update () {
		//TODO
	}

	public boolean ouvertureFichier() {
		audioInputStream = null;
		try{
			audioInputStream = AudioSystem.getAudioInputStream(fichier);
		} 
		catch (UnsupportedAudioFileException e) {
			e.printStackTrace();
			return false;
		} 
		catch (IOException e) {
			e.printStackTrace();
			return false;
		}

		if (audioInputStream == null) return false;

		audioFormat = audioInputStream.getFormat();

		return true;
	}

	public boolean preparationLectureFichier() {
		info = new DataLine.Info(SourceDataLine.class, audioFormat);

		try {
			line = (SourceDataLine) AudioSystem.getLine(info);

		} 
		catch (LineUnavailableException e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

	public boolean lectureFichier() {
		try {
			line.open(audioFormat);
		} 
		catch (LineUnavailableException e) {
			e.printStackTrace();
			return false;
		}

		line.start();

		try {
			byte bytes[] = new byte[1024];
			int bytesRead=0;
			while (((bytesRead = audioInputStream.read(bytes, 0, bytes.length)) != -1)) {
				line.write(bytes, 0, bytesRead);
			}
		} 
		catch (IOException io) {
			io.printStackTrace();
			return false;
		}
		
		line.close();

		return true;
	}

	public void setFichier(File file) {
		fichier = file;
	}

}
