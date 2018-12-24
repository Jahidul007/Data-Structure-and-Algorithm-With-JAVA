import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Hashset {
    public static void main(String[] args) {

        String[] crap = {"apples", "lamon", "geese", "bacon", "youtube","geese"};
        List<String> l1 = Arrays.asList(crap);

        System.out.printf("%s ", l1);
        System.out.println();

        Set<String> set = new HashSet<String>(l1);
        System.out.printf("%s ", set);
    }
}
