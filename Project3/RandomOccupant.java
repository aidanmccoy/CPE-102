import java.awt.*;
import java.util.*;

/**
*RandomOccupant.java
*A public class that extends Occupant that has the framework
*for all randomly moving occupants in the maze
**@author Aidan McCoy CPE 102
*@version 5/2/15
**/

public abstract class RandomOccupant extends Occupant{
	private Maze maze;
	private Random randomNum;
	
	public RandomOccupant(Maze newMaze){
		randomNum = new Random();
		maze = newMaze;
		int row = randomNum.nextInt(maze.rows());
		int col = randomNum.nextInt(maze.cols());		
		moveTo(maze.getSquare(row,col));
	}

	public RandomOccupant(Maze newMaze, long seed){
		randomNum = new Random(seed);
		maze = newMaze;
		int row = randomNum.nextInt(maze.rows());
		int col = randomNum.nextInt(maze.cols());
		moveTo(maze.getSquare(row,col));
	}

	public RandomOccupant(Maze newMaze, Square location){
		maze = newMaze;
		moveTo(location);
		randomNum = new Random();
	}

	public void move(){
		int row = super.location().row();
		int col = super.location().col();
		int randomDir = randomNum.nextInt(4);
		if(!super.location().wall(randomDir)){
			if(randomDir == Square.UP){
				//row = row -1;
				moveTo(maze.getSquare(row-1,col));
			}
			if (randomDir == Square.RIGHT){
				//col = col +1;
				moveTo(maze.getSquare(row,col+1));
			}
			if (randomDir == Square.DOWN){
				//row = row + 1;
				moveTo(maze.getSquare(row+1,col));
			}
			if (randomDir == Square.LEFT){
				//col = col -1;
				moveTo(maze.getSquare(row,col-1));
			}
		}
		else{
			move();
		}
	}
}