package model;



public abstract class AbstractPiece {
	
 
	
	protected Coord coord;
	private Couleur couleur;

	public AbstractPiece(Couleur couleur) {
		this.coord = new Coord(0, 0);
		this.couleur=couleur;
	}
	
	public int getX() {
		return this.coord.x;
	}
	
	public int getY() {
		return this.coord.y;
	}
	
	public Couleur getCouleur() {
		return this.couleur;
	}
	
	/**public boolean move() {
	}
	
	public boolean capture() {
		
	}*/
	
	@Override
	public String toString() {
		return this.getClass().getSimpleName() + " (" + this.getX() + ";" + this.getY() + ")";
	}
	
	public abstract boolean isMoveOk(int xFinal, int yFinal);
	
}
	
