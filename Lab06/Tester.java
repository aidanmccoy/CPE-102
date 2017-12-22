public class Tester{
	public static void main(String[] args){
		Animal aa = new Animal(3);
		Animal ab = new Animal(3);
		Animal ac = new Animal(4);
		System.out.println("Animal aa:" +aa.toString());
		System.out.println("Animal ab:" +ab.toString());
		System.out.println("Animal ac:" +ac.toString());
		if(aa.equals((Animal)ab)) System.out.println("aa is the same as ab");
		if(!aa.equals((Animal)ac)) System.out.println("aa is different than ac");

		Person pa = new Person(2,"tom");
		Person pb = new Person(2,"tom");
		Person pc = new Person(2,"paul");
		System.out.println("Person aa:" +pa.toString());
		System.out.println("Person ab:" +pb.toString());
		System.out.println("Person ac:" +pc.toString());
		if(pa.equals((Person)pb)) System.out.println("pa is the same as pb");
		if(!pa.equals((Person)pc)) System.out.println("pa is different than pc");

		Student sa = new Student(2,"rick",3.2);
		Student sb = new Student(2,"rick",3.2);
		Student sc = new Student(2,"rick",3.1);
		System.out.println("Student sa:" +sa.toString());
		System.out.println("Student sb:" +sb.toString());
		System.out.println("Student sc:" +sc.toString());
		if(sa.equals((Student)sb)) System.out.println("sa is the same as sb");
		if(!sa.equals((Student)sc)) System.out.println("sa is different than sc");
	}
}