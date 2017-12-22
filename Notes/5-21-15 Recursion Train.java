//-----------------------------------Train Interface------------------------------
public interface Train{
	
	public int length();//length of train
	public double cargoValue();//total value of cargo on train
	public boolean isPassenger(int cargo, int passernger); //passenger trains have more passenger cars than cargo cars
	public String toString();
	// A string representation of the train.
	//Engines add their name, passengers add their class, cargos add their class and value Cabooses add their class
	//EX: "Highroller: Passenger, Cargo(1000.0), Cargo(25.0),Passenger, Caboose"
}

//---------------------------------Example Trains--------------------------------

public static void main(String[] args){
	Train t1, t2;

	t1 = new Engine("Shorty", new Caboose());

	t2 = new Engine("Highroller",
				new Passenger(
					new Passenger(
						new Cargo(1000,
							new Cargo(25,
								new Passenger(
									new Caboose()))))));
}

//-------------------------------------Engine Class--------------------------------------

// always at the start of the train
public class Engine implements Train{
	private Train rest;
	private String name;

	public Engine(String name, Train rest){
		this.rest = rest;
		this.name = name;
	}

	public int length(){
		return 1 + rest.length();
	}

	public double cargoValue(){
		return rest.cargoValue();
	}

	public boolean isPassenger(int cargo, int passenger){
		return rest.isPassenger();
	}
	public String toString(){
		return name + ": "+ rest;
	}
}

//----------------------------Passenger Class-----------------------------------

// middle of the train
public class Passenger implements Train{
	private Train rest;

	public Passenger(Train rest){
		this.rest = rest;
	}
	public int length(){
		return 1+rest.length();
	}
	public double cargoValue(){
		return rest.cargoValue;
	}
	public boolean isPassenger(int cargo, int passenger){
		return rest.isPassenger(cargo,passenger +1)
	}
	public String toString(){
		return "Passenger" + rest;
	}
}

//---------------------------------Cargo Class----------------------------------------

public class Cargo implements Train{

	public String toString(){
		return"Cargo(" + value + "), "+ rest;
	}
}
//---------------------------------Caboose Class----------------------------------

public class Caboose implements Train{
	public int length(){

	}
	public double cargovalue(){

	}
	public boolean isPassenger(int cargo, int passenger){
		return passenger > cargo;
	}
	public String toString(){
		return "Caboose"
	}
}

//----------------Comparator class to sort Trains in descending order-----------------

public class TrainValueComparator implements Comparator<Train>{
	public int compare(Train a, Train b){
		int va = a.cargoValue();
		int vb = b.cargoValue();

		if(va<vb) return 1;
		if(vb<va) return -1;
		return 0;
	}
}

//-------------- A comparator to put trains of length 9 first, then cargo trains, then doesnt matter
public class TrainAlexComparator implements Comparator<Train>{
	public int compare(Train a, Train b){
		if(a.length() == 9 && b.length() != 9) return -1;
		if(a.length() != 9 && b.length() == 9) return 1;
		if(!a.isPassenger() &&  b.isPassenger()) return -1;
		if(a.isPassenger() && !b.isPassenger()) return 1;
		return 0;
	}
}