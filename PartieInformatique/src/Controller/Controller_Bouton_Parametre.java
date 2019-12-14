/**
 * 
 */
package Controller;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;

import javax.swing.JButton;

import Model.Model;

/**
 * @author goodw
 *
 */
public class Controller_Bouton_Parametre extends Controller implements ActionListener {

	/**
	 * 
	 */
	public Controller_Bouton_Parametre(Model model,
			Set<Component> handler) {

		super(model, handler);

	}


	public void actionPerformed(ActionEvent arg0) {

		JButton bouton = (JButton) arg0.getSource();

		if (bouton.getText().equals("Appliquer & quitter") {

			for (Component b : handler.getComponent()) {

				if (b instanceof JButton) {

					if (((JButton) b).getText().equals("Pause"))
						((JButton) b).setText("Play");

				}
			}


		}

	}

}
