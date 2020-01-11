package Controller;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.io.File;
import java.util.Set;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

import Model.Model;
import View.Vue_2D;
import View.Vue_3D;

/**
 * 
 * Classe implémentant ActionListener et MenuListener
 * Sert à gérer tous les actions de la barre de menu
 * 
 * Goodwin
 * 	Création et implémentation de la classe entière
 */
public class Controller_Menu extends Controller implements ActionListener, MenuListener  {

	/**
	 * Constructeur utilisant le Constructeur Parent
	 * 
	 * @param model   : Instanciant le Model
	 * @param handler : Instanciant l'adapteur
	 */
	public Controller_Menu(Model model,
			Set<Component> handler) {

		super(model, handler);

	}

	/**
	 * Méthode de l'interface parente ActionListener
	 * 
	 * Ouvrir un fichier ... : création d'un FileChooser (permettant de choisir 
	 * 	un fichier sur l'espace disque) qui renvoi et ouvre le fichier choisit
	 * 
	 * 2D : affiche le visualiseur 2D
	 * 3D : affiche le visualiseur 3D
	 */
	public void actionPerformed(ActionEvent arg0) {

		JMenuItem menuItem = (JMenuItem) arg0.getSource();		

		if (menuItem.getText().equals("Ouvrir un fichier...")) {

			model.setFichier(new File("res/auprintemps-44100-32.wav"));	//TODO A supprimer
			// TODO A décommenter ...
			/*JFileChooser fc = new JFileChooser();
			int valeur_de_retour = fc.showOpenDialog(null);

			if (valeur_de_retour == JFileChooser.APPROVE_OPTION)
				model.setFichier(fc.getSelectedFile());
			*/
			return;
			
		}

		if (menuItem.getText().equals("2D") && menuItem.isSelected()) {

			model.setIsThreeDimension(false);
			model.setChangingDimension(true);
			
			return;
		}

		if (menuItem.getText().equals("3D") && menuItem.isSelected()) {

			model.setIsThreeDimension(true);
			model.setChangingDimension(true);
			
			return;

		}		
	}

	/**
	 * Quand un menu est annulé
	 * 	Non implémenter
	 */
	public void menuCanceled(MenuEvent arg0) {}

	/**
	 * Quand un menu est dé-sélectionné
	 * 	Non implémenter
	 */
	public void menuDeselected(MenuEvent arg0) {}

	/**
	 * Quand on selectionne un menu
	 * 
	 * Paramètre : affiche la fenêtre des paramètres
	 */
	public void menuSelected(MenuEvent arg0) {

		JMenu menu = (JMenu) arg0.getSource();

		if (menu.getText().equals("Paramètres")) {

			model.setPrintSettings(true);
			
			return;

		}
	}
}

