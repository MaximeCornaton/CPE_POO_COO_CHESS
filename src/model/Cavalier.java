package model;

public class Cavalier extends AbstractPiece{
	
	public Cavalier(Couleur couleur, Coord coord) {
		super(couleur,coord);
	}
	
	public boolean isMoveOk(int xFinal, int yFinal) {
		return (Math.sqrt((xFinal-this.getX())^2 + (yFinal-this.getY())^2) == Math.sqrt(5));
	}
	
	public 

}
