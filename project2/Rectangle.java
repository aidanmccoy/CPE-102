import java.util.*;
import java.awt.*;

public class Rectangle implements Shape{
	private double width;
	private double height;
	private Point position;
	private Color color;
	private boolean filled;

	public Rectangle(double width,double height, Point position,Color color,boolean filled){
		this.width = width;
		this.height = height;
		this.position = position; 
		this.color = color;
		this.filled = filled;
	}

	public double getArea(){
		return (width * height);
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
	public void move(Point point){
		position.x = position.x + point.x;
		position.y = position.y + point.y;
	}
	public double getWidth(){
		return width;
	}
	public void setWidth(double newWidth){
		width = newWidth;
	}
	public double getHeight(){
		return height;
	}
	public void setHeight(double newHeight){
		height = newHeight;
	}
	public Point getPosition(){
		return position;
	}
	public boolean equals(Object other){
		if (other == null) return false;
		if(!this.getClass().equals(other.getClass())) return false;
		Rectangle r = (Rectangle)other;
		return height == (r.height) && width == (r.width) && position.equals(r.position) && color.equals(r.color) && filled == (r.filled);
	}
	
}