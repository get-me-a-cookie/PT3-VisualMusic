package Model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Observable;
import java.util.Observer;

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
 * @author 
 * Goodwin
 * 	Création et implémentation de la classe entière
 */
public class Model extends Observable implements Observer {

	/**
	 * L'epaisseur des formes 2D et 3D
	 */
	private int epaisseur;
	
	/**
	 * L'amplitude des formes 2d et 3D
	 * 
	 * Prend la valeur de base et multiplie par l'amplitude
	 */
	private int amplitude;
	
	/**
	 * L'espacement entre deux formes 2D et 3D
	 */
	private int espacement;
	
	/**
	 * La valeur de couleur rouge pour l'intérieur des formes 2D
	 * 
	 * 0 <= couleur <= 255
	 */
	private int couleur_2d_forme_r;
	
	/**
	 * La valeur de couleur bleu pour l'intérieur des formes 2D
	 * 
	 * 0 <= couleur <= 255
	 */
	private int couleur_2d_forme_b;
	
	/**
	 * La valeur de couleur vert pour l'intérieur des formes 2D
	 * 
	 * 0 <= couleur <= 255
	 */
	private int couleur_2d_forme_g;
	
	/**
	 * La valeur de couleur rouge pour les traits des formes 2D
	 * 
	 * 0 <= couleur <= 255
	 */
	private int couleur_2d_trait_r;
	
	/**
	 * La valeur de couleur vert pour les traits des formes 2D
	 * 
	 * 0 <= couleur <= 255
	 */
	private int couleur_2d_trait_g;
	
	/**
	 * La valeur de couleur bleu pour les traits des formes 2D
	 * 
	 * 0 <= couleur <= 255
	 */
	private int couleur_2d_trait_b;
	
	/**
	 * La valeur de couleur rouge pour le cube 3d numéro 1 
	 * 
	 * 0 <= couleur <= 255
	 */
	private int couleur_3d_cube1_r;
	
	/**
	 * La valeur de couleur vert pour le cube 3d numéro 1 
	 * 
	 * 0 <= couleur <= 255
	 */
	private int couleur_3d_cube1_g;
	
	/**
	 * La valeur de couleur bleu pour le cube 3d numéro 1 
	 * 
	 * 0 <= couleur <= 255
	 */
	private int couleur_3d_cube1_b;
	
	/**
	 * La valeur de couleur rouge pour le cube 3d numéro 2 
	 * 
	 * 0 <= couleur <= 255
	 */
	private int couleur_3d_cube2_r;
	
	/**
	 * La valeur de couleur vert pour le cube 3d numéro 2
	 * 
	 * 0 <= couleur <= 255
	 */
	private int couleur_3d_cube2_g;
	
	/**
	 * La valeur de couleur bleu pour le cube 3d numéro 2 
	 * 
	 * 0 <= couleur <= 255
	 */
	private int couleur_3d_cube2_b;
	
	/**
	 * La valeur de couleur rouge pour le cube 3d numéro 3 
	 * 
	 * 0 <= couleur <= 255
	 */
	private int couleur_3d_cube3_r;
	
	/**
	 * La valeur de couleur vert pour le cube 3d numéro 3
	 * 
	 * 0 <= couleur <= 255
	 */
	private int couleur_3d_cube3_g;
	
	/**
	 * La valeur de couleur bleu pour le cube 3d numéro 3 
	 * 
	 * 0 <= couleur <= 255
	 */
	private int couleur_3d_cube3_b;
	
	/**
	 * La valeur de couleur rouge pour le cube 3d numéro 4 
	 * 
	 * 0 <= couleur <= 255
	 */
	private int couleur_3d_cube4_r;
	
	/**
	 * La valeur de couleur vert pour le cube 3d numéro 4
	 * 
	 * 0 <= couleur <= 255
	 */
	private int couleur_3d_cube4_g;
	
	/**
	 * La valeur de couleur bleu pour le cube 3d numéro 4 
	 * 
	 * 0 <= couleur <= 255
	 */
	private int couleur_3d_cube4_b;
	
