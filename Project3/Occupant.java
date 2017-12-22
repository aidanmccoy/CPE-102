/** 
*Occupant.java
*An abstract class that represents all things that occupy the maze
*@author Aidan McCoy CPE 102
*@version 5/2/15
**/

import java.awt.*;

public abstract class Occupant{
	
	private Square square;

	public Occupant(){}

	public Occupant(Square start){
		square = start;
	}

	public Square location(){
		return square;
	}
	public void moveTo(Square newLoc){
		square = newLoc;

	}
}