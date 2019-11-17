package Model;

import java.io.File;
import java.util.Observable;

import javax.sound.sampled.LineEvent;

//TODO Javadoc, contenu
public class Model extends Observable {

	private File fichier;
	private Model_Musique musique = new Model_Musique();
	private Thread musiqueThread;
	private boolean enCours;

	public void update () {
		//TODO
	}

	public void lectureFichier() {
		if (!musique.isPause())
			enCours = false;
			musique.initialisation(fichier);

		//cool du multithreading :)
		musiqueThread = new Thread(musique);
		enCours = true;
		musiqueThread.start();
	}

	public void setFichier(File file) {
		fichier = file;
	}

	public Model_Musique getMusique() {
		return musique;
	}
	
	public void stop() {
		if(musiqueThread !=null && enCours) {
			enCours = false;
			fichier = null;
			musiqueThread.stop();
		}
		
	}

}
