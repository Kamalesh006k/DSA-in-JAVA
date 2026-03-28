import java.util.*;
public class NQueen {
    static boolean isValid(int row, int col,int n,char[][] chess){
        for(int i=0; i<n; i++){
            if(chess[row][i]=='Q') return false;
            if(chess[i][col] == 'Q') return false;
        }
        int r = row-1, c = col-1;
        while(r >=0 && c>=0){
            if(chess[r][c] == 'Q') return false;
            r --;
            c --;
        }
        int rr = row+1, cc = col-1;
        while(rr < n && cc>=0){
            if(chess[rr][cc] == 'Q') return false;
            rr ++;
            cc --;
        }

        return true;
    }

    public static int placeQueen(char[][] chess,int n,int col,int ans){
        if(col>=n){
            return ans+1;
        }
        for(int i=0; i<n; i++){
            if(isValid(i, col, n, chess)){
                chess[i][col] = 'Q';
                ans = placeQueen(chess, n, col+1,ans);
                chess[i][col] = '.';
            }
        }
        return ans;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the value of N: ");
        int n = sc.nextInt();
        char[][] chess = new char[n][n];
        System.out.println(placeQueen(chess,n,0,0));
    }    
}
