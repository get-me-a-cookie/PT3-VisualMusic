/**
 * 
 */
package View;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.time.temporal.JulianFields;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 * @author goodw
 *
 */
public class Vue_Parametre extends JFrame implements Observer {

	private static int GRID_BAG_CONSTRAINTS_FRAME_SIZE = 18;

	/**
	 * 
	 */
	public Vue_Parametre() {

		super();

		JPanel panel = new JPanel(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();



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



		JSeparator separator_parametre_reste = new JSeparator(SwingConstants.HORIZONTAL);
		JSeparator separator_section4_slider_autoplay = new JSeparator(SwingConstants.HORIZONTAL);
		JSeparator separator_section1_section2 = new JSeparator(SwingConstants.VERTICAL);
		JSeparator separator_section2_section3 = new JSeparator(SwingConstants.VERTICAL);
		JSeparator separator_section3_section4 = new JSeparator(SwingConstants.VERTICAL);

		/*
		 * If you are lost in the GridBagConstraints:
		 * https://docs.google.com/spreadsheets/d/1bSuEb7csMHc0i-HCx7FFaSAbMqYHoHI6-LiGcnqSEtE/edit?usp=sharing
		 * 
		 * It's a small Google Sheet, that we used to do the interface.
		 * 
		 * Now, in the code that is next, I tried to limit all affectations and so calculation
		 * for the CPU, how little they are.
		 * So, it may be a little hard to follow the components adding.
		 */

		/* 
		 * ##################################################
		 * 
		 * Ajout de élément simple (sans gridwidth, gridheight)
		 * 
		 * ##################################################
		 */

		//Première partie, Champs de espacement, epaisseur, amplitude
		gbc.gridx = 1;
		gbc.gridy = 4;
		panel.add(textField_affichage_espacement, gbc);
		gbc.gridy = 6;
		panel.add(textField_affichage_epaisseur, gbc);
		gbc.gridy = 8;
		panel.add(textField_affichage_amplitude, gbc);

		gbc.gridx = 2;
		panel.add(label_affichage_amplitude_pourCent, gbc);
		gbc.gridy = 6;
		panel.add(label_affichage_epaisseur_px, gbc);
		gbc.gridy = 4;
		panel.add(label_affichage_espacement_px, gbc);

		//Deuxième partie, Champs des couleur de 2D
		gbc.gridx = 4;
		gbc.gridy = 6;
		panel.add(label_couleur_2d_trait_red, gbc);
		gbc.gridy = 7;
		panel.add(label_couleur_2d_trait_green, gbc);
		gbc.gridy = 8;
		panel.add(label_couleur_2d_trait_blue, gbc);

		gbc.gridx = 5;
		panel.add(textField_2d_couleur_trait_blue, gbc);
		gbc.gridy = 7;
		panel.add(textField_2d_couleur_trait_green, gbc);
		gbc.gridy = 6;
		panel.add(textField_2d_couleur_trait_red, gbc);

		gbc.gridx = 6;
		gbc.gridy = 6;
		panel.add(label_couleur_2d_forme_red, gbc);
		gbc.gridy = 7;
		panel.add(label_couleur_2d_forme_green, gbc);
		gbc.gridy = 8;
		panel.add(label_couleur_2d_forme_blue, gbc);

		gbc.gridx = 7;
		panel.add(textField_2d_couleur_forme_blue, gbc);
		gbc.gridy = 7;
		panel.add(textField_2d_couleur_forme_green, gbc);
		gbc.gridy = 6;
		panel.add(textField_2d_couleur_forme_red, gbc);

		//Troisième partie, Champs des couleur 3D
		gbc.gridx = 11;
		gbc.gridy = 5;
		panel.add(label_couleur_3d_red, gbc);
		gbc.gridy = 6;
		panel.add(textField_3d_couleur_cube1_red, gbc);
		gbc.gridy = 7;
		panel.add(textField_3d_couleur_cube2_red, gbc);
		gbc.gridy = 8;
		panel.add(textField_3d_couleur_cube3_red, gbc);
		gbc.gridy = 9;
		panel.add(textField_3d_couleur_cube4_red, gbc);

		gbc.gridx = 12;
		panel.add(textField_3d_couleur_cube4_green, gbc);
		gbc.gridy = 8;
		panel.add(textField_3d_couleur_cube3_green, gbc);
		gbc.gridy = 7;
		panel.add(textField_3d_couleur_cube2_green, gbc);
		gbc.gridy = 6;
		panel.add(textField_3d_couleur_cube1_green, gbc);
		gbc.gridy = 5;
		panel.add(label_couleur_3d_green, gbc);

		gbc.gridx = 13;
		panel.add(label_couleur_3d_blue, gbc);
		gbc.gridy = 6;
		panel.add(textField_3d_couleur_cube1_blue, gbc);
		gbc.gridy = 7;
		panel.add(textField_3d_couleur_cube2_blue, gbc);
		gbc.gridy = 8;
		panel.add(textField_3d_couleur_cube3_blue, gbc);
		gbc.gridy = 9;
		panel.add(textField_3d_couleur_cube4_blue, gbc);

		/* 
		 * ##################################################
		 * 
		 * Ajout de élément simple (sans gridwidth, gridheight)
		 * 
		 * ##################################################
		 */

		//Titre Paramètre
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = Vue_Parametre.GRID_BAG_CONSTRAINTS_FRAME_SIZE;
		panel.add(label_parametre, gbc);


		//Première Section

		//Titre affichage
		gbc.gridy = 2;
		gbc.gridwidth = 3;
		panel.add(label_affichage, gbc);

		//Sous Titre espacement
		gbc.gridy = 3;
		panel.add(label_affichage_espacement, gbc);

		//Sous Titre epaisseur
		gbc.gridy = 5;
		panel.add(label_affichage_epaisseur, gbc);

		//Sous Titre amplitude
		gbc.gridy = 7;
		panel.add(label_affichage_amplitude, gbc);


		//Deuxième Section

		//titre 2D
		gbc.gridx = 4;
		gbc.gridy = 2;
		gbc.gridwidth = 4;
		panel.add(label_2d, gbc);

		//Sous titre couleur
		gbc.gridy = 3;
		panel.add(label_couleur_2d, gbc);

		//checkbox random
		gbc.gridy = 4;
		panel.add(checkbox_2d_couleur_random, gbc);

		//sous sous titre trait
		gbc.gridy = 5;
		gbc.gridwidth = 2;
		panel.add(label_2d_trait, gbc);

		//sous sous titre forme
		gbc.gridx = 6;
		gbc.gridy = 5;
		panel.add(label_2d_forme, gbc);


		//Troisème section

		//titre 3D
		gbc.gridx = 9;
		gbc.gridy = 2;
		gbc.gridwidth = 5;
		panel.add(label_3d, gbc);

		//Sous titre couleur
		gbc.gridy = 3;
		panel.add(label_couleur_3d, gbc);

		//checkbox random
		gbc.gridy = 4;
		panel.add(checkbox_3d_couleur_random, gbc);

		//sous sous titre cube1
		gbc.gridy = 6;
		gbc.gridwidth = 2;
		panel.add(label_3d_cube1, gbc);

		//sous sous titre cube2
		gbc.gridy = 7;
		panel.add(label_3d_cube2, gbc);

		//sous sous titre cube3
		gbc.gridy = 8;
		panel.add(label_3d_cube3, gbc);

		//sous sous titre cube4
		gbc.gridy = 9;
		panel.add(label_3d_cube4, gbc);


		//Quatrième section
		
		//slider aigu
		gbc.gridx = 15;
		gbc.gridy = 2;
		gbc.gridwidth = 3;
		panel.add(slider_aigu, gbc);
		
		//slider grave
		gbc.gridy = 3;
		panel.add(slider_grave, gbc);
		
		//slider vitesse
		gbc.gridy = 4;
		panel.add(slider_vitesse, gbc);

		//autoplay
		gbc.gridy = 6;
		panel.add(checkbox_autoplay, gbc);
		
		
		
		
		
		
		
		

		this.add(panel);
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
