package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;

import javax.media.opengl.GL2;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLCapabilities;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.GLProfile;
import javax.media.opengl.awt.GLCanvas;
import javax.swing.JPanel;

import com.jogamp.opengl.util.Animator;
import com.jogamp.opengl.util.FPSAnimator;

import Model.Model;

/**
 * Classe représentant le visualisateur de l'IG
 * Affiche des formes géométrique 2D en fonction de la musique écouté
 * 
 * @author Goodwin
 */
public class Vue_3D extends GLCanvas implements Observer {

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
	private static int NOMBRE_RECTANGLE = 4;

	/**
	 * Contient tout les ratios qui seront affiché (barres)
	 * Taille définit dans méthode update
	 */
	private double[] ratioFrequence = new double[4];

	/**
	 * Un tableau contenant un nombre de couleur egal
	 * au nombre de rectangle
	 */
	private Color[] couleurs = new Color[NOMBRE_RECTANGLE];

	/**
	 * L'espacement entre chaque rectangle, en pixel
	 */
	private static int ESPACEMENT = 0;


	final static GLProfile profile = GLProfile.get( GLProfile.GL2 );
	static GLCapabilities capabilities = new GLCapabilities( profile );

	final Animator animator = new Animator(this);

	private Forme_Cube cube1;
	private Forme_Cube cube2;
	private Forme_Cube cube3;
	private Forme_Cube cube4;

	public Vue_3D() {

		super(capabilities);

		cube1 = new Forme_Cube(-1, -16);
		cube2 = new Forme_Cube( 1, -16);
		cube3 = new Forme_Cube(-1, -14);
		cube4 = new Forme_Cube( 1, -14);

		this.addGLEventListener(cube1);
		this.addGLEventListener(cube2);
		this.addGLEventListener(cube3);
		this.addGLEventListener(cube4);
		
		this.revalidate();
		this.repaint();

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

			if (!model.isThreeDimension()) {

				ratioFrequence = new double[Vue_3D.NOMBRE_RECTANGLE];
				animator.stop();

			}

			else {

				EPAISSEUR_RECTANGLE = model.getParametres().get("Epaisseur");
				//ESPACEMENT = model.getParametres().get("Espacement");

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
				
				if (!animator.isAnimating())
					animator.start();
				
				//TODO Thread
			}
		}
	}

	//https://www.tutorialspoint.com/jogl/jogl_quick_guide.htm
}
