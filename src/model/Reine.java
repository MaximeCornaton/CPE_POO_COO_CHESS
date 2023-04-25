package model;

public class Reine extends AbstractPiece{
	
	public Reine(Couleur couleur, Coord coord){
		super(couleur,coord);
	}
	
	public boolean isMoveOk(int xFinal, int yFinal) {
		return (xFinal >= 0 && yFinal >= 0 && xFinal != this.getX() && yFinal == this.getY() || xFinal == this.getX() 
					&& yFinal != this.getY() && super.isMoveOk(xFinal, yFinal) || Math.abs(yFinal - this.getY()) == Math.abs(xFinal) - this.getX());
	}
	
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Reine a = new Reine(Couleur.NOIR, new Coord(0,0));
		System.out.println(a.isMoveOk(7, 5));
		
		System.out.println(a);
		
	}
}
