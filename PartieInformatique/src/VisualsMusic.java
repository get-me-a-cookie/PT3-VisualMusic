import java.applet.Applet;
import java.applet.AudioClip;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import View.InterfaceGraphique;

public class VisualsMusic {

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		InterfaceGraphique i = new InterfaceGraphique();
		//i.afficher();
		
		Applet a = new Applet ();
		File u = new File("son.mp3");
		AudioClip ac = Applet.newAudioClip(u.toURL());
		ac.play();
	}

}
