/** 
*Occupant.java
*An abstract class that represents all things that occupy the maze
*@author Aidan McCoy CPE 102
*@version 5/2/15
**/

import java.util.*;
import java.awt.*;

public abstract class Occupant implements DelimitedTextIO{
	
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
	public String toText(char delimiter){
		int x = square.row();
		int y = square.col();
		return getClass().getName() +delimiter+ x + delimiter + y ;
	}
}