/**
 * 
 */
package model;

import java.util.List;

/**
 * @author maxime
 *
 */
public class Jeu {
	
	private Couleur couleur;
	private List<Pieces> Pieces;
	
	/**
	 * Le constructeur de jeu fait appel à la fabrique de pièces
	 * @param color
	 */
	public Jeu(Couleur couleur) {
		this.couleur = couleur;
		this.Pieces = tools.ChessPiecesFactory.newPieces(couleur);
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Jeu jeu = new Jeu(Couleur.BLANC);
	}

}
