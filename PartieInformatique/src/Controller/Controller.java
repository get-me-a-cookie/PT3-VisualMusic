package Controller;

import Model.Model;

/**
 * Classe permettant de faciliter la structure MVC
 * Définit un Model qui sera commun à tout les Controller
 * 	et un Constructeur initialisant ce model
 * 
 * @author goodw
 */
public abstract class Controller {

	/**
	 * Model permettant la structure MVC
	 * Sera partager par toute les classes filles
	 */
	protected Model model;
	
	/**
	 * Adaptateur entre les composant graphique et les controlleur
	 */
	protected Adapteur_ControllerVue handler;

	/**
	 * Constructeur instanciant le Modèle permettant la 
	 * 	structure MVC
	 * @param model   : Instanciant le Model
	 * @param handler : Instanciant l'adapteur
	 */
	public Controller(Model model,
			Adapteur_ControllerVue handler) {
		
		super();
		this.handler = handler;
		this.model = model;
		
	}
	
}
