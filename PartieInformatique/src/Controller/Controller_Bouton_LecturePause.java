package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import Model.Model;

/**
 * 
 * @author goodw
 * 
 * Classe implémentant ActionListener
 * 
 * Instancié uniquement pour les boutons Lecture et Pause
 */
public class Controller_Bouton_LecturePause extends Controller implements ActionListener {

	/**
	 * Constructeur utilisant le Constructeur Parent
	 * @param model -> Instanciant le Model
	 */
	public Controller_Bouton_LecturePause(Model model) {
		super(model);
	}
	
	/**
	 * Méthode de l'interface parente ActionListener
	 * 
	 * Si aucun fichier n'est ouvert, définis une erreur
	 * Si on clique sur un bouton "Play", lecture de la musique et dé-pause
	 * Si on clique sur un bouton "Stop", pause de la musique en cours
	 */
	public void actionPerformed(ActionEvent arg0) {
		if (!model.isFileLoaded()) {
			model.setErreur(1);
			return;
		}
		JButton bouton = (JButton) arg0.getSource();
		if (bouton.getText().equals("Play")) {
			model.lectureFichier();
			if (model.getMusique().isPause()) model.getMusique().setPause(false);
		}
		if (bouton.getText().equals("Pause")) {
			if (!model.getMusique().isPause()) model.getMusique().setPause(true);
		}
	}

}
