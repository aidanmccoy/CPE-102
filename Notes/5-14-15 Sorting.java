public class Student{
	private String name;
	private double gpa;
	private int age;

	ArrayList<Student>list = new ArrayList<>();
	list.add(new Student("Foo",3.0,18));
	list.add(new Student("Bar",3.4,20));
	list.add(new Student("Tom",3.6,19));

	Collections.sort(list);
}

//---------------------interface : Comparable--------------------------------------------
public class Student implements Comparable<Student>{
	public int compareTo(Student s){
		if (age < s.age) return -1;
		if (age > s.age) return 1;
		return 0;
	}
}
//---------------------interface: Compareator-------------------------------------------
public class StudentNameComparator implements Comparator<Student>{
	public int compare(Student s1, Student s2){
		return s1.getName().compareTo(s2.getName());
	}
}

Collections.sort(list,new StudentNameComparator());

//-----------------------Selection Sorting----------------------------------------------
//take the smallest compare to rest of list, if smaller is found, use it. Take 
//it and move to left of list and repeat with rest of list
public class SelectionSort{

	private static void swap(ArrayList<Students> list, int i, int j){
		Student tmp = list.get(i);
		list.set(i,list.get(j));
		list.set(j,tmp);
	}
	public static void sort(ArrayList<Student> list){
		for(int i=0; i<list.size()-1;i++){
			int imin = i;
			for(int j = i + 1; j< list.size(); ++j){
				if list.get(j)<list.get(imin){
					imin =j;
				}
			}
			swap(list,i,imin);
		}
	}
}
//----------------------Insertion Sorting------------------------------------------
//take the next item in the list and swap it with the previous until it is in the
// correct order then repeat with the next element
for(int i=1;i<list.size();++i){
	int j =i;
	while(j> 0 && list.get(j-1)>(list.get(j)){
		swap(j,j-1);
		--j;

	}
}