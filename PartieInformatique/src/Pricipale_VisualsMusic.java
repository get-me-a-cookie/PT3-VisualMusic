

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import Controller.Controller_Bouton_LecturePause;
import Controller.Controller_MenuFichier;
import Model.Model;
import View.Vue_Erreur;
import View.Vue_GenerationForme;

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

	//TODO javadoc
	Model model;
	
	/**
	 * Bouton permettant de mettre en marche la musique
	 * S'affiche si la vidéo est en pause
	 */	
	private JButton bouton_play;
	
	/**
	 * Bouton permettant de mettre en pause la musique
	 * S'affiche si la vidéo est en lecture
	 */	
	private JButton bouton_pause;
	
	//private JButton bouton_stop;
	//private JButton bouton_volume;
	//private JButton bouton_pleinEcran;
		
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
	 * Affichera les formes en fonction de la musique
	 */
	private Vue_GenerationForme visualisateur;
	
	//TODO javadoc
	private Vue_Erreur erreur;

	///////////////////////////////////////
	////////////// Méthodes ///////////////
	///////////////////////////////////////

	/**
	 * Créateur de l'IG toute entière
	 */
	public Pricipale_VisualsMusic () {
		/* TODO changer le constructeur en main
		 * 		Mettre les attributs directement dans le main
		 */
		//Création Model
		model = new Model();
		
		//Paramètrage de la fenêtre
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Visuals Music");
		
		//Création des éléments 
		this.creationMenu();
		this.creationBouton();
		this.creationVisualisateur();
		erreur = new Vue_Erreur();
		
		//Ajout des observer
		model.addObserver(visualisateur);
		model.addObserver(erreur);
		
		//Ajout de tous les éléments
		this.add(panel_bouton, BorderLayout.SOUTH);
		this.add(menu, BorderLayout.NORTH);
		this.add(visualisateur, BorderLayout.CENTER);
				
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
		
		bouton_play = new JButton("Play");
		bouton_pause = new JButton("Pause");
		
		//Modification des éléments
		panel_bouton.setBackground(new Color(87, 73, 73, 50));
		
		//Ajout des Controller
		bouton_play.addActionListener(new Controller_Bouton_LecturePause(model));
		bouton_pause.addActionListener(new Controller_Bouton_LecturePause(model));
		
		//Ajout des éléments
		panel_bouton.add(bouton_play);
		panel_bouton.add(bouton_pause);

	}
	
	/**
	 * Création du l'IG centrale
	 * Affichage des formes
	 */
	private void creationVisualisateur() {
		
		//Création des éléments
		visualisateur = new Vue_GenerationForme();	
		
		//Modification des éléments
		visualisateur.setPreferredSize(
				new Dimension(800,450)); //rapport de 16:9
		
		//Ajout des éléments
		
	}
	
	public static void main (String[] args) {
		Pricipale_VisualsMusic easy = new Pricipale_VisualsMusic();
	}
	
}
