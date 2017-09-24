import java.util.*;

/**
 * JSONParser.java
 * A Parser for JSON data
 */
public class JSONParser {

  public JSONObject read (String x) { 
    Scanner s = new Scanner (x);
    return readObject(s);
  }

  private Value readValue (Scanner in) {

    Value li = null;
    if ( in.hasNext("\\{")) {
      li = readObject(in);
    } else if ( in.hasNext("\\[")) { 
      li = readArray(in);
    } else { 
      li = createValue(in);
    }
    return li;

  }

  private Value readArray (Scanner in) { 

    String token = in.next().trim();
    JSONArray retVal = JSONFactory.getJSONArray();
    if ( token.equals("[")) {

      while (! in.hasNext("]")) {

        Value li = readValue(in);
        retVal.addValue(li);
        if (in.hasNext(",")) {
          in.next(",");
          // discard comma
        }
      }
      in.next ("]"); // discard ]
    }
    return retVal;
  }

  private JSONObject readObject (Scanner in) {

    JSONObject retVal = JSONFactory.getJSONObject();
    String token = in.next().trim();

    if ( token.equals("{")) {

      while (! in.hasNext("}")) {
        Value key = createValue(in);
        
        if (! in.hasNext(":")) {
          System.out.println("error! expected colon, found: " + token);
        } else {
          in.next(":");
          // discard :
        }


        Value li = readValue(in);
        retVal.addKeyValue(key,li);
        if (in.hasNext(",")) {
          in.next(",");
          // discard comma
        }
      } 

      in.next ("}"); // discard }
    } else {
      System.out.println("error: expected {, found: " + token);
    }
    return retVal;
  }
  
  private String readString(Scanner in) { 
    String token, out = "";
    token = in.next();
    out = token;
    while (!token.endsWith("\"")) {
      token = in.next();
      out+= " " + token;
    }
    return out;
  }

  public Value createValue(Scanner in) {

    Value li = null;
    String token;
    if (in.hasNext("\\d*(\\.\\d*)?")) {
      // integer
      token = in.next("\\d*(\\.\\d*)?");
      if ( token.contains(".")) {
        li = new DoubleItem ( Double.parseDouble(token));

      } else { 
        li = new IntItem( Integer.parseInt(token));

      }
    } else if (in.hasNext("\\\"[^\\\"]*\\\"")) { 
      // value
      token = in.next("\\\"[^\\\"]*\\\"");
      li = new StringItem(token);


    } else if (in.hasNext("\\\".*")) {
      String out = readString(in);
      li = new StringItem(out);

    } else if (in.hasNext("true|false")) {
      token = in.next("true|false");
      li = new BooleanItem((token.equalsIgnoreCase("true")));

    } else { 
      System.out.println("error: expected value, found: " + in.next());
    }

    return li;
  }

}

