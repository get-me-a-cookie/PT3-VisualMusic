package View;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import Model.Model;

/**
 * Classe Définissant une fenetre essentiellement composé
 * de TextField permettant de modifié des paramètres.
 * 
 * C'est paramètres peuvent être utilisé pour modifié
 * l'affichage
 * 
 * @author
 * Goodwin
 * 	Création et implémentation de la classe entière
 */
public class Vue_Parametre extends JFrame implements Observer {

	/**
	 * Toute l'interface
	 */
	private JPanel panel_fenetre;

	/**
	 * Les contraintes du GridBagLayout relatif à la fenentre
	 */
	private GridBagConstraints gbc_fenetre;

	/**
	 * Première partie de l'IG
	 */
	private JPanel panel_section1;

	/**
	 * Les contraintes du GridBagLayout relatif à la partie 1
	 */
	private GridBagConstraints gbc_section1;

	/**
	 * Deuxieme partie de l'IG
	 */
	private JPanel panel_section2;

	/**
	 * Les contraintes du GridBagLayout relatif à la partie 2
	 */
	private GridBagConstraints gbc_section2;

	/**
	 * Troisieme partie de l'IG
	 */
	private JPanel panel_section3;

	/**
	 * Les contraintes du GridBagLayout relatif à la partie 3
	 */
	private GridBagConstraints gbc_section3;

	/**
	 * Quatrieme partie de l'IG
	 */
	private JPanel panel_section4;

	/**
	 * Les contraintes du GridBagLayout relatif à la partie 4
	 */
	private GridBagConstraints gbc_section4;

	/**
	 * Cinquieme partie de l'IG
	 */
	private JPanel panel_section5;

	/**
	 * Les contraintes du GridBagLayout relatif à la partie 5
	 */
	private GridBagConstraints gbc_section5;

	/**
	 * Le titre du panel principal
	 */
	private JLabel label_parametre;

	/**
	 * Le titre du panel relatif à l'affichage
	 */
	private JLabel label_affichage;

	/**
	 * Titre du texteField relatif à l'espacement
	 */
	private JLabel label_affichage_espacement;

	/**
	 * Titre du texteField relatif à l'epaisseur
	 */
	private JLabel label_affichage_epaisseur;

	/**
	 * Titre du texteField relatif à l'amplitude
	 */
	private JLabel label_affichage_amplitude;

	/**
	 * Unité du texteField relatif à l'espacement
	 */
	private JLabel label_affichage_espacement_px;

	/**
	 * Unité du texteField relatif à l'epaisseur
	 */
	private JLabel label_affichage_epaisseur_px;

	/**
	 * Unité du texteField relatif à l'amplitude
	 */
	private JLabel label_affichage_amplitude_pourCent;

	/**
	 * Le titre du panel relatif aux couleur 2d
	 */
	private JLabel label_couleur_2d;

	/**
	 * Le titre du panel relatif aux couleur 3d
	 */
	private JLabel label_couleur_3d;

	/**
	 * Titre du texteField relatif a la couleur rouge 
	 * des traits de l'affichage 2d
	 */
	private JLabel label_couleur_2d_trait_red;

	/**
	 * Titre du texteField relatif a la couleur verte 
	 * des traits de l'affichage 2d
	 */
	private JLabel label_couleur_2d_trait_green;

	/**
	 * Titre du texteField relatif a la couleur bleu 
	 * des traits de l'affichage 2d
	 */
	private JLabel label_couleur_2d_trait_blue;

	/**
	 * Titre du texteField relatif a la couleur rouge 
	 * des formes de l'affichage 2d
	 */
	private JLabel label_couleur_2d_forme_red;

	/**
	 * Titre du texteField relatif a la couleur verte 
	 * des formes de l'affichage 2d
	 */
	private JLabel label_couleur_2d_forme_green;

	/**
	 * Titre du texteField relatif a la couleur bleu 
	 * des formes de l'affichage 2d
	 */
	private JLabel label_couleur_2d_forme_blue;

	/**
	 * Titre du texteField relatif a la couleur rouge 
	 * l'affichage 3d
	 */
	private JLabel label_couleur_3d_red;

	/**
	 * Titre du texteField relatif a la couleur verte 
	 * l'affichage 3d
	 */
	private JLabel label_couleur_3d_green;

