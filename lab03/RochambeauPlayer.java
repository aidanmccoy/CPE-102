import java.util.*;
//extends java.lang.Object
public class RochambeauPlayer
{
   
   public String name;
   public int wins = 0;
   public int throwType;
   public String hand;   

   public RochambeauPlayer(java.lang.String name)
   {
   this.name = name;
   }

   public java.lang.String getName(){
   return name;
   }
   
   public int getWins(){
   return wins;
   }
  
   public void incrementWins(){
   wins = (wins+1);
   }

   public java.lang.String lastThrow(){
      if(throwType == 0){
         hand = ("Rock");
      }
      else if (throwType == 1){
         hand = ("Paper");
      }
      else if (throwType == 2){
         hand = ("Scissors");
      }
      return hand;
    }

   public String toString(){
      return (name + " has won " + wins + " games.");
   }

   public int makeThrow(){
      Random rand = new Random();
      throwType = rand.nextInt(3);
      return throwType;
      }
   
   public int makeThrow(int throwTypePerson){
      throwType = throwTypePerson;
      return throwTypePerson;
   }         

}
