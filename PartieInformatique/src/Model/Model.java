package Model;

import java.io.File;
import java.util.Observable;

import javax.sound.sampled.LineEvent;

//TODO Javadoc, contenu
public class Model extends Observable {

	private File fichier;
	private Model_Musique musique = new Model_Musique();
	private Thread musiqueThread;

	public void update () {
		//TODO
	}

	public void lectureFichier() {
		if (!musique.isPause())
			musique.initialisation(fichier);

		//cool du multithreading :)
		musiqueThread = new Thread(musique);
		musiqueThread.start();
	}

	public void setFichier(File file) {
		fichier = file;
	}

	public Model_Musique getMusique() {
		return musique;
	}

}
