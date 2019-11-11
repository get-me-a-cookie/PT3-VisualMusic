package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import Model.Model;

public class Controller_Bouton_LecturePause extends Controller implements ActionListener {

	public Controller_Bouton_LecturePause(Model model) {
		super(model);
	}
	
	public void actionPerformed(ActionEvent arg0) {
		if (!model.isFileLoaded()) {
			model.setErreur(true);
			return;
		}
		JButton bouton = (JButton) arg0.getSource();
		if (bouton.getText().equals("Play")) {
			model.lectureFichier();
			if (model.getMusique().isPause()) model.getMusique().setPause();
		}
		if (bouton.getText().equals("Pause")) {
			if (!model.getMusique().isPause()) model.getMusique().setPause();
		}
	}

}
