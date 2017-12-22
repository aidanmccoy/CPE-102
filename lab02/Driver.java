import java.util.Scanner;

public class Driver
{
   public static void main(String[] args)
   {
   // Declare Scanner Object
   Scanner scanner = new Scanner(System.in);

   // Name Prompt
   System.out.print("What is your name? ");

   //Read Name
   String name = scanner.nextLine();

   // Constructor
   Greeter greeter = new Greeter(name);
  
   // Get Greeter and save to string
   String greeting = greeter.greet();

   //Display greetung
   System.out.println(greeting);
   }
}
