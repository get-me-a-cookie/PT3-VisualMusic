package Controller;

import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class ChangementSon implements ChangeListener{

	private  int slider;
	private JSlider slider_son;

	public ChangementSon(int i) {
		// TODO Auto-generated constructor stub
		this.slider = i;
	}
	@Override
	public void stateChanged(ChangeEvent arg0) {
		// TODO Auto-generated method stub
		 
	        String str = Integer.toString(slider);
	        
	}
}
