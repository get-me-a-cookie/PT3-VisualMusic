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
	
	private double largeur;
	private double hauteur = 0;
	private double profondeur;
	
	private GLU glu = new GLU();
	double x = 0;

	public void display(GLAutoDrawable drawable) {

		final GL2 gl = drawable.getGL().getGL2();
		gl.glClear(GL2.GL_COLOR_BUFFER_BIT | GL2.GL_DEPTH_BUFFER_BIT );
		gl.glLoadIdentity();
		gl.glColor3d(couleur_red, couleur_green, couleur_blue);
		gl.glTranslatef( 0f, 0f, -5.0f ); 
		
		gl.glRotated(x, 1, 1, 1);

		//giving different colors to different sides
		gl.glBegin(GL2.GL_QUADS); // Start Drawing The Cube
		
		gl.glVertex3d( largeur, hauteur, -profondeur); // Top Right Of The Quad (Top)
		gl.glVertex3d(-largeur, hauteur, -profondeur); // Top Left Of The Quad (Top)
		gl.glVertex3d(-largeur, hauteur,  profondeur); // Bottom Left Of The Quad (Top)
		gl.glVertex3d( largeur, hauteur,  profondeur); // Bottom Right Of The Quad (Top)

		
		gl.glColor3d(1, 0, 0);
		
		gl.glVertex3f( 1.0f, -1.0f, 1.0f ); // Top Right Of The Quad
		gl.glVertex3f( -1.0f, -1.0f, 1.0f ); // Top Left Of The Quad
		gl.glVertex3f( -1.0f, -1.0f, -1.0f ); // Bottom Left Of The Quad
		gl.glVertex3f( 1.0f, -1.0f, -1.0f ); // Bottom Right Of The Quad
		
		gl.glVertex3f( 1.0f, 1.0f, 1.0f ); // Top Right Of The Quad (Front)
		gl.glVertex3f( -1.0f, 1.0f, 1.0f ); // Top Left Of The Quad (Front)
		gl.glVertex3f( -1.0f, -1.0f, 1.0f ); // Bottom Left Of The Quad
		gl.glVertex3f( 1.0f, -1.0f, 1.0f ); // Bottom Right Of The Quad 

		gl.glVertex3f( 1.0f, -1.0f, -1.0f ); // Bottom Left Of The Quad
		gl.glVertex3f( -1.0f, -1.0f, -1.0f ); // Bottom Right Of The Quad
		gl.glVertex3f( -1.0f, 1.0f, -1.0f ); // Top Right Of The Quad (Back)
		gl.glVertex3f( 1.0f, 1.0f, -1.0f ); // Top Left Of The Quad (Back)

		gl.glVertex3f( -1.0f, 1.0f, 1.0f ); // Top Right Of The Quad (Left)
		gl.glVertex3f( -1.0f, 1.0f, -1.0f ); // Top Left Of The Quad (Left)
		gl.glVertex3f( -1.0f, -1.0f, -1.0f ); // Bottom Left Of The Quad
		gl.glVertex3f( -1.0f, -1.0f, 1.0f ); // Bottom Right Of The Quad 

		gl.glVertex3f( 1.0f, 1.0f, -1.0f ); // Top Right Of The Quad (Right)
		gl.glVertex3f( 1.0f, 1.0f, 1.0f ); // Top Left Of The Quad
		gl.glVertex3f( 1.0f, -1.0f, 1.0f ); // Bottom Left Of The Quad
		gl.glVertex3f( 1.0f, -1.0f, -1.0f ); // Bottom Right Of The Quad
		gl.glEnd(); // Done Drawing The Quad
		gl.glFlush();
		x += 0.2;
	}

	@Override
	public void dispose( GLAutoDrawable drawable ) {
		// TODO Auto-generated method stub
	}

	@Override
	public void init( GLAutoDrawable drawable ) {

		final GL2 gl = drawable.getGL().getGL2();
		gl.glShadeModel( GL2.GL_SMOOTH );
		gl.glClearColor( 0f, 0f, 0f, 0f );
		gl.glClearDepth( 1.0f );
		gl.glEnable( GL2.GL_DEPTH_TEST );
		gl.glDepthFunc( GL2.GL_LEQUAL );
		gl.glHint( GL2.GL_PERSPECTIVE_CORRECTION_HINT, GL2.GL_NICEST );

	}

	@Override
	public void reshape( GLAutoDrawable drawable, int x, int y, int width, int height ) {

		final GL2 gl = drawable.getGL().getGL2();
		if( height <= 0 )
			height = 1;

		final float h = ( float ) width / ( float ) height;
		gl.glViewport( 0, 0, width, height );
		gl.glMatrixMode( GL2.GL_PROJECTION );
		gl.glLoadIdentity();

		glu.gluPerspective( 45.0f, h, 1.0, 20.0 );
		gl.glMatrixMode( GL2.GL_MODELVIEW );
		gl.glLoadIdentity();

	}

}
