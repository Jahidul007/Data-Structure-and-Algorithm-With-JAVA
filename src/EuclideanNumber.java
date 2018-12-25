public class EuclideanNumber {
    public static void main(String[] args) {

        System.out.println(gcdIterative(3,0));
    }
    public static int gcdIterative(int num1, int num2){

        while (num2 != 0){
            int temp = num2;
            num2 = num1%num2;
            num1 = temp;
        }
        return num1;
    }
    public static int gcdRecursive(int num1, int num2){

        if (num2 == 0) return num1;
        return gcdRecursive(num1, num1%num2);
    }

}
