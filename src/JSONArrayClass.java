// CLASS: JSONArrayClass
//
// REMARKS: A JSON Array class that uses a LinkedList to implement array-like functionality.
//
//-----------------------------------------


public class JSONArrayClass implements JSONArray {
	
	private LinkedList list;
	
	public JSONArrayClass() {
		this.list = new LinkedList();
	}

	/**
	* Insert a value into the "array"
	* @param toInsert The value to insert into the "array"
	*/
	@Override
	public void addValue(Value toInsert) {
		if(list != null) {
			Node n = new Node(toInsert, null);
			list.insert(n);
		}
		
	}

	/**
	* Get a value at a specific index in the "array"
	* @param index The value to insert into the "array"
	*/
	@Override
	public Value getValue(int index) {
		Value toReturn = null;
		if(list != null)
			toReturn = list.get(index);
		return toReturn;
		
	}

	
	/**
	* Creates an iterator to iterate over the current instance of the "array"
	* @return iter The iterator created
	*/
	@Override
	public JSONIter iterator() {
		JSONArrayIteratorClass iter = null;
		if(list != null) {
			iter = new JSONArrayIteratorClass(this.list);
		}
		return iter;
	}

	/**
	* Display the data in the "array" in string format
	* @return String The data in displayable format
	*/
	@Override
	public String toString() {
		String toReturn = "[ ";
		Node curr = list.getFront();
		while(curr != null) {
			toReturn += curr.getValue().toString();
			if(curr.hasNext())
			 toReturn += " , ";
			curr = curr.getNext();
		}
		toReturn += " ]";
		return toReturn;
	}

}

class JSONArrayIteratorClass implements JSONIter {
	private LinkedList list;
	private Node current;
	
	public JSONArrayIteratorClass() {
		list = new LinkedList();
		current = this.list.getFront();
	}
	
	/**
	* Initialize the iterator
	*/
	public JSONArrayIteratorClass(LinkedList list) {
		this.list = list;
		current = this.list.getFront();
	}

	/**
	* Checks to see if there is some data in the list
	* @return boolean True if there is data
	*/
	@Override
	public boolean hasNext() {
		return current != null;
	}

	/**
	* Returns the current data member and moves to the next one
	* @return Value The current data member in the list
	*/
	@Override
	public Value getNext() {
		Value nextValue = null;
		if(current != null) {
			nextValue = current.getValue();
			current = current.getNext();
		}
		return nextValue;
	}

}
