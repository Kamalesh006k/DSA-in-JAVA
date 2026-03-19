import java.util.*;

class Pair {
    int val, idx;

    Pair(int val, int idx) {
        this.val = val;
        this.idx = idx;
    }
}
public class FourSum {

    static int[] fourSum(int[] arr, int target){
        Pair[] p = new Pair[arr.length];
        for(int i=0; i<arr.length; i++){
            p[i] = new Pair(arr[i],i);
        }
        Arrays.sort(p,(a,b) -> a.val - b.val);
        for(int i=0; i<arr.length-3; i++){
            if(i>0 && p[i].val == p[i-1].val) continue;
            for(int j=i+1; j<arr.length-2; j++){
                if(j>i+1 && p[j].val == p[j-1].val) continue;
                int left = j+1; 
                int right = arr.length-1;
    
                while (left < right) {
                    int sum = p[i].val+p[j].val+p[left].val+p[right].val;
                    if(sum == target){
                        return new int[]{p[i].idx,p[j].idx,p[left].idx,p[right].idx};
                        // left++;
                        // right--;
        
                        // while (arr[left] == arr[left-1]) {
                        //     left++;
                        // }
                        // while (arr[right] == arr[right+1]) {
                        //     right--;
                        // }
                    }else if(sum < target){
                        left++;
                    }else{
                        right --;
                    }
    
                }
            }
        }
        return new int[]{};
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int target = sc.nextInt();
        int[] arr = new int[n];

        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }

        int[] result = fourSum(arr, target);

        for(int s: result){
            System.out.print(s+" ");
        }
    }
}
