package View;

import java.awt.Color;
import java.awt.DisplayMode;
import java.util.Observable;
import java.util.Observer;

import javax.media.opengl.GL2;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.glu.GLU;

import Model.Model;

public class Forme_Cube implements GLEventListener {

	private double[] couleur_red 	= {
			Math.random(),
			Math.random(),
			Math.random(),
			Math.random()};
	private double[] couleur_green  = {
			Math.random(),
			Math.random(),
			Math.random(),
			Math.random()};
	private double[] couleur_blue 	= {
			Math.random(),
			Math.random(),
			Math.random(),
			Math.random()};

	private double[] ratioFrequence = {0.8,0.9,0.2,0.4};//new double[4];

	private double 	 largeur 	= 1;
	private double 	 profondeur	= 1;
	private double[] hauteur 	= new double[4];

	private double cube1_posX = -1;
	private double cube1_posY = -4;
	private double cube1_posZ = -16;

	private double cube2_posX =  1;
	private double cube2_posY = -4;
	private double cube2_posZ = -16;

	private double cube3_posX = -1;
	private double cube3_posY = -4;
	private double cube3_posZ = -14;

	private double cube4_posX =  1;
	private double cube4_posY = -4;
	private double cube4_posZ = -14;

	private static int CUBE_ONE = 0;
	private static int CUBE_TWO = 1;
	private static int CUBE_THREE = 2;
	private static int CUBE_FOUR = 3;

	private GLU glu = new GLU();

	public void display(GLAutoDrawable drawable) {

		for (int index = 0; 
				index < ratioFrequence.length;
				index ++) {

			hauteur[index] = 5 * ratioFrequence[index];
			System.out.println(hauteur[index]);

		}

		final GL2 gl = drawable.getGL().getGL2();

		gl.glClear(GL2.GL_COLOR_BUFFER_BIT | GL2.GL_DEPTH_BUFFER_BIT );


		gl.glLoadIdentity();	//reset l'origine
		gl.glTranslated(cube1_posX, cube1_posY, cube1_posZ); //déplace l'origine
		gl.glColor3d(
				couleur_red[Forme_Cube.CUBE_ONE],
				couleur_green[Forme_Cube.CUBE_ONE],
				couleur_blue[Forme_Cube.CUBE_ONE]);
		this.paintCube(gl, Forme_Cube.CUBE_ONE);

		gl.glLoadIdentity();
		gl.glTranslated(cube2_posX, cube2_posY, cube2_posZ); 
		gl.glColor3d(
				couleur_red[Forme_Cube.CUBE_TWO],
				couleur_green[Forme_Cube.CUBE_TWO],
				couleur_blue[Forme_Cube.CUBE_TWO]);
		this.paintCube(gl, Forme_Cube.CUBE_TWO);

		gl.glLoadIdentity();
		gl.glTranslated(cube3_posX, cube3_posY, cube3_posZ); 
		gl.glColor3d(
				couleur_red[Forme_Cube.CUBE_THREE],
				couleur_green[Forme_Cube.CUBE_THREE],
				couleur_blue[Forme_Cube.CUBE_THREE]);
		this.paintCube(gl, Forme_Cube.CUBE_THREE);

		gl.glLoadIdentity();
		gl.glTranslated(cube4_posX, cube4_posY, cube4_posZ); 
		gl.glColor3d(
				couleur_red[Forme_Cube.CUBE_FOUR],
				couleur_green[Forme_Cube.CUBE_FOUR],
				couleur_blue[Forme_Cube.CUBE_FOUR]);
		this.paintCube(gl, Forme_Cube.CUBE_FOUR);

		gl.glFlush();

	}

