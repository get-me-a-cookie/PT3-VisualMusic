package Model;

import java.io.File;
import java.util.Observable;

//TODO Javadoc, contenu
/** 
 * 
 * @author goodw
 *
 * Classe de type Model, permettant la structure MVC
 * 	Instancié uniquement dans le code principale
 * 	et méthode quasi-uniquement utilisé dans les Controller
 * 	lors d'Action
 * 
 * Cette classe conserne toute la gestion évenementiel du
 * 	programme
 * 	Elle informe également les Vue
 */
public class Model extends Observable {

	/**
	 * Fichier qui sera écouté
	 */
	private File fichier;
	
	/**
	 * Classe de type Model, connu et instancié uniquement ici
	 * Permet le MultiThreading et ainsi de garder la main sur le programme
	 */
	private Model_Musique musique = new Model_Musique();
	
	/**
	 * Permet le MultiThreading et ainsi de garder la main sur le programme
	 * Créé a partir de musique, attribut décris ci-dessus
	 */
	private Thread musiqueThread;
	
	//TODO javadoc
	private boolean enCours;
	
	/**
	 * Définis si le programme a rencontré une erreur
	 * 0 -> aucune erreur
	 * 1 -> erreur de type ""
	 */
	private int erreur = 0;
	private int bit;

	//TODO bricolage -> fonctionne pas
	public void modifier () {
		
		setChanged();
		notifyObservers();
	}

	//TODO Check pause / mettre pause a true dès le début
	public void lectureFichier() {
		if (musiqueThread == null || musique.isPause()) {
			if (!musique.isLoad())
				musique.initialisation(fichier);
	
			//cool du multithreading :)
			musiqueThread = new Thread(musique);
			musiqueThread.start();
			if (Thread.State.TERMINATED == musiqueThread.getState()) {
				musiqueThread = null;
				musique.setPause(true);
			}
		}
	}

	public void setFichier(File file) {
		fichier = file;
	}

	public Model_Musique getMusique() {
		return musique;
	}
	
	public void stop() {
		musique.reset();
	}

	public boolean isFileLoaded() {
		if (fichier == null) return false;
		return true;
	}

	public void setErreur(int b) {
		/* TODO A voir si on peux enlever le paramètre et juste faire
		 * erreur = true;
		 * Notify.......
		 * erreur = false;
		 */
		erreur  = b;
		setChanged();
		notifyObservers();
		erreur = 0;
	}

	public int getErreur() {
		return erreur;
	}
}
