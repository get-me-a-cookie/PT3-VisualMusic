package Controller;

import Model.Model;

/**
 * Classe permettant de faciliter la structure MVC
 * Définit un Model qui sera commun à tout les Controller
 * 	et un Constructeur initialisant ce model
 * 
 * @author
 * Goodwin
 * 	Création et implémentation de la classe entière
 */
public abstract class Controller {

	/**
	 * Model permettant la structure MVC
	 * Sera partager par toute les classes filles
	 */
	protected Model model;

	/**
	 * Constructeur instanciant le Modèle permettant la 
	 * 	structure MVC
	 * 
	 * @param model   : Instanciant le Model
	 */
	public Controller(Model model) {
		
		super();
		
		this.model = model;
		
	}
	
}
