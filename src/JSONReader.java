//-----------------------------------------
//
//-----------------------------------------
//.................................................................................A3Part1
public class JSONReader {
  static String json0 = 
    "{ \"name\" : \"Mike\" , \"movies allowed\" : 3 , \"loaned\" : [ { \"title\" : \"Fences\" , \"star\" : \"Denzel Washington\" } , { \"title\" : \"La La Land\" , \"star\" : \"Emma Stone\" } ] }";
  static String json1 = "{ \"days\" : [ \"Mon\" , \"Tue\" , \"Wed\" , \"Thu\" , \"Fri\" ] }";
  
  public static void main(String [] args){
    JSONParser parser = new JSONParser();
    JSONObject myObj = parser.read(json0);
    System.out.println(myObj);
    JSONIter iter = myObj.iterator();
    while(iter.hasNext())
      System.out.println(iter.getNext());
    System.out.println();


    myObj = parser.read(json1);
    System.out.println(myObj);
    JSONArray myAry = (JSONArray)myObj.getValue(new StringItem("\"days\""));
    System.out.println(myAry);
    iter = myAry.iterator();
    while(iter.hasNext())
      System.out.println(iter.getNext());
    System.out.println("\nEnd of processing.");
  }// main
}// class JSONReader

//...................................................................................Value
interface Value {
  String toString();
}// interface Value

//..............................................................................JSONObject
interface JSONObject extends Value {
  void addKeyValue( Value key, Value v);
  Value getValue (Value key);
  JSONIter iterator();
}// interface JSONObject

//...............................................................................JSONArray
interface JSONArray extends Value {
  void addValue(Value v);
  Value getValue(int index);
  JSONIter iterator ();
}// interface JSONArray

//................................................................................JSONIter
interface JSONIter {
  boolean hasNext();
  Value getNext();
}// interface JSONIter


//.............................................................................JSONFactory
class JSONFactory{
  public static JSONObject getJSONObject() {
	  JSONObjectClass object = new JSONObjectClass();
	  return object; 
  }
  public static JSONArray getJSONArray() {
	  JSONArrayClass array = new JSONArrayClass();
	  return array; 
  }
}// class JSONFactory

