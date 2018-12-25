import java.util.Arrays;
import java.util.Collections;

public class BinarySearch {
    public static void main(String[] args) {

        int[] array = {1,5,3,8,9, 10,-3};
        Algorithm algorithm = new Algorithm(array);

        System.out.println(algorithm.linearSearch(9));
        Arrays.sort(array);
        for (int i : array)
            System.out.printf("%d ",i);
        System.out.println();
        System.out.println(algorithm.binarySearch(10));
    }
}
