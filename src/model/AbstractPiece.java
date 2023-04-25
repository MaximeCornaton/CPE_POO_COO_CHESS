package model;



public abstract class AbstractPiece extends java.lang.Object implements Pieces  {
	
 
	
	protected Coord coord;
	private Couleur couleur;
	
	public AbstractPiece(Couleur couleur, Coord coord) {
		this.coord = coord;
		this.couleur = couleur;
	}

	public AbstractPiece(Couleur couleur) {
		this(couleur, new Coord(0,0));
		
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
	
	public boolean move(int x, int y) {
		//TODO vérifier si la case est occupée ou non
		if (this.isMoveOk(x, y)){
			this.coord.x = x;
			this.coord.y = y;
			return true;
		}else {
			return false;
		}
	}
	
	public boolean capture() {
		return true;
	}
	
	@Override
	public String toString() {
		return this.getClass().getSimpleName() + " (" + this.getX() + ";" + this.getY() + ")";
	}
	
	public abstract boolean isMoveOk(int xFinal, int yFinal);
	
}
	
