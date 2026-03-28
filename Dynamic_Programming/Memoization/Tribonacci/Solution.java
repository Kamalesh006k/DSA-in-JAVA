import java.util.Scanner;
import java.util.*;
class Solution {
    public static int calc(int n, int[] dp){
        if(dp[n] != -1) return dp[n];
        if(n == 0) return dp[n] = 0;
        if(n == 1) return dp[n] = 1;
        if(n == 2) return dp[n] = 1;
        return dp[n] = calc(n-1,dp)+calc(n-2,dp)+calc(n-3,dp);
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        System.out.print(calc(n,dp));
    }
}