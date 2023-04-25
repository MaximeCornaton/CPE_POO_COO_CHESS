package model;

public class Echiquier implements BoardGames{
	private Jeu noir;
	private Jeu blanc;
	private Jeu courant;
	private Jeu non_courant;
	
	
	private Echiquier() {
		this.blanc = new Jeu(Couleur.BLANC);
		this.noir = new Jeu(Couleur.NOIR);
		this.courant = this.blanc;
		this.non_courant = this.noir;
	}
	/**
	 * 
	 * @param xInit
	 * @param yInit
	 * @param xFinal
	 * @param yFinal
	 * @return Permet de vérifier si une pièce peut être déplacé
	 */
	private boolean isMoveOk(int xInit, int yInit, int xFinal, int yFinal) {
		
	}

	@Override
	public boolean move(int xInit, int yInit, int xFinal, int yFinal) {
		// TODO Auto-generated method stub
		
		return false;
	}

	@Override
	public boolean isEnd() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Couleur getColorCurrentPlayer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Couleur getPieceColor(int x, int y) {
		// TODO Auto-generated method stub
		return null;
	}

}
