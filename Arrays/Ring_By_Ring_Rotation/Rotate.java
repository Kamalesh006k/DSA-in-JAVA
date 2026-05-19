import java.util.*;
import java.util.Scanner;
public class Rotate {

    public static void rotate(int[][] mat){
        int top = 0 , bottom = mat.length-1;
        int left = 0, right = mat[0].length-1;

        while(top <= bottom && left <= right){
            int prev = mat[top+1][left];
            for(int i=left; i<= right; i++){
                int cur = mat[top][i];
                mat[top][i] = prev;
                prev = cur;
            }
            top++;

            for(int i=top; i<=bottom; i++){
                int cur = mat[i][right];
                mat[i][right] = prev;
                prev = cur;
            }
            right--;

            for(int i=right; i>=left; i--){
                int cur = mat[bottom][i];
                mat[bottom][i] = prev;
                prev = cur;
            }
            bottom--;

            for(int i=bottom; i>=top; i--){
                int cur = mat[i][left];
                mat[i][left] = prev;
                prev = cur;
            }
            left++;
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
    
        int[][] mat = new int[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                mat[i][j] = sc.nextInt();
            }
        }

        for(int i=0; i<k; i++){
            rotate(mat);
        }
        System.out.println();
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                System.out.print(mat[i][j]+" ");
            }
            System.out.println();
        }

    }


}
