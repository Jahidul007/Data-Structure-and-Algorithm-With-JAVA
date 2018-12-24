import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CollectionsSort {
    public static void main(String[] args) {

        String[] crap = {"apples", "lamon", "gese", "bacon", "youtube"};

        List<String> l1 = Arrays.asList(crap);

        //ascending
        Collections.sort(l1);
        System.out.println(l1);

        //reverse sorting
        Collections.sort(l1,Collections.reverseOrder());
        System.out.println(l1);
    }
}
