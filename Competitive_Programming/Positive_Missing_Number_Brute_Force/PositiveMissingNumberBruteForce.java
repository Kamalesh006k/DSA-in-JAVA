import java.util.*;

public class PositiveMissingNumberBruteForce{

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }

        for(int i=1; i<n; i++){
            boolean flag = false;
            for(int j=0; j<n; j++){
                if(arr[j] == i){
                    flag = true;
                }
            }
            if(!flag){
                System.out.println(i);
                return;
            }
        }
        System.out.println("No missing elements");
    }
}