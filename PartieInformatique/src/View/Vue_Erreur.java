package View;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
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

		if (model.getErreur() instanceof FileNotFoundException) {
			JOptionPane.showMessageDialog(null, 
					"Désolé mais notre hamster s'est perdu, ... \n\nAucun fichier n'a été ouvert !!", 
					"Aucun fichier ouvert !!", ERROR_MESSAGE);
			return;
		}
		
		if (model.getErreur() instanceof NullPointerException) {
			JOptionPane.showMessageDialog(null, 
					"Problème de donnée\n\nL'application a du mal à retrouver certaine donnée, merci de redémarrer l'application", 
					"Fail to find some data !!", ERROR_MESSAGE);
			return;
		}
		
		if (model.getErreur() instanceof UnsupportedAudioFileException) {
			JOptionPane.showMessageDialog(null, 
					"Impossible de lire ce fichier:\nEssayer d'ouvrir un fichier \".wav\".", 
					"File unsupported !!", ERROR_MESSAGE);
			return;
		}
		
		if (model.getErreur() instanceof LineUnavailableException) {
			JOptionPane.showMessageDialog(null, 
					"Problème lors de la lecture du fichier\n\nLa lecture à été interrompus car l'application n'a pas pus accèder aux données audio", 
					"Audio compromis !!", ERROR_MESSAGE);
			return;
		}
		
		if (model.getErreur() instanceof Exception) {
			JOptionPane.showMessageDialog(null, 
					"Problème inconnus...\n\nLe problème est inconnu, merci de faire parvenir un screen de l'application avec le message d'erreur.\n\nstephane.goodwin3@etu.univ-lorraine.fr", 
					"Error !!", ERROR_MESSAGE);
			return;
		}
		
	}

}
