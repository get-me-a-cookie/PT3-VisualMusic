package Controller;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Set;

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
	 * @param model   : Instanciant le Model
	 * @param handler : Instanciant l'adapteur
	 */
	public Controller_Souris(Model model,
			Set<Component> handler) {
		
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
