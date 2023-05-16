/**
 * 
 */
package model;

import java.util.List;
import java.util.LinkedList;

/**
 * @author maxime
 *
 */
public class Jeu {
	
	private Couleur couleur;
	private List<Pieces> pieces;
	private boolean castling;
	private boolean possibleCapture;
	
	/**
	 * Le constructeur de jeu fait appel à la fabrique de pièces
	 * @param color
	 */
	public Jeu(Couleur couleur) {
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
	protected void setPossibleCapture(boolean PossibleCapture) {
		this.possibleCapture = PossibleCapture;
		
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
		Pieces p = this.findPiece(x, y);
		Couleur color = p.getCouleur();
		
		return color;
	
	}
	
	
	/**
	 * 
	 * @param x
	 * @param y
	 * @return type de la pi�ce aux coordonn�es x,y c'est � dire le nom de la classe : maPiece.getClass().getSimpleName();
	 */
	protected String getPieceType(int x, int y){
		return findPiece(x,y).getClass().getSimpleName();
	}
	
	
	/**
	 * 
	 * @return couleur du jeu
	 */
	protected Couleur getCouleur() {
		return this.couleur;
	}
	
	
	/**
	 * 
	 * @return une vue de la liste des pièces en cours ne donnant que des accès en lecture sur des PieceIHM (type piece + couleur + liste de coordonnées)
	 */
	public List<PieceIHM> getPiecesIHM() {
			PieceIHM newPieceIHM = null;
			List<PieceIHM> list = new LinkedList<PieceIHM>();
			
			for (Pieces piece : pieces) {
				boolean existe = false;
				// si le type de piece existe déjà dans la liste de PieceIHM // ajout des coordonnées de la pièce dans la liste de Coord de ce type
				// si elle est toufours en jeu (x et y != -1)
				for ( PieceIHM pieceIHM : list) {
					if ((pieceIHM.getTypePiece()).equals(piece.getClass().getSimpleName())){
						existe = true;
						if (piece.getX() != -1) {
							pieceIHM.add (new Coord (piece.getX (), piece.getY () ));
							}
					}
				}
				// sinon, création d'une nouvelle PieceIHM si la pièce est toujours en jeu
				if (! existe) {
						if (piece.getX () != -1) {
							newPieceIHM = new PieceIHM(piece.getClass().getSimpleName() , piece.getCouleur()) ;
							newPieceIHM.add (new Coord(piece.getX(), piece.getY()));
							list.add (newPieceIHM);
						}
					}
				}
			return list;
	}
	
	
	/**
	 * met à jour un booléen pour activer l'hypothèse d'un roque du roi
	 */
	protected void setCastling() {
		this.castling = !this.castling;
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
		boolean promotion = false;
		if (this.getPieceType(xFinal, yfinal).equals("Pion")) {
			promotion = true;
		}
		return promotion;
	}

	
	
	/**
	 * 
	 * @param xFinal
	 * @param yfinal
	 * @param type = type de Pieces dans lequel le pion est promu
	 * @return true si promotion OK
	 */
	protected boolean pawnPromotion(int xFinal, int yFinal, String type) {
		boolean promotion = false;
		if (isPawnPromotion(xFinal, yFinal)) {
			if (!type.equals("Roi") && !type.equals("Pion")) {
				promotion = true;
			}
		}
		return promotion;
	}
	
	
	/**
	 * 
	 * @return coordonnées du roi
	 */
	protected Coord getKingCoord() {
		Coord coord = new Coord(0,0);
		for (Pieces piece : pieces) {
			int x = piece.getX();
			int y = piece.getY();
			if (this.getPieceType(x, y).equals("Roi")){
				 coord.x = x;
				 coord.y = y;
			}
		}
		return coord;
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Jeu jeu = new Jeu(Couleur.BLANC);
	}

}
