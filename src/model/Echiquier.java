package model;

import java.util.*;

public class Echiquier implements BoardGames{
	private Jeu noir;
	private Jeu blanc;
	private Jeu courant;
	private Jeu non_courant;
	private String msg;
	
	
	public Echiquier() {
		this.blanc = new Jeu(Couleur.BLANC);
		this.noir = new Jeu(Couleur.NOIR);
		this.courant = this.blanc;
		this.non_courant = this.noir;
		this.msg = "";
		
	}
	/**
	 * 
	 * @param xInit
	 * @param yInit
	 * @param xFinal
	 * @param yFinal
	 * @return Permet de vérifier si une pièce peut être déplacé
	 */
	public boolean isMoveOk(int xInit, int yInit, int xFinal, int yFinal) {
		boolean res = true;
		
		// Bonne exemple SRP
		if (!(0<= xFinal && xFinal <=7 && 0<= yFinal && yFinal <=7) ||  // Si position pas dans le plateau 
				(this.courant.findPiece(xFinal, yFinal) != null) ||  // ou une pièce est déjà sur la position finale
						(xFinal == xInit && yFinal == yInit) // Si la position finale est la même qu'initialement
				){
			res = false ;	
		}
		
		if(this.non_courant.findPiece(xFinal, yFinal) != null) { // Si il n'y a pas de pièce du jeu non courant
			res = false;
			
		}
		else {
			res = false;
		}
		
		if(!(this.courant.isMoveOk(xInit, yInit, xFinal, yFinal))) { // Si le mouvement est autorisé par le jeu
			res = false;
		}
		
		return res;
		
	}
	
	public void switchJoueur() {
		if(this.courant.getCouleur() == Couleur.NOIR) {
			this.courant = this.blanc;
			this.non_courant = this.noir;
		}
		else {
			this.courant = this.noir;
			this.non_courant = this.blanc;
		}
	}

	@Override
	public boolean move(int xInit, int yInit, int xFinal, int yFinal) {
		if(this.isMoveOk(xInit, yInit, xFinal, yFinal)) {
			this.courant.move(xInit, yInit, xFinal, yFinal);
			for(PieceIHM piece : this.non_courant.getPiecesIHM()) {
				if(this.isMoveOk(piece.getList().get(0).x, piece.getList().get(0).y, this.courant.getKingCoord().x, this.courant.getKingCoord().y)) {
					this.courant.undoMove();
				}
			}
		}
		
		return false;
	}
	
	public List<PieceIHM> getPieceIHM(){
		List<PieceIHM> piecesIHM = new LinkedList<PieceIHM>();
		piecesIHM.addAll(this.blanc.getPiecesIHM());
		piecesIHM.addAll(this.noir.getPiecesIHM());
		return piecesIHM;
	}

	@Override
	public boolean isEnd() {
			
		return false;
	}

	@Override
	public String getMessage() {
		return this.msg;
	}

	@Override
	public Couleur getColorCurrentPlayer() {
		return this.courant.getCouleur();
	}

	@Override
	public Couleur getPieceColor(int x, int y) {
		return this.courant.getPieceColor(x, y);
		
	}
	@Override
	public String toString() {
		return "Echiquier | Courant : " + this.courant.getCouleur() + " | msg : " + this.msg;
	}
	
	public static void main(String[] args) {
		
		Echiquier e = new Echiquier();
		
		
		System.out.println(e.getPieceIHM());
		
		
	}
	
	

}
