package Controller;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

import org.omg.CORBA.portable.InputStream;

import Model.Model;

/**
 * 
 * @author goodw
 * 
 * Classe implémentant ActionListener
 * 
 * Instancié uniquement pour les JMenuItem du JMenu "Fichier"
 */
public class Controller_Menu extends Controller implements ActionListener  {

	/**
	 * Constructeur utilisant le Constructeur Parent
	 * @param model : Instanciant le Model
	 */
	public Controller_Menu(Model model) {
		super(model);
	}
	
	/**
	 * Méthode de l'interface parente ActionListener
	 * 
	 * Si on clique sur un JMenuItem "Ouvrir un fichier ...", création d'un 
	 * 	FileChooser (permettant de choisir un fichier sur l'espace disque)
	 * 	qui renvoi et ouvre le fichier choisit
	 */
	public void actionPerformed(ActionEvent arg0) {
		JMenuItem menu = (JMenuItem) arg0.getSource();
		if (menu.getText().equals("Ouvrir un fichier...")) {
			/*// TODO A décommenter ...
			JFileChooser fc = new JFileChooser();
			int valeur_de_retour = fc.showOpenDialog(null);
			if (valeur_de_retour == JFileChooser.APPROVE_OPTION) {
				model.setFichier(fc.getSelectedFile());
			}
			*/
			//test pour lire un mp3 -> erreur
			/*
			 * URLConnection conn = null; 
			 
		     
	         
		    try {
				 conn = new URL("url").openConnection();
				 InputStream is = (InputStream) conn.getInputStream();
				 
				    OutputStream outstream = new FileOutputStream(new File("/res/spiritp3")); // fill in correct file name.
				     
				    byte[] buffer = new byte[4096];
				    int len;
				     
				     
				    while ((len = is.read(buffer)) > -1) {
				        outstream.write(buffer, 0, len);
				    }
				    outstream.close(); // in a finally block of course
				is.close();
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} // fill in the correct http address
		    */

		 
		 model.setFichier(new File("res/son.wav"));	//TODO A supprimer
		    }
	}

		
		
	}

