import java.util.*;
public class Max {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) arr[i] = sc.nextInt();
        int k = sc.nextInt();
        int sum = 0;
        double MaxAvg = 0;
        for(int i=0; i<k; i++) sum+=arr[i];
        for(int i=k; i<n; i++){
            sum += arr[i]-arr[i-k];
            int avg = sum/k;
            MaxAvg = Math.max(MaxAvg, avg);
        }
        System.out.println(MaxAvg);
    }
}
