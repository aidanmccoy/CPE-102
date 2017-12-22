import java.awt.*;

public class Person extends Animal{

	private String name;

	public Person(int numLegs, String name){
		super(numLegs);
		this.name = name;
	}

	public boolean equals(Object other){
		if(!super.equals(other)) return false;
		return name == ((Person)other).name;
	}

	public String toString(){
		return super.toString() + " and a Person object whose name is "+ name;
	}
}