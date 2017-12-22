import java.util.*;
import java.awt.*;

public class WorkSpace{

	private ArrayList<Shape> shapeList = new ArrayList<Shape>();

	public void add(Shape newShape){
		shapeList.add(newShape);
	}
	public Shape remove(int index){
		return shapeList.remove(index);
	}
	public Shape get(int index){
		return shapeList.get(index);
	}
	public int size(){
		return shapeList.size();
	}
	public ArrayList<Circle> getCircles(){
		
		ArrayList<Circle> circles = new ArrayList<Circle>();

		for(int i = 0; i < shapeList.size(); i++){
			if(shapeList.get(i) instanceof Circle){
				circles.add((Circle)shapeList.get(i));
			}
		}
		return circles;
	}
	public ArrayList<Rectangle> getRectangles(){
		
		ArrayList<Rectangle> rectangles = new ArrayList<Rectangle>();

		for(int i = 0; i < shapeList.size(); i++){
			if(shapeList.get(i) instanceof Rectangle){
				rectangles.add((Rectangle)shapeList.get(i));
			}
		}
		return rectangles;
	}
	public ArrayList<Triangle> getTriangles(){
		
		ArrayList<Triangle> triangles = new ArrayList<Triangle>();

		for(int i = 0; i < shapeList.size(); i++){
			if(shapeList.get(i) instanceof Triangle){
				triangles.add((Triangle)shapeList.get(i));
			}
		}
		return triangles;
	}
	public ArrayList<ConvexPolygon> getConvexPolygons(){
		
		ArrayList<ConvexPolygon> convexPolygons = new ArrayList<ConvexPolygon>();

		for(int i = 0; i < shapeList.size(); i++){
			if(shapeList.get(i) instanceof ConvexPolygon){
				convexPolygons.add((ConvexPolygon)shapeList.get(i));
			}
		}
		return convexPolygons;
	}
	public ArrayList<Shape> getShapesByColor(Color color){
		ArrayList<Shape> shapesByColor = new ArrayList<Shape>();

		for(int i = 0; i < shapeList.size(); i++){
			if(shapeList.get(i).getColor() == color){
				shapesByColor.add((Shape)shapeList.get(i));
			}
		}
		return shapesByColor;
	}
	public double getAreaOfAllShapes(){
		double totalArea = 0.0;
		
		for(int i = 0; i < shapeList.size(); i++){
			totalArea = (totalArea + shapeList.get(i).getArea());
		}
		return totalArea;
	}

}