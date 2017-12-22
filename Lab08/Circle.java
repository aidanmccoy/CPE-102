import java.util.Random;

public class Circle
{
    private double radius;

    public Circle()
    {
        Random rand = new Random();
        radius = rand.nextDouble();
    }
    public Circle(double radius) throws NegativeRadiusException,ZeroRadiusException
    {
        this.radius = radius;
        if(radius == 0 ){
            throw new ZeroRadiusException();
        }
        if(radius <0 ){
            throw new NegativeRadiusException(radius);
        }
    }

    public double radius()
    {
        return radius;
    }
    
    public double diameter()
    {
        return radius*2.0;
    }
    
    public double circumference()
    {
        return 2.0*Math.PI*radius;
    }
    
    public double area()
    {
        return Math.PI*radius*radius;
    }
    
    public String toString()
    {
        return "Radius: " + radius;
    }
}
