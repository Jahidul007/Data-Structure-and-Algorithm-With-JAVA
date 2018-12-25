public class AddingNnumber {
    public static void main(String[] args) {

        int a = recursionSum(10);
        System.out.println(a);
    }

    public static int recursionSum(int N){
        if(N == 1 )
            return 1;
        return N+(recursionSum(N-1));
    }

}
