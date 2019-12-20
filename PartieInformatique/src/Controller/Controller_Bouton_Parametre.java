/**
 * 
 */
package Controller;

import java.awt.Component;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;

import Model.Model;

/**
 * @author goodw
 *
 */
public class Controller_Bouton_Parametre extends Controller implements ActionListener {

	private static int ESPACE_LABEL_TEXTFIELD = 16;

	private Map<String, Integer> settings = new HashMap<String, Integer>();

	/**
	 * 
	 */
	public Controller_Bouton_Parametre(Model model,
			Set<Component> handler) {

		super(model, handler);

	}


	public void actionPerformed(ActionEvent arg0) {

		JButton bouton = (JButton) arg0.getSource();
		JTextField textField;
		JCheckBox checkbox;
		JSlider slider;
		JPanel panel;
		JLabel label;
		Point locationA;
		Point locationB;
		int textToInt;
		String fieldToString;

		if (bouton.getText().equals("Appliquer & quitter")) {

			for (Component comp : handler) {

				if (comp instanceof JCheckBox) {

					checkbox = (JCheckBox) comp;

					if (checkbox.getText().equals("Autoplay")) {

						settings.put("Autoplay",
								checkbox.isSelected() ? 1 : 0);
						continue;

					}

					else if (checkbox.getParent() instanceof JPanel) {

						panel = (JPanel) checkbox.getParent();

						for (Component compFrere : panel.getComponents()) {

							if (compFrere instanceof JLabel) {

								label = (JLabel) compFrere;

								if (label.getText().equals("2D")) {

									settings.put("Couleur_2d_random",
											checkbox.isSelected() ? 1 : 0);
									break;

								}
								else if (label.getText().equals("3D")) {

									settings.put("Couleur_3d_random",
											checkbox.isSelected() ? 1 : 0);
									break;

								}
							}
						}

						continue;

					}
				}

				if (comp instanceof JTextField) {

					textField = (JTextField) comp;

					if (textField.getParent() instanceof JPanel) {

						panel = (JPanel) textField.getParent();

						for (Component compFrere : panel.getComponents()) {

							if (compFrere instanceof JLabel) {

								label = (JLabel) compFrere;
								locationA = label.getLocation();
								locationB = textField.getLocation();

								if (label.getText().equals("Espacement")
										&& locationB.getY() 
										- locationA.getY()
										- Controller_Bouton_Parametre.ESPACE_LABEL_TEXTFIELD == 0) {

									fieldToString = textField.getText();

									if (fieldToString.length() > 0) {

										textToInt = Integer.parseInt(textField.getText());

										settings.put("Espacement", 
												checkBorne(textToInt, true, false, false));

									}

									break;

								}

								if (label.getText().equals("Epaisseur")
										&& locationB.getY() 
										- locationA.getY()
										- Controller_Bouton_Parametre.ESPACE_LABEL_TEXTFIELD == 0) {

									fieldToString = textField.getText();

									if (fieldToString.length() > 0) {

										textToInt = Integer.parseInt(textField.getText());

										settings.put("Epaisseur", 
												checkBorne(textToInt, true, false, false));

									}

									break;

								}

								if (label.getText().equals("Amplitude")
										&& locationB.getY() 
										- locationA.getY()
										- Controller_Bouton_Parametre.ESPACE_LABEL_TEXTFIELD == 0) {

									fieldToString = textField.getText();

									if (fieldToString.length() > 0) {

										textToInt = Integer.parseInt(textField.getText());

										settings.put("Amplitude", 
												checkBorne(textToInt, true, false, false));

									}

									break;

								}

								if (label.getText().equals("Trait")) {
									
									if (locationB.getY() 
											- locationA.getY()
											- Controller_Bouton_Parametre.ESPACE_LABEL_TEXTFIELD == 0) {

										fieldToString = textField.getText();

										if (fieldToString.length() > 0) {

											textToInt = Integer.parseInt(textField.getText());

											settings.put("Couleur_2d_trait_red", 
													checkBorne(textToInt, true, false, true));

										}

										break;

									}

									if (locationB.getY() 
											- locationA.getY()
											- 2 * Controller_Bouton_Parametre.ESPACE_LABEL_TEXTFIELD == 0) {

										fieldToString = textField.getText();

										if (fieldToString.length() > 0) {

											textToInt = Integer.parseInt(textField.getText());

											settings.put("Couleur_2d_trait_green", 
													checkBorne(textToInt, true, false, true));

										}

										break;

									}

									if (locationB.getY() 
											- locationA.getY()
											- 3 * Controller_Bouton_Parametre.ESPACE_LABEL_TEXTFIELD == 0) {

										fieldToString = textField.getText();

										if (fieldToString.length() > 0) {

											textToInt = Integer.parseInt(textField.getText());

											settings.put("Couleur_2d_trait_blue", 
													checkBorne(textToInt, true, false, true));

										}

										break;

									}

									break;

								}

								if (label.getText().equals("Forme")) {

									if (locationB.getY() 
											- locationA.getY()
											- Controller_Bouton_Parametre.ESPACE_LABEL_TEXTFIELD == 0) {

										fieldToString = textField.getText();

										if (fieldToString.length() > 0) {

											textToInt = Integer.parseInt(textField.getText());

											settings.put("Couleur_2d_forme_red", 
													checkBorne(textToInt, true, false, true));

										}

										break;

									}

									if (locationB.getY() 
											- locationA.getY()
											- 2 * Controller_Bouton_Parametre.ESPACE_LABEL_TEXTFIELD == 0) {

										fieldToString = textField.getText();

										if (fieldToString.length() > 0) {

											textToInt = Integer.parseInt(textField.getText());

											settings.put("Couleur_2d_forme_green",
													checkBorne(textToInt, true, false, true));

										}

										break;

									}

									if (locationB.getY() 
											- locationA.getY()
											- 3 * Controller_Bouton_Parametre.ESPACE_LABEL_TEXTFIELD == 0) {

										fieldToString = textField.getText();

										if (fieldToString.length() > 0) {

											textToInt = Integer.parseInt(textField.getText());

											settings.put("Couleur_2d_forme_blue", 
													checkBorne(textToInt, true, false, true));

										}

										break;

									}

									break;

								}

								if (label.getText().equals("R")) {

									if (locationB.getY() 
											- locationA.getY()
											- Controller_Bouton_Parametre.ESPACE_LABEL_TEXTFIELD == 0) {

										fieldToString = textField.getText();

										if (fieldToString.length() > 0) {

											textToInt = Integer.parseInt(textField.getText());
											
											settings.put("Couleur_3d_cube1_red", 
													checkBorne(textToInt, true, false, true));
											
										}

										break;

									}

									if (locationB.getY() 
											- locationA.getY()
											- 2 * Controller_Bouton_Parametre.ESPACE_LABEL_TEXTFIELD == 0) {

										fieldToString = textField.getText();

										if (fieldToString.length() > 0) {

											textToInt = Integer.parseInt(textField.getText());

											settings.put("Couleur_3d_cube2_red", 
													checkBorne(textToInt, true, false, true));

										}

										break;

									}

									if (locationB.getY() 
											- locationA.getY()
											- 3 * Controller_Bouton_Parametre.ESPACE_LABEL_TEXTFIELD == 0) {

										fieldToString = textField.getText();

										if (fieldToString.length() > 0) {

											textToInt = Integer.parseInt(textField.getText());

											settings.put("Couleur_3d_cube3_red", 
													checkBorne(textToInt, true, false, true));

										}

										break;

									}

									if (locationB.getY() 
											- locationA.getY()
											- 4 * Controller_Bouton_Parametre.ESPACE_LABEL_TEXTFIELD == 0) {

										fieldToString = textField.getText();

										if (fieldToString.length() > 0) {

											textToInt = Integer.parseInt(textField.getText());

											settings.put("Couleur_3d_cube4_red", 
													checkBorne(textToInt, true, false, true));

										}

										break;

									}

									break;

								}

								if (label.getText().equals("G")) {

									if (locationB.getY() 
											- locationA.getY()
											- Controller_Bouton_Parametre.ESPACE_LABEL_TEXTFIELD == 0) {

										fieldToString = textField.getText();

										if (fieldToString.length() > 0) {

											textToInt = Integer.parseInt(textField.getText());

											settings.put("Couleur_3d_cube1_green", 
													checkBorne(textToInt, true, false, true));

										}

										break;

									}

									if (locationB.getY() 
											- locationA.getY()
											- 2 * Controller_Bouton_Parametre.ESPACE_LABEL_TEXTFIELD == 0) {

										fieldToString = textField.getText();

										if (fieldToString.length() > 0) {

											textToInt = Integer.parseInt(textField.getText());

											settings.put("Couleur_3d_cube2_green", 
													checkBorne(textToInt, true, false, true));

										}

										break;

									}

									if (locationB.getY() 
											- locationA.getY()
											- 3 * Controller_Bouton_Parametre.ESPACE_LABEL_TEXTFIELD == 0) {

										fieldToString = textField.getText();

										if (fieldToString.length() > 0) {

											textToInt = Integer.parseInt(textField.getText());

											settings.put("Couleur_3d_cube3_green", 
													checkBorne(textToInt, true, false, true));

										}

										break;

									}

									if (locationB.getY() 
											- locationA.getY()
											- 4 * Controller_Bouton_Parametre.ESPACE_LABEL_TEXTFIELD == 0) {

										fieldToString = textField.getText();

										if (fieldToString.length() > 0) {

											textToInt = Integer.parseInt(textField.getText());

											settings.put("Couleur_3d_cube4_green", 
													checkBorne(textToInt, true, false, true));

										}

										break;

									}

									break;

								}

								if (label.getText().equals("B")) {

									if (locationB.getY() 
											- locationA.getY()
											- Controller_Bouton_Parametre.ESPACE_LABEL_TEXTFIELD == 0) {

										fieldToString = textField.getText();

										if (fieldToString.length() > 0) {

											textToInt = Integer.parseInt(textField.getText());

											settings.put("Couleur_3d_cube1_blue", 
													checkBorne(textToInt, true, false, true));

										}

										break;

									}

									if (locationB.getY() 
											- locationA.getY()
											- 2 * Controller_Bouton_Parametre.ESPACE_LABEL_TEXTFIELD == 0) {

										fieldToString = textField.getText();

										if (fieldToString.length() > 0) {

											textToInt = Integer.parseInt(textField.getText());

											settings.put("Couleur_3d_cube2_blue", 
													checkBorne(textToInt, true, false, true));

										}

										break;

									}

									if (locationB.getY() 
											- locationA.getY()
											- 3 * Controller_Bouton_Parametre.ESPACE_LABEL_TEXTFIELD == 0) {

										fieldToString = textField.getText();

										if (fieldToString.length() > 0) {

											textToInt = Integer.parseInt(textField.getText());

											settings.put("Couleur_3d_cube3_blue", 
													checkBorne(textToInt, true, false, true));

										}

										break;

									}

									if (locationB.getY() 
											- locationA.getY()
											- 4 * Controller_Bouton_Parametre.ESPACE_LABEL_TEXTFIELD == 0) {

										fieldToString = textField.getText();

										if (fieldToString.length() > 0) {

											textToInt = Integer.parseInt(textField.getText());

											settings.put("Couleur_3d_cube4_blue", 
													checkBorne(textToInt, true, false, true));

										}

										break;

									}

									break;

								}
							}
						}

						continue;

					}
				}

				if (comp instanceof JSlider) {

					//TODO truc des slider

				}
			}

			model.parametersChanged(settings);

			model.setPrintSettings(false);

		}
	}


	private int checkBorne(int ACheck, boolean ABorneZero, boolean ABorneCent, boolean ABorne255) {

		if (ABorne255 && ACheck > 255)
			ACheck = 255;

		if (ABorneCent && ACheck > 100)
			ACheck = 100;

		if (ABorneZero && ACheck < 0)
			ACheck = 0;

		return ACheck;

	}

}
