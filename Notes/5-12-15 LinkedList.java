public class MyLinkedList<E>{

	private class Node{
		private E data;
		private Node next;
	}
	private Node head;
	private int size;

	public MyLinkedList(){
		head = null;
		size = 0;
	}
	public void addFirst(E e){
		Node node = new Node();
		node.data = e;
		nade.next = head;
		head = node;
		size++
	}
	public void add (E e){
		Node node = new Node();
		node.data = e;
		node.next = null;
		if (size == 0){
			head = node;
		}
		else{
			Node tail = getNode(size-1);
			tail.next = node;
		}
		size++;
	}
	private Node getNode(int index){
		Node curr = head;
		for (int i = 0; i<index,i++){
			curr = curr.next;
		}
		return curr;
	}

	public E get(int index){
		return getNode(index.data);
	} 
}

MyLinkedList<Student> list = new MyLinkedList<>();

list.addFirst(new Student("A"));
list.addFirst(new Student("B"));
list.addFirst(new Student("C"));
//the list made is in reverse order i.e. [C,B,A]