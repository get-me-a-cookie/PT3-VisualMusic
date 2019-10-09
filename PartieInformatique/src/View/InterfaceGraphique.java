package View;

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

/** 
 * @author Goodwui
 * Classe représentant l'IG, composé de 
 *     - un menu
 *     - le visualiseur de musique
 *     - les bouton de lectures
 */
public class InterfaceGraphique extends JFrame {

	///////////////////////////////////////
	////////////// Attributs //////////////
	///////////////////////////////////////

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
	private JPanel bouton;
	
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
	private JMenu menu_fichier_ouvrir;
	
	/**
	 * Panneau principale
	 * Affichera les formes en fonction de la musique
	 */
	private IGAffichage visualisateur;

	///////////////////////////////////////
	////////////// Méthodes ///////////////
	///////////////////////////////////////

	/**
	 * Créateur de l'IG toute entière
	 */
	public InterfaceGraphique () {

		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Visuals Music");
		
		this.creationMenu();
		this.creationBouton();
		this.creationVisualisateur();
		
		
		//Ajout de tous les éléments
		this.add(bouton, BorderLayout.SOUTH);
		this.add(menu, BorderLayout.NORTH);
		this.add(visualisateur, BorderLayout.CENTER);
				
		this.pack();
		
	}
	
	/**
	 * Création du l'IG supérieur
	 * Menu (fichier, ...)
	 */
	public void creationMenu() {
		
		//Création des éléments
		bouton = new JPanel(new FlowLayout(FlowLayout.LEFT));
		
		menu = new JMenuBar();
		
		menu_fichier = new JMenu("Fichier");
		menu_fichier_ouvrir = new JMenu("Ouvrir un fichier...");
		
		//Modification des éléments
		menu.setBackground(new Color(206, 213, 209));
		
		//Ajout des éléments
		menu_fichier.add(menu_fichier_ouvrir);
		
		menu.add(menu_fichier);
		
	}
	
	/**
	 * Création du l'IG inférieur
	 * Bouton de navigation
	 */
	public void creationBouton() {
		
		//Création des éléments
		bouton = new JPanel();
		
		bouton_play = new JButton("Play");
		bouton_pause = new JButton("Pause");
		
		//Modification des éléments
		bouton.setBackground(new Color(87, 73, 73, 50));
		bouton.setPreferredSize(new Dimension(10, 100));
				//Centrer les bouton verticalement
		
		//Ajout des éléments
		bouton.add(bouton_play);
		bouton.add(bouton_pause);

	}
	
	/**
	 * Création du l'IG centrale
	 * Affichage des formes
	 */
	public void creationVisualisateur() {
		
		//Création des éléments
		visualisateur = new IGAffichage();	
		
		//Modification des éléments
		visualisateur.setPreferredSize(new Dimension(700,400));
		
		//Ajout des éléments
		
	}
	

	
}
