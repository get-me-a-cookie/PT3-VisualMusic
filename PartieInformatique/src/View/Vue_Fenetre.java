package View;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.HashSet;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JSlider;

import Controller.Controller_Bouton_Musique;
import Controller.Controller_Clavier;
import Controller.Controller_Menu;
import Controller.Controller_Slider;
import Model.Model;
import View.Vue_2D;
import View.Vue_3D;
import View.Vue_Erreur;

/** 
 * Classe représentant l'IG, composé 
 *     - d'une barre de menu
 *     - d'un visualiseur 2D de musique
 *     - d'un visualiseur 3D de musique
 *     - de boutons de lecture, d'arret
 *     - d'un slider de volume
 *     
 * @author 
 * Goodwin
 * 	Création de la quasi totalité de la classe
 * 	Correction de la méthode frameCenter
 * Perrin
 * 	Creation de la méthode frameCenter
 * 	Ajout du Slider de volume
 * 	Transformation du panel sud en GridBagLayout
 */
public class Vue_Fenetre extends JFrame implements Observer {

	///////////////////////////////////////
	////////////// Attributs //////////////
	///////////////////////////////////////

	/**
	 * Bouton permettant de mettre en marche la musique
	 * si vidéo en pause : "Lecture"
	 * sinon 			 : "Pause
	 */	
	private JButton bouton_playPause;

	/**
	 * Bouton permettant de stoper la musique
	 * 
	 * Elle reprendra à zero si on reclique sur "Lecture"
	 */	
	private JButton bouton_stop;

	/**
	 * Bouton permettant de mettre la fenêtre en plein écran
	 * 
	 * Actuelement désactiver car l'affichage en plein écran
	 *  est en cours d'implémentation
	 */	
	private JButton bouton_pleinEcran;

	/**
	 * Bandeau inférieur de l'IG
	 * 
	 * Contient les différents boutons de affectant la musique
	 * (Lecture, stop, volume, ...)
	 */
	private JPanel panel_bouton;

	/**
	 * Menu qui permettra d'accéder à toutes les fonctionnalitées de l'application
	 * 		- ouvrir une musique
	 * 		- passer d'un visualiseur à un autre
	 * 		- ...
	 */
	private JMenuBar menu;

	/** 
	 * Catégorie de la barre de menu
	 * 
	 * Actions disponibles :
	 * 		- Ouvrir un fichier...
	 * 			Sert à ouvrir un fichier
	 */
	private JMenu menu_fichier;

	/**  
	 * Catégorie de la barre de menu
	 * 
	 * Actions disponibles :
	 * 		- Vue 2D
	 * 			Passe au visualiseur 2D
	 * 		- Vue 3D
	 * 			Passe au visualiseur 3D
	 */
	private JMenu menu_affichage;

	/**  
	 * Catégorie de la barre de menu
	 * 
	 * Quand on clique dessus, affiche la fenêtre des paramètres
	 */
	private JMenu menu_parametre;

	/**
	 * Actions de la catégorie "Affichage" de la barre de menu
	 * 
	 * Permet d'afficher en 2D la musique
	 */
	private JRadioButtonMenuItem menu_affichage_2D;

	/**
	 * Actions de la catégorie "Affichage" de la barre de menu
	 * 
	 * Permet d'afficher en 3D la musique
	 */
	private JRadioButtonMenuItem menu_affichage_3D;

	/**
	 * Groupe de radio bouton de la catégorie "Affichage" de la barre de menu
	 * 
	 * Groupe les bouton radios afin de selectioner le type de vue (2D ou 3D)
	 */
	private ButtonGroup menu_affichage_dimension;

	/**
	 * Actions de la catégorie "Fichier" de la barre de menu
	 * 
	 * Permet d'ouvrir un fichier
	 */
	private JMenuItem menu_fichier_ouvrir;

	/**
	 * Panneau principale 	/	Visualiseur
	 * 
	 * Visualiseur 2D
	 * 
	 * Affichera les formes 2D en fonction de la musique
	 */
	private Vue_2D vue_visualisateur2D;

	/**
	 * Panneau principale 	/	Visualiseur
	 * 
	 * Visualiseur 3D
	 * 
	 * Affichera les formes 3D en fonction de la musique
	 */
	private Vue_3D vue_visualisateur3D;

	/**
	 * Message d'erreur qui s'affiche quand une erreur est signalé
	 */
	private Vue_Erreur vue_erreur;

