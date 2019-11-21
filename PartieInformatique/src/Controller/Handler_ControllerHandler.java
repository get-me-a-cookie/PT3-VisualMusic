/**
 * 
 */
package Controller;

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
//TODO javadoc

/**
 * @author goodw
 *
 */
public class Handler_ControllerHandler {

	Set<JComponent> component;

	/**
	 * 
	 */
	public Handler_ControllerHandler() {
		component = new HashSet<JComponent>();
	}

	public Set<JComponent> getComponent() {
		return component;
	}
	
}
