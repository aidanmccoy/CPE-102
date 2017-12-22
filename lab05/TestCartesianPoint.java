import java.util.*;
public class TestCartesianPoint
{
   public static void main(String[] args)
   {
      // test methods
      testConstructor();
      testRadius();
      testAngle();
      testDistanceFrom();
      testRotate90();

      // results
      System.out.println("\nTests: " + SUnit.testsRun());
      System.out.println("Failures: " + SUnit.testsFailed());

      if (SUnit.testsFailed() == 0)
         System.out.println("\nPASSED ALL TESTS!!!");
   }

   private static void testConstructor()
   {
      int fails = SUnit.testsFailed();

      System.out.println("Testing constructor...");
      CartesianPoint cp = new CartesianPoint(2.1,4.7);
      SUnit.assertEquals(2.1, cp.xCoordinate(), .000001);
      SUnit.assertEquals(4.7, cp.yCoordinate(), .000001);

      if (fails == SUnit.testsFailed())
          System.out.println("     PASS");
   }

   private static void testRadius(){
      int fails = SUnit.testsFailed();

      System.out.println("Testing Radius...");
      CartesianPoint p1 = new CartesianPoint(0,0);
      SUnit.assertEquals(0,p1.radius(), .000001);
      CartesianPoint p2 = new CartesianPoint(1,0);
      SUnit.assertEquals(1,p2.radius(), .000001);
      CartesianPoint p3 = new CartesianPoint(-3,-4);
      SUnit.assertEquals(5,p3.radius(), .000001);
      CartesianPoint p4 = new CartesianPoint(-3,4);
      SUnit.assertEquals(5,p4.radius(), .000001);
      CartesianPoint p5 = new CartesianPoint(4,-3);
      SUnit.assertEquals(5,p5.radius(), .000001);

      if (fails == SUnit.testsFailed())
          System.out.println("     PASS");
   }

   private static void testAngle(){
      int fails = SUnit.testsFailed();

      System.out.println("Testing Angle...");
      CartesianPoint p1 = new CartesianPoint(1,1);
      SUnit.assertEquals(0.78539816, p1.angle(), .000001);
      CartesianPoint p2 = new CartesianPoint(-1,1);
      SUnit.assertEquals(2.356194, p2.angle(), .000001);


      if (fails == SUnit.testsFailed())
          System.out.println("     PASS");
   }

   private static void testDistanceFrom(){
      int fails = SUnit.testsFailed();

      System.out.println("Testing DistanceFrom...");
      CartesianPoint p1 = new CartesianPoint(0,0);
      CartesianPoint p2 = new CartesianPoint(1,0);
      SUnit.assertEquals(1, p1.distanceFrom(p2), .000001);
      CartesianPoint p3 = new CartesianPoint(-1,-1);
      CartesianPoint p4 = new CartesianPoint(-1,0);
      SUnit.assertEquals(1, p3.distanceFrom(p4), .000001);

      if (fails == SUnit.testsFailed())
          System.out.println("     PASS");
   }

   private static void testRotate90(){
      int fails = SUnit.testsFailed();

      System.out.println("Testing Rotate90...");
      CartesianPoint p1 = new CartesianPoint(0,0);
      p1.rotate90();
      SUnit.assertEquals(0, p1.xCoordinate(), .000001);
      SUnit.assertEquals(0, p1.yCoordinate(), .000001);
      CartesianPoint p2 = new CartesianPoint(0,1);
      Point rotp2 = p2.rotate90();
      SUnit.assertEquals(0, p2.xCoordinate(), .000001);
      SUnit.assertEquals(1, p2.yCoordinate(), .000001);
      SUnit.assertEquals(-1, rotp2.xCoordinate(),.000001);
      SUnit.assertEquals(0, rotp2.yCoordinate(),.000001);

      if (fails == SUnit.testsFailed())
          System.out.println("     PASS");

   }
}
