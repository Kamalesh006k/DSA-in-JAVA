import java.util.*;
public class TwoSum {

    static int[] twoSum(int[] arr, int target){
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0; i<arr.length; i++){
            int temp = target - arr[i];
            if(map.containsKey(temp)){
                return new int[]{map.get(temp),i};
            }else{
                map.put(arr[i], i);
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
        int[] result = twoSum(arr, target);
        for(int s: result){
            System.out.print(s+" ");
        }
    }
}
