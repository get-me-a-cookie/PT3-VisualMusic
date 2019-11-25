package App;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GraphicsDevice;
import java.awt.Toolkit;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;

import Controller.Controller_Bouton_LecturePause;
import Controller.Controller_Menu;
import Controller.Handler_ControllerHandler;
import Model.Model;
import Model.Model_Cube;
import View.Vue_2D;
import View.Vue_3D;
import View.Vue_Erreur;
/** 
 * @author Goodwui
 * Classe représentant l'IG, composé de 
 *     - un menu
 *     - le visualiseur de musique
 *     - les bouton de lectures
 */
public class Pricipale_VisualsMusic extends JFrame {

	///////////////////////////////////////
	////////////// Attributs //////////////
	///////////////////////////////////////

	/**
	 * Model qui sera incérer dans la création des Action
	 * afin de respecter le modèle MVC
	 */
	private Model model;

	/**
	 * Bouton permettant de mettre en marche la musique
	 * S'affiche si la vidéo est en pause
	 */	
	private JButton bouton_playPause;

	//TODO
	private JButton bouton_stop;

	//TODO
	//private JButton bouton_volume;

	//TODO
	private JButton bouton_pleinEcran;
	
	//TODO
	private Handler_ControllerHandler handler = new Handler_ControllerHandler();

	/**
	 * Bandeau inférieur de l'IG
	 * Contiendra les différents boutons de navigation de la musique
	 * (play, stop, pause, ...)
	 */
	private JPanel panel_bouton;

	/**
	 * Menu qui permettra d'accéder à toutes les fonctionnalitées de l'application
	 * ouvrir une musique, ...
	 */
	private JMenuBar menu;

	/**  
	 * Catégorie du @menu
	 * Actions disponibles :
	 * 		- Ouvrir un fichier...
	 */
	private JMenu menu_fichier;

	/**  
	 * Catégorie du @menu
	 * Actions disponibles :
	 * 		- Vue 2D
	 * 		- Vue 3D
	 */
	private JMenu menu_affichage;

	/**
	 * Actions de @menu_affichage
	 * Permet d'afficher en 2D la musique
	 */
	private JRadioButtonMenuItem menu_affichage_2D;

	/**
	 * Actions de @menu_affichage
	 * Permet d'afficher en 3D la musique
	 */
	private JRadioButtonMenuItem menu_affichage_3D;
	
	private ButtonGroup menu_affichage_dimension;
	
	/**
	 * Actions de @menu_fichier
	 * Permet d'ouvrir un fichier
	 */
	private JMenuItem menu_fichier_ouvrir;

	/**
	 * Panneau principale
	 * Affichera les formes 2D en fonction de la musique
	 */
	private Vue_2D visualisateur2D;
	
	/**
	 * Panneau principale
	 * Affichera les formes 3D en fonction de la musique
	 */
	private Vue_3D visualisateur3D;
	
	/**
	 * Message d'erreur qui s'affiche quand:
	 *    - Aucun fichier n'a été sélectionner mais que
	 *		l'utilisateur essai de le lire
	 */
	private Vue_Erreur erreur;
	//TODO plus tard 
	private boolean pleine_ecran = false;
	/*
	 * Cube qui créer un cube
	 * a testé car pas afficher
	 */
	//TODO
	private Model_Cube cube;
	///////////////////////////////////////
	////////////// Méthodes ///////////////
	///////////////////////////////////////

	/**
	 * Créateur de l'IG toute entière
	 */
	public Pricipale_VisualsMusic () {
		/* TODO A voir
		 * 		changer le constructeur en main
		 * 		Mettre les attributs directement dans le main
		 */
		//Création Model
		model = new Model();

		//Création des éléments 
		this.creationMenu();
		this.creationBouton();
		this.creationVisualisateur();
		erreur = new Vue_Erreur();

		//Ajout des observer
		model.addObserver(visualisateur2D);
		model.addObserver(visualisateur3D);
		model.addObserver(erreur);

		//Ajout de la fenêtre dans le handler
		handler.getComponent().add(this);

		//Ajout de tous les éléments
		this.add(panel_bouton, BorderLayout.SOUTH);
		this.add(menu, BorderLayout.NORTH);
		this.add(visualisateur2D, BorderLayout.CENTER);
		//this.add(visualisateur3D, BorderLayout.CENTER);
		//this.add(pleine_ecran);
		
		//Paramètrage de la fenêtre
		this.fullScreen();
		this.setTitle("Visuals Music");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.pack();
	}

