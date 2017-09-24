// CLASS: Node
//
// REMARKS: A Node object stored by the LinkedList class,
//          it stores Value data and if required Key data.
//
//-----------------------------------------
public class Node {
	private Value value;
	private Value key;
	private Node next;
	
	public Node(Value value, Node link) {
		this.value = value;
		this.next = link;
		this.key = null;
	}
	
	public Node(Value value, Value key, Node link) {
		this.value = value;
		this.key = key;
		this.next = link;
	}
	
	public Node getNext() {
		return this.next;
	}
	
	public Value getValue() {
		return this.value;
	}
	
	public Value getKey() {
		return this.key;
	}
	
	public void setNext(Node link) {
		this.next = link;
	}
	
	public boolean hasNext() {
		return next != null;
	}

}
