package View;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import Model.Model;

/**
 * Classe représentant le visualisateur de l'IG
 * Affiche des formes géométrique 2D en fonction de la musique écouté
 * 
 * @author
 * Goodwin
 * 	Création et implémentation de la classe entière
 */
public class Vue_2D extends JPanel implements Observer {

	/**
	 * Taille Maximale de la fenètre de l'application
	 * sur l'axe des abscisses (horizontal)
	 */
	private int taille_fenetre_x;

	/**
	 * Taille Maximale de la fenètre de l'application
	 * sur l'axe des ordonnées (vertical)
	 */
	private int taille_fenetre_y;

	/**
	 * Epaisseur de chacun des triangles
	 * 
	 * Valeur par défault: 60
	 * 	Permet d'avoir des formes de bonne taille
	 */
	private int epaisseur_rectangle;	

	/**
	 * Distance en pixel entre les forme 
	 * et les bords droits et gauche
	 */
	private int margin_forme_fenetre;	

	/**
	 * Epaisseur de la ligne centrale
	 */
	private int epaisseur_ligne = 2;	

	/**
	 * Nombre de rectangle à afficher
	 */
	private int nombre_rectangle;

	/**
	 * Contient tout les ratios qui seront affiché (barres)
	 * Taille définit dans méthode update
	 */
	private double[] ratioFrequence;

	/**
	 * Un tableau contenant un nombre de couleur égal
	 * au nombre de rectangle
	 * 
	 * Contiendra N-Couleur qui seront utilisé pour
	 * tracer l'extérieur de chacun des cubes
	 */
	private Color[] couleurs_trait;

	/**
	 * Un tableau contenant un nombre de couleur égal
	 * au nombre de rectangle
	 * 
	 * Contiendra N-Couleur qui seront utilisé pour
	 * tracer l'intérieur de chacun des cubes
	 * 
	 * Utilisé si l'utilisateur n'entre aucune
	 * couleurs spécifiques
	 */
	private Color[] couleurs_forme;

	/**
	 * Une couleur unique pour tracer l'extérieur des cubes
	 * 
	 * Utilisé si l'utilisateur entre une
	 * couleurs spécifiques
	 */
	private Color couleur_trait;

	/**
	 * Une couleur unique pour tracer l'intérieur des cubes
	 * 
	 * Utilisé si l'utilisateur entre une
	 * couleurs spécifiques
	 */
	private Color couleur_forme;

	/**
	 * L'espacement entre chaque rectangle, en pixel
	 * 
	 * Valeur par défault: 0
	 * 	N'affiche pas d'espace entre les formes
	 */
	private int espacement;

	/**
	 * Constructeur de la classe
	 * 
	 * Initialise les donnés sensibles
	 */
	public Vue_2D() {

		super();

		this.taille_fenetre_x = 800;
		this.taille_fenetre_y = 450;

		this.epaisseur_rectangle = 60;
		this.margin_forme_fenetre = 100;

		this.nombre_rectangle = (
				(taille_fenetre_x - 2 * margin_forme_fenetre)
				- 2 * epaisseur_rectangle)
				/ (epaisseur_rectangle);

		this.epaisseur_ligne = 2;

		this.ratioFrequence = new double[nombre_rectangle];

		this.espacement = 0;

	}

	/**
	 * Définition de la méthode paint
	 * 
	 * Affiche des formes géométriques (Rectangles)
	 * en fonction de la musique et centre l'affichage
	 */
	public void paint(Graphics g) { 

		//Nettoie la fenêtre / l'affichage précedent
		g.clearRect(0, 0, taille_fenetre_x, taille_fenetre_y);

		//Affiche une ligne epaisse au centre de la fenêtre
		g.fillRect(margin_forme_fenetre, 
				taille_fenetre_y / 2 - epaisseur_ligne/2, 
				taille_fenetre_x - 2*margin_forme_fenetre, 
				epaisseur_ligne);

		if ((nombre_rectangle % 2) == 0)
			paintPaire(g);

		else
			paintImpaire(g);

	}

	/**
	 * Centre l'affichage des rectangle si le nombre de rectangle
	 * à affiché est un nombre paire
	 * 
	 * @param g : de type Graphics, sert à tracé les rectangles
	 */
	private void paintPaire(Graphics g) {

		int j;
		j = 0;

		for (int i = taille_fenetre_x / 2 - (epaisseur_rectangle * nombre_rectangle / 2);
				j < nombre_rectangle;
				i += epaisseur_rectangle + espacement) {

			paintRectCouleur(g, i, j);
			j ++;

		}
	}

