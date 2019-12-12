package Controller;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.JMenuItem;

import Model.Model;
import View.Vue_2D;
import View.Vue_3D;

/**
 * 
 * Classe implémentant ActionListener
 * 
 * @author goodw
 */
public class Controller_Menu extends Controller implements ActionListener  {

	/**
	 * Constructeur utilisant le Constructeur Parent
	 * @param model   : Instanciant le Model
	 * @param handler : Instanciant l'adapteur
	 */
	public Controller_Menu(Model model,
			Adapteur_ControllerVue handler) {
		
		super(model, handler);
		
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
			
			if (valeur_de_retour == JFileChooser.APPROVE_OPTION)
				model.setFichier(fc.getSelectedFile());
			if(!model.getFichier()) {
				model.lectureFichier();
			}
			 */		 
		}
		
		if (menu.getText().equals("2D") && menu.isSelected()) {
			
			JFrame fenetre	= null;
			Vue_2D twoD 	= null;
			Vue_3D threeD 	= null;
			
			model.setIsThreeDimension(false);
			
			for (Component b : handler.getComponent()) {
				
				if (b instanceof JFrame)
					fenetre = (JFrame) b;
				
				if (b instanceof Vue_2D)
					twoD = (Vue_2D) b;
				
				if (b instanceof Vue_3D)
					threeD = (Vue_3D) b;
				
			}
			
			try {
				
				fenetre.remove(threeD);
				fenetre.add(twoD, BorderLayout.CENTER);
				fenetre.revalidate();
				fenetre.repaint();
				
			}
			
			catch (NullPointerException e) {

				//TODO message d'erreur
				model.setErreur(e);
				return;
				
			}
		}
		
		if (menu.getText().equals("3D") && menu.isSelected()) {
			
			JFrame fenetre	= null;
			Vue_2D twoD 	= null;
			Vue_3D threeD 	= null;

			model.setIsThreeDimension(true);
			
			for (Component b : handler.getComponent()) {
				
				if (b instanceof JFrame)
					fenetre = (JFrame) b;

				if (b instanceof Vue_2D)
					twoD = (Vue_2D) b;

				if (b instanceof Vue_3D)
					threeD = (Vue_3D) b;

			}
			
			try {
				
				fenetre.remove(twoD);
				fenetre.add(threeD, BorderLayout.CENTER);
				fenetre.revalidate();
				fenetre.repaint();
				
			}
			
			catch (NullPointerException e) {

				//TODO message d'erreur
				model.setErreur(e);
				return;
				
			}
		}
		model.setFichier(new File("res/auprintemps-44100-32.wav"));	//TODO A supprimer
		
		if(!model.getFichier()) {
			model.lectureFichier(); // TODO a supprimer et le mettre ailleur (remis dans le commentaire) 
		}
	}
}

