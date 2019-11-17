package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import Model.Model;
import View.Vue_Pleine_Ecran;

public class Controller_Bouton_LecturePause extends Controller implements ActionListener {
	private Vue_Pleine_Ecran vue;
	public Controller_Bouton_LecturePause(Model model) {
		super(model);
		vue = new Vue_Pleine_Ecran();
	}
	
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		JButton bouton = (JButton) arg0.getSource();
		if (bouton.getText().equals("Play")) {
			model.lectureFichier();
			if (model.getMusique().isPause()) model.getMusique().setPause();
		}
		if (bouton.getText().equals("Pause")) {
			if (!model.getMusique().isPause()) model.getMusique().setPause();
		}
		if(bouton.getText().contentEquals("Stop")) {
			model.stop();
		}
		
		if(bouton.getText().contentEquals("Ecran")) {
			vue.FullScreen();
		}
		
	}

}
