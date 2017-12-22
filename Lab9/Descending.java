import java.util.*;

public class Descending implements Comparator<Integer>{
	public int compare(Integer a, Integer b){
		if (b == a) return 0;
		else if(b>a) return 1;
		else return -1;
	}
}