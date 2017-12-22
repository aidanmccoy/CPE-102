/**
*Drawable Treasure.java
*A class that allows for the drawing of Treasure on the maze
**@author Aidan McCoy CPE 102
*@version 5/2/15
**/

public class DrawableTreasure extends Treasure implements Drawable{

	public DrawableTreasure(Maze maze){
		super(maze);
	}

	public DrawableTreasure(Maze maze, long seed){
		super(maze,seed);
	}

	public DrawableTreasure(Maze maze, Square location){
		super(maze,location);
	}

	public void draw(){

	}
}