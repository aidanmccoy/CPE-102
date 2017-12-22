import java.awt.*;

public class Student extends Person{
	
	private double gpa;

	public Student(int numLegs, String name, double gpa){
		super(numLegs,name);
		this.gpa = gpa;
	}

	public boolean equals(Object other){
		if(!super.equals(other)) return false;
		return gpa == ((Student)other).gpa;
	}
	public String toString(){
		return super.toString() + " and a Student Object with a "+ gpa +"GPA";
	}

}