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

	private double couleur_red = Math.random();
	private double couleur_green = Math.random();
	private double couleur_blue = Math.random();

	private double 	 largeur 	= 1;
	private double 	 profondeur	= 1;
	private double[] hauteur 	= {0, 0, 0, 0};

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
	double x = 0;

	public void display(GLAutoDrawable drawable) {

		final GL2 gl = drawable.getGL().getGL2();
		
		gl.glClear(GL2.GL_COLOR_BUFFER_BIT | GL2.GL_DEPTH_BUFFER_BIT );
		gl.glLoadIdentity();
		
		gl.glColor3d(couleur_red, couleur_green, couleur_blue);

		//gl.glRotated(x, 1, 1, 1);
		
		gl.glTranslated(cube1_posX, cube1_posY, cube1_posZ); 
		this.paintCube(gl, Forme_Cube.CUBE_ONE);
		
		gl.glTranslated(cube2_posX, cube2_posY, cube2_posZ); 
		this.paintCube(gl, Forme_Cube.CUBE_TWO);
		
		gl.glTranslated(cube3_posX, cube3_posY, cube3_posZ); 
		this.paintCube(gl, Forme_Cube.CUBE_THREE);
		
		gl.glTranslated(cube4_posX, cube4_posY, cube4_posZ); 
		this.paintCube(gl, Forme_Cube.CUBE_FOUR);
		
		gl.glFlush();
		
		//x += 0.5;

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

		final GL2 gl = drawable.getGL().getGL2();
		gl.glShadeModel( GL2.GL_SMOOTH );
		gl.glClearColor( 0f, 0f, 0f, 0f );
		gl.glClearDepth( 1.0f );
		gl.glEnable( GL2.GL_DEPTH_TEST );
		gl.glDepthFunc( GL2.GL_LEQUAL );
		gl.glHint( GL2.GL_PERSPECTIVE_CORRECTION_HINT, GL2.GL_NICEST );

	}

	public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {

		final GL2 gl = drawable.getGL().getGL2();
		if( height <= 0 )
			height = 1;

		final float h = (float) width / (float) height;
		gl.glViewport( 0, 0, width, height );
		gl.glMatrixMode( GL2.GL_PROJECTION );
		gl.glLoadIdentity();

		glu.gluPerspective( 45.0f, h, 1.0, 20.0 );
		gl.glMatrixMode( GL2.GL_MODELVIEW );
		gl.glLoadIdentity();

	}
}
