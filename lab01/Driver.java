public class Driver
{
   public static void main(String[] args)
   {
      // Declare and test a Counter object ...
      Counter ct = new Counter();
  
         // some sample tests
         System.out.println("Initial count: " + ct.currentCount());
         ct.incrementCount();
         System.out.println("Incremented once: " + ct.currentCount());
         ct.incrementCount();
         System.out.println("Incremented once: " + ct.currentCount());
         ct.incrementCount();
         System.out.println("Incremented once: " + ct.currentCount());
         ct.incrementCount();
         System.out.println("Incremented once: " + ct.currentCount());
         ct.reset();
         System.out.println("Reset: " + ct.currentCount());
         ct.incrementCount();
         System.out.println("Incremented once: " + ct.currentCount());
         ct.incrementCount();
         System.out.println("Incremented once: " + ct.currentCount());
         ct.incrementCount();
         System.out.println("Incremented once: " + ct.currentCount());
         ct.incrementCount();
         System.out.println("Incremented once: " + ct.currentCount());
         ct.unReset();
         
         System.out.println("unReset: " + ct.currentCount());



   }
}
