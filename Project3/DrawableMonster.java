/**
*DrawableMonster.java
*A class that lets you draw the monsters in the maze
**@author Aidan McCoy CPE 102
*@version 5/2/15
**/

public class DrawableMonster extends Monster implements Drawable{

	public DrawableMonster(Maze maze){
		super(maze);
	}

	public DrawableMonster(Maze maze, long seed){
		super(maze,seed);
	}
	public DrawableMonster(Maze maze, Square location){
		super(maze,location);
	}

	public void draw(){

	}
}