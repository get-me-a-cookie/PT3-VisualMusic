/**
 * 
 */
package View;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
/*
 * #############################################################
 * #############################################################
 * #############################################################
 * #############################################################
 * #############################################################
 * #############################################################
 * #############################################################
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 					Classe qui sera delete
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * #############################################################
 * #############################################################
 * #############################################################
 * #############################################################
 * #############################################################
 * #############################################################
 * #############################################################
 */
/**
 * @author goodw
 *
 */
public class Vue_TextField_PlusMoins extends JPanel {
	
	/**
	 * TODO
	 */
	public Vue_TextField_PlusMoins(JButton button1,
			JTextField textField,
			JButton button2) {
		
		super();
		
		this.setLayout(new GridLayout(3,1));
		
		button1.setPreferredSize(new Dimension(
				textField.getPreferredSize().width,
				5));
		button2.setPreferredSize(new Dimension(
				textField.getPreferredSize().width,
				10));
		
		this.add(button1);
		this.add(textField);
		this.add(button2);
		
	}

}
