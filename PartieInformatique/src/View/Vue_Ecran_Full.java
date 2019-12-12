package View;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;

import Model.Model;

public class Vue_Ecran_Full  extends JFrame implements Observer{

	private boolean pleine_ecran;
	
	public Vue_Ecran_Full() {
		pleine_ecran = false;
	}
	
	public void fullScreen() {
		Dimension tailleEcran = Toolkit.getDefaultToolkit().
				getScreenSize();	
		int height = tailleEcran.height;
		int width = tailleEcran.width;

		if(pleine_ecran) {
			pleine_ecran = false;
			// On récuper la taille de l'écran
			this.setSize(width/2, height/2);
			this.setLocationRelativeTo(null);
			this.repaint();
			
		}
		else {
			pleine_ecran = true;
			this.setExtendedState(this.MAXIMIZED_BOTH);
			this.repaint();
		
		}
	}
	public boolean getBoolean() {
		return pleine_ecran;
	}
	
	public void setPleineecran(boolean pleine_ecran) {
		this.pleine_ecran = pleine_ecran;
	}
	@Override
	public void update(Observable m, Object arg) {
		// TODO Auto-generated method stub
		Model mod = (Model) m;
		
	}
}
