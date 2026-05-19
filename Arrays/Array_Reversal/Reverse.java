import java.util.*;
public class Reverse {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Before Reversing....");
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        int k=0, j=n-1;
        while (k<j) {
            int temp = arr[k];
            arr[k] = arr[j];
            arr[j] = temp;

            k++;
            j--;
        }
        System.out.println("After Reversing....");
        for(int i=0; i<n; i++){
            System.out.print(arr[i]+" ");
        }
    }
}
