package model;

public class Cavalier extends AbstractPiece{
	
	public Cavalier(Couleur couleur, Coord coord) {
		super(couleur,coord);
	}
	
	public boolean isMoveOk(int xFinal, int yFinal) {
		if (Math.sqrt((xFinal-this.getX())^2 + (yFinal-this.getY())^2) == Math.sqrt(5)) {
			System.out.println("ok");
			return true;
		}else {
			double a = (Math.sqrt(Math.pow((xFinal-this.getX()),2.0) + Math.pow((yFinal-this.getY(),2.0)));
			System.out.println(a);
			return false;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cavalier c = new Cavalier(Couleur.NOIR, new Coord(0,0));
		System.out.println(c.isMoveOk(4, 1));
		
		System.out.println(c);
		
	}

}
