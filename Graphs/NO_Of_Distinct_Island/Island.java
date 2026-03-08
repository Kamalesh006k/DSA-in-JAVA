import java.util.*;

class pair{
    int row;
    int col;
    pair(int row, int col){
        this.row = row;
        this.col = col;
    }
}
public class Island{
    static List<String> distinct(int r, int c, int[][] arr, int[][] vis, int[] delr, int[] delc){
        List<String> lst = new ArrayList<>();
        Queue<pair> q = new LinkedList<>();
        vis[r][c]  = 1;
        q.add(new pair(r, c));
        lst.add("(0,0)");
        while(!q.isEmpty()){
            pair cur= q.poll();
            int row = cur.row;
            int col = cur.col;
            for(int i=0; i<4; i++){
                int newRow = row+delr[i];
                int newCol = col+delc[i];
    
                if(newRow>=0 && newCol>=0 && newRow<arr.length && newCol<arr[0].length && vis[newRow][newCol]==0 && arr[newRow][newCol]==1){
                    vis[newRow][newCol] = 1;
                    q.add(new pair(newRow, newCol));
                    lst.add((newRow-r) + "," + (newCol-c));
                }
            }
        }
        return lst;
    }
     public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr = new int[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                arr[i][j] = sc.nextInt();
            }
        }
        int[] delr = {-1,0,1,0};
        int[] delc = {0,1,0,-1}; 
        int[][] vis = new int[n][m];
        Set<List<String>> st = new HashSet<>();
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(arr[i][j]  == 1 && vis[i][j] == 0){
                    st.add(distinct(i, j, arr,vis,delr,delc));
                }
            }
        }
        System.out.println("No of Distinct Island: "+st.size());
        sc.close();
    }
}
