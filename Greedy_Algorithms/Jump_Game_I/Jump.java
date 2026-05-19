import java.util.*;
public class Jump {

    public static boolean jump(int[] arr){
    int max = 0;

    for(int i = 0; i < arr.length; i++){
        if(i > max) return false; 

        max = Math.max(max, i + arr[i]);

        if(max >= arr.length - 1) return true;
    }
    return true;
}
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }

        if(jump(arr)){
            System.out.println("True");
        }else{
            System.out.println("False");
        }
    }
}
