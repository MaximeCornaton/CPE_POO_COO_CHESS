package model;

public class Fou extends AbstractPiece{
	public Fou(Couleur couleur, Coord coord) {
		super(couleur,coord);
	}

	@Override
	public boolean capture() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean move(int xFinal, int yFinal) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isMoveOk(int xFinal, int yFinal) {
		// TODO Auto-generated method stub
		return (Math.abs(yFinal - this.getY()) == Math.abs(xFinal) - this.getX());
	
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Fou a = new Fou(Couleur.NOIR, new Coord(0,0));
		System.out.println(a.isMoveOk(3, 3));
		
		System.out.println(a);
		
	}
}
