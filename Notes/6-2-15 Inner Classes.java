public class MyLinkedList<E> implements List<E>{
	private class Iterator<E> implements Iterator<E>{
		public E next();
		public boolean hasNext();
	}
	public Iterator<E> iterator(){
		return new IteratorImply();
	}
}

//--------------------------------------------------------------
//----------Singleton: Loosely Coupled System design

public class Foo{
	private static instance = null;
	private Foo(){}
	public static Foo getInstance(){
		if(instance == null){
			instance = new Foo();
		}
		return instance;
	}
}

//all new refernces point to the same object

//------------------------------------------------------------
//----------Chain of Responsibility design pattern
// gives more than 1 object an opportunity to handle a request by linking recieving 
// objects together

//comparators: if you want the first one to come first then return -1