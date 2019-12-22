package View;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
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
import javax.swing.JTextField;

import Controller.Controller_Bouton_Musique;
import Controller.Controller_Menu;
import Controller.Controller_Slider;
import Model.Model;
import View.Vue_2D;
import View.Vue_3D;
import View.Vue_Ecran_Full;
import View.Vue_Erreur;

/** 
 * Classe représentant l'IG, composé de 
 *     - un menu
 *     - le visualiseur de musique
 *     - les bouton de lectures
 *     
 * @author 
 * Goodwin
 * 	Création de la quasi totalité de la classe
 * 	Correction de la méthode frameCenter, creationSlider
 * Perrin
 * 	Création de la méthode frameCenter, creationSlider
 */
public class Vue_Fenetre extends JFrame implements Observer {

	///////////////////////////////////////
	////////////// Attributs //////////////
	///////////////////////////////////////

	/**
	 * Bouton permettant de mettre en marche la musique
	 * si vidéo en pause : "Play"
	 * sinon 			 : "Pause
	 */	
	private JButton bouton_playPause;

	/**
	 * Bouton permettant de stoper la musique
	 * Elle reprendra à zeron si on reclique sur play
	 */	
	private JButton bouton_stop;

	/**
	 * Bouton permettant de mettre la fenêtre en plein écran
	 */	
	private JButton bouton_pleinEcran;

	/**
	 * Adapteur entre les controller et l'interface graphique
	 * Sert à retirer des éléments dans l'interface quand on 
	 * clique sur un bouton, ect ...
	 */
	Set<Component> handler = new HashSet<Component>();

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
	 * Catégorie du @menu
	 * Actions disponibles :
	 * 		- Amplitude
	 * 		- Taille rectangles
	 * 		- Espacement rectangles
	 */
	private JMenu menu_parametre;

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

	/**
	 * Groupe de radio bouton du menu "Affichage"
	 * Groupe les bouton radios afin de selectioner 
	 * le type de vue (2D, 3D)
	 */
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
	private Vue_2D vue_visualisateur2D;

	/**
	 * Panneau principale
	 * Affichera les formes 3D en fonction de la musique
	 */
	private Vue_3D vue_visualisateur3D;

	/**
	 * Message d'erreur qui s'affiche quand:
	 *    - Aucun fichier n'a été sélectionner mais que
	 *		l'utilisateur essai de le lire
	 */
	private Vue_Erreur vue_erreur;

	/**
	 * Vue permettant d'afficher une vue 
	 * en pleine écran
	 */
	private Vue_Ecran_Full vue_full_ecran;

	private GridBagConstraints c;
	///////////////////////////////////////
	////////////// Méthodes ///////////////
	///////////////////////////////////////