	/**
	 * Définis si la musique doit se lancer automatiquement dès quelle et ouverte
	 * ou non
	 * 
	 * true : se lancera automatiquement
	 * false: l'utilisateur devra presser "Lecture"
	 */
	private boolean autoplay;
	
	/**
	 * Définis si les couleur pour l'affichage 2D seront aléatoire ou non
	 * 
	 * true : sera aléatoire
	 * false: définis pas l'utilisateur
	 */
	private boolean couleur_2d_random;
	
	/**
	 * Définis si les couleur pour l'affichage 3D seront aléatoire ou non
	 * 
	 * true : sera aléatoire
	 * false: définis pas l'utilisateur
	 */
	private boolean couleur_3d_random;
	
	/**
	 * Définis si la fenêtre dois se mettre en plein écran ou non
	 * 
	 * true : sera en plein écran
	 * false: ne le sera pas
	 */
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
	 * 
	 * null : aucune
	 * autre : de type donné
	 */
	private Exception erreur;

	/**
	 * Définis si l'utilisateur utilise le visualiseur 2D ou non
	 * 
	 * true  : l'utilisateur utilise la 3D
	 * false : l'utilisateur utilise la 2D
	 */
	private boolean isThreeDimension;
	
	/**
	 * Définis s'il faut changer de visualiseur ou non
	 * 
	 * true : il faut changer
	 * false: il ne faut pas changer
	 */
	private boolean changingDimension;

	/**
	 * Définis s'il faut afficher les paramètres ou non
	 * 
	 * true : à afficher
	 * false: ne pas afficher
	 */
	private boolean printSettings;

	/**
	 * Définis si la lecture doit être en pause ou non
	 * 
	 * true  : la lecture s'arrète
	 * false : la lecture continue/commence
	 */
	private boolean pause;

	/**
	 * Le niveau du son en pourcents entier
	 */
	private int volume;
	
	/**
	 * Constructeur de la classe
	 * 
	 * Initialise les champs ainsi que les paramètres
	 */
	public Model() {

		erreur = null;

		isThreeDimension 	= false;
		printSettings 		= false;
		fullScreen 			= false;

		amplitude 			= 100;
		epaisseur 			= 60;
		espacement			= 0;
		autoplay 			= true;
		couleur_2d_random	= true;
		couleur_3d_random	= true;

		pause = true;
		
		changingDimension = false;
		
		volume = 50;

	}
	
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
	 * permet de modifier le fichier qui doit être lus
	 */
	public void setFichier(File file) {

		musique = new Model_Musique(this);
		pause = true;
		
		fichier = null;
		
		if (musiqueThread != null)
			musiqueThread.interrupt();
		
		musiqueThread = null;
				
		if (file.exists()) {

			fichier = file;

			if (autoplay) {

				pause = false;

				this.lectureFichier();

			}			
		}

		else {

			setErreur(new FileNotFoundException());
			return;

		}
	}

	/**
	 * permet d'obtenir le model jouant la musique
	 * 
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
	 * @return un boolean qui permet de savoir
	 * si le fichier est en cours de lecture ou pas
	 * 
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
	 * 
	 * utiliser uniquement pas Model_Musique
	 */
	public void update(Observable o, Object arg) {

		setChanged();
		notifyObservers();

	}

	/**
	 * permet de notifié les vue quand des paramètres on changer
	 */
	public void parametersChanged(boolean b) {

		if (b) {
			
			this.setChanged();
			this.notifyObservers();
			
		}

	}

	/**
	 * renvoie un boulean signalant le visualiseur utiliser
	 */
	public boolean isThreeDimension() {

		return isThreeDimension;

	}

	/**
	 * Permet de modifier le signal du visualiseur utiliser
	 */
	public void setIsThreeDimension(boolean vueChanged) {

		this.isThreeDimension = vueChanged;
		
	}

	/**
	 * Signal si oui ou non l'affichage est en plein écran 	 
	 */
	public boolean isFullScreen() {

		return fullScreen;

	}

