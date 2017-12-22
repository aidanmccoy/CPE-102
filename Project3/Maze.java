import java.util.*;
/**
 * Class that contains all the logic to model a Maze with Treasures, Monsters, and an Explorer.
 * 
 * @author Aidan McCoy
 * @version 5/2/15
 */
public class Maze
{
   // named constants
   public static final int ACTIVE = 0;
   public static final int EXPLORER_WIN = 1;
   public static final int MONSTER_WIN = 2;
    
    // instance variables
   private Square[][] squares;
   private ArrayList<RandomOccupant> randOccupants;
   private Explorer explorer;
   private int rows;
   private int cols;

   /**
    * Constructor for objects of class Maze
    */
   public Maze(Square[][] squares, int rows, int cols)
   {
      this.squares = squares;
      this.rows = rows;
      this.cols = cols;
		
      randOccupants = new ArrayList<>();
		
   }
	
   // QUERIES
   public Square getSquare(int row, int col) { return squares[row][col]; }
   public int rows() {return rows;}
   public int cols() {return cols;}
   public String explorerName() {return explorer.name();}
   public Explorer getExplorer() {return explorer;}
    
   // - Implement the following two methods.  I have them stubbed to return dummy values just so it will compile.
   //          Your getRandomOccupant should return the occupant from the ArrayList at the specified index.
   public RandomOccupant getRandomOccupant(int index) {return (randOccupants.get(index));
   }

   public int getNumRandOccupants() {return randOccupants.size();
   }
	
   // COMMANDS
   //  - implement the following method
   public void addRandomOccupant(RandomOccupant ro){
    randOccupants.add(ro);
   }
	
   public void setExplorer(Explorer e) {explorer = e;}
	
   public void explorerMove(int key)
   {
      explorer.move(key);
   }
	
   public void randMove()
   {
    for(RandomOccupant x : randOccupants){
      x.move();
      // - instruct each object in the RandomOccupant to move
    }
   }
	
   /**
    * Returns the status of the game.
    *
    * If all treasures have been found, return EXPLORER_WIN.
    * If not, check each maze occupant, if it is a Monster and
    *    it is in the same location as the Explorer, return
    *    MONSTER_WIN.  Note that you can use == to check locations, do you know why?
    * Otherwise, return ACTIVE.
    */
   public int gameStatus()
   {
      int status = ACTIVE;
      int treasureFound = 0;
      int treasureTotal = 0;
      for(RandomOccupant x: randOccupants){
        if(x.getClass() == Treasure.class){
          Treasure t = (Treasure)x;
          treasureTotal = treasureTotal +1;
          if (t.found() == true){
            treasureFound = treasureFound +1;
          }
        }
      }
      if (treasureFound == treasureTotal){
        status = EXPLORER_WIN;
      }
      if (status == ACTIVE){
        for(RandomOccupant x: randOccupants){
          if(x.getClass() == Monster.class){
            Monster m = (Monster)x;
            if(m.location() == explorer.location()){
              status = MONSTER_WIN;
            }
          }
        }
      }
    return status;
   }
	
   private boolean foundAllTreasures()
   {  
    int treasureFound = 0;
    int treasureTotal = 0;  
    boolean foundAll = true;
    for(RandomOccupant x: randOccupants){
      Treasure t = (Treasure)x;
      if(t instanceof Treasure){
        treasureTotal = treasureTotal +1;
          if (t.found() == true){
            treasureFound = treasureFound +1;
          }
        }
      }
    if(treasureFound == treasureTotal){
      return true;
    }
    else{
      return false;
    }
   }
    
   public void lookAround(Square s)
   {
      int row = s.row();
      int col = s.col();
      boolean top = false;
      boolean right = false;
      boolean left = false;
      boolean down = false;
        
      // Clear what was previously in view
      resetInView();
        
      // Set the current square so that we are viewing it (obviously)
      s.setInView(true);

      //check top,bottom,and sides
      if (s.wall(0)== false){
        this.getSquare(row-1,col).setInView(true);
        top = true;
      }

      if (s.wall(1) == false){
        this.getSquare(row,col+1).setInView(true);
        right = true;
      }
      if (s.wall(2)== false){
        this.getSquare(row+1,col).setInView(true);
        down = true;
      }
      if (s.wall(3)==false){
        this.getSquare(row,col-1).setInView(true);
        left = true;
      }

      if(top == true){
        if(!this.getSquare(row-1,col).wall(1)){
          this.getSquare(row-1,col+1).setInView(true);
        }
        if(!this.getSquare(row-1,col).wall(3)){
          this.getSquare(row-1,col-1).setInView(true);
        }
      }
        if(right == true){
        if(!this.getSquare(row,col+1).wall(0)){
          this.getSquare(row-1,col+1).setInView(true);
        }
        if(!this.getSquare(row,col+1).wall(2)){
          this.getSquare(row+1,col-1).setInView(true);
        }
      }
        if(down == true){
        if(!this.getSquare(row+1,col).wall(1)){
          this.getSquare(row+1,col+1).setInView(true);
        }
        if(!this.getSquare(row+1,col).wall(3)){
          this.getSquare(row+1,col-1).setInView(true);
        }
      }
        if(left == true){
        if(!this.getSquare(row,col-1).wall(0)){
          this.getSquare(row-1,col-1).setInView(true);
        }
        if(!this.getSquare(row,col-1).wall(2)){
          this.getSquare(row+1,col-1).setInView(true);
        }
      }
    }




      /*if (top && right){
        Square sqr = getSquare(row-1,col+1);
        if(sqr.wall(3) == false && sqr.wall(2) == false){
          sqr.setInView(true);
        }
      }
      if (top && left){
        Square sqr = getSquare(row-1,col-1);
        if(sqr.wall(1) == false && sqr.wall(2) == false){
          sqr.setInView(true);
        }
      }
      if (down && right){
        Square sqr = getSquare(row+1,col+1);
        if(sqr.wall(3) == false && sqr.wall(0) == false){
          sqr.setInView(true);
        }
      }
      if (down && left){
        Square sqr = getSquare(row+1,col-1);
        if(sqr.wall(1) == false && sqr.wall(0) == false){
          sqr.setInView(true);
        }
      }*/
    
   private void resetInView()
   {
      for (int i = 0; i<rows; i++) {
         for (int j = 0; j<cols; j++) {
            squares[i][j].setInView(false);
         }
      }
   }
}
