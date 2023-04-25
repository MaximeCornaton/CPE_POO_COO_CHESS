package model;

public class Cavalier extends AbstractPiece{
	
	private Cavalier(Couleur couleur, Coord coord) {
		super(couleur,coord);
	}
	
	public boolean isMoveOk(int xFinal, int yFinal) {
		double diffX = xFinal - this.getX();
		double diffY = yFinal - this.getY();
		return (Math.sqrt(Math.pow(diffX, 2.0) + Math.pow(diffY, 2.0)) == Math.sqrt(5)) && super.isMoveOk(xFinal, yFinal);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cavalier c = new Cavalier(Couleur.NOIR, new Coord(0,0));
		System.out.println(c.isMoveOk(1, 2));
		System.out.println(c);
	}
	
	

}
