import java.util.*;
public class Fact {

    static int fact(int n, int[] dp){
        if (dp[n] != -1) return dp[n];
        if(n == 0 || n==1) return dp[n] = 1;
        return dp[n]=n*fact(n-1,dp);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        System.out.println(fact(n, dp));
    }
}
