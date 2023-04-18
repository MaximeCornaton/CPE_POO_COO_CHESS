package model;


public class Tour extends AbstractPiece{
	
	public Tour(Couleur couleur, Coord coord) {
		super(couleur, coord);
		// TODO Auto-generated constructor stub
	}


	public boolean isMoveOk(int xFinal, int yFinal) {
		return (xFinal != this.coord.x && yFinal == this.coord.y || xFinal == this.coord.x && yFinal != this.coord.y);
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
