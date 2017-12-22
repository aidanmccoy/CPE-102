/**
*Treasure.java
* A public class that extends Random Occupant to place non moving
*random objects on the map.
*@author Aidan McCoy CPE 102
*@version 5/2/15
**/

public class Treasure extends RandomOccupant{

	private boolean found;

	public Treasure(Maze maze){
		super(maze);
		found = false;
		maze.getSquare(location().row(),location().col()).setTreasure(this);
	}

	public Treasure(Maze maze, long seed){
		super(maze,seed);
		found = false;
		maze.getSquare(location().row(),location().col()).setTreasure(this);
	}

	public Treasure(Maze maze, Square location){
		super(maze,location);
		found = false;
		maze.getSquare(location().row(),location().col()).setTreasure(this);
	}

	public boolean found(){
		return found;
	}

	public void setFound(){
		found = true;
	}

	public void move(){}

	
}