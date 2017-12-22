/**
*DrawableSquare.java
*A class that allows you to draw the pattern for each of the
*squares that make up the maze
**@author Aidan McCoy CPE 102
*@version 5/2/15
**/

public class DrawableSquare extends Square implements Drawable{


	/*private int col = x();
	private int row = y();*/
	public DrawableSquare(boolean up, boolean right,boolean down, boolean left, int row, int col){
		super(up,right,down,left,col,row);
		

	}
	public void draw(){

	}
}