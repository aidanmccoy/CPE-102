//Array Notes
public class MyArrayList<E>{
	private Object[] data;
	private int size;

	public MyArrayList(int initSize){
		size = 0;
		data = new Object[initSize];
	}

	//Default Constructor
	public MyArrayList(){
		this(10);
	}
	public void add(E e){
		makeRoom();
		data[size]=e;
		size++;		
	}
	public E get(int index){
		return (E)data[index];
	}
	public int indexOF(E e){
		for int i = 0; i<size;++i){
			if(data[i].equals(e)){
				index = i;
				break;
			}
		}
	}
	public void remove(int index){
		for(int i = index;i<size){
			data[i]= data[i+1];
		}
		--size;
	}
	private void makeRoom(){
		if(size == data.length){
			Object[]newData = new Object[2*size];
			for(int i = 0; i<size; i++){
				newData[i]= data[i];
			}
			data = newData;
		}
	}
	public MyArrayList<E> veryShallowCopy(){
		MyArrayList<E> copy = new MyArrayList<E>(data.length);
		copy.size = size;
		cope.data = data;
		return copy;
	}
	public MyArrayList<E> shallowCopy(){
		MyArrayList<E> copy = new MyArrayList<E>(data.length);
		for(int i= 0; i<size; i ++){
			copy.date[i]= data[i];
		}
		copy.size = size;
		return copy;
	}
	public MyArrayList<E> deepCopy(){
		MyArrayList<E> copy = new MyArrayList<E>(data.length);
		for(int i =0;i<size;++i){
			copy.data[i]=data[i].copy();  // we are assuming that the copy function is done in the data type and recreates a copy of itself
		}
		copy.size = size;
		return copy;
	}

}
//New List
MyArrayList<Student> list = new MyArrayList<>(5);
// now it is all filled with null
list.add(new Student("Foo"));
//size is now 1
list.add(new Student("Adam"));
int i = list.indexOf(new Student("Adam"));