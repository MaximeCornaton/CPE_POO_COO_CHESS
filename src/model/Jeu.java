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
	private List<Pieces> pieces;
	
	/**
	 * Le constructeur de jeu fait appel à la fabrique de pièces
	 * @param color
	 */
	protected Jeu(Couleur couleur) {
		this.couleur = couleur;
		this.pieces = tools.ChessPiecesFactory.newPieces(couleur);
	}
	
	/**
	 * 
	 */
	@Override
	public String toString() {
	    StringBuilder sb = new StringBuilder();
	    sb.append("Jeu [couleur="+ couleur).append(", Pieces=");
	    for (Pieces piece : pieces) {
	        sb.append(piece.toString()+", ");
	    }
	    sb.setLength(sb.length() - 2);
	    sb.append("]");
	    return sb.toString();
	}
	
	/**
	 * 
	 * @param x
	 * @param y
	 * @return Piece sur la case x, y
	 */
	protected Pieces findPiece(int x, int y) {
		Pieces finded = null;
	    for (Pieces piece : pieces) {
	        if (piece.getX() == x && piece.getY() == y) {
	        	finded = piece;
	        }
	    }
	    return finded;
	}
	
	
	/**
	 * 
	 * @param x
	 * @param y
	 * @return true si une pièce se trouve aux coordonnées indiquées
	 */
	private Boolean isPieceHere(int x, int y){
		return findPiece(x, y) != null;
		
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Jeu jeu = new Jeu(Couleur.BLANC);
	}

}
