import java.util.*;
public class Min {

    static int pairs(int node ,List<List<Integer>> adj, int[] vis){
        vis[node] = 1;
        for(int s: adj.get(node)){
            if(vis[s] == 0){
                return pairs(s, adj, vis) + 1;
            }
        }
        return 1;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        List<List<Integer>> adj = new ArrayList<>();

        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0; i<m; i++){
            int u = sc.nextInt();
            int v = sc.nextInt();

            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int pair = (n*(n-1))/2;
        int[] vis = new int[n];
        int totalPairs = 0;
        for(int i=0; i<n; i++){
            if(vis[i] == 0){
                int unipairs = pairs(i, adj, vis);
                totalPairs += (unipairs * (unipairs - 1))/2;
            }
        }

        System.out.println(pair - totalPairs);
    }
}
