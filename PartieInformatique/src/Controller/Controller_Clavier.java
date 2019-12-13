package Controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;

import Model.Model;

/**
 * 
 * @author goodw
 *
 * Classe implémentant KeyListener 
 * 
 * Instancié uniquement pour permettre de mettre des racourcis clavier
 * 	comme presser la touche ESPACE pour mettre en pause/lecture
 */
public class Controller_Clavier extends Controller implements KeyListener {

	/**
	 * Constructeur utilisant le Constructeur Parent
	 * @param model   : Instanciant le Model
	 * @param handler : Instanciant l'adapteur
	 */
	public Controller_Clavier(Model model,
			Adapteur_ControllerVue handler) {
		super(model, handler);
	}

	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		//fonctionne mais met du temps à se faire - touche espace pour
		// play ou pause
		if(e.getKeyCode() == KeyEvent.VK_SPACE) {
			if(model.isFileLoaded()) {
				JButton bouton = (JButton) e.getSource();
				
				//Controle le bouton play
				if (bouton.getText().equals("Play")) {
					
					bouton.setText("Pause");
					model.lectureFichier();
					
					if (model.getMusique().isPause()) 
						model.getMusique().setPause(false);
					
					return;
					
				}
			}
		}
		//on appuye sur echap pour quitter -> vue s'affiche ?
		if(e.getKeyCode() == KeyEvent.VK_ESCAPE) {
			
		}
	}

	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
