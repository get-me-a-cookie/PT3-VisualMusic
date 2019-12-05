package Controller;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.JMenuItem;

import Model.Model;
import View.Vue_2D;
import View.Vue_3D;

/**
 * 
 * @author goodw
 * 
 * Classe implémentant ActionListener
 * 
 * Instancié uniquement pour les JMenuItem du JMenu "Fichier"
 */
public class Controller_Menu extends Controller implements ActionListener  {

	/**
	 * Constructeur utilisant le Constructeur Parent
	 * @param model   : Instanciant le Model
	 * @param handler : Instanciant l'adapteur
	 */
	public Controller_Menu(Model model,
			Adapteur_ControllerVue handler) {
		super(model, handler);
	}

	/**
	 * Méthode de l'interface parente ActionListener
	 * 
	 * Si on clique sur un JMenuItem "Ouvrir un fichier ...", création d'un 
	 * 	FileChooser (permettant de choisir un fichier sur l'espace disque)
	 * 	qui renvoi et ouvre le fichier choisit
	 */
	public void actionPerformed(ActionEvent arg0) {
		JMenuItem menu = (JMenuItem) arg0.getSource();
		if (menu.getText().equals("Ouvrir un fichier...")) {
			/*// TODO A décommenter ...
			JFileChooser fc = new JFileChooser();
			int valeur_de_retour = fc.showOpenDialog(null);
			if (valeur_de_retour == JFileChooser.APPROVE_OPTION) {
				model.setFichier(fc.getSelectedFile());
			}
			 */		 
		}
		if (menu.getText().equals("2D") && menu.isSelected()) {
			JFrame fenetre	= null;
			Vue_2D twoD 	= null;
			Vue_3D threeD 	= null;
			for (Component b : handler.getComponent()) {
				if (b instanceof JFrame) {
					fenetre = (JFrame) b;
				}
				if (b instanceof Vue_2D) {
					twoD = (Vue_2D) b;
				}
				if (b instanceof Vue_3D) {
					threeD = (Vue_3D) b;
				}
			}
			try {
				fenetre.remove(threeD);
				fenetre.add(twoD, BorderLayout.CENTER);
				fenetre.repaint();
			}
			catch (NullPointerException e) {
				System.out.println("erreur2");
			}
		}
		if (menu.getText().equals("3D") && menu.isSelected()) {
			JFrame fenetre	= null;
			Vue_2D twoD 	= null;
			Vue_3D threeD 	= null;
			for (Component b : handler.getComponent()) {
				if (b instanceof JFrame) {
					fenetre = (JFrame) b;
				}
				if (b instanceof Vue_2D) {
					twoD = (Vue_2D) b;
				}
				if (b instanceof Vue_3D) {
					threeD = (Vue_3D) b;
				}
			}
			try {
				fenetre.remove(twoD);
				fenetre.add(threeD, BorderLayout.CENTER);
				fenetre.repaint();
			}
			catch (NullPointerException e) {
				System.out.println("erreur3");
			}
		}
		model.setFichier(new File("res/auprintemps.wav"));	//TODO A supprimer
	}
}