	private void paintCube(GL2 gl, int numeroCube) {

		gl.glBegin(GL2.GL_QUADS); // Start Drawing The Cube

		gl.glVertex3d( largeur,  hauteur[numeroCube], -profondeur); 	// Top Right Of The Quad (Top)
		gl.glVertex3d(-largeur,  hauteur[numeroCube], -profondeur); 	// Top Left Of The Quad (Top)
		gl.glVertex3d(-largeur,  hauteur[numeroCube],  profondeur); 	// Bottom Left Of The Quad (Top)
		gl.glVertex3d( largeur,  hauteur[numeroCube],  profondeur); 	// Bottom Right Of The Quad (Top)

		gl.glVertex3d( largeur, -hauteur[numeroCube], -profondeur);		// Top Right Of The Quad (Bot)
		gl.glVertex3d(-largeur,  hauteur[numeroCube], -profondeur); 	// Top Left Of The Quad (Bot)
		gl.glVertex3d(-largeur,  hauteur[numeroCube],  profondeur);		// Bottom Left Of The Quad (Bot)
		gl.glVertex3d( largeur,  hauteur[numeroCube],  profondeur); 	// Bottom Right Of The Quad (Bot)

		gl.glVertex3d( largeur,  hauteur[numeroCube],  profondeur);		// Top Right Of The Quad (Front)
		gl.glVertex3d(-largeur,  hauteur[numeroCube],  profondeur);		// Top Left Of The Quad (Front)
		gl.glVertex3d(-largeur, -hauteur[numeroCube],  profondeur);		// Bottom Left Of The Quad
		gl.glVertex3d( largeur, -hauteur[numeroCube],  profondeur );	// Bottom Right Of The Quad 

		gl.glVertex3d( largeur, -hauteur[numeroCube], -profondeur ); 	// Bottom Left Of The Quad
		gl.glVertex3d(-largeur, -hauteur[numeroCube], -profondeur );	// Bottom Right Of The Quad
		gl.glVertex3d(-largeur,  hauteur[numeroCube], -profondeur ); 	// Top Right Of The Quad (Back)
		gl.glVertex3d( largeur,  hauteur[numeroCube], -profondeur );	// Top Left Of The Quad (Back)

		gl.glVertex3d(-largeur,  hauteur[numeroCube],  profondeur ); 	// Top Right Of The Quad (Left)
		gl.glVertex3d(-largeur,  hauteur[numeroCube], -profondeur ); 	// Top Left Of The Quad (Left)
		gl.glVertex3d(-largeur, -hauteur[numeroCube], -profondeur ); 	// Bottom Left Of The Quad
		gl.glVertex3d(-largeur, -hauteur[numeroCube],  profondeur ); 	// Bottom Right Of The Quad 

		gl.glVertex3d( largeur,  hauteur[numeroCube], -profondeur ); 	// Top Right Of The Quad (Right)
		gl.glVertex3d( largeur,  hauteur[numeroCube],  profondeur ); 	// Top Left Of The Quad
		gl.glVertex3d( largeur, -hauteur[numeroCube],  profondeur ); 	// Bottom Left Of The Quad
		gl.glVertex3d( largeur, -hauteur[numeroCube], -profondeur ); 	// Bottom Right Of The Quad

		gl.glEnd(); // Done Drawing The Quad

	}

	public void dispose( GLAutoDrawable drawable ) {



	}

	public void init( GLAutoDrawable drawable ) {

		GL2 gl = drawable.getGL().getGL2();      // get the OpenGL graphics context
		glu = new GLU();                         // get GL Utilities
		gl.glClearColor(0.0f, 0.0f, 0.0f, 0.0f); // set background (clear) color
		gl.glClearDepth(1.0f);      // set clear depth value to farthest
		gl.glEnable(GL2.GL_DEPTH_TEST); // enables depth testing
		gl.glDepthFunc(GL2.GL_LEQUAL);  // the type of depth test to do
		gl.glHint(GL2.GL_PERSPECTIVE_CORRECTION_HINT, GL2.GL_NICEST); // best perspective correction
		gl.glShadeModel(GL2.GL_SMOOTH); // blends colors nicely, and smoothes out lighting

	}

	public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {

		GL2 gl = drawable.getGL().getGL2();  // get the OpenGL 2 graphics context

		if (height == 0) height = 1;   // prevent divide by zero
		float aspect = (float)width / height;

		// Set the view port (display area) to cover the entire window
		gl.glViewport(0, 0, width, height);

		// Setup perspective projection, with aspect ratio matches viewport
		gl.glMatrixMode(GL2.GL_PROJECTION);  // choose projection matrix
		gl.glLoadIdentity();             // reset projection matrix
		glu.gluPerspective(45.0, aspect, 0.1, 100.0); // fovy, aspect, zNear, zFar

		// Enable the model-view transform
		gl.glMatrixMode(GL2.GL_MODELVIEW);
		gl.glLoadIdentity(); // reset

	}

	/**
	 * @return the largeur
	 */
	public double getLargeur() {

		return largeur;

	}

	/**
	 * @param largeur the largeur to set
	 */
	public void setLargeur(double largeur) {

		this.largeur = largeur;

	}

	/**
	 * @return the profondeur
	 */
	public double getProfondeur() {

		return profondeur;

	}

	/**
	 * @param profondeur the profondeur to set
	 */
	public void setProfondeur(double profondeur) {

		this.profondeur = profondeur;

	}

	/**
	 * @return the hauteur
	 */
	public double[] getHauteur() {

		return hauteur;

	}

	/**
	 * @param hauteur the hauteur to set
	 */
	public void setHauteur(double[] hauteur) {

		this.hauteur = hauteur;

	}

	/**
	 * @return the ratioFrequence
	 */
	public double[] getRatioFrequence() {

		return ratioFrequence;

	}

	/**
	 * @param ratioFrequence the ratioFrequence to set
	 */
	public void setRatioFrequence(double[] ratioFrequence) {

		this.ratioFrequence = ratioFrequence;

	}
}
