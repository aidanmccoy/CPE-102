import java.util.*;

public class  OddEvenAscending implements Comparator<Integer>{
	public int compare(Integer a, Integer b){
		if(a%2 == 1 && b%2 ==0) return -1;
		if(a%2 == 0 && b%2 ==1) return 1;
		if(a>b) return 1;
		else if (a<b) return -1;
		else return 0;
	}
}