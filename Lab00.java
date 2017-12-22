public class Lab00
{
   public static void main(String[] args)
   {
      int x = 5;
      String y = "hello";
      double z = 9.8;

      // Printing the variables 

      System.out.println("x: "+x+" y: " +y+" z: " + z);

      // Making and Printing Arrays

      int [] nums = {3,6,-1,2};
      for (int num : nums){
         System.out.println(num);
      }

      // Calling a Function

      int numFound = char_count(y,'l');
      System.out.println("Found: "+ numFound);

      // A counting loop

      for (int i = 1; i < 11; i++){
         System.out.print(i + " ");
      }
   }
   public static int char_count(String s, char c){
      int count = 0;
      for( int i = 0; i<s.length();i++){
         if( c == s.charAt(i)){
            count ++;}
      }
      return count;
   }
}