	/**
	 * Créateur de l'IG toute entière
	 */
	public Vue_Fenetre(Model model) {

		/* TODO A voir
		 * 		changer le constructeur en main
		 * 		Mettre les attributs directement dans le main
		 */

		//TODO a voir pour pas le mêtre dans la fenetre paramètres

		//Création des éléments 
		this.creationMenu(model, handler);
		this.creationPanelSud(model, handler);
		this.creationVisualisateur();
		vue_erreur = new Vue_Erreur();
		vue_full_ecran = new Vue_Ecran_Full();

		//Ajout des observer
		model.addObserver(vue_visualisateur2D);
		model.addObserver(vue_visualisateur3D);
		model.addObserver(vue_erreur);
		model.addObserver(vue_full_ecran);
		model.addObserver(this);

		handler.add(this);

		//Ajout de tous les éléments
		this.add(panel_bouton, BorderLayout.SOUTH);
		this.add(menu, BorderLayout.NORTH);
		this.add(vue_visualisateur2D, BorderLayout.CENTER);

		//Paramètrage de la fenêtre

		this.addWindowListener(new WindowAdapter() {

			public void windowClosing(WindowEvent windowEvent) {

				if (JOptionPane.showConfirmDialog(null, 
						"Are you sure you want to close this window?", "Close Window?", 
						JOptionPane.YES_NO_OPTION,
						JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION)
					System.exit(0);

			}
		});

		this.frameCenter();
		this.setTitle("Visuals Music");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setVisible(true);
		this.pack();


	}

	/**
	 * Création du l'IG supérieur
	 * Menu (fichier, ...)
	 * @param handler2 
	 */
	private void creationMenu(Model model, Set<Component> handler2) {

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
		menu_fichier_ouvrir.addActionListener(new Controller_Menu(model, handler2));

		menu_affichage_2D.addActionListener(new Controller_Menu(model, handler2));
		menu_affichage_3D.addActionListener(new Controller_Menu(model, handler2));

		menu_parametre.addMenuListener(new Controller_Menu(model, handler2));

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
	 * Création du l'IG inférieur
	 * Bouton de navigation
	 */
	private void creationPanelSud(Model model, Set<Component> handler) {

		//Création des éléments
		panel_bouton = new JPanel();
		JLabel texte_Volume = new JLabel("Volume :");
		JSlider slider = new JSlider(0,100);
		panel_bouton.setLayout(new GridBagLayout());
		c = new GridBagConstraints();

		bouton_playPause = new JButton("Play");
		c.gridx =0;
		c.gridy=0;
		c.gridheight =2;
		panel_bouton.add(bouton_playPause,c);


		bouton_stop = new JButton("Stop");
		c.gridx =1;
		c.gridy=0;
		panel_bouton.add(bouton_stop,c);

		bouton_pleinEcran = new JButton("Ecran");
		c.gridx =2;
		c.gridy=0;
		panel_bouton.add(bouton_pleinEcran,c);

		c.gridheight =1;
		c.gridx=3;
		c.gridy=0;
		panel_bouton.add(texte_Volume,c);


		slider.setPreferredSize(new Dimension(100,50));
		slider.setMinimum(0);
		slider.setMajorTickSpacing(50);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		slider.addChangeListener(new Controller_Slider(model, handler));
		c.gridx=3;
		c.gridy=1;
		panel_bouton.add(slider,c);

		//Modification des éléments
		panel_bouton.setBackground(new Color(87, 73, 73, 50));
		bouton_playPause.setPreferredSize(new Dimension(100,50));
		bouton_stop.setPreferredSize(new Dimension(100,50));
		bouton_pleinEcran.setPreferredSize(new Dimension(100,50));		

		//Ajout des Bouton dans le handler
		handler.add(bouton_playPause);
		handler.add(bouton_stop);
		handler.add(bouton_pleinEcran);

		//Ajout des Controller
		bouton_playPause.addActionListener(new Controller_Bouton_Musique(model, handler));
		bouton_stop.addActionListener(new Controller_Bouton_Musique(model, handler));
		bouton_pleinEcran.addActionListener(new Controller_Bouton_Musique(model, handler));

	}

	/**
	 * Création du l'IG centrale
	 * Affichage des formes
	 */
	private void creationVisualisateur() {

		//Création des éléments
		vue_visualisateur2D = new Vue_2D();	
		vue_visualisateur3D = new Vue_3D();	

		//Modification des éléments
		vue_visualisateur2D.setPreferredSize(
				new Dimension(800,450)); //rapport de 16:9
		vue_visualisateur3D.setSize( 		 //Obligé de faire setSize pour un Canva
				new Dimension(800,450)); //rapport de 16:9

		//Ajout des éléments

		handler.add(vue_visualisateur2D);
		handler.add(vue_visualisateur3D);
	}

	//TODO Javadoc
	//C'est chiant comme méthode, tu peux pas faire ce que tu veux avec la fenetre
	public void frameCenter() {

		Dimension tailleEcran = Toolkit.getDefaultToolkit().
				getScreenSize();

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


	public void update(Observable m, Object o) {

		Model model = (Model) m;

		if (model.getErreur() == null) {
			
			if (!model.isPause())
				bouton_playPause.setText("Pause");
			else
				bouton_playPause.setText("Play");

			if (model.isFullScreen()) {

				this.setExtendedState(JFrame.MAXIMIZED_BOTH); 
				//this.setUndecorated(true);
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
