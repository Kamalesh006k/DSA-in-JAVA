import java.util.*;
public class Fib {

    static int fib(int n, int[] dp){
        if(dp[n] != -1) return dp[n];
        if(n == 0) return dp[n] = 0;
        if(n == 1) return dp[n] = 1;
        return dp[n] = fib(n-1,dp)+fib(n-2,dp);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        for(int i=0; i<n; i++){
            System.out.print(fib(i,dp)+" ");
        }
    }
}
