/**
*Monster.java
*A public class Monster that extends RandomObject to create 
*something that moves around the maze
*@author Aidan McCoy CPE 102
*@version 5/2/15
**/


import java.awt.*;
import java.util.*;

public class Monster extends RandomOccupant{

	public Monster(Maze maze){
		super(maze);
	}

	public Monster(Maze maze, long seed){
		super(maze,seed);
	}

	public Monster(Maze maze, Square location){
		super(maze,location);

	}
}