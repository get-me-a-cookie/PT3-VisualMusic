package View;

import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Model.Model;

/**
 * 
 * @author Goodwin
 * Classe représentant le visualisateur de l'IG
 * Affiche des formes géométrique (2D, 3D) en fonction de la musique écouté
 */
public class Vue_GenerationForme extends JPanel implements Observer {

	/**
	 * Taille Maximale de la fenètre de l'application
	 * sur l'axe des abscisses (horizontal)
	 */
	private static int TAILLE_FENETRE_X = 800;
	
	/**
	 * Taille Maximale de la fenètre de l'application
	 * sur l'axe des ordonnées (vertical)
	 */
	private static int TAILLE_FENETRE_Y = 450;

	/**
	 * Coordonnée sur l'axe des abscisses (horizontal)
	 * du milieu de la @TAILLE_FENETRE_X
	 */
	private static int MILIEU_FENETRE_X = TAILLE_FENETRE_X / 2;

	/**
	 * Coordonnée sur l'axe des ordonnées (vertical)
	 * du milieu de la @TAILLE_FENETRE_Y
	 */
	private static int MILIEU_FENETRE_Y = TAILLE_FENETRE_Y / 2;
	
	
	/**
	 * Définition de la méthode paint
	 * Affiche des formes géométriques (2D, 3D)
	 * en fonction de la musique
	 */
	public void paint(Graphics g) { 
		
		// affiche une ligne au centre de la fenêtre
		g.drawLine(100, 
				   MILIEU_FENETRE_Y, 
				   TAILLE_FENETRE_X - 100, 
				   MILIEU_FENETRE_Y);
		
		//sert à rien
		g.drawRect(MILIEU_FENETRE_X, MILIEU_FENETRE_Y-200, 30, 200);
		
		//TODO a compléter
	}

	public void update(Observable m, Object obj) {
		// TODO Auto-generated method stub
		
		Model model = (Model) m;
		
	}
	
}
