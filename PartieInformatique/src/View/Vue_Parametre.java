/**
 * 
 */
package View;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;

/**
 * @author goodw
 *
 */
public class Vue_Parametre extends JFrame implements Observer {

	/**
	 * 
	 */
	public Vue_Parametre() {
		
		super();
		
		//Ne rend pas la fenêtre visible quand on la créé
		
		this.setTitle("Visuals Music - Settings");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setResizable(false);
		this.pack();
		
	}

	public void update(Observable o, Object arg) {
		
		
		
	}

}
