package model;


public class Tour extends AbstractPiece{
	
	public Tour(Couleur couleur, Coord coord) {
		super(couleur, coord);
		// TODO Auto-generated constructor stub
	}


	public boolean isMoveOk(int xFinal, int yFinal) {
		return (xFinal >= 0 && yFinal >= 0 && xFinal != this.coord.x && yFinal == this.coord.y || xFinal == this.coord.x && yFinal != this.coord.y);
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Tour a = new Tour(Couleur.NOIR, new Coord(0,0));
		System.out.println(a.isMoveOk(0, 0));
		
		System.out.println(a);
		
	}

}
