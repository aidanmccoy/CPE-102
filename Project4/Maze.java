import java.util.*;
import java.io.*;
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

   public Maze(){
    randOccupants = new ArrayList<>();
   }
   
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
        
      // Clear what was previously in view
      resetInView();
        
      // Set the current square so that we are viewing it (obviously)
      s.setInView(true);
   
  Square sqr = getSquare(row, col);

  if (sqr.wall(Square.UP) == false){
    Square upSqr = getSquare(row - 1, col);  
    upSqr.setInView(true);
    if (upSqr.wall(Square.LEFT) == false){
      Square upLeft = getSquare(row - 1, col - 1);
      upLeft.setInView(true);
    }
    if (upSqr.wall(Square.RIGHT) == false){
      Square upRight = getSquare(row - 1, col +1);
      upRight.setInView(true);
    }
  } 
  
  if (sqr.wall(Square.LEFT) == false){
    Square leftSqr = getSquare(row, col - 1);
    leftSqr.setInView(true);
    if (leftSqr.wall(Square.UP) == false){
      Square leftUP = getSquare(row - 1, col -1);
      leftUP.setInView(true);
    }
    if (leftSqr.wall(Square.DOWN) == false){
      Square leftDown = getSquare(row + 1, col -1);
      leftDown.setInView(true);
    }
  }
  
  if (sqr.wall(Square.RIGHT) == false){
    Square rightSqr = getSquare(row, col + 1);
    rightSqr.setInView(true);
    if (rightSqr.wall(Square.UP) == false){
      Square rightUp = getSquare(row - 1, col + 1);
      rightUp.setInView(true);
    }
    if (rightSqr.wall(Square.DOWN) == false){
      Square rightDown = getSquare(row + 1, col + 1);
      rightDown.setInView(true);
    }
  }
  
  if (sqr.wall(Square.DOWN) == false){
    Square downSqr = getSquare(row + 1, col);
    downSqr.setInView(true);
    if (downSqr.wall(Square.LEFT) == false){
      Square downLeft = getSquare(row + 1, col - 1);
      downLeft.setInView(true);
    }
    if (downSqr.wall(Square.RIGHT) == false){
      Square downRight = getSquare (row + 1, col + 1);
      downRight.setInView(true);
      
    }
    
  }
  
}
   private void resetInView()
   {
      for (int i = 0; i<rows; i++) {
         for (int j = 0; j<cols; j++) {
            squares[i][j].setInView(false);
         }
      }
   }

   public void writeMazeToFile(String fileName) throws IOException{
    try{
      char delimiter = ',';
      String toWrite = rows + "," + cols;
      PrintStream toPrint = new PrintStream(fileName);
      toPrint.println(toWrite);
      for (int i = 0; i<rows; i++){
        for (int j = 0; j<cols; j++){
          toPrint.println(squares[i][j].toText(delimiter));
        }
      }
      if(explorer != null){
      toPrint.println(explorer.toText(delimiter));
    }
      for(RandomOccupant randOcc: randOccupants){
        if(randOcc instanceof Treasure){
          toPrint.println(randOcc.toText(delimiter));
        }
      }
      for(RandomOccupant randOcc: randOccupants){
        if(randOcc instanceof Monster){
          toPrint.println(randOcc.toText(delimiter));
        }
      }
      toPrint.close();
    }
    catch (IOException except){
      except.printStackTrace();
    }
  }

  public void readMazeFromFile(String fileName) throws IOException, FileNotFoundException, MazeReadException{
    
    Scanner line = new Scanner(new File(fileName));
    String workingLine = line.nextLine();
    Scanner obj = new Scanner(workingLine);
    obj.useDelimiter(",");
    int lineNumber =1;

    try{
      rows = obj.nextInt();
      cols = obj.nextInt();
      squares = new Square[rows][cols];
    }
    catch(Exception e){
      throw new MazeReadException("Rows and columns not specified.", workingLine,lineNumber);
    }
    while(line.hasNext()){
      lineNumber++;
      workingLine = line.nextLine();
      obj = new Scanner(workingLine);
      obj.useDelimiter(",");
      String type;
      try{
        type = obj.next();
      }
      catch(Exception e){
        throw new MazeReadException("Line format or other error.",workingLine,lineNumber);
      }
      if(type.equals("Square")){
        int row = obj.nextInt();
        int col = obj.nextInt();
        if(squares[row][col] != null){
          throw new MazeReadException("Duplicate square.",workingLine,lineNumber);
        }
        Square s = new Square(row,col);
        s.toObject(obj);
        squares[row][col] = s;
      }
      else if(type.equals("Explorer")){
        explorer = new Explorer(this);
        explorer.toObject(obj);
      }
      else if(type.equals("Treasure")){
        Treasure t = new Treasure(this);
        try{
          t.toObject(obj);
        }
        catch (Exception e){
          throw new MazeReadException("Line format or other error.",workingLine,lineNumber);
        }
        randOccupants.add(t);
      }
      else if(type.equals("Monster")){
        Monster m = new Monster(this);
        try{
          m.toObject(obj);
        }
        catch(Exception e){
          throw new MazeReadException("Line format or other error.", workingLine, lineNumber);
        }
        randOccupants.add(m);
        }
        else{
          throw new MazeReadException("Unknown type.", workingLine,lineNumber);
        }
      }
    }
}
