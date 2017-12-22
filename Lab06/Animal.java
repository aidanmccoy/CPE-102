import java.awt.*;

public class Animal{
	private int numLegs;


	public Animal(int numLegs){
		this.numLegs = numLegs;
	}

	public boolean equals(Object other){
		if(other == null) return false;
		if(!this.getClass().equals(other.getClass())) return false;
		Animal a = (Animal)other;
		return numLegs == (a.numLegs);
	}

	public String toString(){
		return ("I am an Animal object with "+ numLegs +" legs");
	}
}	