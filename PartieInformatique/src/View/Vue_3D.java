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
 * Affiche des formes géométrique 3D en fonction de la musique écouté
 */
public class Vue_3D extends JPanel implements Observer {

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
	 * Epaisseur de chaqun des triangles
	 */
	private static int EPAISSEUR_RECTANGLE = 30;	
	
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
		
		// TODO Ne fonctionne pas
		/*int j = 0;
		for (int i = MILIEU_FENETRE_X-EPAISSEUR_RECTANGLE*8; 
				 i < MILIEU_FENETRE_X+EPAISSEUR_RECTANGLE*8; 
				 i += EPAISSEUR_RECTANGLE) {
			g.drawRect(i,
					   MILIEU_FENETRE_Y-bitDeLecture[j]/50*MILIEU_FENETRE_Y,
					   EPAISSEUR_RECTANGLE,
					   bitDeLecture[j]/50*MILIEU_FENETRE_Y);
			j++;
		}*/
		
		
		//TODO a compléter
	}

	public void update(Observable m, Object obj) {
		/* TODO Ne fonctionne pas */
		Model model = (Model) m;
		/*for (int i = 0; i < bitDeLecture.length; i ++) {
			int bit = model.getMusique().getOneBytes();
			bitDeLecture[i] = bit < 0 ? -bit: bit; //nb de rectangle max sur l'IG
			repaint();
		}*/
	}
	
}
