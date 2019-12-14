package Model;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

//TODO Javadoc, contenu
/** 
 * Classe de type Model, permettant la structure MVC
 * 	Instancié uniquement dans le code principale
 * 	et méthode quasi-uniquement utilisé dans les Controller
 * 	lors d'Action
 * 
 * Cette classe conserne toute la gestion évenementiel du
 * 	programme
 * 	Elle informe également les Vue
 * 
 * @author goodw
 */
public class Model extends Observable implements Observer {

	private boolean fullScreen = false;
	
	/**
	 * Fichier qui sera écouté
	 */
	private File fichier;
	
	/**
	 * Classe de type Model, connu et instancié uniquement ici
	 * Permet le MultiThreading et ainsi de garder la main sur le programme
	 */
	private Model_Musique musique = new Model_Musique(this);
	
	/**
	 * Permet le MultiThreading et ainsi de garder la main sur le programme
	 * Créé a partir de musique, attribut décris ci-dessus
	 */
	private Thread musiqueThread;
	
	/**
	 * Définis si le programme a rencontré une erreur
	 * 0 : aucune erreur
	 * 1 : erreur de type ""
	 */
	private Exception erreur = null;
	
	/**
	 * les paramètres avec leur valeurs
	 */
	private Map<String, Integer> parametres = new HashMap<String, Integer>();
	
	/**
	 * Définis si l'utilisateur a demander de changer de vue
	 * afin de pouvoir réinitialiser les vue à chaque fois.
	 * true  : l'utilisateur veux changer de vue
	 * false : il reste sur sa vue actuelle 
	 */
	private boolean isThreeDimension = false;
	
	private boolean printSettings = false;

	public Model() {
		
		parametres.put("Autoplay"				, 1); //1 = true, 0 = false
		parametres.put("Couleur_2d_random"	 	, 1); //1 = true, 0 = false
		parametres.put("Couleur_3d_random"	 	, 1); //1 = true, 0 = false
		parametres.put("Espacement"			 	, 0);
		parametres.put("Epaisseur"			 	, 60);
		parametres.put("Amplitude"			 	, 100);
		parametres.put("Couleur_2d_trait_red"	, 0);
		parametres.put("Couleur_2d_trait_green"	, 0);
		parametres.put("Couleur_2d_trait_blue" 	, 0);
		parametres.put("Couleur_2d_forme_red"  	, 0);
		parametres.put("Couleur_2d_forme_green"	, 0);
		parametres.put("Couleur_2d_forme_blue" 	, 0);
		parametres.put("Couleur_3d_cube1_red"  	, 0);
		parametres.put("Couleur_3d_cube2_red"  	, 0);
		parametres.put("Couleur_3d_cube3_red"  	, 0);
		parametres.put("Couleur_3d_cube4_red"  	, 0);
		parametres.put("Couleur_3d_cube1_green"	, 0);
		parametres.put("Couleur_3d_cube2_green"	, 0);
		parametres.put("Couleur_3d_cube3_green"	, 0);
		parametres.put("Couleur_3d_cube4_green"	, 0);
		parametres.put("Couleur_3d_cube1_blue" 	, 0);
		parametres.put("Couleur_3d_cube2_blue" 	, 0);
		parametres.put("Couleur_3d_cube3_blue" 	, 0);
		parametres.put("Couleur_3d_cube4_blue" 	, 0);
		
	}

	//TODO Check pause / mettre pause a true dès le début
	/**
	 * Permet de lire un fichier audio tous en permettant de
	 * garder la main sur l'application grâce au multithreading
	 */
	public void lectureFichier() {
		
		if (musiqueThread == null || musique.isPause()) {
			
			if (!musique.isLoad())
				musique.initialisation(fichier);
			
			musiqueThread = new Thread(musique);
			musiqueThread.start();
			
		}
	}
	
	/**
	 * permet de modifier le fichier qui fdoit être lus
	 */
	public void setFichier(File file) {
		
		if (file.exists()) {
			
			fichier = file;
			this.lectureFichier();
		}
	}
	
	/**
	 * permet d'obtenir le model jouant la musique
	 * @return le model de la musique
	 */
	public Model_Musique getMusique() {
		
		return musique;
		
	}
	
	/**
	 * permet d'arrêter la musique
	 * et de remettre le même fichier
	 * au début de la lecture
	 */
	public void stop() {
		
		musique.reset();
		
	}

	/**
	 * @return une boolean qui permet de savoir
	 * si le fichier est en cours de lecture ou pas
	 * true : le fichier est entrain d'être lu
	 * false : il n'y a pas de fichier en cour de lecture
	 */
	public boolean isFileLoaded() {
		
		if (fichier == null)
			return false;
		
		return true;
		
	}

	/**
	 * notify si il y a une erreur,
	 * à la vue
	 */
	public void setErreur(Exception e) {
		
		erreur  = e;
		
		setChanged();
		notifyObservers();
		
		erreur = null;
		
	}

	/**
	 * permet d'obtenir une erreur
	 * @return  Exception si il y a une erreur
	 * 			null sinon
	 */
	public Exception getErreur() {
		
		return erreur;
		
	}
	
	/**
	 * @return le ration de la fréquense actuel
	 * par rapport à celle du fichier
	 */
	public double getRatioFrequence() {
		
		double freq = 0;
		
		freq = 	(musique.getFrequence() 
				* (parametres.get("Amplitude")) / 100)
				/ musique.getAudioFormat().getFrameRate();
		
		return freq;
		
	}

	/**
	 * Méthode permettant de mettre à jour
	 * et de notify l'observer
	 */
	public void update(Observable o, Object arg) {
		
		setChanged();
		notifyObservers();
		
	}
	
	/**
	 * renvoie tous les parmetres ainsi que leur valeurs associé
	 * @return the parametres
	 */
	public Map<String, Integer> getParametres() {
		
		return parametres;
		
	}
	
	/**
	 * permet de modifié un paramètre en donnant
	 * sa valeur et le paramètre
	 * @param textLabel		: le paramètre a modifié
	 * @param texteToInt	: la valeur a donner
	 */
	public void parametersChanged(Map<String, Integer> map) {
		
		parametres.putAll(map);
		
		setChanged();
		notifyObservers();
		
	}
	
	/**
	 * @return the vueChanged
	 */
	public boolean isThreeDimension() {
		
		return isThreeDimension;
		
	}

	/**
	 * @param vueChanged the vueChanged to set
	 */
	public void setIsThreeDimension(boolean vueChanged) {
		
		this.isThreeDimension = vueChanged;
		
		setChanged();
		notifyObservers();
		
	}

	/**
	 * @return the fullScreen
	 */
	public boolean isFullScreen() {
		
		return fullScreen;
		
	}

	/**
	 * @param fullScreen the fullScreen to set
	 */
	public void setFullScreen(boolean fullScreen) {
		
		this.fullScreen = fullScreen;

		setChanged();
		notifyObservers();
		
	}
	
	/**
	 * @return the printSettings
	 */
	public boolean isPrintSettings() {
		
		return printSettings;
		
	}

	/**
	 * @param printSettings the printSettings to set
	 */
	public void setPrintSettings(boolean printSettings) {
		
		this.printSettings = printSettings;
		
		this.setChanged();
		this.notifyObservers();
		
	}
}
