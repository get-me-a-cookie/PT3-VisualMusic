package App;

import Model.Model;

import View.Vue_Fenetre;
import View.Vue_Parametre;

/**
 * Classe lançant l'application Visual's Music
 * 
 * @author
 * Goodwin
 * 	Création et implémentation de la classe entière
 */

public class Pricipale_VisualsMusic {

	/**
	 * Lance notre application
	 */
	public static void main (String[] args) {

		Model model = new Model();
		
		//partage du model pour les Controllers
		Vue_Fenetre Frame = new Vue_Fenetre(model);
		Vue_Parametre settings = new Vue_Parametre(model);
		
		model.addObserver(settings);

	}

}
