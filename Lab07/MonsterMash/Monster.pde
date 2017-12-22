import java.lang.*;

public class Monster{
  public PVector direction;
  public double x;
  public double y;
  
  public Monster(double x, double y){
    this.x = x;
    this.y = y;
    direction = new PVector(0,0);
  }
  
  public void draw(){
       pushMatrix();
       translate((int)x, (int)y);
        
       stroke(0);       
       fill(70,20,200);
       ellipse(0,0,25,40);
       
       noStroke();
       fill(70,20,200);
       ellipse(9,17,5,12);
       ellipse(5,17,5,12);
       ellipse(1,17,5,12);
       ellipse(-3,17,5,12);
       ellipse(-7,17,5,12);
       ellipse(13,17,5,12);
       ellipse(-11,17,5,12);
       
       fill(255,255,255);
       ellipse(-7,-5,8,5);
       ellipse(7,-5,8,5);
       
       fill(0);
       ellipse(-6,-5,2,2);
       ellipse(6,-5,2,2);

      
      
      /*
       // head
       fill(120);
       ellipse(0, -10, 25, 25);
        
       // eyes
       fill(255);
       ellipse(0, -10, 20, 18);
       fill(120);
       ellipse(0, -17, 20, 10);
       fill(0);
       ellipse(-2, -10, 2, 2);
       ellipse(2, -10, 2, 2);
        
       // muzzle / jowels
       fill(180);
       ellipse(0, -3, 22, 10);
       fill(120);
       rect(-7, 0, 14, 13);
       ellipse(0, 10, 20, 10);
       fill(180);
       ellipse(-10, 5, 7, 15);
       ellipse(10, 5, 7, 15);
        
       // nose
       fill(0);
       ellipse(0, -6, 8, 5);
        
       // teeth
       fill(255);
       triangle(-7, 0, -5, -5, -3, 0);
       triangle(7, 0, 5, -5, 3, 0);
        
       // ears
       fill(120);
       ellipse(-10, -20, 6, 3);
       ellipse(10, -20, 6, 3);*/
        
       popMatrix();
   
  }
  public double getX(){
    return x;
  }
  public double getY(){
    return y;
  }
  public void move(){
    x = x+direction.x;
    y = y+direction.y;    
  }
  public void setVector(PVector direction2){
    direction = direction2;
  }
  
  
}
