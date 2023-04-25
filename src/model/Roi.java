package model;

public class Roi extends AbstractPiece{
	
	public Roi(Couleur couleur, Coord coord) {
		super(couleur,coord);
		
	}

	@Override
	public boolean isMoveOk(int xFinal, int yFinal) {
		// TODO Auto-generated method stub
		return (Math.abs(yFinal - this.getY()) == 1 || Math.abs(xFinal) - this.getX() == 1 && super.isMoveOk(xFinal, yFinal));
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Roi a = new Roi(Couleur.NOIR, new Coord(0,0));
		System.out.println(a.isMoveOk(1, 0));
		
		System.out.println(a);
		
	}

	@Override
	public boolean capture() {
		// TODO Auto-generated method stub
		return false;
	}

	
	
}
