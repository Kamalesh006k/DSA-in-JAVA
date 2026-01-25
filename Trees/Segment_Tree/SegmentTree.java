import java.util.*;

public class SegmentTree {
    static void findMin(int[] arr, int[] seg, int i, int left, int right){
        if(left == right){
            seg[i] = arr[left];
            return;
        }
        int mid = left + (right-left)/2;
        findMin(arr,seg,2*i+1,left,mid);
        findMin(arr,seg,2*i+2,mid+1,right);
        seg[i] = Math.min(seg[2*i+1],seg[2*i+2]);
        return;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of elements to insert:");
        int n=sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        int[] seg = new int[n*2-1];
        findMin(arr,seg,0,0,n-1);
        for(int s: seg){
            System.out.print(s+" ");
        }
        System.out.println();
        System.out.println("The minimum element in the array: "+seg[0]);
    }
}
