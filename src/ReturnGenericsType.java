public class ReturnGenericsType {
    public static void main(String[] args) {

        System.out.println(max(12,-12,1));
        System.out.println(max("appl","tots","totto"));
    }
    public static <T extends Comparable<T>> T max(T a, T b, T c){

        T m = a;

        if (b.compareTo(a)>0)
            m = b;
        if (c.compareTo(m)>0)
            m = c;

        return m;

    }
}
