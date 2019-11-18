package View;

import java.awt.Dimension;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;

import Model.Model;

public class Vue_Pleine_Ecran extends JFrame implements Observer {

	private boolean plein_ecran = false;
	
	
	public void FullScreen() {
		if(plein_ecran) {
			this.setAlwaysOnTop(false);
			
			this.setPreferredSize(
					new Dimension(800,450));
			plein_ecran = false;
			 this.setVisible(true);
		}
		else {
			
			this.setTitle("Visuals Music");
	        this.setSize(500,300);
	        this.setAlwaysOnTop(true);
			this.setExtendedState(JFrame.MAXIMIZED_BOTH);
			 this.setVisible(true);
			plein_ecran = true;
		}
	}
	
	public void update(Observable m, Object obj) {
		// TODO Auto-generated method stub
		
		Model model = (Model) m;
		
	}
}