	/**
	 * Permet de signaler s'il faut afficher la fenêtre en plein écran ou non
	 */
	public void setFullScreen(boolean fullScreen) {

		this.fullScreen = fullScreen;

		setChanged();
		notifyObservers();

	}

	/**
	 * signal s'il faut afficher les paramètres
	 */
	public boolean isPrintSettings() {

		return printSettings;

	}

	/**
	 * Permet de signaler s'il faut afficher les paramètre ou non
	 */
	public void setPrintSettings(boolean printSettings) {

		this.printSettings = printSettings;

		if (printSettings)
			this.setPause(true);

		this.setChanged();
		this.notifyObservers();

	}

	/**
	 * Renvoie l'epaisseur
	 */
	public int getEpaisseur() {
		
		return epaisseur;
		
	}

	/**
	 * Modifie l'epaisseur
	 */
	public void setEpaisseur(int epaisseur) {
		
		this.epaisseur = epaisseur;
		
	}

	/**
	 * Renvoie l'amplitude
	 */
	public int getAmplitude() {
		
		return amplitude;
		
	}

	/**
	 * Modifie l'amplitude
	 */
	public void setAmplitude(int amplitude) {
		
		this.amplitude = amplitude;
		
	}

	/**
	 * Renvoie l'espacement
	 */
	public int getEspacement() {
		
		return espacement;
		
	}

	/**
	 * Modifie l'espacement
	 */
	public void setEspacement(int espacement) {
		
		this.espacement = espacement;
		
	}

	/**
	 * Renvoie la couleur rouge des formes 2D 
	 */
	public int getCouleur_2d_forme_r() {
		
		return couleur_2d_forme_r;
		
	}

	/**
	 * Modifie la couleur rouge des formes 2D 
	 */
	public void setCouleur_2d_forme_r(int couleur_2d_forme_r) {
		
		this.couleur_2d_forme_r = couleur_2d_forme_r;
		
	}

	/**
	 * Renvoie la couleur bleu des formes 2D 
	 */
	public int getCouleur_2d_forme_b() {
		
		return couleur_2d_forme_b;
		
	}

	/**
	 * Modifie la couleur bleu des formes 2D 
	 */
	public void setCouleur_2d_forme_b(int couleur_2d_forme_b) {
		
		this.couleur_2d_forme_b = couleur_2d_forme_b;
		
	}

	/**
	 * Renvoie la couleur verte des formes 2D 
	 */
	public int getCouleur_2d_forme_g() {
		
		return couleur_2d_forme_g;
		
	}

	/**
	 * Modifie la couleur verte des formes 2D 
	 */
	public void setCouleur_2d_forme_g(int couleur_2d_forme_g) {
		
		this.couleur_2d_forme_g = couleur_2d_forme_g;
		
	}

	/**
	 * Renvoie la couleur rouge des traits 2D 
	 */
	public int getCouleur_2d_trait_r() {
		
		return couleur_2d_trait_r;
		
	}

	/**
	 * Modifie la couleur rouge des traits 2D 
	 */
	public void setCouleur_2d_trait_r(int couleur_2d_trait_r) {
		
		this.couleur_2d_trait_r = couleur_2d_trait_r;
		
	}

	/**
	 * Renvoie la couleur verte des traits 2D 
	 */
	public int getCouleur_2d_trait_g() {
		
		return couleur_2d_trait_g;
		
	}

	/**
	 * Modifie la couleur verte des traits 2D 
	 */
	public void setCouleur_2d_trait_g(int couleur_2d_trait_g) {
		
		this.couleur_2d_trait_g = couleur_2d_trait_g;
		
	}

	/**
	 * Renvoie la couleur bleu des traits 2D 
	 */
	public int getCouleur_2d_trait_b() {
		
		return couleur_2d_trait_b;
		
	}

	/**
	 * Modifie la couleur bleu des traits 2D 
	 */
	public void setCouleur_2d_trait_b(int couleur_2d_trait_b) {
		
		this.couleur_2d_trait_b = couleur_2d_trait_b;
		
	}

