/**
 * 
 */
package View;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * @author goodw
 *
 */
public class Vue_JMenu_TextField extends JPanel {

	/**
	 * 
	 */
	public Vue_JMenu_TextField(JButton button1,
			JTextField textField,
			JButton button2,
			JLabel label) {
		
		super();
		
		this.setLayout(new GridBagLayout());
		
		GridBagConstraints gbc = new GridBagConstraints();

		gbc.gridx = 0;
		gbc.gridy = 0;
		this.add(button1);
		
		gbc.gridy = 1;
		this.add(textField);

		gbc.gridy = 2;
		this.add(button2);

		gbc.gridx = 1;
		gbc.gridy = 1;
		this.add(label);
		
	}

}
