import java.util.*;

public class PolarPoint implements Point
{
   private double angle;
   private double radius;


   public PolarPoint( double radius, double angle){
      this.angle = angle;
      this.radius = radius;
   }
   
   public double angle()
   {return angle;}
   
   public double distanceFrom(Point other)
   {return Math.sqrt((radius*radius) + (other.radius() * other.radius())+ (-2 * radius*other.radius()*(Math.cos(other.angle() - angle))));
   }
   
   public double radius()
   {return radius;}

   public Point rotate90()
   {return new PolarPoint(radius,(angle + ((Math.PI)/2)));}

   public double xCoordinate()
   {return radius*(Math.cos(angle));}

   public double yCoordinate()
   {return radius*(Math.sin(angle));}

}
