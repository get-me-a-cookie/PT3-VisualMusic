package View;

import java.awt.Graphics;
import javax.swing.JPanel;

public class IGAffichage extends JPanel {

	public void paint(Graphics g) { 
		
		g.fillArc(0, 0, 100, 250, 1000, 350);
	}
	
}
