import java.util.*;

public class BasicLinkedList<E> extends java.lang.Object implements BasicList<E>{
	
	//----------------------------------------------------------------------
	//----------------private class for Node------------------------------
	//----------------------------------------------------------
	private class Node{

		//private variables for Nodes
		Node next;
		Node previous;
		E data;

		// constructor
		public Node(E dataValue){
			next = null;
			data = dataValue;
			previous = null;
		}
	//------------------------------------------------------------------
		//Constructor 2
		public Node(E dataValue, Node nextValue){
			next = nextValue;
			data = dataValue;
		}
	//------------------------------------------------------------------
		//Helper Functions
		public E getData(){
			return data;
		}

		public void setData(E dataValue){
			data = dataValue;
		}

		public void setNext(Node nextValue){
			next = nextValue;
		}
	}

	////------------------------------------------------------------------
	//---------Basic Linked List Class
	//------------------------------------------------------------------

	//Private variables for start Node and Length
	private Node head;
	private Node tail;
	private int size;


	//Constructor
	public BasicLinkedList(){}
	//------------------------------------------------------------------

	//add method
	public void add(E element){
		Node newNode = new Node(element);

		if(size ==0){
			head = newNode;
			tail = newNode;
		}
		else{
			tail.next = new Node(element);
			tail.next.previous = tail;
			tail = tail.next;
		}
		size++;
	}
	//------------------------------------------------------------------
	private Node getNode(int index){
		Node curr = head;
		if (index< 0 || index >= size) throw new IndexOutOfBoundsException();
		for(int i = 0; i<index;i++){
			curr = curr.next;
		}
		return curr;
	}
	//------------------------------------------------------------------
	// add method with index

	public void add(int index, E element){
		Node newNode = new Node(element);
		Node curr = head;
		if(index<0 || index>size) throw new IndexOutOfBoundsException();
		if(index == 0 && size == 0){
			newNode.next = head;
			head = newNode;
			tail = newNode;
		}
		else if(index == 0){
			newNode.next = head;
			head = newNode;
		}
		else if(index == size){
			newNode.next = head;
			tail.next = newNode;
			tail = newNode;
		}
		else{
			Node preNode = getNode(index -1);
			newNode.next = preNode.next;
			preNode.next = newNode;
			newNode.previous = preNode;
			newNode.next.previous = newNode;
		}
		size ++;
	}

	//------------------------------------------------------------------
	public BasicListIterator<E> basicListIterator(){
		return new Iteratorclass();
	}
	//------------------------------------------------------------------
	// method to clear the list 
	public void clear(){
		size = 0; 
		head = null;
		tail = null;
		
	}
	//------------------------------------------------------------------ 
	// method to see if the linked list contains an element
	public boolean contains(E element){
		Node curr = head;
		boolean finalboo = false;
		for (int i =0; i<size;i++){
			if(get(i) == null && element == null) finalboo = true;
			else if(get(i).equals(element)){
			finalboo = true;
			}
		}
		return finalboo;
	}
	//------------------------------------------------------------------
	// get method that returns the object E at the index and returns
	// null if there is not one.
	public E get(int index){
		if(index< 0 || index >= size || head == null) throw new IndexOutOfBoundsException();
		else{return getNode(index).getData();
		}
	}

	//------------------------------------------------------------------

	public int indexOf(E element){
		Node curr = head;

		for (int i = 0;i<size;i++){
			if(element == null && curr.data == null) return i;
			else if(curr.data.equals(element) && element != null && curr.data != null){
				return i;
			}
			curr = curr.next;
		}
		throw new NoSuchElementException();
	}
	public java.util.Iterator<E> iterator(){
		return new Iteratorclass();

	}
	//------------------------------------------------------------------
	//method to remove an object at an index and return that object
	public E remove(int index){
		if (head == null || index >= size || index <0 ) throw new IndexOutOfBoundsException();
		Node indexNode = getNode(index);
		if (size ==1){
			head = null;
			tail = null;
		}
		else if(index == size -1){
			tail = tail.previous;
			if(tail != null){
				tail.next = null;
			}
		}
		else if (index == 0){
			head = head.next;
			if (head != null){
				head.previous = null;
			}
		}
		else{
			indexNode.previous.next = indexNode.next;
			indexNode.next.previous = indexNode.previous;
		}
		size--;
		return indexNode.getData();
	}
	//------------------------------------------------------------------

	public E set(int index,E element){
		if(index >= size || index < 0) throw new IndexOutOfBoundsException();
		Node curr = head;
		for(int i =0; i <index; i++){
			curr = curr.next;
		}
		E temp = curr.data;
		curr.setData(element);
		return temp;

	}
	//------------------------------------------------------------------
	public int size(){
		return size;

	}
	//------------------------------------------------------------------
	//------------------------------------------------------------------
	// Private class for Iterator
	//------------------------------------------------------------------
	private class Iteratorclass implements BasicListIterator<E>{

		private int index = 0;
		private Node curr = head;
		private Node last = null; 

		public Iteratorclass(){};

		public boolean hasNext(){
			return curr != null;
		}
		public boolean hasPrevious(){
			return last != null;
		}
		public E next(){
			if(hasNext() == false)throw new NoSuchElementException();	
			else{
			E data = curr.data;
			last = curr;
			curr = curr.next;
			return data;
			}
		}
		public E previous(){
			if(hasPrevious() == false) throw new NoSuchElementException();
			else{
				E data = last.data;
				curr = last;
				last = last.previous;
				return data;
			}
			
		}
		public void remove(){throw new UnsupportedOperationException();
		}
	}
}