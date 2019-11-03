import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.UnsupportedAudioFileException;

import View.InterfaceGraphique;

public class VisualsMusic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//InterfaceGraphique i = new InterfaceGraphique();
		//i.afficher();


		File file = new File("res/spirit.ogg");
		
		System.out.println(file.exists());
		
		
		
		AudioInputStream audioInputStream = null;
		try {
			//obtention d'un flux audio à partir d'un fichier (objet File)
			audioInputStream = AudioSystem.getAudioInputStream(file);

		} 
		catch (UnsupportedAudioFileException e) {
			e.printStackTrace();
			return;
		} 
		catch (IOException e) {
			e.printStackTrace();
			return;
		}	

		AudioFormat audioFormat = audioInputStream.getFormat();
		DataLine.Info info = new DataLine.Info(SourceDataLine.class, audioFormat);

		SourceDataLine line;
		try {
			line = (SourceDataLine) AudioSystem.getLine(info);

		}
		catch (LineUnavailableException e) {
			e.printStackTrace();
			return;
		}

		boolean stop = false;
        // Avant toute chose il est nécessaire d'ouvrir la ligne
        try {
            line.open(audioFormat);
        } catch (LineUnavailableException e) {
            e.printStackTrace();
            return;
            // TODO Auto-generated catch block

        }
        // pour que le flux soit effectivement redirigé sur la carte son il
        // faut
        // demarrer la ligne
        line.start();

		// il faut maintenant écrire sur la ligne. Travail comme sur un
		// inputStream quelconque
		try {
			byte bytes[] = new byte[1024];
			int bytesRead=0;			
			while (((bytesRead = audioInputStream.read(bytes, 0, bytes.length)) != -1)
					&& !stop) {
				
				line.write(bytes, 0, bytesRead);
			}
		} catch (IOException io) {
			io.printStackTrace();
			return;
		}
		// on ferme la ligne à la fin
		line.close();
	}

}
