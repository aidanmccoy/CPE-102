public class Rochambeau
{
   public static final int PAPER = 1;
   public static final int ROCK = 0;
   public static final int SCISSORS = 2;

   public Rochambeau(){
   }


   public static int getWinner(int throw1, int throw2){
      if(throw1 == ROCK && throw2 == PAPER){
         return -1;
      }
      else if(throw1 == ROCK && throw2 == SCISSORS){
         return 1;
      }
      else if(throw1 == PAPER && throw2 == ROCK){
         return 1;
      }
      else if(throw1 == PAPER && throw2 == SCISSORS){
         return -1;
      }
      else if(throw1 == SCISSORS && throw2 == ROCK){
         return -1;
      }
      else if(throw1 == SCISSORS && throw2 == PAPER){
         return 1;
      }
      else{ 
         return 0;
      }
   }


}
