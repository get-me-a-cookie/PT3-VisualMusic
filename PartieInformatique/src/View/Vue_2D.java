package View;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import Model.Model;

/**
 * 
 * @author Goodwin
 * Classe représentant le visualisateur de l'IG
 * Affiche des formes géométrique 2D en fonction de la musique écouté
 */
public class Vue_2D extends JPanel implements Observer {

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
	private static int EPAISSEUR_RECTANGLE;	

	/**
	 * Distance en pixel entre les forme 
	 * et les bords droits et gauche
	 */
	private static int MARGIN_FORME_FENETRE = 100;	

	/**
	 * Epaisseur de la ligne centrale
	 */
	private static int EPAISSEUR_LIGNE = 2;	

	/**
	 * Nombre de rectangle à afficher
	 */
	private static int NOMBRE_RECTANGLE;

	/**
	 * Contient tout les ratios qui seront affiché (barres)
	 * Taille définit dans méthode update
	 */
	private double[] ratioFrequence;

	/**
	 * Un tableau contenant un nombre de couleur egal
	 * au nombre de rectangle
	 */
	private Color[] couleurs = new Color[NOMBRE_RECTANGLE];

	private static double AMPLITUDE = 1;
	private static int ESPACEMENT = 0;

	/**
	 * Définition de la méthode paint
	 * Affiche des formes géométriques (2D, 3D)
	 * en fonction de la musique
	 */
	public void paint(Graphics g) { 

		//Nettoie la fenêtre / l'affichage précedent
		g.clearRect(0, 0, TAILLE_FENETRE_X, TAILLE_FENETRE_Y);

		//Affiche une ligne epaisse au centre de la fenêtre
		g.fillRect(MARGIN_FORME_FENETRE, 
				MILIEU_FENETRE_Y - EPAISSEUR_LIGNE/2, 
				TAILLE_FENETRE_X - 2*MARGIN_FORME_FENETRE, 
				EPAISSEUR_LIGNE);

		//g.setColor(Color.cyan);

		if ((NOMBRE_RECTANGLE % 2) == 0) {
			paintPaire(g);
		}
		else {
			paintImpaire(g);
		}

	}

	/**
	 * Centre l'affichage des rectangle si le nombre de rectangle
	 * à affiché est un nombre paire
	 * @param g : de type Graphics, sert à tracé les rectangles
	 */
	private void paintPaire(Graphics g) {
		int j;
		j = 0;
		for (int i = TAILLE_FENETRE_X / 2
				- (EPAISSEUR_RECTANGLE * NOMBRE_RECTANGLE / 2); //MILIEU_FENETRE_X-EPAISSEUR_RECTANGLE*3; 
				j < NOMBRE_RECTANGLE / 2; //MILIEU_FENETRE_X+EPAISSEUR_RECTANGLE*3; 
				i += EPAISSEUR_RECTANGLE) {

			paintRectCouleur(g, i, j);
			j ++;

		}

		for (int i = TAILLE_FENETRE_X / 2; //MILIEU_FENETRE_X-EPAISSEUR_RECTANGLE*3; 
				j < NOMBRE_RECTANGLE ; //MILIEU_FENETRE_X+EPAISSEUR_RECTANGLE*3; 
				i += EPAISSEUR_RECTANGLE) {

			paintRectCouleur(g, i, j);
			j ++;

		}

	}

	/**
	 * Centre l'affichage des rectangle si le nombre de rectangle
	 * à affiché est un nombre impaire
	 * @param g : de type Graphics, sert à tracé les rectangles
	 */
	private void paintImpaire(Graphics g) {

		int j;
		j = 0;
		for (int i = TAILLE_FENETRE_X / 2 //- EPAISSEUR_RECTANGLE / 2
				- (EPAISSEUR_RECTANGLE * NOMBRE_RECTANGLE / 2); //MILIEU_FENETRE_X-EPAISSEUR_RECTANGLE*3; 
				j < NOMBRE_RECTANGLE / 2; //MILIEU_FENETRE_X+EPAISSEUR_RECTANGLE*3; 
				i += EPAISSEUR_RECTANGLE) {

			paintRectCouleur(g, i, j);
			j ++;

		}

		for (int i = TAILLE_FENETRE_X / 2 - EPAISSEUR_RECTANGLE / 2; //MILIEU_FENETRE_X-EPAISSEUR_RECTANGLE*3; 
				j < NOMBRE_RECTANGLE ; //MILIEU_FENETRE_X+EPAISSEUR_RECTANGLE*3; 
				i += EPAISSEUR_RECTANGLE) {

			paintRectCouleur(g, i, j);
			j ++;

		}

	}

	/**
	 * Trace un rectangle avec les coordonnés fournis
	 * et lui fournis un couleur spécifique
	 * @param g : de type Graphics, sert à tracé les rectangles
	 * @param x : l'absisce où commencé à tracer le rectangle
	 * @param numero_rectangle : Quel rectangle doit être affiché
	 */
	private void paintRectCouleur(Graphics g, int x, int numero_rectangle) {
		// On trace le rectangle
		// la couleur correspond au dedans du rectangle
		g.setColor(new Color(
				(float) Math.random(),
				(float) Math.random(),
				(float) Math.random()));

		if (ratioFrequence[numero_rectangle] != 0) {
			g.fillRect(x,
					(int) (MILIEU_FENETRE_Y-ratioFrequence[numero_rectangle]*MILIEU_FENETRE_Y),
					EPAISSEUR_RECTANGLE,
					(int) (ratioFrequence[numero_rectangle]*TAILLE_FENETRE_Y));
		}

	}

	/**
	 * Met à jour la vue
	 * Importe la frequence du model et la stock dans le 
	 * tableau ratioFrequence tout en décalant chaque
	 * élément vers la gauche
	 */
	public void update(Observable m, Object obj) {
		Model model = (Model) m;

		if (model.getErreur() == null) {

			AMPLITUDE = model.getParametres().get("Amplitude");
			EPAISSEUR_RECTANGLE = model.getParametres().get("Epaisseur");
			ESPACEMENT = model.getParametres().get("Espacement");
			
			NOMBRE_RECTANGLE = (
					(TAILLE_FENETRE_X - 2*MARGIN_FORME_FENETRE)
					- 2 * EPAISSEUR_RECTANGLE)
					/ EPAISSEUR_RECTANGLE;
			
			
			double[] sauvegarde_rationFrequence = ratioFrequence;
			ratioFrequence = new double[NOMBRE_RECTANGLE];
			
			if (sauvegarde_rationFrequence != null) {
				
				for (int index = 0; index < NOMBRE_RECTANGLE; index ++) {
					
					ratioFrequence[index] = sauvegarde_rationFrequence[index];
					
				}
			}

			if (model.isFileLoaded() 
					&& model.getMusique().isLoad()
					&& !model.getMusique().isPause()) {

				for (int index = 0; index < NOMBRE_RECTANGLE; index ++) {

					try {
						
						ratioFrequence[index] = ratioFrequence[index + 1];
					}

					catch (IndexOutOfBoundsException e) {
						
						ratioFrequence[index] = model.getRatioFrequence();
					}
				}
			}

			repaint();

		}
	}

}
