package View;

import java.io.FileNotFoundException;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JOptionPane;

import Model.Model;

/**
 * Classe affichant un message d'erreur quand il y en a une
 * 
 * @author goodwin1u
 *
 */
public class Vue_Erreur extends JOptionPane implements Observer {

	/**
	 * Met à jour la vue
	 * Importe l'erreur du Model
	 * Regarde de quelle type elle est, 
	 * et affiche un message correspondant au type
	 */
	public void update(Observable m, Object arg1) {

		Model model = (Model) m;

		if (model.getErreur() instanceof FileNotFoundException)
			JOptionPane.showMessageDialog(null, 
					"Désolé mais notre hamster s'est perdu, ... \n\nAucun fichier n'a été ouvert !!", 
					"Aucun fichier ouvert !!", ERROR_MESSAGE);
		
	}

}
