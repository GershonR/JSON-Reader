// CLASS: DataItem
// REMARKS: This class just stores the different data types in 1 file for easier management.
//
//-----------------------------------------


class StringItem implements Value {
	private String data;
	
	public StringItem(String data) {
		this.data = data;
	}
	
	public String getData() {
		return this.data;
	}
	
	public void setData(String data) {
		this.data = data;
	}
	
	public String toString() {
		return data;
	}

}

class BooleanItem implements Value {
	private boolean data;
	
	public BooleanItem(boolean data) {
		this.data = data;
	}
	
	public boolean getData() {
		return this.data;
	}
	
	public void setData(boolean data) {
		this.data = data;
	}
	
	public String toString() {
		return ""+data;
	}
}

class DoubleItem implements Value {
	private double data;
	
	public DoubleItem(double data) {
		this.data = data;
	}
	
	public double getData() {
		return this.data;
	}
	
	public void setData(double data) {
		this.data = data;
	}
	
	public String toString() {
		return ""+data;
	}
}

class IntItem implements Value {
	private int data;
	
	public IntItem(int data) {
		this.data = data;
	}
	
	public int getData() {
		return this.data;
	}
	
	public void setData(int data) {
		this.data = data;
	}
	
	public String toString() {
		return ""+data;
	}
}