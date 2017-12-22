/**
 * A simple I/O Program that has 2 parts as a client server system
 *
 * @author Aidan McCoy
 * @version Lab 02
 * @version CPE102-16/17
 * @version Spring 2015
 */

public class Greeter {

   private String name;
   public Greeter(String name)
   {
      this.name = name;
   }
   public String greet (){
      return ("Hello " + name); 
   }


}