	/**
	 * Centre l'affichage des rectangle si le nombre de rectangle
	 * à affiché est un nombre impaire
	 * 
	 * @param g : de type Graphics, sert à tracé les rectangles
	 */
	private void paintImpaire(Graphics g) {

		int j;
		j = 0;

		for (int i = taille_fenetre_x / 2 - (epaisseur_rectangle * nombre_rectangle / 2);
				j < nombre_rectangle;
				i += epaisseur_rectangle + espacement) {

			paintRectCouleur(g, i, j);
			j ++;

		}
	}

	/**
	 * Trace un rectangle avec les coordonnés fournis
	 * et lui fournis un couleur spécifique
	 * 
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

			if (couleur_forme == null && couleur_trait == null) { //si pas de couleur unique

				g.setColor(couleurs_forme[numero_rectangle]);
				g.fillRect(x,
						(int) (taille_fenetre_y / 2-ratioFrequence[numero_rectangle]*taille_fenetre_y / 2/2),
						epaisseur_rectangle,
						(int) (ratioFrequence[numero_rectangle]*taille_fenetre_y/2));

				g.setColor(couleurs_trait[numero_rectangle]);
				g.drawRect(x,
						(int) (taille_fenetre_y / 2-ratioFrequence[numero_rectangle]*taille_fenetre_y / 2/2),
						epaisseur_rectangle,
						(int) (ratioFrequence[numero_rectangle]*taille_fenetre_y/2));

			}

			else if (couleurs_forme == null && couleurs_trait == null) { //si pas de couleurs

				g.setColor(couleur_forme);
				g.fillRect(x,
						(int) (taille_fenetre_y / 2-ratioFrequence[numero_rectangle]*taille_fenetre_y / 2/2),
						epaisseur_rectangle,
						(int) (ratioFrequence[numero_rectangle]*taille_fenetre_y/2));

				g.setColor(couleur_trait);
				g.drawRect(x,
						(int) (taille_fenetre_y / 2-ratioFrequence[numero_rectangle]*taille_fenetre_y / 2/2),
						epaisseur_rectangle,
						(int) (ratioFrequence[numero_rectangle]*taille_fenetre_y/2));

			}
		}
	}

	/**
	 * Met à jour la vue
	 * 
	 * Importe la frequence du model et la stock dans le 
	 * tableau ratioFrequence tout en décalant chaque
	 * élément vers la gauche
	 */
	public void update(Observable m, Object obj) {

		Model model = (Model) m;

		if (model.getErreur() == null) {

			if (model.isThreeDimension())
				return; //evite les calcul inutile

			else {

				epaisseur_rectangle = model.getEpaisseur();
				espacement = model.getEspacement();

				nombre_rectangle = (
						(taille_fenetre_x - 2 * margin_forme_fenetre)
						- 2 * epaisseur_rectangle)
						/ (epaisseur_rectangle);

				if (model.isCouleur_2d_random()) {

					couleur_forme = null;
					couleur_trait = null;

					couleurs_forme = new Color[nombre_rectangle];

					for (int index = 0; index < couleurs_forme.length; index ++) {

						couleurs_forme[index] = new Color(
								(float) Math.random(),
								(float) Math.random(),
								(float) Math.random()); 

					}

					couleurs_trait = new Color[nombre_rectangle];

					for (int index = 0; index < couleurs_trait.length; index ++) {

						couleurs_trait[index] = new Color(
								(float) Math.random(),
								(float) Math.random(),
								(float) Math.random()); 

					}
				}

				else {

					couleurs_trait = null;
					couleurs_forme = null;

					couleur_forme = new Color( 
							model.getCouleur_2d_forme_r(),
							model.getCouleur_2d_forme_g(),
							model.getCouleur_2d_forme_b());

					couleur_trait = new Color( 
							model.getCouleur_2d_trait_r(),
							model.getCouleur_2d_trait_g(),
							model.getCouleur_2d_trait_b());

				}

				double[] sauvegarde_rationFrequence = ratioFrequence;
				ratioFrequence = new double[nombre_rectangle];

				if (sauvegarde_rationFrequence != null) {

					for (int index = 0; index < sauvegarde_rationFrequence.length; index ++) {

						ratioFrequence[index] = sauvegarde_rationFrequence[index];

					}
				}

				if (model.isFileLoaded() 
						&& model.getMusique().isLoad()
						&& !model.getMusique().isPause()) {

					for (int index = 0; index < nombre_rectangle; index ++) {

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
}
