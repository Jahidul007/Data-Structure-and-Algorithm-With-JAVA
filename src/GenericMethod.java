public class GenericMethod {
    public static void main(String[] args) {

        Integer[] iray = {1,2,3,4};
        Character[] cray = {'a','b','c','d'};

        printMe(iray);
        printMe(cray);
    }

    // generic method
    private static <T> void printMe(T[] x){

        for (T b : x)
            System.out.printf("%s ", b);
        System.out.println();

    }
}
