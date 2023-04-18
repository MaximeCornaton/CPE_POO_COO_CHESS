package model;

import model.Couleur;

public abstract class AbstractPiece {
	
 
	
	private Coord coord;
	private Couleur couleur;

	public AbstractPiece(Couleur couleur, Coord coord) {
		this.coord = new Coord(0, 0);
		this.couleur=couleur;
	}
	
	public AbstractPiece(Couleur couleur) {
		this(couleur,new Coord(0,0));
	}
	
	public AbstractPiece() {
		this(Couleur.NOIRBLANC);
	}
}
