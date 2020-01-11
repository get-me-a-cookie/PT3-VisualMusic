package Controller;

import java.awt.Component;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileNotFoundException;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JSlider;

import Model.Model;

/**
 * Classe implémentant KeyListener
 * Sert à mettre des racourcis clavier
 * 	Espace : pause/lecture
 * 
 * @author
 * Goodwin
 * 	Création de la classe et refonte totale da la classe car erreurs
 * Perrin
 * 	Implémentation de la classe entière
 */
public class Controller_Clavier extends Controller implements KeyListener {

	/**
	 * Constructeur utilisant le Constructeur Parent
	 * 
	 * @param model   : Instanciant le Model
	 * @param handler : Instanciant l'adapteur
	 */
	public Controller_Clavier(Model model,
			Set<Component> handler) {

		super(model, handler);

	}

	/**
	 * Quand une touche est pressé fait l'action correpondante
	 * Espace	: pause/lecture
	 */
	public void keyPressed(KeyEvent e) {

		//si touche ECHAP, quitte l'app
		if(e.getKeyCode() == KeyEvent.VK_ESCAPE) {

			model.setQuit(true);
			
			return;
			
		}
		
		// si le fichier n'est pas lu alors on affiche une erreur
		if (!model.isFileLoaded()) {

			model.setErreur(new FileNotFoundException());
			
			return;

		}
		
		//Si touche SPACE, pause/lecture
		if(e.getKeyCode() == KeyEvent.VK_SPACE) {

			if (model.isPause()) {

				model.lectureFichier();
				model.setPause(false); 

			}

			else 
				model.setPause(true);
			
			return;

		}
	}

	public void keyReleased(KeyEvent arg0) {}

	public void keyTyped(KeyEvent arg0) {}

}
