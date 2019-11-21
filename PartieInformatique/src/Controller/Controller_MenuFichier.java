package Controller;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

import Model.Model;

/**
 * 
 * @author goodw
 * 
 * Classe implémentant ActionListener
 * 
 * Instancié uniquement pour les JMenuItem du JMenu "Fichier"
 */
public class Controller_MenuFichier extends Controller implements ActionListener  {

	/**
	 * Constructeur utilisant le Constructeur Parent
	 * @param model : Instanciant le Model
	 */
	public Controller_MenuFichier(Model model) {
		super(model);
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
		model.setFichier(new File("res/son.wav"));	//TODO A supprimer
		}
	}
}
