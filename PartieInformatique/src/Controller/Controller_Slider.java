package Controller;

import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import Model.Model;
/**
 * Classe qui permettra de gèrer le son lorsque 
 * l'utilisateur le modifie sur le slider
 * 
 * @author
 * Goodwin
 *  Implémentation de la classe
 */
public class Controller_Slider extends Controller implements ChangeListener {

	/**
	 * Constructeur utilisant le Constructeur Parent
	 * 
	 * @param model   : Instanciant le Model
	 */
	public Controller_Slider(Model model) {
		
		super(model);
		
	}
	
	/**
	 * Métode de l'interface ChangeListener
	 * 
	 * Quand on modifie le slider, on modifie le son
	 */
	public void stateChanged(ChangeEvent arg0) {
		
		JSlider volume = (JSlider) arg0.getSource();
		
		model.setVolume(volume.getValue());
		
	}
}
