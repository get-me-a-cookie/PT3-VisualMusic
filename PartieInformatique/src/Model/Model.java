package Model;

import java.io.File;
import java.io.FileNotFoundException;
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

	private int epaisseur;
	private int amplitude;
	private int espacement;
	private int couleur_2d_forme_r;
	private int couleur_2d_forme_b;
	private int couleur_2d_forme_g;
	private int couleur_2d_trait_r;
	private int couleur_2d_trait_g;
	private int couleur_2d_trait_b;
	private int couleur_3d_cube1_r;
	private int couleur_3d_cube1_g;
	private int couleur_3d_cube1_b;
	private int couleur_3d_cube2_r;
	private int couleur_3d_cube2_g;
	private int couleur_3d_cube2_b;
	private int couleur_3d_cube3_r;
	private int couleur_3d_cube3_g;
	private int couleur_3d_cube3_b;
	private int couleur_3d_cube4_r;
	private int couleur_3d_cube4_g;
	private int couleur_3d_cube4_b;
	private boolean autoplay;
	private boolean couleur_2d_random;
	private boolean couleur_3d_random;

	private boolean fullScreen;

	/**
	 * Fichier qui sera écouté
	 */
	private File fichier;

	/**
	 * Classe de type Model, connu et instancié uniquement ici
	 * Permet le MultiThreading et ainsi de garder la main sur le programme
	 */
	private Model_Musique musique;

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
	private Exception erreur;

	/**
	 * les paramètres avec leur valeurs
	 */
	private Map<String, Integer> parametres;

	/**
	 * Définis si l'utilisateur a demander de changer de vue
	 * afin de pouvoir réinitialiser les vue à chaque fois.
	 * true  : l'utilisateur veux changer de vue
	 * false : il reste sur sa vue actuelle 
	 */
	private boolean isThreeDimension;

	private boolean printSettings;
	private boolean pause;

	public Model() {

		musique = new Model_Musique(this);

		erreur = null;

		isThreeDimension = false;
		printSettings = false;
		fullScreen = false;

		amplitude 			= 100;
		epaisseur 			= 60;
		espacement			= 0;
		autoplay 			= true;
		couleur_2d_random	= true;
		couleur_3d_random	= true;

		pause = true;

	}

	//TODO Check pause / mettre pause a true dès le début
	/**
	 * Permet de lire un fichier audio tous en permettant de
	 * garder la main sur l'application grâce au multithreading
	 */
	public void lectureFichier() {

		if (musiqueThread == null || pause) {

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

			if (autoplay) {

				this.setPause(false);

				this.lectureFichier();

			}			
		}

		else {

			setErreur(new FileNotFoundException());

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
				* amplitude / 100)
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
	public void parametersChanged(boolean b) {

		if (b) {
			this.setChanged();
			this.notifyObservers();
		}

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

		if (printSettings)
			musique.setPause(true);

		this.setChanged();
		this.notifyObservers();

	}

	/**
	 * @return the epaisseur
	 */
	public int getEpaisseur() {
		return epaisseur;
	}

	/**
	 * @param epaisseur the epaisseur to set
	 */
	public void setEpaisseur(int epaisseur) {
		this.epaisseur = epaisseur;
	}

	/**
	 * @return the amplitude
	 */
	public int getAmplitude() {
		return amplitude;
	}

	/**
	 * @param amplitude the amplitude to set
	 */
	public void setAmplitude(int amplitude) {
		this.amplitude = amplitude;
	}

	/**
	 * @return the espacement
	 */
	public int getEspacement() {
		return espacement;
	}

	/**
	 * @param espacement the espacement to set
	 */
	public void setEspacement(int espacement) {
		this.espacement = espacement;
	}

	/**
	 * @return the couleur_2d_forme_r
	 */
	public int getCouleur_2d_forme_r() {
		return couleur_2d_forme_r;
	}

	/**
	 * @param couleur_2d_forme_r the couleur_2d_forme_r to set
	 */
	public void setCouleur_2d_forme_r(int couleur_2d_forme_r) {
		this.couleur_2d_forme_r = couleur_2d_forme_r;
	}

	/**
	 * @return the couleur_2d_forme_b
	 */
	public int getCouleur_2d_forme_b() {
		return couleur_2d_forme_b;
	}

	/**
	 * @param couleur_2d_forme_b the couleur_2d_forme_b to set
	 */
	public void setCouleur_2d_forme_b(int couleur_2d_forme_b) {
		this.couleur_2d_forme_b = couleur_2d_forme_b;
	}

	/**
	 * @return the couleur_2d_forme_g
	 */
	public int getCouleur_2d_forme_g() {
		return couleur_2d_forme_g;
	}

	/**
	 * @param couleur_2d_forme_g the couleur_2d_forme_g to set
	 */
	public void setCouleur_2d_forme_g(int couleur_2d_forme_g) {
		this.couleur_2d_forme_g = couleur_2d_forme_g;
	}

	/**
	 * @return the couleur_2d_trait_r
	 */
	public int getCouleur_2d_trait_r() {
		return couleur_2d_trait_r;
	}

	/**
	 * @param couleur_2d_trait_r the couleur_2d_trait_r to set
	 */
	public void setCouleur_2d_trait_r(int couleur_2d_trait_r) {
		this.couleur_2d_trait_r = couleur_2d_trait_r;
	}

	/**
	 * @return the couleur_2d_trait_g
	 */
	public int getCouleur_2d_trait_g() {
		return couleur_2d_trait_g;
	}

	/**
	 * @param couleur_2d_trait_g the couleur_2d_trait_g to set
	 */
	public void setCouleur_2d_trait_g(int couleur_2d_trait_g) {
		this.couleur_2d_trait_g = couleur_2d_trait_g;
	}

	/**
	 * @return the couleur_2d_trait_b
	 */
	public int getCouleur_2d_trait_b() {
		return couleur_2d_trait_b;
	}

	/**
	 * @param couleur_2d_trait_b the couleur_2d_trait_b to set
	 */
	public void setCouleur_2d_trait_b(int couleur_2d_trait_b) {
		this.couleur_2d_trait_b = couleur_2d_trait_b;
	}

	/**
	 * @return the couleur_3d_cube1_r
	 */
	public int getCouleur_3d_cube1_r() {
		return couleur_3d_cube1_r;
	}

	/**
	 * @param couleur_3d_cube1_r the couleur_3d_cube1_r to set
	 */
	public void setCouleur_3d_cube1_r(int couleur_3d_cube1_r) {
		this.couleur_3d_cube1_r = couleur_3d_cube1_r;
	}

	/**
	 * @return the couleur_3d_cube1_g
	 */
	public int getCouleur_3d_cube1_g() {
		return couleur_3d_cube1_g;
	}

	/**
	 * @param couleur_3d_cube1_g the couleur_3d_cube1_g to set
	 */
	public void setCouleur_3d_cube1_g(int couleur_3d_cube1_g) {
		this.couleur_3d_cube1_g = couleur_3d_cube1_g;
	}

	/**
	 * @return the couleur_3d_cube1_b
	 */
	public int getCouleur_3d_cube1_b() {
		return couleur_3d_cube1_b;
	}

	/**
	 * @param couleur_3d_cube1_b the couleur_3d_cube1_b to set
	 */
	public void setCouleur_3d_cube1_b(int couleur_3d_cube1_b) {
		this.couleur_3d_cube1_b = couleur_3d_cube1_b;
	}

	/**
	 * @return the couleur_3d_cube2_r
	 */
	public int getCouleur_3d_cube2_r() {
		return couleur_3d_cube2_r;
	}

	/**
	 * @param couleur_3d_cube2_r the couleur_3d_cube2_r to set
	 */
	public void setCouleur_3d_cube2_r(int couleur_3d_cube2_r) {
		this.couleur_3d_cube2_r = couleur_3d_cube2_r;
	}

	/**
	 * @return the couleur_3d_cube2_g
	 */
	public int getCouleur_3d_cube2_g() {
		return couleur_3d_cube2_g;
	}

	/**
	 * @param couleur_3d_cube2_g the couleur_3d_cube2_g to set
	 */
	public void setCouleur_3d_cube2_g(int couleur_3d_cube2_g) {
		this.couleur_3d_cube2_g = couleur_3d_cube2_g;
	}

	/**
	 * @return the couleur_3d_cube2_b
	 */
	public int getCouleur_3d_cube2_b() {
		return couleur_3d_cube2_b;
	}

	/**
	 * @param couleur_3d_cube2_b the couleur_3d_cube2_b to set
	 */
	public void setCouleur_3d_cube2_b(int couleur_3d_cube2_b) {
		this.couleur_3d_cube2_b = couleur_3d_cube2_b;
	}

	/**
	 * @return the couleur_3d_cube3_r
	 */
	public int getCouleur_3d_cube3_r() {
		return couleur_3d_cube3_r;
	}

	/**
	 * @param couleur_3d_cube3_r the couleur_3d_cube3_r to set
	 */
	public void setCouleur_3d_cube3_r(int couleur_3d_cube3_r) {
		this.couleur_3d_cube3_r = couleur_3d_cube3_r;
	}

	/**
	 * @return the couleur_3d_cube3_g
	 */
	public int getCouleur_3d_cube3_g() {
		return couleur_3d_cube3_g;
	}

	/**
	 * @param couleur_3d_cube3_g the couleur_3d_cube3_g to set
	 */
	public void setCouleur_3d_cube3_g(int couleur_3d_cube3_g) {
		this.couleur_3d_cube3_g = couleur_3d_cube3_g;
	}

	/**
	 * @return the couleur_3d_cube3_b
	 */
	public int getCouleur_3d_cube3_b() {
		return couleur_3d_cube3_b;
	}

	/**
	 * @param couleur_3d_cube3_b the couleur_3d_cube3_b to set
	 */
	public void setCouleur_3d_cube3_b(int couleur_3d_cube3_b) {
		this.couleur_3d_cube3_b = couleur_3d_cube3_b;
	}

	/**
	 * @return the couleur_3d_cube4_r
	 */
	public int getCouleur_3d_cube4_r() {
		return couleur_3d_cube4_r;
	}

	/**
	 * @param couleur_3d_cube4_r the couleur_3d_cube4_r to set
	 */
	public void setCouleur_3d_cube4_r(int couleur_3d_cube4_r) {
		this.couleur_3d_cube4_r = couleur_3d_cube4_r;
	}

	/**
	 * @return the couleur_3d_cube4_g
	 */
	public int getCouleur_3d_cube4_g() {
		return couleur_3d_cube4_g;
	}

	/**
	 * @param couleur_3d_cube4_g the couleur_3d_cube4_g to set
	 */
	public void setCouleur_3d_cube4_g(int couleur_3d_cube4_g) {
		this.couleur_3d_cube4_g = couleur_3d_cube4_g;
	}

	/**
	 * @return the couleur_3d_cube4_b
	 */
	public int getCouleur_3d_cube4_b() {
		return couleur_3d_cube4_b;
	}

	/**
	 * @param couleur_3d_cube4_b the couleur_3d_cube4_b to set
	 */
	public void setCouleur_3d_cube4_b(int couleur_3d_cube4_b) {
		this.couleur_3d_cube4_b = couleur_3d_cube4_b;
	}

	/**
	 * @return the autoplay
	 */
	public boolean isAutoplay() {
		return autoplay;
	}

	/**
	 * @param autoplay the autoplay to set
	 */
	public void setAutoplay(boolean autoplay) {
		this.autoplay = autoplay;
	}

	/**
	 * @return the couleur_2d_random
	 */
	public boolean isCouleur_2d_random() {
		return couleur_2d_random;
	}

	/**
	 * @param couleur_2d_random the couleur_2d_random to set
	 */
	public void setCouleur_2d_random(boolean couleur_2d_random) {
		this.couleur_2d_random = couleur_2d_random;
	}

	/**
	 * @return the couleur_3d_random
	 */
	public boolean isCouleur_3d_random() {
		return couleur_3d_random;
	}

	/**
	 * @param couleur_3d_random the couleur_3d_random to set
	 */
	public void setCouleur_3d_random(boolean couleur_3d_random) {
		this.couleur_3d_random = couleur_3d_random;
	}

	public void setPause(boolean b) {

		this.pause = b;

		this.musique.setPause(b);

		this.setChanged();
		this.notifyObservers();

	}

	public boolean isPause() {

		return this.pause;

	}
}
