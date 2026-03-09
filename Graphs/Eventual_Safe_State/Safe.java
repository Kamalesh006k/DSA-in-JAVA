import java.util.ArrayList;
import java.util.Scanner;
import java.util.*;

public class Safe{

    static boolean SafePath(int node, List<List<Integer>> adj, int[] vis, int[] path, int[] check){
        vis[node] = 1;
        path[node] = 1;

        for(int s: adj.get(node)){
            if(vis[s] == 0){
                if(SafePath(s, adj, vis, path, check)){
                    check[node] = 0;
                    return true;
                }
            }else if(path[s] == 1){
                check[s] = 0;
                return true;
            }
        }
        check[node] = 1;
        path[node] = 0;
        return false;
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
        }

        int[] vis = new int[n];
        int[] path = new int[n];
        int[] check = new int[n];

        for(int i= 0; i<n; i++){
            if(vis[i] == 0){
                SafePath(i, adj, vis, path, check);
            }
        }
        List<Integer> ans = new ArrayList<>();
        for(int i=0; i<n; i++){
            if(check[i] == 1){
                ans.add(i);
            }
        }

        System.out.println(ans);
    }
}