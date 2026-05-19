import java.util.*;
public class Max {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i=0; i<n; i++) arr[i] = sc.nextInt();
        int target = sc.nextInt();
        int maxLen = 0, sum = 0;
        int l = 0;

        for(int i=0; i<n; i++){
            sum+=arr[i];
            while(sum>target){
                sum-=arr[l];
                l++;
            }
            maxLen = Math.max(maxLen, i-l+1);
        }
        System.out.println(maxLen);
    } 

}
