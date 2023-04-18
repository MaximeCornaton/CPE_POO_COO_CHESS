/**
 * 
 */
package model;

/**
 * @author maxime
 *
 */
public interface Pieces {
	/**
	 * 
	 * @return true si piece effectivement capturée Positionne x et y à -1
	 */
	boolean capture();
	/** 
	 *
	 * @return couleur de la piece
	 */
	Couleur getCouleur();
	/**
	 * 
	 * @return indice de la colonne où est positionnée la piece
	 */
	int getX();
	/**
	 * 
	 * @return indice de la ligne où est positionnée la piece
	 */
	int getY();
	/**
	 * 
	 * @param xFinal
	 * @param yFinal
	 * @return true si déplacement légal en fonction des algo de déplacement spécifique de chaque pièce
	 */
	boolean isMoveOk(int xFinal, int yFinal);
	/**
	 * 
	 * @param xFinal
	 * @param yFinal
	 * @return true si déplacement effectué
	 */
	boolean move(int xFinal, int yFinal);
}
