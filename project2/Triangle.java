import java.util.*;
import java.awt.*;

public class Triangle implements Shape{
	private Point a;
	private Point b;
	private Point c;
	private Color color;
	private boolean filled;

	public Triangle(Point a,Point b,Point c,Color color,boolean filled){
		this.a = a;
		this.b = b;
		this.c = c;
		this.color = color;
		this.filled = filled;
	}

	public double getArea(){
		return Math.abs((a.x-c.x)*(b.y-a.y)-(a.x-b.x)*(c.y-a.y))*(.5);
	}
	public Color getColor(){
		return color;
	}
	public void setColor(Color newColor){
		color = newColor;
	}
	public boolean getFilled(){
		return filled;
	}
	public void setFilled(boolean newFilled){
		filled = newFilled;
	}
	public void move(Point newPoint){
		a = new Point(a.x+newPoint.x , a.y+newPoint.y);
		b = new Point(b.x+newPoint.x , b.y+newPoint.y);
		c = new Point(c.x+newPoint.x , c.y+newPoint.y);
	}
	public Point getVertexA(){
		return a;
	}
	public void setVertexA(Point newPoint){
		a = newPoint;
	}
		public Point getVertexB(){
		return b;
	}
	public void setVertexB(Point newPoint){
		b = newPoint;
	}	
	public Point getVertexC(){
		return c;
	}
	public void setVertexC(Point newPoint){
		c = newPoint;
	} 
	public boolean equals(Object other){
		if (other == null) return false;
		if(!this.getClass().equals(other.getClass())) return false;
		Triangle t = (Triangle)other;
		return a.equals(t.a) && b.equals(t.b) && c.equals(t.c) && color.equals(t.color) && filled == (t.filled);
	}
}
