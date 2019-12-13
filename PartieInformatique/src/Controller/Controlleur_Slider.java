package Controller;

import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import Model.Model;
/**
 * Classe qui permettra de gèrer le son lorsque 
 * l'utilisateur va le changer
 * @author perri
 *
 */
public class Controlleur_Slider extends Controller implements ChangeListener {
	
	public Controlleur_Slider(Model model, Adapteur_ControllerVue handler) {
		
		super(model, handler);
		
	}

	/*
	 * A implémenter pour que le "click" fait pour changer
	 * le volume est ajoutée au slider
	 * Sachant que la modification du nombre 
	 * ne modifie pas pour le moment le volume
	 */
	public void stateChanged(ChangeEvent arg0) {
		
		
	        
	}
}
