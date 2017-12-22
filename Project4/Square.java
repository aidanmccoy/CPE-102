/**
*Square.java 
*
*A public class that represents all of the squares
*that make up the maze.
*
*@author Aidan McCoy CPE 102
*@version 5/2/15
**/


import java.awt.*;
import java.util.*;

public class Square implements DelimitedTextIO{

	public static final int SQUARE_SIZE = 50;
	public static final int UP = 0;
	public static final int RIGHT = 1;
	public static final int DOWN = 2;
	public static final int LEFT = 3;


	private boolean seen;
	private boolean inView;
	private int row;
	private int col;
	private Treasure treasure;
	private boolean wall[];

	public Square(int row,int col){
		this.row = row;
		this.col = col;		
	}

	public Square(boolean up, boolean right, boolean down, boolean left, int row, int col){
		inView = false;
		seen = false;
		this.row = row;
		this.col = col;
		treasure = null;
		wall = new boolean[] {up,right,down,left};
	}

	public boolean wall(int direction){
		boolean finalboo = true;
		if(direction == UP){
			finalboo = wall[0];
			
		}
		else if (direction == RIGHT){
			finalboo = wall[1];
			
		}
		else if(direction == DOWN){
			finalboo = wall[2];
		}
		else if(direction == LEFT){
			finalboo = wall[3];
			
		}
		return finalboo;
	}
	public boolean seen(){
		return seen;
	}
	public boolean inView(){
		return inView;
	}
	public int row(){
		return row;
	}
	public int col(){
		return col;
	}
	public Treasure treasure(){
		return treasure;
	}
	public int x(){
		return col*SQUARE_SIZE;
	}
	public int y(){
		return row*SQUARE_SIZE;
	}
	public void setInView(boolean inview){
		inView = inview;
		if(seen == false && inview == true){
			seen = true;
		}
		else{
			seen = seen;
		}
	}
	public void setTreasure(Treasure t){
		treasure = t;
	}
	public void enter(){
		if(treasure != null){
			if(treasure.found() == false){
				treasure.setFound();
			}
		}
	}
	public String toText(char delimiter){

		return getClass().getName()+ delimiter+ row +delimiter+ col+delimiter + wall[UP]+delimiter+wall[RIGHT]+delimiter+wall[DOWN]+delimiter+wall[LEFT]+delimiter+seen()+delimiter+inView();
	}
	public void toObject(Scanner input){
	
		wall = new boolean[4];
		if (input.hasNextBoolean()){
			wall[UP] = input.nextBoolean();
		}
		if (input.hasNextBoolean()){
		wall[RIGHT] = input.nextBoolean();
		}
		if (input.hasNextBoolean()){
		wall[DOWN] = input.nextBoolean();
		}	
		if (input.hasNextBoolean()){
			wall[LEFT] = input.nextBoolean();
		}
		if (input.hasNextBoolean()){
			seen = input.nextBoolean();
		}
		if (input.hasNextBoolean()){
		inView = input.nextBoolean();
		}
	}
}