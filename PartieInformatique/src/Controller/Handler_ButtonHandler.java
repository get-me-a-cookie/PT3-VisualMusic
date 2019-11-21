/**
 * 
 */
package Controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.JButton;


/*
 * Moyen que la classe soit inutile
 * Set directement dans les COntroller
 */
//TODO javadoc

/**
 * @author goodw
 *
 */
public class Handler_ButtonHandler {

	Set<JButton> boutons;

	/**
	 * 
	 */
	public Handler_ButtonHandler() {
		super();
		boutons = new HashSet<JButton>();
	}

	public Set<JButton> getBoutons() {
		return boutons;
	}
	
}