	/**
	 * Renvoie la couleur rouge du cube 3D numéro 1 
	 */
	public int getCouleur_3d_cube1_r() {
		
		return couleur_3d_cube1_r;
		
	}

	/**
	 * Modifie la couleur rouge du cube 3D numéro 1 
	 */
	public void setCouleur_3d_cube1_r(int couleur_3d_cube1_r) {
		
		this.couleur_3d_cube1_r = couleur_3d_cube1_r;
		
	}

	/**
	 * Renvoie la couleur verte du cube 3D numéro 1 
	 */
	public int getCouleur_3d_cube1_g() {
		
		return couleur_3d_cube1_g;
	
	}

	/**
	 * Modifie la couleur verte du cube 3D numéro 1 
	 */
	public void setCouleur_3d_cube1_g(int couleur_3d_cube1_g) {
	
		this.couleur_3d_cube1_g = couleur_3d_cube1_g;
	
	}

	/**
	 * Renvoie la couleur bleu du cube 3D numéro 1 
	 */
	public int getCouleur_3d_cube1_b() {
	
		return couleur_3d_cube1_b;
	
	}

	/**
	 * Modifie la couleur bleu du cube 3D numéro 1 
	 */
	public void setCouleur_3d_cube1_b(int couleur_3d_cube1_b) {
	
		this.couleur_3d_cube1_b = couleur_3d_cube1_b;

	}

	/**
	 * Renvoie la couleur rouge du cube 3D numéro 2 
	 */
	public int getCouleur_3d_cube2_r() {
	
		return couleur_3d_cube2_r;
	
	}

	/**
	 * Modifie la couleur rouge du cube 3D numéro 2 
	 */
	public void setCouleur_3d_cube2_r(int couleur_3d_cube2_r) {
	
		this.couleur_3d_cube2_r = couleur_3d_cube2_r;

	}

	/**
	 * Renvoie la couleur verte du cube 3D numéro 2 
	 */
	public int getCouleur_3d_cube2_g() {
	
		return couleur_3d_cube2_g;
	
	}

	/**
	 * Modifie la couleur verte du cube 3D numéro 2 
	 */
	public void setCouleur_3d_cube2_g(int couleur_3d_cube2_g) {
	
		this.couleur_3d_cube2_g = couleur_3d_cube2_g;
	
	}

	/**
	 * Renvoie la couleur bleu du cube 3D numéro 2 
	 */
	public int getCouleur_3d_cube2_b() {
	
		return couleur_3d_cube2_b;
	
	}

	/**
	 * Modifie la couleur bleu du cube 3D numéro 2 
	 */
	public void setCouleur_3d_cube2_b(int couleur_3d_cube2_b) {
	
		this.couleur_3d_cube2_b = couleur_3d_cube2_b;
	
	}

	/**
	 * Renvoie la couleur rouge du cube 3D numéro 3 
	 */
	public int getCouleur_3d_cube3_r() {
	
		return couleur_3d_cube3_r;
	
	}

	/**
	 * Modifie la couleur rouge du cube 3D numéro 3 
	 */
	public void setCouleur_3d_cube3_r(int couleur_3d_cube3_r) {
	
		this.couleur_3d_cube3_r = couleur_3d_cube3_r;
	
	}

	/**
	 * Renvoie la couleur verte du cube 3D numéro 3 
	 */
	public int getCouleur_3d_cube3_g() {
	
		return couleur_3d_cube3_g;
	
	}

	/**
	 * Modifie la couleur verte du cube 3D numéro 3 
	 */
	public void setCouleur_3d_cube3_g(int couleur_3d_cube3_g) {
	
		this.couleur_3d_cube3_g = couleur_3d_cube3_g;
	
	}

	/**
	 * Renvoie la couleur bleu du cube 3D numéro 3 
	 */
	public int getCouleur_3d_cube3_b() {
	
		return couleur_3d_cube3_b;
	
	}

	/**
	 * Modifie la couleur bleu du cube 3D numéro 3 
	 */
	public void setCouleur_3d_cube3_b(int couleur_3d_cube3_b) {
	
		this.couleur_3d_cube3_b = couleur_3d_cube3_b;
	
	}

