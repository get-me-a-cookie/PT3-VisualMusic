package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

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
	
	//TODO javadoc
	private Handler_ButtonHandler handler;
	
	/**
	 * Constructeur utilisant le Constructeur Parent
	 * @param model : Instanciant le Model
	 */
	public Controller_Bouton_LecturePause(Model model,
			Handler_ButtonHandler handler) {
		super(model);
		this.handler = handler;
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
			model.setErreur(new FileNotFoundException());
			return;
		}
		JButton bouton = (JButton) arg0.getSource();
		if (bouton.getText().equals("Play")) {
			bouton.setText("Pause");
			model.lectureFichier();
			if (model.getMusique().isPause()) model.getMusique().setPause(false);
			return;
		}
		if (bouton.getText().equals("Pause")) {
			bouton.setText("Play");
			if (!model.getMusique().isPause()) model.getMusique().setPause(true);
			return;
		}
		if(bouton.getText().equals("Stop")) {
			model.stop();
			for (JButton b : handler.getBoutons()) {
				if (b.getText().equals("Pause")) b.setText("Play");
			}
			return;
		}
	}

}
