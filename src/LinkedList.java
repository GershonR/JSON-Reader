// CLASS: LinkedList
//
// REMARKS: A linked list to hold data of type Node, Nodes are inserted at the end
//
//-----------------------------------------

public class LinkedList {
	private Node front;
	private Node back;
	private int size;
	
	public LinkedList() {
		front = null;
		back = null;
		size = 0;
	}
	
	public Node getFront() {
		return this.front;
	}
	
	public Node getBack() {
		return this.back;
	}
	
	public boolean isEmpty() {
		return front == null;
	}
	
	public int getSize() {
		return this.size;
	}
	
	 /**
	 * Insert a node to the end of the list 
	 * @param newNode The node to insert
	 */
	public void insert(Node newNode) {
         if (newNode == null)
               return;
         else {
               newNode.setNext(null);;
               if (getFront() == null) {
                     front = newNode;
                     back = newNode;
               } else {
                     getBack().setNext(newNode);
                     back = newNode;
               }
         }
   }
	 
	/**
	* Return a Value type at a givem index
    * @param index The index of the item
 	* @return The value at spot index
 	*/
    public Value get(int index) {
	   Value toReturn = null;
	   Node curr = getFront();
	   int currSpot = 0;
	   while(curr != null && currSpot <= index) {
		   if(currSpot == index)
			   toReturn = curr.getValue();
		   currSpot++;
		   curr = curr.getNext();
	   }
	   return toReturn;
   }

   /**
   * Given a key return the data associated to it
   * @param key The key to the data item
   * @return The data associated with the key
   */
   public Value get(Value key) {
	   Value toReturn = null;
	   Node curr = getFront();
	   Value currKey;
	   while(curr != null && key != null) {
		   currKey = curr.getKey();
		   if(currKey.toString().equals(key.toString())) {
			   toReturn = curr.getValue();
		   }
		   curr = curr.getNext();
	   }
	   return toReturn;
   }
	 
	 
}
