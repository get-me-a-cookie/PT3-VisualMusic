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
import javax.media.opengl.glu.GLU;
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
	 * @return the ratioFrequence
	 */
	public double[] getRatioFrequence() {
		return ratioFrequence;
	}

	/**
	 * Un tableau contenant un nombre de couleur egal
	 * au nombre de rectangle
	 */
	private Color[] couleurs = new Color[NOMBRE_RECTANGLE];

	/**
	 * L'espacement entre chaque rectangle, en pixel
	 */
	private static int ESPACEMENT = 20;


	final static GLProfile profile = GLProfile.get( GLProfile.GL2 );
	static GLCapabilities capabilities = new GLCapabilities( profile );

	final FPSAnimator animator = new FPSAnimator(this, 300, true);

	private Forme_Cube cubes;

	public Vue_3D() {

		super(capabilities);


		cubes = new Forme_Cube();

		this.addGLEventListener(cubes);

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

					if (!animator.isStarted())
						animator.start();

					for (int index = 0; index < NOMBRE_RECTANGLE; index ++) {

						try {

							ratioFrequence[index] = ratioFrequence[index + 1];
							
						}

						catch (IndexOutOfBoundsException e) {

							ratioFrequence[index] = model.getRatioFrequence();

						}
					}
				}

				cubes.setRatioFrequence(ratioFrequence);
				//TODO Thread
			}
		}
	}

	//https://www.tutorialspoint.com/jogl/jogl_quick_guide.htm
}
