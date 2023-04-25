package model;



public abstract class AbstractPiece extends java.lang.Object implements Pieces  {
	
 
	
	private Coord coord;
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
		boolean res=false;
		if (this.isMoveOk(x, y)){
			this.coord.x = x;
			this.coord.y = y;
			res = true;
		}
		return res;
	}
	
	private boolean isCaptured() {
		return (this.coord.x == -1 && this.coord.y == -1);
	}
	
	public boolean capture() {
		// Bien pour SRP: une piece ne peut agir que sur elle même.
		boolean res = false;
		if (!this.isCaptured()) {
			this.coord.x=-1;
			this.coord.y=-1;
			res = true;
		}
		return res;
	}
	
	
	@Override
	public String toString() {
		return this.getClass().getSimpleName() + " (" + this.getX() + ";" + this.getY() + ")";
	}
	
	public boolean isMoveOk(int xFinal, int yFinal) {
		if (0<= xFinal && xFinal <=7 && 0<= yFinal && yFinal <=7) {
			return true ;
		}
		else {
			return false;
		}
	}
	
}
	
