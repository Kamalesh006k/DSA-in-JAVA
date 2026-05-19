import java.util.*;
public class Change {
    public static boolean change(int[] arr){
        Map<Integer,Integer> map = new HashMap<>();

        for(int i=0; i<arr.length; i++){
            int k = arr[i];
            map.put(k, map.getOrDefault(k,0)+1);
            if(k == 10){
                if(map.getOrDefault(5,0)>=1){
                    map.put(5, map.get(5)-1);
                }else{
                    return false;
                }
            } else if (k == 20) {
                if (map.getOrDefault(10, 0) >= 1 && map.getOrDefault(5, 0) >= 1) {
                    map.put(10, map.get(10) - 1);
                    map.put(5, map.get(5) - 1);
                } else if (map.getOrDefault(5, 0) >= 3) {
                    map.put(5, map.get(5) - 3);
                } else {
                    return false;
                }
            }
            
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        if(change(arr)){
            System.out.println("True");
        }else{
            System.out.println("False");
        }
        
    }
}
