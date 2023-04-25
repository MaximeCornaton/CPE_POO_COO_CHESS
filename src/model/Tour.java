package model;


public class Tour extends AbstractPiece{
	/**
	 * 
	 * @param couleur
	 * @param coord
	 */
	public Tour(Couleur couleur, Coord coord) {
		super(couleur, coord);
		
	}


	public boolean isMoveOk(int xFinal, int yFinal) {
		return (xFinal >= 0 && yFinal >= 0 && xFinal != this.getX() && yFinal == this.getY() || xFinal == this.getX() && yFinal != this.getY());
	}
	

	public static void main(String[] args) {
		
		Tour a = new Tour(Couleur.NOIR, new Coord(0,0));
		System.out.println(a.isMoveOk(0, 0));
		
		System.out.println(a);
		
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

}
