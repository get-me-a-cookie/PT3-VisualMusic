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
		// TODO Auto-generated method stub
		JButton bouton = (JButton) arg0.getSource();
		if (bouton.getText().equals("Play")) {
			model.ouvertureFichier();
			model.preparationLectureFichier();
			model.lectureFichier();
		}
	}

}
