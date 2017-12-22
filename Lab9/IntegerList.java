import java.util.*;
public class IntegerList{

	ArrayList<Integer> intList = new ArrayList<Integer>();
	private int size;
	//private Random rand = new Random();


	public IntegerList(int initSize,int randMax){
			for(int i=0;i<initSize;i++){
			Random rand = new Random();
			int randVal = rand.nextInt(randMax);
			intList.add(randVal);
		}
	}
	public void sort(){
		Collections.sort(intList);
	}
	public void sort(Comparator<Integer> compInt){
		Collections.sort(intList,compInt);
	}
	public boolean isSorted(Comparator<Integer> compInt){
		if(compInt == null){
			for(int i=1;i<intList.size();i++){
				if(intList.get(i-1).compareTo(intList.get(i))>0) return false;
			}
			return true;
		}
		for(int i = 0; i<intList.size()-1;i++){
			if(compInt.compare(intList.get(i),intList.get(i+1))>0) return false;
		}
		return true;
	}
	public String toString(){
		String finalstr = "";
		for(Integer i: intList){
			finalstr = finalstr +i+"\n";
		}
		return finalstr;
	}
	public void mySLOsort(){
		int i;
		int j;
		int theNum;
		for (i =1; i<intList.size();i++){
			theNum = intList.get(i);
			j=i;
			while(j>0 && intList.get(j-1)>theNum){
				intList.set(j,intList.get(j-1));
				j--;
			}
			intList.set(j,theNum);
		}
	}
	public void mySLOsort(Comparator<Integer> compInt){
		int i;
		int j;
		int theNum;
		for (i = 1; i<intList.size();i++){
			
			j=i;
			while(j>0&& compInt.compare(intList.get(j-1), intList.get(j))==1){
				theNum = intList.get(i);
				intList.set(i,intList.get(j));
				intList.set(j,theNum);
				j--;

			}
		}
	}
	public int binarySearch(int key){
		int imin = 0;
		int imax = intList.size()-1;
		while(imin<= imax){
			int imid = (imin + imax)/2;
			int xmid = intList.get(imid);
			if(key == xmid){
				return imid;
			} else if(key<xmid){
				imax = imid-1;
			} else{
				imin = imid +1;
			}
			
		}
		return -1;
	}
	public int recBinarySearch(int key){
		return recBinarySearch(key,0,intList.size()-1);
	}
	private int recBinarySearch(int key,int imin,int imax){
		if (imin> imax){
			return -1;
		}
		int imid = (imin + imax)/2;
		int xmid = intList.get(imid);
		if(key == xmid){
			return imid;
		} else if (key<xmid) {
			return recBinarySearch(key,imin,imid-1);
		} else{
			return recBinarySearch(key,imid+1,imax);
		}
	}
}