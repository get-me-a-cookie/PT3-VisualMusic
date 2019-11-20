package App;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GraphicsDevice;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import Controller.Controller_Bouton_LecturePause;
import Controller.Controller_MenuFichier;
import Model.Model;
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
	private JButton bouton_stop;
	//private JButton bouton_volume;
	private JButton bouton_pleinEcran;

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
	private boolean pleine_ecran = false;

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

		//Paramètrage de la fenêtre
		this.FullScreen();

		//Création des éléments 
		this.creationMenu();
		this.creationBouton();
		this.creationVisualisateur();
		erreur = new Vue_Erreur();

		//Ajout des observer
		model.addObserver(visualisateur2D);
		model.addObserver(visualisateur3D);
		model.addObserver(erreur);

		//Ajout de tous les éléments
		this.add(panel_bouton, BorderLayout.SOUTH);
		this.add(menu, BorderLayout.NORTH);
		this.add(visualisateur2D, BorderLayout.CENTER);
		//this.add(pleine_ecran);

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

		//Modification des éléments
		menu.setBackground(new Color(206, 213, 209));

		//Ajout des Controller
		menu_fichier_ouvrir.addActionListener(new Controller_MenuFichier(model));

		//Ajout des éléments
		menu_fichier.add(menu_fichier_ouvrir);

		menu.add(menu_fichier);

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

		//Ajout des Controller
		bouton_playPause.addActionListener(new Controller_Bouton_LecturePause(model));
		bouton_stop.addActionListener(new Controller_Bouton_LecturePause(model));
		bouton_pleinEcran.addActionListener(new Controller_Bouton_LecturePause(model));

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

		//Ajout des éléments

	}

	/** 
	 * Création de la fênetre à dimension normale
	 *  et FullEcran selon une boolean 
	 */
	public void FullScreen() {
		Dimension tailleEcran = Toolkit.getDefaultToolkit().
				getScreenSize();	
		int height = tailleEcran.height;
		int width = tailleEcran.width;
		
		if(!pleine_ecran) {
			this.setTitle("Visuals Music");
			pleine_ecran = false;
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

			// On récuper la taille de l'écran
			this.setSize(width/2, height/2);
			this.setLocationRelativeTo(null);
			this.setVisible(true);
		}
		else {
			this.revalidate();
			pleine_ecran = true;
			this.setTitle("Visuals Music");
			this.setExtendedState(this.MAXIMIZED_BOTH);
			this.setVisible(true);
			this.pack();

		}
	}

	public static void main (String[] args) {
		Pricipale_VisualsMusic vue = new Pricipale_VisualsMusic();

	}

}
