package Model;

import java.io.File;
import java.util.Observable;

//TODO Javadoc, contenu
public class Model extends Observable {

	private File fichier;
	private Model_Musique musique = new Model_Musique();
	private Thread musiqueThread;
	private boolean erreur = false;
	private int bit;

	//TODO bricolage -> fonctionne pas
	public void modifier () {
		
		setChanged();
		notifyObservers();
	}

	public void lectureFichier() {
		if (!musique.isPause())
			musique.initialisation(fichier);

		//cool du multithreading :)
		musiqueThread = new Thread(musique);
		musiqueThread.start();
		modifier();
	}

	public void setFichier(File file) {
		fichier = file;
	}

	public Model_Musique getMusique() {
		return musique;
	}

	public boolean isFileLoaded() {
		if (fichier == null) return false;
		return true;
	}

	public void setErreur(boolean b) {
		/* TODO A voir si on peux enlever le paramètre et juste faire
		 * erreur = true;
		 * Notify.......
		 * erreur = false;
		 */
		erreur  = b;
		setChanged();
		notifyObservers();
		erreur = false;
	}

	public boolean isErreur() {
		if (erreur) return true;
		return false;
	}
}
