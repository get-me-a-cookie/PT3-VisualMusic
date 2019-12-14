/**
 * 
 */
package View;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.HashSet;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.border.Border;

import Controller.Controller_Bouton_Parametre;
import Model.Model;

/**
 * @author goodw
 *
 */
public class Vue_Parametre extends JFrame implements Observer {

	private static int GRID_BAG_CONSTRAINTS_FRAME_SIZE = 18;

	private Set<Component> components = new HashSet<Component>();
	
	/**
	 * 
	 */
	public Vue_Parametre(Model model) {

		super();

		/*
		 * Creation des composants
		 */

		JPanel panel_fenetre 			= new JPanel(new GridBagLayout());
		GridBagConstraints gbc_fenetre 	= new GridBagConstraints();

		JPanel panel_section1 			= new JPanel(new GridBagLayout());
		GridBagConstraints gbc_section1 = new GridBagConstraints();

		JPanel panel_section2 			= new JPanel(new GridBagLayout());
		GridBagConstraints gbc_section2 = new GridBagConstraints();

		JPanel panel_section3 			= new JPanel(new GridBagLayout());
		GridBagConstraints gbc_section3 = new GridBagConstraints();

		JPanel panel_section4 			= new JPanel(new GridBagLayout());
		GridBagConstraints gbc_section4 = new GridBagConstraints();

		JPanel panel_section5 			= new JPanel(new GridBagLayout());
		GridBagConstraints gbc_section5 = new GridBagConstraints();

		

		JLabel label_parametre = new JLabel("Paramètres");

		JLabel label_affichage 						= new JLabel("Affichage");
		JLabel label_affichage_espacement 			= new JLabel("Espacement");
		JLabel label_affichage_epaisseur 			= new JLabel("Epaisseur");
		JLabel label_affichage_amplitude 			= new JLabel("Amplitude");
		JLabel label_affichage_espacement_px 		= new JLabel("px");
		JLabel label_affichage_epaisseur_px 		= new JLabel("px");
		JLabel label_affichage_amplitude_pourCent	= new JLabel("%");

		JLabel label_couleur_2d 				= new JLabel("Couleur");
		JLabel label_couleur_3d 				= new JLabel("Couleur");
		JLabel label_couleur_2d_trait_red 	= new JLabel("R");
		JLabel label_couleur_2d_trait_green = new JLabel("G");
		JLabel label_couleur_2d_trait_blue 	= new JLabel("B");
		JLabel label_couleur_2d_forme_red 	= new JLabel("R");
		JLabel label_couleur_2d_forme_green = new JLabel("G");
		JLabel label_couleur_2d_forme_blue 	= new JLabel("B");
		JLabel label_couleur_3d_red 		= new JLabel("R");
		JLabel label_couleur_3d_green 		= new JLabel("G");
		JLabel label_couleur_3d_blue 		= new JLabel("B");

		JLabel label_2d			= new JLabel("2D");
		JLabel label_2d_trait	= new JLabel("Trait");
		JLabel label_2d_forme	= new JLabel("Forme");

		JLabel label_3d		= new JLabel("3D");
		JLabel label_3d_cube1		= new JLabel("Cube 1");
		JLabel label_3d_cube2		= new JLabel("Cube 2");
		JLabel label_3d_cube3		= new JLabel("Cube 3");
		JLabel label_3d_cube4		= new JLabel("Cube 4");



		JTextField textField_affichage_espacement 	= new JTextField(4);
		JTextField textField_affichage_epaisseur 	= new JTextField(4);
		JTextField textField_affichage_amplitude  	= new JTextField(4);

		JTextField textField_2d_couleur_trait_red	= new JTextField(4);
		JTextField textField_2d_couleur_trait_green	= new JTextField(4);
		JTextField textField_2d_couleur_trait_blue	= new JTextField(4);

		JTextField textField_2d_couleur_forme_red	= new JTextField(4);
		JTextField textField_2d_couleur_forme_green	= new JTextField(4);
		JTextField textField_2d_couleur_forme_blue	= new JTextField(4);

		JTextField textField_3d_couleur_cube1_red	= new JTextField(4);
		JTextField textField_3d_couleur_cube1_green	= new JTextField(4);
		JTextField textField_3d_couleur_cube1_blue	= new JTextField(4);

		JTextField textField_3d_couleur_cube2_red	= new JTextField(4);
		JTextField textField_3d_couleur_cube2_green	= new JTextField(4);
		JTextField textField_3d_couleur_cube2_blue	= new JTextField(4);

		JTextField textField_3d_couleur_cube3_red	= new JTextField(4);
		JTextField textField_3d_couleur_cube3_green	= new JTextField(4);
		JTextField textField_3d_couleur_cube3_blue	= new JTextField(4);

		JTextField textField_3d_couleur_cube4_red	= new JTextField(4);
		JTextField textField_3d_couleur_cube4_green	= new JTextField(4);
		JTextField textField_3d_couleur_cube4_blue	= new JTextField(4);



		JCheckBox checkbox_2d_couleur_random	= new JCheckBox("Aléatoire");
		JCheckBox checkbox_3d_couleur_random	= new JCheckBox("Aléatoire");
		JCheckBox checkbox_autoplay				= new JCheckBox("Autoplay");



		JSlider slider_aigu		= new JSlider(-15, 15);
		JSlider slider_grave	= new JSlider(-15, 15);
		JSlider slider_vitesse	= new JSlider(-15, 15);



		JButton submit = new JButton("Appliquer & quitter");


		Border outsideBorder = BorderFactory.createRaisedBevelBorder();
		Border insideBorder = BorderFactory.createEtchedBorder();
		Border compound = BorderFactory.createCompoundBorder(insideBorder, insideBorder);

		/*
		 * Modification des éléments
		 */

		//Ajout Border
		panel_section1.setBorder(compound);
		panel_section2.setBorder(compound);
		panel_section3.setBorder(compound);
		panel_section4.setBorder(compound);
		panel_section5.setBorder(compound);

		//Modification taille 
		//panel
		panel_section1.setPreferredSize(new Dimension(150, 300));
		panel_section2.setPreferredSize(new Dimension(200, 300));
		panel_section3.setPreferredSize(new Dimension(300, 300));
		panel_section4.setPreferredSize(new Dimension(150, 200));
		panel_section5.setPreferredSize(new Dimension(150, 100));
		
		//Ajout Controlleur
		components.add(textField_2d_couleur_forme_blue);
		components.add(textField_2d_couleur_forme_green);
		components.add(textField_2d_couleur_forme_red);
		components.add(textField_2d_couleur_trait_blue);
		components.add(textField_2d_couleur_trait_green);
		components.add(textField_2d_couleur_trait_red);
		components.add(textField_3d_couleur_cube1_blue);
		components.add(textField_3d_couleur_cube1_green);
		components.add(textField_3d_couleur_cube1_red);
		components.add(textField_3d_couleur_cube2_blue);
		components.add(textField_3d_couleur_cube2_green);
		components.add(textField_3d_couleur_cube2_red);
		components.add(textField_3d_couleur_cube3_blue);
		components.add(textField_3d_couleur_cube3_green);
		components.add(textField_3d_couleur_cube3_red);
		components.add(textField_3d_couleur_cube4_blue);
		components.add(textField_3d_couleur_cube4_green);
		components.add(textField_3d_couleur_cube4_red);
		components.add(textField_affichage_amplitude);
		components.add(textField_affichage_epaisseur);
		components.add(textField_affichage_espacement);
		components.add(checkbox_autoplay);
		components.add(checkbox_2d_couleur_random);
		components.add(checkbox_3d_couleur_random);
		components.add(slider_aigu);
		components.add(slider_grave);
		components.add(slider_vitesse);
		submit.addActionListener(new Controller_Bouton_Parametre(model, components));
		
		/*
		 * If you are lost in the GridBagConstraints:
		 * https://docs.google.com/spreadsheets/d/1bSuEb7csMHc0i-HCx7FFaSAbMqYHoHI6-LiGcnqSEtE/edit?usp=sharing
		 * 
		 * It's a small Google Sheet, that we used to do the interface.
		 * 
		 * We have 5 sections. One for each bloc (between black separator)
		 */
		
		//Section1
		gbc_section1.gridx = 1;
		gbc_section1.gridy = 2;
		panel_section1.add(textField_affichage_espacement, gbc_section1);
		gbc_section1.gridy = 4;
		panel_section1.add(textField_affichage_epaisseur, gbc_section1);
		gbc_section1.gridy = 6;
		panel_section1.add(textField_affichage_amplitude, gbc_section1);

		gbc_section1.gridx = 2;
		gbc_section1.gridy = 2;
		panel_section1.add(label_affichage_espacement_px, gbc_section1);
		gbc_section1.gridy = 4;
		panel_section1.add(label_affichage_epaisseur_px, gbc_section1);
		gbc_section1.gridy = 6;
		panel_section1.add(label_affichage_amplitude_pourCent, gbc_section1);
		
		gbc_section1.insets = new Insets(10, 0, 0, 0);
		gbc_section1.gridwidth = 3;
		gbc_section1.gridx = 0;
		gbc_section1.gridy = 0;
		panel_section1.add(label_affichage, gbc_section1);
		gbc_section1.gridy = 1;
		panel_section1.add(label_affichage_espacement, gbc_section1);
		gbc_section1.gridy = 3;
		panel_section1.add(label_affichage_epaisseur, gbc_section1);
		gbc_section1.gridy = 5;
		panel_section1.add(label_affichage_amplitude, gbc_section1);


		//Section2
		gbc_section2.gridy = 4;
		panel_section2.add(label_couleur_2d_trait_red, gbc_section2);
		gbc_section2.gridy = 5;
		panel_section2.add(label_couleur_2d_trait_green, gbc_section2);
		gbc_section2.gridy = 6;
		gbc_section2.insets = new Insets(0, 0, 50, 0);
		panel_section2.add(label_couleur_2d_trait_blue, gbc_section2);
		gbc_section2.insets = new Insets(0, 0, 0, 0);

		gbc_section2.gridx = 1;
		gbc_section2.gridy = 4;
		panel_section2.add(textField_2d_couleur_trait_red, gbc_section2);
		gbc_section2.gridy = 5;
		panel_section2.add(textField_2d_couleur_trait_green, gbc_section2);
		gbc_section2.gridy = 6;
		gbc_section2.insets = new Insets(0, 0, 50, 0);
		panel_section2.add(textField_2d_couleur_trait_blue, gbc_section2);
		gbc_section2.insets = new Insets(0, 0, 0, 0);

		gbc_section2.gridx = 2;
		gbc_section2.gridy = 4;
		panel_section2.add(label_couleur_2d_forme_red, gbc_section2);
		gbc_section2.gridy = 5;
		panel_section2.add(label_couleur_2d_forme_green, gbc_section2);
		gbc_section2.gridy = 6;
		gbc_section2.insets = new Insets(0, 0, 50, 0);
		panel_section2.add(label_couleur_2d_forme_blue, gbc_section2);
		gbc_section2.insets = new Insets(0, 0, 0, 0);

		gbc_section2.gridx = 3;
		gbc_section2.gridy = 4;
		panel_section2.add(textField_2d_couleur_forme_red, gbc_section2);
		gbc_section2.gridy = 5;
		panel_section2.add(textField_2d_couleur_forme_green, gbc_section2);
		gbc_section2.gridy = 6;
		gbc_section2.insets = new Insets(0, 0, 50, 0);
		panel_section2.add(textField_2d_couleur_forme_blue, gbc_section2);
		gbc_section2.insets = new Insets(0, 0, 0, 0);
		
		gbc_section2.gridwidth = 2;
		gbc_section2.gridy = 3;
		gbc_section2.gridx = 0;
		panel_section2.add(label_2d_trait, gbc_section2);
		gbc_section2.gridx = 2;
		panel_section2.add(label_2d_forme, gbc_section2);

		gbc_section2.weighty = 1;
		gbc_section2.gridwidth = 4;
		gbc_section2.gridx = 0;
		gbc_section2.gridy = 0;
		gbc_section2.insets = new Insets(0, 0, 20, 0);
		panel_section2.add(label_2d, gbc_section2);
		gbc_section2.weighty = 0;
		gbc_section2.gridy = 1;
		gbc_section2.insets = new Insets(0, 0, 5, 0);
		panel_section2.add(label_couleur_2d, gbc_section2);
		gbc_section2.gridy = 2;
		gbc_section2.insets = new Insets(0, 0, 10, 0);
		panel_section2.add(checkbox_2d_couleur_random, gbc_section2);


		//Section3
		gbc_section3.gridx = 2;
		gbc_section3.gridy = 3;
		panel_section3.add(label_couleur_3d_red, gbc_section3);
		gbc_section3.gridy = 4;
		panel_section3.add(textField_3d_couleur_cube1_red, gbc_section3);
		gbc_section3.gridy = 5;
		panel_section3.add(textField_3d_couleur_cube2_red, gbc_section3);
		gbc_section3.gridy = 6;
		panel_section3.add(textField_3d_couleur_cube3_red, gbc_section3);
		gbc_section3.gridy = 7;
		gbc_section3.insets = new Insets(0, 0, 50, 0);
		panel_section3.add(textField_3d_couleur_cube4_red, gbc_section3);
		gbc_section3.insets = new Insets(0, 0, 0, 0);

		gbc_section3.gridx = 3;
		gbc_section3.gridy = 3;
		panel_section3.add(label_couleur_3d_green, gbc_section3);
		gbc_section3.gridy = 4;
		panel_section3.add(textField_3d_couleur_cube1_green, gbc_section3);
		gbc_section3.gridy = 5;
		panel_section3.add(textField_3d_couleur_cube2_green, gbc_section3);
		gbc_section3.gridy = 6;
		panel_section3.add(textField_3d_couleur_cube3_green, gbc_section3);
		gbc_section3.gridy = 7;
		gbc_section3.insets = new Insets(0, 0, 50, 0);
		panel_section3.add(textField_3d_couleur_cube4_green, gbc_section3);
		gbc_section3.insets = new Insets(0, 0, 0, 0);

		gbc_section3.gridx = 4;
		gbc_section3.gridy = 3;
		panel_section3.add(label_couleur_3d_blue, gbc_section3);
		gbc_section3.gridy = 4;
		panel_section3.add(textField_3d_couleur_cube1_blue, gbc_section3);
		gbc_section3.gridy = 5;
		panel_section3.add(textField_3d_couleur_cube2_blue, gbc_section3);
		gbc_section3.gridy = 6;
		panel_section3.add(textField_3d_couleur_cube3_blue, gbc_section3);
		gbc_section3.gridy = 7;
		gbc_section3.insets = new Insets(0, 0, 50, 0);
		panel_section3.add(textField_3d_couleur_cube4_blue, gbc_section3);
		gbc_section3.insets = new Insets(0, 0, 0, 0);

		gbc_section3.gridwidth = 2;
		gbc_section3.gridx = 0;
		gbc_section3.gridy = 4;
		panel_section3.add(label_3d_cube1, gbc_section3);
		gbc_section3.gridy = 5;
		panel_section3.add(label_3d_cube2, gbc_section3);
		gbc_section3.gridy = 6;
		panel_section3.add(label_3d_cube3, gbc_section3);
		gbc_section3.gridy = 7;
		gbc_section3.insets = new Insets(0, 0, 50, 0);
		panel_section3.add(label_3d_cube4, gbc_section3);
		gbc_section3.insets = new Insets(0, 0, 0, 0);

		gbc_section3.gridwidth = 5;
		gbc_section3.gridx = 0;
		gbc_section3.gridy = 0;
		gbc_section3.weighty = 1;
		gbc_section3.insets = new Insets(0, 0, 20, 0);
		panel_section3.add(label_3d, gbc_section3);
		gbc_section3.weighty = 0;
		gbc_section3.gridy = 1;
		gbc_section3.insets = new Insets(0, 0, 5, 0);
		panel_section3.add(label_couleur_3d, gbc_section3);
		gbc_section3.gridy = 2;
		gbc_section3.insets = new Insets(0, 0, 10, 0);
		panel_section3.add(checkbox_3d_couleur_random, gbc_section3);


		//Section4
		panel_section4.add(slider_aigu, gbc_section4);
		gbc_section4.gridy = 1;
		panel_section4.add(slider_grave, gbc_section4);
		gbc_section4.gridy = 2;
		panel_section4.add(slider_vitesse, gbc_section4);


		//Section5
		panel_section5.add(checkbox_autoplay, gbc_section5);


		//Fenetre
		gbc_fenetre.gridx = 3;
		gbc_fenetre.gridy = 1;
		panel_fenetre.add(panel_section4, gbc_fenetre);
		gbc_fenetre.gridy = 2;
		panel_fenetre.add(panel_section5, gbc_fenetre);

		gbc_fenetre.gridheight = 2;
		gbc_fenetre.gridx = 0;
		gbc_fenetre.gridy = 1;
		panel_fenetre.add(panel_section1, gbc_fenetre);
		gbc_fenetre.gridx = 1;
		panel_fenetre.add(panel_section2, gbc_fenetre);
		gbc_fenetre.gridx = 2;
		panel_fenetre.add(panel_section3, gbc_fenetre);

		gbc_fenetre.gridheight = 1;
		gbc_fenetre.gridwidth = 4;
		gbc_fenetre.gridx = 0;
		gbc_fenetre.gridy = 3;
		panel_fenetre.add(submit, gbc_fenetre);
		
		gbc_fenetre.gridy = 0;
		panel_fenetre.add(label_parametre, gbc_fenetre);

		this.add(panel_fenetre);

		//Ne rend pas la fenêtre visible quand on la créé

		this.setTitle("Visuals Music - Settings");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setResizable(false);
		this.setVisible(true);
		this.pack();
		
	}

	public void update(Observable o, Object arg) {



	}

}
