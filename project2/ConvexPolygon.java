import java.util.*;
import java.awt.*;

public class ConvexPolygon implements Shape{
	private Point[] verticies;
	private Color color;
	private boolean filled;

	public ConvexPolygon(Point[] verticies, Color color,boolean filled){
		this.verticies = verticies;
		this.color = color;
		this.filled = filled;
	}
	public double getArea(){
		double yx = 0.0;
		double xy = 0.0;
		double areaTotal = 0.0;
		int index = 0;

		for(index = 0;index < verticies.length-1;index++){
			yx +=verticies[index].y * verticies[index+1].x;
			xy +=verticies[index].x * verticies[index+1].y;
		}
		yx +=verticies[index].y * verticies[0].x;
		xy +=verticies[index].x * verticies[0].y;
		areaTotal = .5*(xy - yx);
		return areaTotal;
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
		for(int i = 0;i < verticies.length; i++){
			verticies[i].x = verticies[i].x + newPoint.x;
			verticies[i].y = verticies[i].y + newPoint.y;
		}
	}
	public Point getVertex(int index){
		return verticies[index];
	}
	public void setVertex(int index,Point newPoint){
		verticies[index] = newPoint;
	}
	public boolean equals(Object other){
		if (other == null) return false;
		if(!this.getClass().equals(other.getClass())) return false;
		ConvexPolygon c = (ConvexPolygon)other;
		boolean equalVertecies = true;
		for(int i = 0; i < verticies.length; i++){
			if(verticies[i].equals(c.verticies[i]) != true){
				equalVertecies = false;
			}
		}
		return equalVertecies && color.equals(c.color) && filled == (c.filled);
	}

}

