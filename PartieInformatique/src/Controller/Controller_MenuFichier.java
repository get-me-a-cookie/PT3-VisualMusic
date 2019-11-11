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

public class Controller_MenuFichier extends Controller implements ActionListener  {

	public Controller_MenuFichier(Model model) {
		super(model);
	}

	public void actionPerformed(ActionEvent arg0) {
		JMenuItem menu = (JMenuItem) arg0.getSource();
		if (menu.getText().equals("Ouvrir un fichier...")) {
			/* TODO A décommenter ...
			JFileChooser fc = new JFileChooser();
			int valeur_de_retour = fc.showOpenDialog(null);
			if (valeur_de_retour == JFileChooser.APPROVE_OPTION) {
				model.setFichier(fc.getSelectedFile());
			}
			*/
		model.setFichier(new File("res/film.wav"));	//TODO A supprimer
		}
	}
}
