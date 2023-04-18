package model;



public abstract class AbstractPiece {
	
 
	
	protected Coord coord;
	private Couleur couleur;

	public AbstractPiece(Couleur couleur, Coord coord) {
		this.coord = new Coord(0, 0);
		this.couleur=couleur;
	}
	
	public int getX() {
		return 1;
	}
	
	public int getY() {
		return 1;
	}
	
	public Couleur getCouleur() {
		return this.couleur;
	}
	
	public boolean move() {
		return true;
	}
	
	public boolean capture() {
		return true;
	}
	
	@Override
	public String toString() {
		return null;
	}
	
	public abstract boolean isMoveOk(int xFinal, int yFinal);
	
}
