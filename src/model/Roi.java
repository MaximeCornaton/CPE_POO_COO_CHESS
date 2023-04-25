package model;

public class Roi extends AbstractPiece{
	
	public Roi(Couleur couleur, Coord coord) {
		super(couleur,coord);
		
	}

	@Override
	public boolean isMoveOk(int xFinal, int yFinal) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
