package Controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

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
	 * @param model -> Instanciant le Model
	 */
	public Controller_Clavier(Model model) {
		super(model);
	}

	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
