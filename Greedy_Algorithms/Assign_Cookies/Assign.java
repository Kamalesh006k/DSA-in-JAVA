import java.util.*;
public class Assign {

    public static int assign(int[] arr1, int[] arr2){
        int count = 0;
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        int i = 0;
        int j = 0;
        while(i<arr1.length && j<arr2.length){
            if(arr1[i]<=arr2[j]){
                count++;
                i++;
                j++;
            }else{
                j++;
            }
        }

        return count;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr1 = new int[n];
        

        for(int i=0; i<n; i++){
            arr1[i] = sc.nextInt();
        }
        int m = sc.nextInt();
        int[] arr2 = new int[m];
        for(int i=0; i<m; i++){
            arr2[i] = sc.nextInt();
        }

        System.out.println(assign(arr1, arr2));
    }
}
