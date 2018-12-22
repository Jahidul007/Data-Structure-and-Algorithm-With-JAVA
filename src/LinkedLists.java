import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class LinkedLists {
    public static void main(String[] args) {

        String[] things = {"apples","bacon","pie","eggs","goats"};
        List<String> list1 = new LinkedList<String>();
        for (String x : things){
            list1.add(x);
        }

        String[] things2 = {"Apple","Pipes","eggs","Goats"};
        List<String> list2 = new LinkedList<String>();
        for (String x : things2){
            list2.add(x);
        }

        list1.addAll(list2);
        list2 = null;

        printMe(list1);
        removeStuff(list1,2,5);
        printMe(list1);
        reverseMe(list1);

    }

    private static void reverseMe(List<String> list1) {
        ListIterator<String> boby = list1.listIterator(list1.size());
        while (boby.hasPrevious())
            System.out.printf("%s ",boby.previous());
    }

    private static void removeStuff(List<String> list1, int from, int to) {
        list1.subList(from,to).clear();
    }

    private static void printMe(List<String> list1) {
        for (String b : list1){
            System.out.printf("%s ", b);
        }
        System.out.println();
    }
}