	/**
	 * Titre du texteField relatif a la couleur bleu 
	 * l'affichage 3d
	 */
	private JLabel label_couleur_3d_blue;

	/**
	 * Titre de la section 2D
	 */
	private JLabel label_2d;

	/**
	 * Titre de la section 2d relative au trait
	 */
	private JLabel label_2d_trait;

	/**
	 * Titre de la section 2d relative au trait
	 */
	private JLabel label_2d_forme;

	/**
	 * Titre de la section 3D
	 */
	private JLabel label_3d;

	/**
	 * Titre de la section 3d relative au cube 1
	 */
	private JLabel label_3d_cube1;

	/**
	 * Titre de la section 3d relative au cube 2
	 */
	private JLabel label_3d_cube2;

	/**
	 * Titre de la section 3d relative au cube 3
	 */
	private JLabel label_3d_cube3;

	/**
	 * Titre de la section 3d relative au cube 4
	 */
	private JLabel label_3d_cube4;

	/**
	 * textField relatif à l'espacement
	 */
	private JTextField textField_affichage_espacement;

	/**
	 * textField relatif à l'epaisseur
	 */
	private JTextField textField_affichage_epaisseur;

	/**
	 * textField relatif à l'amplitude
	 */
	private JTextField textField_affichage_amplitude;

	/**
	 * textField relatif à la couleur rouge
	 * des traits de l'affichage 2D
	 */
	private JTextField textField_2d_couleur_trait_red;

	/**
	 * textField relatif à la couleur verte
	 * des traits de l'affichage 2D
	 */
	private JTextField textField_2d_couleur_trait_green;

	/**
	 * textField relatif à la couleur bleu
	 * des traits de l'affichage 2D
	 */
	private JTextField textField_2d_couleur_trait_blue;

	/**
	 * textField relatif à la couleur rouge
	 * des formes de l'affichage 2D
	 */
	private JTextField textField_2d_couleur_forme_red;

	/**
	 * textField relatif à la couleur verte
	 * des traits de l'affichage 2D
	 */
	private JTextField textField_2d_couleur_forme_green;

	/**
	 * textField relatif à la couleur bleu
	 * des traits de l'affichage 2D
	 */
	private JTextField textField_2d_couleur_forme_blue;

	/**
	 * textField relatif à la couleur rouge
	 * du cube 1 de l'affichage 3d
	 */
	private JTextField textField_3d_couleur_cube1_red;

	/**
	 * textField relatif à la couleur verte
	 * du cube 1 de l'affichage 3d
	 */
	private JTextField textField_3d_couleur_cube1_green;

	/**
	 * textField relatif à la couleur bleu
	 * du cube 1 de l'affichage 3d
	 */
	private JTextField textField_3d_couleur_cube1_blue;

	/**
	 * textField relatif à la couleur rouge
	 * du cube 1 de l'affichage 3d
	 */
	private JTextField textField_3d_couleur_cube2_red;

	/**
	 * textField relatif à la couleur verte
	 * du cube 1 de l'affichage 3d
	 */
	private JTextField textField_3d_couleur_cube2_green;

	/**
	 * textField relatif à la couleur bleu
	 * du cube 1 de l'affichage 3d
	 */
	private JTextField textField_3d_couleur_cube2_blue;

	/**
	 * textField relatif à la couleur rouge
	 * du cube 1 de l'affichage 3d
	 */
	private JTextField textField_3d_couleur_cube3_red;

	/**
	 * textField relatif à la couleur verte
	 * du cube 1 de l'affichage 3d
	 */
	private JTextField textField_3d_couleur_cube3_green;

	/**
	 * textField relatif à la couleur bleu
	 * du cube 1 de l'affichage 3d
	 */
	private JTextField textField_3d_couleur_cube3_blue;

	/**
	 * textField relatif à la couleur rouge
	 * du cube 1 de l'affichage 3d
	 */
	private JTextField textField_3d_couleur_cube4_red;

	/**
	 * textField relatif à la couleur verte
	 * du cube 1 de l'affichage 3d
	 */
	private JTextField textField_3d_couleur_cube4_green;

	/**
	 * textField relatif à la couleur bleu
	 * du cube 1 de l'affichage 3d
	 */
	private JTextField textField_3d_couleur_cube4_blue;

