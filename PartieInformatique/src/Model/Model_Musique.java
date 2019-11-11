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

	/*public SourceDataLine getLine() {
		return line;
	}*/

}
