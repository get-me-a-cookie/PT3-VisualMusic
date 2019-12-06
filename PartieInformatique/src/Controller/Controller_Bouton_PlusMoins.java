package Controller;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.BadLocationException;

import Model.Model;
import View.Vue_TextField_PlusMoins;

public class Controller_Bouton_PlusMoins extends Controller implements ActionListener {

	private JTextField textField = null;

	private int valueOfParameter;

	private String textOfLabel = null;

	public Controller_Bouton_PlusMoins(Model model, Adapteur_ControllerVue handler, JTextField tf) {
		super(model, handler);
		textField = tf;
	}		

	public void actionPerformed(ActionEvent arg0) {

		JButton bouton = (JButton) arg0.getSource();

		boolean boutonFind = false;
		boolean labelFind = false;

		for (Component panel : handler.getComponent()) {

			if (!labelFind && panel instanceof JPanel) {

				JPanel componentToJPanel = (JPanel) panel;

				try {

					for (Component vue : componentToJPanel.getComponents()) {

						if (vue	instanceof Vue_TextField_PlusMoins) {

							Vue_TextField_PlusMoins componentToVue = (Vue_TextField_PlusMoins) componentToJPanel.getComponent(0);

							for (Component button : componentToVue.getComponents()) {

								if (button instanceof JButton) {

									JButton componentToJButton = (JButton) button;

									if (componentToJButton == bouton) {

										boutonFind = true;
										break;

									}
								}
							}
						}
					}
				}

				catch (ArrayIndexOutOfBoundsException e) {
					model.setErreur(e);
					return;

				}

				if (boutonFind) {

					for (Component label : componentToJPanel.getComponents()) {

						if (label instanceof JLabel) {

							JLabel componentToJLabel = (JLabel) label;

							if (componentToJLabel.getText().equals("Amplitude")) {

								textOfLabel = "Amplitude";
								labelFind = true; 
								break;

							}

							else if (componentToJLabel.getText().equals("Espacement")) {

								textOfLabel = "Espacement";
								labelFind = true; 
								break;

							}

							else if (componentToJLabel.getText().equals("Epaisseur")) {

								textOfLabel = "Epaisseur";
								labelFind = true; 
								break;

							}
						}
					}
				}
			}
		}

		if (boutonFind && labelFind) {
			
			try {
				
				valueOfParameter = model.getParametres().get(textOfLabel);
				
			}
			
			catch (NullPointerException e) {
				
				model.setErreur(e);
				return;
				
			}

			if (bouton.getText().equals("+")) {
				
				valueOfParameter += 5;
				checkBorne(true, false);
				
				if (textOfLabel.equals("Amplitude")) {
					
					textField.setText(valueOfParameter + " %");
					parametersChanged(textOfLabel, valueOfParameter);
					
				}
				
				else {
					
					if (textOfLabel.equals("Espacement")
							|| textOfLabel.equals("Epaisseur")) {
						
						textField.setText(valueOfParameter + " px");
						parametersChanged(textOfLabel, valueOfParameter);
						
					}
				}
			}
			
			else if (bouton.getText().equals("-")) {
				
				valueOfParameter -= 5;
				checkBorne(true, false);
				
				if (textOfLabel.equals("Amplitude")) {
					
					textField.setText(valueOfParameter + " %");
					parametersChanged(textOfLabel, valueOfParameter);
					
				}
				
				else {
					
					if (textOfLabel.equals("Espacement")
							|| textOfLabel.equals("Epaisseur")) {
						
						textField.setText(valueOfParameter + " %");
						parametersChanged(textOfLabel, valueOfParameter);
						
					}
				}
			}
		}
	}

	private void checkBorne(boolean ABorneZero, boolean ABorneCent) {
		
		if (ABorneCent && valueOfParameter > 100)
			valueOfParameter = 100;
		
		if (ABorneZero && valueOfParameter < 0)
			valueOfParameter = 0;
		
	}

	private void parametersChanged(String label, int value) {
		
		if (!label.isEmpty())
			model.parametersChanged(label, value);
		
	}
}