	/**
	 * checkbox relative aux couleur 2d random ou non
	 */
	private JCheckBox checkbox_2d_couleur_random;

	/**
	 * checkbox relative aux couleur 3d random ou non
	 */
	private JCheckBox checkbox_3d_couleur_random;

	/**
	 * checkbox relative à l'autoplay actif ou non
	 */
	private JCheckBox checkbox_autoplay;

	/**
	 * Slider modifiant les aigues
	 */
	private JSlider slider_aigu;

	/**
	 * Slider modifiant les graves
	 */
	private JSlider slider_grave;

	/**
	 * Slider modifiant la vitesse
	 */
	private JSlider slider_vitesse;

	/**
	 * Bouton de validation
	 */
	private JButton submit;

	/**
	 * Bordure intérieur des panels
	 */
	private Border insideBorder;

	/**
	 * Bordure des panels
	 */
	private Border compound;

	/**
	 * Créateur de l'IG toute entière
	 */
	public Vue_Parametre(Model model) {

		super();

		this.addWindowListener(new WindowAdapter() {

			public void windowClosing(WindowEvent windowEvent) {

				if (JOptionPane.showConfirmDialog(null, 
						"Tout éléments non sauvegardé ne sera pas pris en compte"
								+ "\n\n"
								+ "Êtes-vous sur de vouloir continuer ?",
								"Fermer les paramètres ?", 
								JOptionPane.YES_NO_OPTION,
								JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) 

					model.setPrintSettings(false);
				
			}
		});

		/*
		 * Creation des composants
		 */

		panel_fenetre 	= new JPanel(new GridBagLayout());
		gbc_fenetre 	= new GridBagConstraints();

		panel_section1 	= new JPanel(new GridBagLayout());
		gbc_section1	= new GridBagConstraints();

		panel_section2 	= new JPanel(new GridBagLayout());
		gbc_section2 	= new GridBagConstraints();

		panel_section3 	= new JPanel(new GridBagLayout());
		gbc_section3 	= new GridBagConstraints();
		
		panel_section4 	= new JPanel(new GridBagLayout());
		gbc_section4 	= new GridBagConstraints();

		panel_section5 	= new JPanel(new GridBagLayout());
		gbc_section5 	= new GridBagConstraints();



		label_parametre = new JLabel("Paramètres");

		label_affichage 					= new JLabel("Affichage");
		label_affichage_espacement 			= new JLabel("Espacement");
		label_affichage_epaisseur 			= new JLabel("Epaisseur");
		label_affichage_amplitude 			= new JLabel("Amplitude");
		label_affichage_espacement_px 		= new JLabel("px");
		label_affichage_epaisseur_px 		= new JLabel("px");
		label_affichage_amplitude_pourCent	= new JLabel("%");

		label_couleur_2d 				= new JLabel("Couleur");
		label_couleur_3d 				= new JLabel("Couleur");
		label_couleur_2d_trait_red 		= new JLabel("R");
		label_couleur_2d_trait_green 	= new JLabel("G");
		label_couleur_2d_trait_blue 	= new JLabel("B");
		label_couleur_2d_forme_red 		= new JLabel("R");
		label_couleur_2d_forme_green 	= new JLabel("G");
		label_couleur_2d_forme_blue 	= new JLabel("B");
		label_couleur_3d_red 			= new JLabel("R");
		label_couleur_3d_green 			= new JLabel("G");
		label_couleur_3d_blue 			= new JLabel("B");

		label_2d		= new JLabel("2D");
		label_2d_trait	= new JLabel("Trait");
		label_2d_forme	= new JLabel("Forme");

		label_3d		= new JLabel("3D");
		label_3d_cube1	= new JLabel("Cube 1");
		label_3d_cube2	= new JLabel("Cube 2");
		label_3d_cube3	= new JLabel("Cube 3");
		label_3d_cube4	= new JLabel("Cube 4");


	
		textField_affichage_espacement 		= new JTextField(4);
		textField_affichage_epaisseur 		= new JTextField(4);
		textField_affichage_amplitude  		= new JTextField(4);

		textField_2d_couleur_trait_red		= new JTextField(4);
		textField_2d_couleur_trait_green	= new JTextField(4);
		textField_2d_couleur_trait_blue		= new JTextField(4);

		textField_2d_couleur_forme_red		= new JTextField(4);
		textField_2d_couleur_forme_green	= new JTextField(4);
		textField_2d_couleur_forme_blue		= new JTextField(4);

		textField_3d_couleur_cube1_red		= new JTextField(4);
		textField_3d_couleur_cube1_green	= new JTextField(4);
		textField_3d_couleur_cube1_blue		= new JTextField(4);

		textField_3d_couleur_cube2_red		= new JTextField(4);
		textField_3d_couleur_cube2_green	= new JTextField(4);
		textField_3d_couleur_cube2_blue		= new JTextField(4);

		textField_3d_couleur_cube3_red		= new JTextField(4);
		textField_3d_couleur_cube3_green	= new JTextField(4);
		textField_3d_couleur_cube3_blue		= new JTextField(4);

		textField_3d_couleur_cube4_red		= new JTextField(4);
		textField_3d_couleur_cube4_green	= new JTextField(4);
		textField_3d_couleur_cube4_blue		= new JTextField(4);



		checkbox_2d_couleur_random	= new JCheckBox("Aléatoire");
		checkbox_3d_couleur_random	= new JCheckBox("Aléatoire");
		checkbox_autoplay			= new JCheckBox("Autoplay");



		slider_aigu		= new JSlider(-15, 15);
		slider_grave	= new JSlider(-15, 15);
		slider_vitesse	= new JSlider(-15, 15);



		submit = new JButton("Appliquer & quitter");



		insideBorder = BorderFactory.createEtchedBorder();
		compound = BorderFactory.createCompoundBorder(insideBorder, insideBorder);

		/*
		 * Modification des éléments
		 */

		//Textfield align right
		textField_2d_couleur_forme_blue.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_2d_couleur_forme_green.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_2d_couleur_forme_red.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_2d_couleur_trait_blue.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_2d_couleur_trait_green.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_2d_couleur_trait_red.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_3d_couleur_cube1_blue.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_3d_couleur_cube1_green.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_3d_couleur_cube1_red.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_3d_couleur_cube2_blue.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_3d_couleur_cube2_green.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_3d_couleur_cube2_red.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_3d_couleur_cube3_blue.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_3d_couleur_cube3_green.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_3d_couleur_cube3_red.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_3d_couleur_cube4_blue.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_3d_couleur_cube4_green.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_3d_couleur_cube4_red.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_affichage_espacement.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_affichage_amplitude.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_affichage_epaisseur.setHorizontalAlignment(SwingConstants.RIGHT);

		//Disable textField random
		textField_2d_couleur_forme_blue.setEnabled(false);
		textField_2d_couleur_forme_red.setEnabled(false);
		textField_2d_couleur_forme_green.setEnabled(false);
		textField_2d_couleur_trait_blue.setEnabled(false);
		textField_2d_couleur_trait_red.setEnabled(false);
		textField_2d_couleur_trait_green.setEnabled(false);
		textField_3d_couleur_cube1_blue.setEnabled(false);
		textField_3d_couleur_cube1_green.setEnabled(false);
		textField_3d_couleur_cube1_red.setEnabled(false);
		textField_3d_couleur_cube2_blue.setEnabled(false);
		textField_3d_couleur_cube2_green.setEnabled(false);
		textField_3d_couleur_cube2_red.setEnabled(false);
		textField_3d_couleur_cube3_blue.setEnabled(false);
		textField_3d_couleur_cube3_green.setEnabled(false);
		textField_3d_couleur_cube3_red.setEnabled(false);
		textField_3d_couleur_cube4_blue.setEnabled(false);
		textField_3d_couleur_cube4_green.setEnabled(false);
		textField_3d_couleur_cube4_red.setEnabled(false);

		//disable element pas encore implémenter
		slider_aigu.setEnabled(false);
		slider_grave.setEnabled(false);
		slider_vitesse.setEnabled(false);

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

		/*
		 * Ajout du controlleur en interne anonyme
		 * pour faciliter l'interaction entre le model et 
		 * les valeur donner par l'utilisateur
		 */
		submit.addActionListener(new ActionListener() {	//class interne anonyle car chiant de retrouvé les Component dans le controller

			public void actionPerformed(ActionEvent e) {

				int textToInt;

				textToInt = Integer.parseInt(textField_affichage_amplitude.getText());
				model.setAmplitude(textToInt);

				textToInt = Integer.parseInt(textField_affichage_epaisseur.getText());
				model.setEpaisseur(textToInt);

				textToInt = Integer.parseInt(textField_affichage_espacement.getText());
				model.setEspacement(textToInt);



				textToInt = Integer.parseInt(textField_2d_couleur_forme_blue.getText());
				model.setCouleur_2d_forme_b(textToInt);

				textToInt = Integer.parseInt(textField_2d_couleur_forme_green.getText());
				model.setCouleur_2d_forme_g(textToInt);

				textToInt = Integer.parseInt(textField_2d_couleur_forme_red.getText());
				model.setCouleur_2d_forme_r(textToInt);



				textToInt = Integer.parseInt(textField_2d_couleur_trait_blue.getText());
				model.setCouleur_2d_trait_b(textToInt);

				textToInt = Integer.parseInt(textField_2d_couleur_trait_green.getText());
				model.setCouleur_2d_trait_g(textToInt);

				textToInt = Integer.parseInt(textField_2d_couleur_trait_red.getText());
				model.setCouleur_2d_trait_r(textToInt);



				textToInt = Integer.parseInt(textField_3d_couleur_cube1_blue.getText());
				model.setCouleur_3d_cube1_b(textToInt);

				textToInt = Integer.parseInt(textField_3d_couleur_cube1_red.getText());
				model.setCouleur_3d_cube1_r(textToInt);

				textToInt = Integer.parseInt(textField_3d_couleur_cube1_green.getText());
				model.setCouleur_3d_cube1_g(textToInt);



				textToInt = Integer.parseInt(textField_3d_couleur_cube2_blue.getText());
				model.setCouleur_3d_cube2_b(textToInt);

				textToInt = Integer.parseInt(textField_3d_couleur_cube2_red.getText());
				model.setCouleur_3d_cube2_r(textToInt);

				textToInt = Integer.parseInt(textField_3d_couleur_cube2_green.getText());
				model.setCouleur_3d_cube2_g(textToInt);



				textToInt = Integer.parseInt(textField_3d_couleur_cube3_blue.getText());
				model.setCouleur_3d_cube3_b(textToInt);

				textToInt = Integer.parseInt(textField_3d_couleur_cube3_red.getText());
				model.setCouleur_3d_cube3_r(textToInt);

				textToInt = Integer.parseInt(textField_3d_couleur_cube3_green.getText());
				model.setCouleur_3d_cube3_g(textToInt);



				textToInt = Integer.parseInt(textField_3d_couleur_cube4_blue.getText());
				model.setCouleur_3d_cube4_b(textToInt);

				textToInt = Integer.parseInt(textField_3d_couleur_cube4_red.getText());
				model.setCouleur_3d_cube4_r(textToInt);

				textToInt = Integer.parseInt(textField_3d_couleur_cube4_green.getText());
				model.setCouleur_3d_cube4_g(textToInt);



				model.setAutoplay(checkbox_autoplay.isSelected());
				model.setCouleur_2d_random(checkbox_2d_couleur_random.isSelected());
				model.setCouleur_3d_random(checkbox_3d_couleur_random.isSelected());



				model.setPrintSettings(false);
				model.parametersChanged(true);

			}
		});



		checkbox_2d_couleur_random.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				if (((JCheckBox)e.getSource()).isSelected()) {

					textField_2d_couleur_forme_blue.setEnabled(false);
					textField_2d_couleur_forme_red.setEnabled(false);
					textField_2d_couleur_forme_green.setEnabled(false);
					textField_2d_couleur_trait_blue.setEnabled(false);
					textField_2d_couleur_trait_red.setEnabled(false);
					textField_2d_couleur_trait_green.setEnabled(false);

				}

				else {

					textField_2d_couleur_forme_blue.setEnabled(true);
					textField_2d_couleur_forme_red.setEnabled(true);
					textField_2d_couleur_forme_green.setEnabled(true);
					textField_2d_couleur_trait_blue.setEnabled(true);
					textField_2d_couleur_trait_red.setEnabled(true);
					textField_2d_couleur_trait_green.setEnabled(true);

				}

			}
		});

		checkbox_3d_couleur_random.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				if (((JCheckBox)e.getSource()).isSelected()) {

					textField_3d_couleur_cube1_blue.setEnabled(false);
					textField_3d_couleur_cube1_green.setEnabled(false);
					textField_3d_couleur_cube1_red.setEnabled(false);
					textField_3d_couleur_cube2_blue.setEnabled(false);
					textField_3d_couleur_cube2_green.setEnabled(false);
					textField_3d_couleur_cube2_red.setEnabled(false);
					textField_3d_couleur_cube3_blue.setEnabled(false);
					textField_3d_couleur_cube3_green.setEnabled(false);
					textField_3d_couleur_cube3_red.setEnabled(false);
					textField_3d_couleur_cube4_blue.setEnabled(false);
					textField_3d_couleur_cube4_green.setEnabled(false);
					textField_3d_couleur_cube4_red.setEnabled(false);

				}

				else {

					textField_3d_couleur_cube1_blue.setEnabled(true);
					textField_3d_couleur_cube1_green.setEnabled(true);
					textField_3d_couleur_cube1_red.setEnabled(true);
					textField_3d_couleur_cube2_blue.setEnabled(true);
					textField_3d_couleur_cube2_green.setEnabled(true);
					textField_3d_couleur_cube2_red.setEnabled(true);
					textField_3d_couleur_cube3_blue.setEnabled(true);
					textField_3d_couleur_cube3_green.setEnabled(true);
					textField_3d_couleur_cube3_red.setEnabled(true);
					textField_3d_couleur_cube4_blue.setEnabled(true);
					textField_3d_couleur_cube4_green.setEnabled(true);
					textField_3d_couleur_cube4_red.setEnabled(true);

				}

			}
		});

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
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE );
		this.setResizable(false);
		this.pack();

	}

	/**
	 * Implémentation de la méthode de l'interface Observer
	 * 
	 * Pré-remplis les champs
	 */
	public void update(Observable o, Object arg) {

		Model model = (Model) o;

		if (model.getErreur() == null) {

			if (model.isPrintSettings()) {

				textField_affichage_espacement.setText("" + model.getEspacement());
				textField_affichage_amplitude.setText("" + model.getAmplitude());
				textField_affichage_epaisseur.setText("" + model.getEpaisseur());
				textField_2d_couleur_forme_blue.setText("" + model.getCouleur_2d_forme_b());
				textField_2d_couleur_forme_green.setText("" + model.getCouleur_2d_forme_g());
				textField_2d_couleur_forme_red.setText("" + model.getCouleur_2d_forme_r());
				textField_2d_couleur_trait_blue.setText("" + model.getCouleur_2d_trait_b());
				textField_2d_couleur_trait_green.setText("" + model.getCouleur_2d_trait_g());
				textField_2d_couleur_trait_red.setText("" + model.getCouleur_2d_trait_r());
				textField_3d_couleur_cube1_blue.setText("" + model.getCouleur_3d_cube1_b());
				textField_3d_couleur_cube1_green.setText("" + model.getCouleur_3d_cube1_g());;
				textField_3d_couleur_cube1_red.setText("" + model.getCouleur_3d_cube1_r());
				textField_3d_couleur_cube2_blue.setText("" + model.getCouleur_3d_cube2_b());
				textField_3d_couleur_cube2_green.setText("" + model.getCouleur_3d_cube2_g());;
				textField_3d_couleur_cube2_red.setText("" + model.getCouleur_3d_cube2_r());
				textField_3d_couleur_cube3_blue.setText("" + model.getCouleur_3d_cube3_b());
				textField_3d_couleur_cube3_green.setText("" + model.getCouleur_3d_cube3_g());;
				textField_3d_couleur_cube3_red.setText("" + model.getCouleur_3d_cube3_r());
				textField_3d_couleur_cube4_blue.setText("" + model.getCouleur_3d_cube4_b());
				textField_3d_couleur_cube4_green.setText("" + model.getCouleur_3d_cube4_g());;
				textField_3d_couleur_cube4_red.setText("" + model.getCouleur_3d_cube4_r());
				checkbox_2d_couleur_random.setSelected(model.isCouleur_2d_random());
				checkbox_3d_couleur_random.setSelected(model.isCouleur_3d_random());
				checkbox_autoplay.setSelected(model.isAutoplay());

				this.setVisible(true);

			}

			else 
				this.setVisible(false);
			
		}
	}
}
