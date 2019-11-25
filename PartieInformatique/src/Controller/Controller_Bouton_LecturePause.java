package Controller;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JComponent;

import Model.Model;

/**
 * 
 * @author goodw
 * 
 * Classe impl�mentant ActionListener
 * 
 * Instanci� uniquement pour les boutons Lecture et Pause
 */
public class Controller_Bouton_LecturePause extends Controller implements ActionListener {
	
	/**
	 * Constructeur utilisant le Constructeur Parent
	 * @param model : Instanciant le Model
	 */
	public Controller_Bouton_LecturePause(Model model,
			Handler_ControllerHandler handler) {
		super(model, handler);
	}
	
	/**
	 * M�thode de l'interface parente ActionListener
	 * 
	 * Si aucun fichier n'est ouvert, d�finis une erreur
	 * Si on clique sur un bouton "Play", lecture de la musique et d�-pause
	 * Si on clique sur le bouton "Pause", la musique sera en pause, et le bouton deviendra play
	 * Si on clique sur un bouton "Stop", pause de la musique en cours et 
	 * r�initialisation de la musique qui �tait en cour de lecture
	 * 
	 */
	public void actionPerformed(ActionEvent arg0) {
		// si le fichier n'est pas lu alors on affiche une erreur
		if (!model.isFileLoaded()) {
			model.setErreur(new FileNotFoundException());
			return;
		}
		JButton bouton = (JButton) arg0.getSource();
		//Controle le bouton play
		if (bouton.getText().equals("Play")) {
			bouton.setText("Pause");
			model.lectureFichier();
			if (model.getMusique().isPause()) model.getMusique().setPause(false);
			return;
		}
		//Contorle le bouton pause
		// TODO Remmetre � play quand Slider de progression est finis
		if (bouton.getText().equals("Pause")) {
			bouton.setText("Play");
			if (!model.getMusique().isPause()) model.getMusique().setPause(true);
			return;
		}
		//Controle le bouton stop
		if(bouton.getText().equals("Stop")) {
			model.stop();
			for (Component b : handler.getComponent()) {
				if (((JButton) b).getText().equals("Pause"))
					((JButton) b).setText("Play");
			}
			return;
		}
	}

}
