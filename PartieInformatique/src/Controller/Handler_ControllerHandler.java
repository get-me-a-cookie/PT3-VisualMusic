/**
 * 
 */
package Controller;

import java.awt.Component;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JComponent;


/*
 * Moyen que la classe soit inutile
 * Set directement dans les COntroller
 */
/**
 * @author goodw
 *
 */
public class Handler_ControllerHandler {
	// Declaration des variables
	Set<Component> component;

	/**
	 * Constructeur principal
	 * qui créer une hahset
	 */
	public Handler_ControllerHandler() {
		component = new HashSet<Component>();
	}
	/*
	 * permet de connaitre la liste du
	 * handler
	 */
	public Set<Component> getComponent() {
		return component;
	}
	
}