	/**
	 * Création du l'IG supérieur
	 * Menu (fichier, ...)
	 */
	private void creationMenu() {

		//Création des éléments		
		menu = new JMenuBar();

		menu_fichier = new JMenu("Fichier");
		menu_fichier_ouvrir = new JMenuItem("Ouvrir un fichier...");
		
		menu_affichage = new JMenu("Affichage");
		menu_affichage_2D = new JRadioButtonMenuItem("2D");
		menu_affichage_3D = new JRadioButtonMenuItem("3D");
		
		menu_affichage_dimension = new ButtonGroup();

		//Modification des éléments
		menu.setBackground(new Color(206, 213, 209));
		
		menu_affichage_2D.setSelected(true);

		//Ajout des Controller
		menu_fichier_ouvrir.addActionListener(new Controller_Menu(model, handler));
		menu_affichage_2D.addActionListener(new Controller_Menu(model, handler));
		menu_affichage_3D.addActionListener(new Controller_Menu(model, handler));

		//Ajout des éléments
		menu_fichier.add(menu_fichier_ouvrir);

		menu_affichage_dimension.add(menu_affichage_2D);
		menu_affichage_dimension.add(menu_affichage_3D);

		menu_affichage.add(menu_affichage_2D);
		menu_affichage.add(menu_affichage_3D);

		menu.add(menu_fichier);
		menu.add(menu_affichage);

	}

	/**
	 * Création du l'IG inférieur
	 * Bouton de navigation
	 */
	private void creationBouton() {

		//Création des éléments
		panel_bouton = new JPanel();
		
		bouton_playPause = new JButton("Play");
		bouton_stop = new JButton("Stop");
		bouton_pleinEcran = new JButton("Ecran");		

		//Modification des éléments
		panel_bouton.setBackground(new Color(87, 73, 73, 50));
		bouton_playPause.setPreferredSize(new Dimension(100,50));
		bouton_stop.setPreferredSize(new Dimension(100,50));
		bouton_pleinEcran.setPreferredSize(new Dimension(100,50));

		//Ajout des Bouton dans le handler
		handler.getComponent().add(bouton_playPause);
		handler.getComponent().add(bouton_stop);
		handler.getComponent().add(bouton_pleinEcran);
		
		//Ajout des Controller
		bouton_playPause.addActionListener(new Controller_Bouton_LecturePause(model, handler));
		bouton_stop.addActionListener(new Controller_Bouton_LecturePause(model, handler));
		bouton_pleinEcran.addActionListener(new Controller_Bouton_LecturePause(model, handler));

		//Ajout des éléments
		panel_bouton.add(bouton_playPause);
		panel_bouton.add(bouton_stop);
		panel_bouton.add(bouton_pleinEcran);

	}

	/**
	 * Création du l'IG centrale
	 * Affichage des formes
	 */
	private void creationVisualisateur() {

		//Création des éléments
		visualisateur2D = new Vue_2D();	
		visualisateur3D = new Vue_3D();	
		
		//Modification des éléments
		visualisateur2D.setPreferredSize(
				new Dimension(800,450)); //rapport de 16:9
		visualisateur3D.setPreferredSize(
				new Dimension(800,450)); //rapport de 16:9

		//Ajout des éléments dans le handler
		handler.getComponent().add(visualisateur2D);
		handler.getComponent().add(visualisateur3D);

		//Ajout des éléments

	}

	/** 
	 * Création de la fênetre à dimension normale
	 *  et FullEcran selon une boolean 
	 */
	//TODO fullscreen -> abscence de vue
	public void fullScreen() {
		Dimension tailleEcran = Toolkit.getDefaultToolkit().
				getScreenSize();	
		int height = tailleEcran.height;
		int width = tailleEcran.width;
		
		if(!pleine_ecran) {
			pleine_ecran = false;

			// On récuper la taille de l'écran
			this.setSize(width/2, height/2);
			this.setLocationRelativeTo(null);
			this.pack();
		}
		else {
			pleine_ecran = true;
			this.setExtendedState(this.MAXIMIZED_BOTH);
		}
	}
	/*
	 * Pour afficher notre application
	 */
	public static void main (String[] args) {
		Pricipale_VisualsMusic vue = new Pricipale_VisualsMusic();

	}

}
