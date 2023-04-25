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
	protected Boolean isPieceHere(int x, int y){
		return findPiece(x, y) != null;
	}
	
	/**
	 * 
	 * @param xInit
	 * @param yInit
	 * @param xFinal
	 * @param yFinal
	 * @return true si piece du jeu peut être déplacée aux coordonnées finales, false sinon
	 */
	protected boolean isMoveOk(int xInit, int yInit, int xFinal, int yFinal) {
		boolean isMoveOk = false;
		
		if(isPieceHere(xInit,yInit) && !isPieceHere(xFinal,yFinal)) {
			isMoveOk = findPiece(xInit,yInit).isMoveOk(xFinal, yFinal);
		}
		return isMoveOk;
	}
	
	/**
	 * 
	 * @param xInit
	 * @param yInit
	 * @param xFinal
	 * @param yFinal
	 * @return true si déplacement pièce effectué
	 */
	protected boolean move(int xInit, int yInit, int xFinal, int yFinal) {
		boolean move=false;
		if (isMoveOk(xInit,yInit,xFinal,yFinal)){
			findPiece(xInit,yInit).move(xFinal, yFinal);
			move = true;
		}
		return move;
	}
	
	
	/**
	 * Si une capture d'une pièce de l'autre jeu est possible met à jour 1 booléen
	 */
	protected void setPossibleCapture() {
		//TODO
	}
	
	
	/**
	 * 
	 * @param xCatch
	 * @param yCatch
	 * @return true si la piece aux coordonnées finales a été capturée
	 */
	protected boolean capture(int xCatch, int yCatch) {
		//TODO 
		return false;
	}

	
	/**
	 * 
	 * @param x
	 * @param y
	 * @return couleur de la pièce aux coordonnées x, y
	 */
	protected Couleur getPieceColor(int x, int y) {
		//TODO 
		return Couleur.BLANC;
	}
	
	
	/**
	 * 
	 * @param x
	 * @param y
	 * @return type de la pi�ce aux coordonn�es x,y c'est � dire le nom de la classe : maPiece.getClass().getSimpleName();
	 */
	protected String getPieceType(int x, int y){
		//TODO
		return "oui";
	}
	
	
	/**
	 * 
	 * @return couleur du jeu
	 */
	protected Couleur getCouleur() {
		return Couleur.BLANC;
	}
	
	/**
	 * 
	 * @return une vue de la liste des pièces en cours ne donnant que des accès en lecture sur des PieceIHM (type piece + couleur + liste de coordonnées)
	 */
	protected List<PieceIHM> getPiecesIHM(){
		//TODO
	}
	
	
	/**
	 * met à jour un booléen pour activer l'hypothèse d'un roque du roi
	 */
	protected void setCastling() {
		//TODO
		
	}
	
	/*
	 * 
	 */
	protected void undoMove() {
		
	}
	
	
	/**
	 * 
	 */
	protected void undoCapture() {
		
	}


	/**
	 * 
	 * @param xFinal
	 * @param yfinal
	 * @return true si on est bien dans le cas d'une promotion du pion
	 */
	protected boolean isPawnPromotion(int xFinal, int yfinal) {
		//TODO
	}

	
	
	/**
	 * 
	 * @param xFinal
	 * @param yfinal
	 * @param type = type de Pieces dans lequel le pion est promu
	 * @return true si promotion OK
	 */
	protected boolean pawnPromotion(int xFinal, int yfinal, String type) {
		
	}
	
	
	/**
	 * 
	 * @return coordonnées du roi
	 */
	protected Coord getKingCoord() {
		
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Jeu jeu = new Jeu(Couleur.BLANC);
	}

}
