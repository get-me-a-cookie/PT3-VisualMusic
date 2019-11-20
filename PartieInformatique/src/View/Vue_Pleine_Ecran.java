package View;

import java.awt.Dimension;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;

import Model.Model;

public class Vue_Pleine_Ecran extends JFrame implements Observer {

	private boolean plein_ecran = false;
	
	
	
	
	public void update(Observable m, Object obj) {
		// TODO Auto-generated method stub
		
		Model model = (Model) m;
		
	}
}
