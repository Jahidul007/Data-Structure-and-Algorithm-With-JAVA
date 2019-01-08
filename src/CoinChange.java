public class CoinChange {

    // recursive coin change exponential running time
    public int naiveCoinChange(int M, int[] v, int index) {

        if (M < 0) return 0;
        if (M == 0) return 1;
        if (v.length == index) return 0;

        return naiveCoinChange(M - v[index], v, index) + naiveCoinChange(M, v, index + 1);
    }

    public void dpCoinChange(int[] v, int M){

        int[][] dpTable = new int[v.length+1][M+1];

        for (int i = 0; i<=v.length; i++){
            dpTable[i][0] = 1;
        }
        for (int i = 1; i<=M; i++){
            dpTable[0][1] = 0;
        }

        // O(V*M)
        for (int i = 1; i<=v.length; i++){
            for (int j = 0; j<=M; j++){

                if (v[i-1] <=j){
                    dpTable[i][j] = dpTable[i-1][j] + dpTable[i][j-v[i-1]];
                } else {
                    dpTable[i][j] = dpTable[i-1][j]  ;
                }
            }
        }
        System.out.println("Solution: " + dpTable[v.length][M]);
    }

    public static void main(String[] args) {

        int m = 1110;
        int[] v = {1,2,3,4,5,6,7,8,9,10};
        int index = 0;

        CoinChange coinChange = new CoinChange();
        coinChange.dpCoinChange(v, m);
        //System.out.println(coinChange.naiveCoinChange(m, v, index));
    }
}
