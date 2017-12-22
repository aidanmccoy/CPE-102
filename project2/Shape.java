import java.util.*;
import java.awt.*;

/**
 *Jave interface Shape
 *@author Aidan McCoy
 *@version Project 02
 *@version CPE-102
 *@version Spring 2015
 */

public interface Shape{
	/**
	 *Calculates and returns the area of an object
	 *@return The area of the object
	 **/
	public double getArea(); 
	
	/**
	*Returns the Color of an object
	*@return the Color of an object
	**/
	public Color getColor(); 

	/**
	*Sets the Color of the object
	*@param color A color is passed into the method
	**/
	public void setColor(Color color); 

	/**
	*Return true if the object is filled with color, otherwise false
	*@return If the Triangle is filled with color
	**/
	public boolean getFilled();

	/**
	*Sets the filled state of the object
	*@param filled a boolean is passed into the method
	**/
	public void setFilled(boolean filled);

	/**
	* Moves the shape by the x and y amounts specified in the Point
	*@param point a Point is passed into the method
	**/
	public void move(Point point); 
}