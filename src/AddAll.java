import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class AddAll {
    public static void main(String[] args) {

        String[] crap = {"apples", "lamon", "geese", "bacon", "youtube","geese"};
        List<String> l1 = Arrays.asList(crap);

        ArrayList<String> list = new ArrayList<String>();
        list.add("Youtube");
        list.add("facebook");
        list.add("twitter");

        for (String x : list)
            System.out.printf("%s ", x);

        Collections.addAll(list,crap);
        System.out.println();

        for (String x : list)
            System.out.printf("%s ", x);

        System.out.println();
        // frequency
        System.out.println(Collections.frequency(l1,"geese"));
        // disjoint
        boolean tof = Collections.disjoint(l1, list);
        System.out.println(tof);
        if (tof)
            System.out.println("these list don't have anything in common");
        else
            System.out.println("these lsit must something have in common");

    }
}
