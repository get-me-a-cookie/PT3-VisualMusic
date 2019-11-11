package View;

import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import Model.Model;

/**
 * 
 * @author Goodwin
 * Classe repr�sentant le visualisateur de l'IG
 * Affiche des formes g�om�trique (2D, 3D) en fonction de la musique �cout�
 */
public class Vue_GenerationForme extends JPanel implements Observer {

	/**
	 * Taille Maximale de la fen�tre de l'application
	 * sur l'axe des abscisses (horizontal)
	 */
	private static int TAILLE_FENETRE_X = 800;
	
	/**
	 * Taille Maximale de la fen�tre de l'application
	 * sur l'axe des ordonn�es (vertical)
	 */
	private static int TAILLE_FENETRE_Y = 450;

	/**
	 * Coordonn�e sur l'axe des abscisses (horizontal)
	 * du milieu de la @TAILLE_FENETRE_X
	 */
	private static int MILIEU_FENETRE_X = TAILLE_FENETRE_X / 2;

	/**
	 * Coordonn�e sur l'axe des ordonn�es (vertical)
	 * du milieu de la @TAILLE_FENETRE_Y
	 */
	private static int MILIEU_FENETRE_Y = TAILLE_FENETRE_Y / 2;

	//TODO javadoc
	private static int EPAISSEUR_RECTANGLE = 30;
	
	//TODO javadoc
	private int[] bitDeLecture = new int[18]; //nb de rectangle max sur l'IG
	
	/**
	 * D�finition de la m�thode paint
	 * Affiche des formes g�om�triques (2D, 3D)
	 * en fonction de la musique
	 */
	public void paint(Graphics g) { 
		
		// affiche une ligne au centre de la fen�tre
		g.drawLine(100, 
				   MILIEU_FENETRE_Y, 
				   TAILLE_FENETRE_X - 100, 
				   MILIEU_FENETRE_Y);
		
		/* TODO Ne fonctionne pas
		 * int j = 0;
		for (int i = MILIEU_FENETRE_X-EPAISSEUR_RECTANGLE*8; 
				 i < MILIEU_FENETRE_X+EPAISSEUR_RECTANGLE*8; 
				 i += EPAISSEUR_RECTANGLE) {
			g.drawRect(i,
					   MILIEU_FENETRE_Y-bitDeLecture[j]/50*MILIEU_FENETRE_Y,
					   EPAISSEUR_RECTANGLE,
					   bitDeLecture[j]/50*MILIEU_FENETRE_Y);
			j++;
		}
		*/
		//TODO a compl�ter
	}

	public void update(Observable m, Object obj) {
		// TODO Auto-generated method stub
		
		/* TODO Ne fonctionne pas
		 * Model model = (Model) m;
		for (int i = 0; i < bitDeLecture.length; i ++) {
			int bit = model.getMusique().getOneBytes();
			bitDeLecture[i] = bit < 0 ? -bit: bit; //nb de rectangle max sur l'IG
			repaint();
		}
		*/
	}
	
}
