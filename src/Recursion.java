public class Recursion {
    public static void main(String[] args) {

        System.out.println(calculateFactorial(5));
    }

 /*   // factorial
    public static long fact (long n){
        if (n <= 1)
            return 1;
        else
            return n*fact(n-1);
    }*/

    public static int fact(int accumulator, int n){

        if(n == 1) return accumulator;
        return fact(accumulator*n, n-1);
    }
    public static int calculateFactorial(int n){
        return fact(1,n);
    }
}
