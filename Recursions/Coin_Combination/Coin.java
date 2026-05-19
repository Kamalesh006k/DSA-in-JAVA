import java.util.*;
public class Coin{

    public static int Sum(int n, List<Integer> arr, int start){
        if(n==0){
            return 1;
        }

        int count = 0;
        for(int i= start; i<arr.size(); i++){
            if(n-arr.get(i) >= 0){
                count+= Sum(n - arr.get(i),arr, i);
            }
        }

        return count;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int target = sc.nextInt();
        int n = sc.nextInt();
        List<Integer> arr = new ArrayList<>();
        for(int i=0; i<n; i++){
            arr.add(sc.nextInt());
        }
        System.out.println(Sum(target, arr,0));
    }
}