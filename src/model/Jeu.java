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
	protected Jeu(Couleur couleur) {
		this.couleur = couleur;
		this.Pieces = tools.ChessPiecesFactory.newPieces(couleur);
	}

	@Override
	public String toString() {
	    StringBuilder sb = new StringBuilder();
	    sb.append("Jeu [couleur="+ couleur).append(", Pieces=");
	    for (Pieces piece : Pieces) {
	        sb.append(piece.toString()+", ");
	    }
	    sb.setLength(sb.length() - 2);
	    sb.append("]");
	    return sb.toString();
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Jeu jeu = new Jeu(Couleur.BLANC);
	}

}
