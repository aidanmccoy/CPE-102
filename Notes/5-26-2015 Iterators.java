//-------------------------Iterators Notes---------------------
//sequential access to elemsnts in a list
List<Integer>aList = new ArrayList<>();
List<Integer>lList = new LinkedList<>();
//code to populate lists...
//...
//...
//------------------aList Sum-------------------
//much faster than linked list for get();
int sum = 0;
for(int i=0;i<aList.size();i_++){
	sum = aList.get(i);
}

//----------------------linkedList sum--------------
int sum = 0;
for(int i =0;i<lList.size()){
	sum = lList.get(i);
}
//-----------------------Iterator interface--------------
public interface Iterator<E>{
	public boolean hasNext();
	public E next();
	public void remove(); //optional
}
// --------------------how to use iterators--------------------
sum=0;
Iterator<Integer> it alist.iterator();
while(it.hasNext()){
	sum += it.next();
}
//-----------------Iterable Interface----------------------
public interface Iterable<E>{
	public Iterator<E> iterator();
}
//-----------------how to use iterable------------------
public class ArrayList<E> implements Iterable<E>;
public class LinkedList<E> implements Iterable<E>;