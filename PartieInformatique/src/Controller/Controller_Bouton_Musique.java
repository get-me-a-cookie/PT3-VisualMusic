package Controller;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

import javax.swing.JButton;

import Model.Model;

/**
 * 
 * Classe implémentant ActionListener
 * 
 * Instancié uniquement pour les boutons Lecture et Pause
 * 
 * @author goodw
 */
public class Controller_Bouton_Musique extends Controller implements ActionListener {

	/**
	 * Constructeur utilisant le Constructeur Parent
	 * @param model   : Instanciant le Model
	 * @param handler : Instanciant l'adapteur
	 */
	public Controller_Bouton_Musique(Model model,
			Adapteur_ControllerVue handler) {
		
		super(model, handler);
		
	}

	/**
	 * Méthode de l'interface parente ActionListener
	 * 
	 * Si aucun fichier n'est ouvert, définis une erreur
	 * Si on clique sur un bouton "Play", lecture de la musique et dé-pause
	 * Si on clique sur le bouton "Pause", la musique sera en pause, et le bouton deviendra play
	 * Si on clique sur un bouton "Stop", pause de la musique en cours et 
	 * réinitialisation de la musique qui était en cour de lecture
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
			
			if (model.getMusique().isPause()) 
				model.getMusique().setPause(false);
			
			return;
			
		}
		
		//Contorle le bouton pause
		// TODO Remmetre à play quand Slider de progression est finis
		if (bouton.getText().equals("Pause")) {
			
			bouton.setText("Play");
			
			if (!model.getMusique().isPause()) 
				model.getMusique().setPause(true);
			
			return;
			
		}
		
		//Controle le bouton stop
		if(bouton.getText().equals("Stop")) {
			
			model.stop();
			
			for (Component b : handler.getComponent()) {
				
				if (b instanceof JButton) {
					
					if (((JButton) b).getText().equals("Pause"))
						((JButton) b).setText("Play");
					
				}
			}
			
			return;
			
		}
	}

}
