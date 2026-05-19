import java.util.*;
import java.util.Scanner;
public class SlidingWindow {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];

        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        int maxSum = 0;
        for(int i=0; i<k; i++){
            maxSum += arr[i];
        }

        for(int i=k; i<n; i++){
            int sum = 0;

            sum += arr[i]-arr[i-k]+maxSum;
            maxSum = Math.max(maxSum, sum);
        }

        System.out.println(maxSum);
    }
}
