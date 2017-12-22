/**
*Explorer.java
*
*a public class that represents a controllable explorer 
*that responds to user input to move through the maze
*@author Aidan McCoy CPE 102
*@version 5/2/15
**/


import java.awt.event.KeyEvent;
import java.util.*;

public class Explorer extends Occupant{
	
	private String name;
	private Maze maze;

	public Explorer(Maze maze){
		this.maze = maze;
	}

	public Explorer(Square location, Maze maze, String name){
		super(location);
		this.maze = maze;
		this.name = name;
		maze.lookAround(location);		
	}

	public String name(){
		return name;
	}
	public void move(int key){
		int row = super.location().row();
		int col = super.location().col();

		if(key == KeyEvent.VK_UP || key == KeyEvent.VK_KP_UP){
			if(location().wall(Square.UP) == false){
				moveTo(maze.getSquare(row-1,col));
			}
		}
		if(key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_KP_RIGHT){
			if(location().wall(Square.RIGHT) == false){
				moveTo(maze.getSquare(row,col+1));
			}
		}
		if(key == KeyEvent.VK_DOWN || key == KeyEvent.VK_KP_DOWN){
			if(location().wall(Square.DOWN) == false){
				moveTo(maze.getSquare(row+1,col));
			}
		}
		if(key == KeyEvent.VK_LEFT || key == KeyEvent.VK_KP_LEFT){
			if(location().wall(Square.LEFT) == false){
				moveTo(maze.getSquare(row,col-1));
			}
		}

	}
	public void moveTo(Square s){
		super.moveTo(s);
		s.enter();
		maze.lookAround(s);
	}
	public String toText(char delimiter){
		return getClass().getName() + delimiter+location().row() + delimiter + location().col() + delimiter + name();
	}
	public void toObject(Scanner input){
		int row,col;
		row = input.nextInt();
		col = input.nextInt();
		Square s = maze.getSquare(row,col);
		moveTo(s);
		this.name = input.next();
	}
}