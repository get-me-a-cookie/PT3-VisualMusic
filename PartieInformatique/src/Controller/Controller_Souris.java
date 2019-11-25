package Controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import Model.Model;

/**
 * 
 * @author goodw
 *
 * Classe implémentant MouseListener 
 * 
 * Instancié uniquement pour permettre de mettre des racourcis souris
 * 	comme cliquer sur les dessin pour mettre en pause/lecture
 */
public class Controller_Souris extends Controller implements MouseListener {

	/**
	 * Constructeur utilisant le Constructeur Parent
	 * @param model : Instanciant le Model
	 */
	public Controller_Souris(Model model,
			Adapteur_ControllerVue handler) {
		super(model, handler);
	}

	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