	/**
	 * Renvoie la couleur rouge du cube 3D numéro 4 
	 */
	public int getCouleur_3d_cube4_r() {
	
		return couleur_3d_cube4_r;
	
	}

	/**
	 * Modifie la couleur rouge du cube 3D numéro 4 
	 */
	public void setCouleur_3d_cube4_r(int couleur_3d_cube4_r) {
	
		this.couleur_3d_cube4_r = couleur_3d_cube4_r;
	
	}

	/**
	 * Renvoie la couleur verte du cube 3D numéro 4 
	 */
	public int getCouleur_3d_cube4_g() {
	
		return couleur_3d_cube4_g;
	
	}

	/**
	 * Modifie la couleur verte du cube 3D numéro 4 
	 */
	public void setCouleur_3d_cube4_g(int couleur_3d_cube4_g) {
	
		this.couleur_3d_cube4_g = couleur_3d_cube4_g;
	
	}

	/**
	 * Renvoie la couleur bleu du cube 3D numéro 4 
	 */
	public int getCouleur_3d_cube4_b() {
	
		return couleur_3d_cube4_b;
	
	}

	/**
	 * Modifie la couleur bleu du cube 3D numéro 4
	 */
	public void setCouleur_3d_cube4_b(int couleur_3d_cube4_b) {
	
		this.couleur_3d_cube4_b = couleur_3d_cube4_b;
	
	}

	/**
	 * Renvoie l'etat du autoplay 
	 */
	public boolean isAutoplay() {
	
		return autoplay;
	
	}

	/**
	 * Modifie l'etat du autoplay 
	 */
	public void setAutoplay(boolean autoplay) {
	
		this.autoplay = autoplay;
	
	}

	/**
	 * Renvoie l'etat des couleurs aléatoire pour la 2D 
	 */
	public boolean isCouleur_2d_random() {
	
		return couleur_2d_random;
	
	}

	/**
	 * Modifie l'etat des couleurs aléatoire pour la 2D 
	 */
	public void setCouleur_2d_random(boolean couleur_2d_random) {
	
		this.couleur_2d_random = couleur_2d_random;
	
	}

	/**
	 * Renvoie l'etat des couleurs aléatoire pour la 3D 
	 */
	public boolean isCouleur_3d_random() {
	
		return couleur_3d_random;
	
	}

	/**
	 * Modifie l'etat des couleurs aléatoire pour la 3D 
	 */
	public void setCouleur_3d_random(boolean couleur_3d_random) {
	
		this.couleur_3d_random = couleur_3d_random;
	
	}

	/**
	 * Signale s'il faut mettre la musique en poause ou non
	 *
	 * @param b
	 * true : pause
	 * false: lecture
	 */
	public void setPause(boolean b) {

		this.pause = b;

		if (this.musique != null)
			this.musique.setPause(b);

		this.setChanged();
		this.notifyObservers();

	}

	/**
	 * Renvoie l'etat de la lecture
	 * 
	 * @return
	 * true : pause
	 * false: lecture
	 */
	public boolean isPause() {

		return this.pause;

	}

	/**
	 * Arrete l'application si true
	 */
	public void setQuit(boolean quit) {

		if (quit)
			System.exit(0);
		
	}

	/**
	 * Renvoie l'etat d'une demande de changement de visualiseur
	 */
	public boolean isChangingDimension() {
		
		return changingDimension;
		
	}

	/**
	 * Demande le changement de visualiseur
	 */
	public void setChangingDimension(boolean changingDimension) {
		
		this.changingDimension = changingDimension;

		this.setChanged();
		this.notifyObservers();

		this.changingDimension = false;
		
	}

	/**
	 * Renvoie le volume de la musique
	 */
	public int getVolume() {
		
		return volume;
		
	}

	/**
	 * Modifie le volume de la musique
	 */
	public void setVolume(int volume) {
		
		this.volume = volume;
		
		this.musique.setVol( (float) volume / 100 );
		
	}
}
