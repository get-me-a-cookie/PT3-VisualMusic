package Controller;

import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
/**
 * Classe qui permettra de gèrer le son lorsque 
 * l'utilisateur va le changer
 * @author perri
 *
 */
public class ChangementSon implements ChangeListener{
	// définition des variables
	// la valeur du volume au moment pas changé
	private  int slider;
	// le slider 
	private JSlider slider_son;
	
	// on récupére la valeur du slider
	public ChangementSon(int i) {
		// TODO Auto-generated constructor stub
		this.slider = i;
	}
	@Override
	/*
	 * A implémenter pour que le "click" fait pour changer
	 * le volume est ajoutée au slider
	 * Sachant que la modification du nombre 
	 * ne modifie pas pour le moment le volume
	 */
	public void stateChanged(ChangeEvent arg0) {
		// TODO Auto-generated method stub
		 
	        String str = Integer.toString(slider);
	        
	}
}
