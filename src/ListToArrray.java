import java.util.Arrays;
import java.util.LinkedList;

public class ListToArrray {
    public static void main(String[] args) {

        String[] stuff = {"babbies", "watermelons", "fudge", "melons"};

        LinkedList<String> theList = new LinkedList<String>(Arrays.asList(stuff));

        theList.add("pumpikinf");
        theList.addFirst("firstThing");

        // convert back to an array
        stuff = theList.toArray(new String[theList.size()]);

        for (String x : stuff)
            System.out.println(x);



        
    }
}
