// CLASS: JSONObjectClass
//
// REMARKS: A JSON Object class that uses a LinkedList to store keys pointing to data types.
//
//-----------------------------------------
public class JSONObjectClass implements JSONObject {
	
	private LinkedList list;
	
	public JSONObjectClass() {
		list = new LinkedList();
	}

	/**
	* Insert a value into the Object
	* @param toInsert The value to insert into the Object
	*/
	@Override
	public void addKeyValue(Value key, Value v) {
		if(list != null) {
			Node n = new Node(v, key, null);
			list.insert(n);
		}
	}

	/**
	* Get a value at a specific index in the Object
	* @param index The value to insert into the Object
	*/
	@Override
	public Value getValue(Value key) {
		Value toReturn = null;
		if(list != null) {
			toReturn = list.get(key);
		}
		return toReturn;
	}

	/**
	* Creates an iterator to iterate over the current instance of the Object
	* @return iter The iterator created
	*/
	@Override
	public JSONIter iterator() {
		JSONObjectIteratorClass iter = new JSONObjectIteratorClass(this.list);
		return iter;
	}

	/**
	* Display the data in the Object in string format
	* @return String The data in displayable format
	*/
	@Override
	public String toString() {
		String toReturn = "{ ";
		Node curr = list.getFront();
		while(curr != null) {
			toReturn += curr.getKey().toString();
			toReturn += " : ";
			toReturn += curr.getValue().toString();
			if(curr.hasNext())
				 toReturn += " , ";
			curr = curr.getNext();
		}
		toReturn += " }";
		return toReturn;
	}

}

class JSONObjectIteratorClass implements JSONIter {
	private LinkedList list;
	private Node current;
	
	public JSONObjectIteratorClass() {
		list = new LinkedList();
		current = this.list.getFront();
	}
	
	public JSONObjectIteratorClass(LinkedList list) {
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
	* Returns the current key member and moves to the next one
	* @return Value The current key member in the list
	*/
	@Override
	public Value getNext() {
		Value nextKey = null;
		if(current != null) {
			nextKey = current.getKey();
			current = current.getNext();
		}
		return nextKey;
	}

}
