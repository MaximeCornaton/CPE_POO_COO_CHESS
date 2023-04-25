package model;

public class Pion extends AbstractPiece implements Pions {
	
	public Pion(Couleur couleur_de_piece, Coord coord) {
		super(couleur_de_piece, coord);
	}
	
	public boolean isMoveDiagOk(int xFinal, int yFinal) {
		return true;
	}
	
	public boolean isMoveOk(int xFinal, int yFinal) {
		// TODO Si premier tour, peut avancer de deux cases
		return ((yFinal-this.getY() == 1) && (xFinal == this.getX()));
	}
	
	@Override
	public boolean move(int x, int y) {
		return super.move(x,y);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Pion a = new Pion(Couleur.NOIR, new Coord(0,0));
		System.out.println(a.isMoveOk(-1, 0));
		
		System.out.println(a);
	}
	
	
}
