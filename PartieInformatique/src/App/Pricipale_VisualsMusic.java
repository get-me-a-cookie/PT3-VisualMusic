package App;

import Model.Model;
import View.Vue_Fenetre;
import View.Vue_Parametre;

public class Pricipale_VisualsMusic {

	/**
	 * Lance notre application
	 */
	public static void main (String[] args) {

		Model model = new Model();
		
		//partage du model pour les Controller
		Vue_Fenetre Frame = new Vue_Fenetre(model);
		Vue_Parametre settings = new Vue_Parametre(model);
		
		model.addObserver(settings);

	}

}
