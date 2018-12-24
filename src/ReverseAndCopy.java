import java.util.*;
public class ReverseAndCopy {
    public static void main(String[] args) {

        //create an array and convert to list
        Character[] ray = {'p','w','n'};
        List<Character> l1 = Arrays.asList(ray);
        System.out.println("List is: ");
        output(l1);

        //reverse and print out the list
        Collections.reverse(l1);
        System.out.println("After the reverse: ");
        output(l1);

        //create new array and new list
        Character[] newRay = new Character[3];
        List<Character> newList = Arrays.asList(newRay);

        //copy contents of list to newList
        Collections.copy(newList, l1);
        System.out.println("Copy of the list: ");
        output(newList);

        // fill collection with crap
        Collections.fill(l1,'X');
        System.out.println("After filling the list: ");
        output(l1);

    }

    private static void output(List<Character> l1) {

        for (Character thing : l1)
            System.out.printf("%s ",thing);
        System.out.println();
    }
}
