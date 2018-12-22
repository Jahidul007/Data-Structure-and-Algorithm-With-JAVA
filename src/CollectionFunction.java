import java.util.ArrayList;
import java.util.*;

public class CollectionFunction {
    public static void main(String[] args) {

        String[] things = {"eggs", "pie", "lasers", "hats"};
        List<String> list = new ArrayList<String>();

        for (String x : things) {
            list.add(x);
        }
        String[] moreThings = {"eggs", "pie","lasers"};
        List<String> list1 = new ArrayList<String>();
        for (String y : moreThings) {
            list1.add(y);
        }

        for (int i = 0; i < list.size(); i++) {
            System.out.printf("%s ", list.get(i));
        }

        editlist(list, list1);
        System.out.println();

        for (int i = 0; i < list.size(); i++) {
            System.out.printf("%s ", list.get(i));
        }


    }

    private static void editlist(Collection<String> l1, Collection<String> l2) {
        Iterator<String> it = l1.iterator();
        while (it.hasNext()){
            if (l2.contains(it.next())){
                it.remove();
            }
        }
    }
}
