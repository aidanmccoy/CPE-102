import java.util.*;

public class CartesianPoint implements Point
{
   private double xCoord;
   private double yCoord;

   public CartesianPoint( double xCoord, double yCoord)
   {
     this.xCoord = xCoord;
     this.yCoord = yCoord;
   }

   public double angle()
   {return Math.atan2(yCoord,xCoord);}
   
   public double distanceFrom(Point other)
   {
   return Math.sqrt((other.xCoordinate() - xCoord) * (other.xCoordinate() - xCoord) + (other.yCoordinate() - yCoord) * (other.yCoordinate() - yCoord));
   }
  
   public double radius()
   {return Math.sqrt((xCoord*xCoord) + (yCoord*yCoord));}

   public Point rotate90()
   {return new CartesianPoint(-yCoord,xCoord);}
   
   public double xCoordinate()
   {return xCoord;}
 
   public double yCoordinate()
   {return yCoord;} 
}

