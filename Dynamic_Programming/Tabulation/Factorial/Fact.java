import java.util.*;
public class Fact {

    static void fact(int n, int[] dp){
        dp[0] = 1;
        if(n>1) dp[1] = 1;
        for(int i=2; i<=n; i++){
            dp[i] = i*dp[i-1];
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dp = new int[n+1];
        fact(n, dp);
        System.out.println(dp[n]);
    }
}
