import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MergeSort {
    static void merger(int[] arr, int low, int mid,int high, List<Integer> result){
        int left = low;
        int right = mid+1;
        result.clear();
        while(left<=mid && right <= high){
            if(arr[left] <= arr[right]){
                result.add(arr[left]);
                left++;
            }else{
                result.add(arr[right]);
                right++;
            }
        }
        while(left <= mid){
            result.add(arr[left]);
            left++;
        }
        while(right<=high){
            result.add(arr[right]);
            right++;
        }
        for (int i = low; i <= high; i++) {
            arr[i] = result.get(i - low);
        }
    }
    static void mergeSort(int[] arr, int low, int high, List<Integer> result){
        if(low >= high) return;
        int mid = low+(high-low)/2;
        mergeSort(arr,low,mid,result);
        mergeSort(arr,mid+1,high, result);
        merger(arr, low, mid,high, result);
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        List<Integer> result = new ArrayList<>();
        int low = 0, hight = n-1;
        mergeSort(arr,low,hight,result);
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        } 
        
    }
}
