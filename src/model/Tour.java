package model;


public class Tour extends AbstractPiece{
	private Coord coord;
	private Couleur couleur_de_piece;
	
	
	/**
	 * 
	 * @param couleur_de_piece
	 * @param coord
	 */
	public Tour(Couleur couleur_de_piece, Coord coord) {
		this.coord = coord;
		this.couleur_de_piece = couleur_de_piece;
	}
	
	public boolean isMoveOk(int xFinal, int yFinal) {
		return (xFinal != this.coord.x && yFinal == this.coord.y || xFinal == this.coord.x && yFinal != this.coord.y);
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