	/**
	 * Texte décrivant que le slider en dessous, modifie le volume
	 */
	private JLabel volume_texte;

	/**
	 * Slider permettant de modifié le volume
	 * 
	 * Méthode encore en cours d'implémentation
	 */
	private JSlider volume_slider;

	/**
	 * Les règles du GridBagLayout appartenant au panel des boutons (Sud)
	 */
	private GridBagConstraints gbc;

	/**
	 * Insets qui sert à décollé les élément du panel sud
	 */
	private Insets insets_panelSud = new Insets(0, 10, 0, 10);

	/**
	 * Dimension des Visualiseurs avec un rapport 16:9
	 */
	private Dimension seizeNeuvieme = new Dimension(800,450); //rapport de 16:9



	///////////////////////////////////////
	////////////// Méthodes ///////////////
	///////////////////////////////////////

	/**
	 * Créateur de l'IG toute entière
	 */
	public Vue_Fenetre(Model model) {

		//Création des éléments 

		this.creationMenu(model);
		this.creationPanelSud(model);
		this.creationVisualisateur();

		vue_erreur = new Vue_Erreur();


		//Ajout des observer

		model.addObserver(vue_visualisateur2D);
		model.addObserver(vue_visualisateur3D);
		model.addObserver(vue_erreur);
		model.addObserver(this);
		

		//Ajout de tous les éléments

		this.add(panel_bouton, BorderLayout.SOUTH);
		this.add(menu, BorderLayout.NORTH);
		this.add(vue_visualisateur2D, BorderLayout.CENTER);


		//Ajout des controlleur
		this.addWindowListener(new WindowAdapter() {
			//Ajout d'un message de confirmation d'arret

			public void windowClosing(WindowEvent windowEvent) {

				if (JOptionPane.showConfirmDialog(null, 
						"Êtes-vous sûr de vouloir fermer l'application ?",
						"Fermer l'application ?",
						JOptionPane.YES_NO_OPTION,
						JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION)
					System.exit(0);

			}
		});
		
		this.addKeyListener(new Controller_Clavier(model));
		
		
		//Paramètrage de la fenêtre

		this.frameCenter();
		this.setTitle("Visuals Music");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setVisible(true);
		this.pack();

		this.requestFocus(); //car premier focus sur le premier bouton (Lecture)

	}

	/**
	 * Création de la partie supérieur de l'IG
	 * Menu (fichier, affichage, ...)
	 * 
	 * Demande le modèle de l'aplication afin de respecter la structure MVC
	 * 	et de pouvoir le donner au controlleurs
	 */
	private void creationMenu(Model model) {

		//Création des éléments
		
		menu = new JMenuBar();

		menu_fichier = new JMenu("Fichier");
		menu_fichier_ouvrir = new JMenuItem("Ouvrir un fichier...");

		menu_affichage = new JMenu("Affichage");
		menu_affichage_2D = new JRadioButtonMenuItem("2D");
		menu_affichage_3D = new JRadioButtonMenuItem("3D");

		menu_affichage_dimension = new ButtonGroup();

		menu_parametre = new JMenu("Paramètres");
		

		//Modification des éléments
		
		menu.setBackground(new Color(206, 213, 209));

		menu_affichage_2D.setSelected(true);
		

		//Ajout des Controller
		
		menu_fichier_ouvrir.addActionListener(new Controller_Menu(model));

		menu_affichage_2D.addActionListener(new Controller_Menu(model));
		menu_affichage_3D.addActionListener(new Controller_Menu(model));

		menu_parametre.addMenuListener(new Controller_Menu(model));
		

		//Ajout des éléments
		
		menu_fichier.add(menu_fichier_ouvrir);

		menu_affichage_dimension.add(menu_affichage_2D);
		menu_affichage_dimension.add(menu_affichage_3D);

		menu_affichage.add(menu_affichage_2D);
		menu_affichage.add(menu_affichage_3D);

		menu.add(menu_fichier);
		menu.add(menu_affichage);
		menu.add(menu_parametre);

	}

	/**
	 * Création de la partie inférieur de l'IG 
	 * Bouton influant la musique
	 * 	Lecture, stop, ...
	 */
	private void creationPanelSud(Model model) {

		//Création des éléments
		
		panel_bouton 		= new JPanel(new GridBagLayout());
		volume_texte 		= new JLabel("Volume :");
		volume_slider 		= new JSlider(0,100);
		gbc 				= new GridBagConstraints();
		bouton_playPause 	= new JButton("Lecture");
		bouton_stop 		= new JButton("Stop");
		bouton_pleinEcran	= new JButton("Plein Ecran");

		
		//Modification des éléments
		
		panel_bouton.setBackground(new Color(87, 73, 73, 50));

		bouton_playPause.setPreferredSize(new Dimension(100,50));

		bouton_stop.setPreferredSize(new Dimension(100,50));

		bouton_pleinEcran.setPreferredSize(new Dimension(100,50));

		volume_slider.setPreferredSize(new Dimension(100,50));
		volume_slider.setMinimum(0);
		volume_slider.setMaximum(200);
		volume_slider.setMajorTickSpacing(50);
		volume_slider.setPaintTicks(true);
		volume_slider.setPaintLabels(true);

		bouton_pleinEcran.setEnabled(false);

		
		//Ajout des Controller
		
		bouton_playPause.addActionListener(new Controller_Bouton_Musique(model));
		bouton_stop.addActionListener(new Controller_Bouton_Musique(model));
		bouton_pleinEcran.addActionListener(new Controller_Bouton_Musique(model));
		volume_slider.addChangeListener(new Controller_Slider(model));
		
		// Ajout des élément dans le panel
		
		gbc.gridx = 3;
		gbc.gridy = 0;
		panel_bouton.add(volume_texte, gbc);

		gbc.gridy=1;
		gbc.insets = insets_panelSud ;
		panel_bouton.add(volume_slider, gbc);

		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridheight = 2;
		panel_bouton.add(bouton_playPause, gbc);

		gbc.gridx = 1;
		panel_bouton.add(bouton_stop, gbc);

		gbc.gridx = 2;
		panel_bouton.add(bouton_pleinEcran, gbc);
		
	}

	/**
	 * Création de la partie centrale de l'IG
	 * Visualiseurs
	 */
	private void creationVisualisateur() {

		//Création des éléments
		
		vue_visualisateur2D = new Vue_2D();	
		vue_visualisateur3D = new Vue_3D();	

		
		//Modification des éléments
		
		vue_visualisateur2D.setPreferredSize(seizeNeuvieme);
		vue_visualisateur3D.setSize(seizeNeuvieme); //Obligé de faire setSize pour un Canva
		
	}
	
	/**
	 * Permet de centrer la fenêtre sur l'écran
	 */
	private void frameCenter() {

		Dimension tailleEcran = Toolkit.getDefaultToolkit().getScreenSize();

		int posY = 
				( (int) tailleEcran.getHeight()
						- (int) vue_visualisateur2D.getPreferredSize().getHeight()
						- (int) menu.getPreferredSize().getHeight()
						- (int) panel_bouton.getPreferredSize().getHeight()) / 2;	
		int posX = 
				( (int) tailleEcran.getWidth() 
						- (int) vue_visualisateur2D.getPreferredSize().getWidth()) / 2;

		this.setLocation(posX, posY);

	}

	/**
	 * Implémentation de la méthode de l'interface Observer
	 * 
	 * Sert a mettre la fenêtre en plein ecran ou non
	 */
	public void update(Observable m, Object o) {

		this.requestFocus();
		
		Model model = (Model) m;

		if (model.getErreur() == null) {

			if (!model.isPause())
				bouton_playPause.setText("Pause");
			else
				bouton_playPause.setText("Lecture");
			
			
			if (model.isChangingDimension() && model.isThreeDimension()) {
				
				this.remove(vue_visualisateur2D);
				this.add(vue_visualisateur3D, BorderLayout.CENTER);
				
			}
			
			if (model.isChangingDimension() && !model.isThreeDimension()) {

				this.remove(vue_visualisateur3D);
				this.add(vue_visualisateur2D, BorderLayout.CENTER);
				
			}
			
			
			if (model.isFullScreen()) {

				this.setExtendedState(JFrame.MAXIMIZED_BOTH);
				this.setUndecorated(true);
				vue_visualisateur2D.setPreferredSize(new Dimension(
						(int)Toolkit.getDefaultToolkit().getScreenSize().getWidth(),
						(int)Toolkit.getDefaultToolkit().getScreenSize().getHeight()
						- (int) menu.getPreferredSize().getHeight()
						- (int) panel_bouton.getPreferredSize().getHeight()));
				//TODO mettre les taille des panels

			}

			else {

				this.pack();
				this.frameCenter();
				//TODO mettre les taille des panels

			}

			this.revalidate();
			this.repaint();

		}
	}
}
