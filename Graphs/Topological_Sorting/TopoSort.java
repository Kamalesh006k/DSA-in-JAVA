import java.util.*;
public class TopoSort {
    static void Topo(int node, int[] vis, List<List<Integer>> adj, Stack<Integer> st){
        vis[node] = 1;
        for(int s: adj.get(node)){
            if(vis[s] == 0){
                Topo(s, vis, adj, st);
            }
        }
        st.add(node);
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
        int[] vis = new  int[n];
        Stack<Integer> st = new Stack<>();
        List<Integer> ans = new ArrayList<>();
        for(int i=0; i<n; i++){
            if(vis[i] == 0){
                Topo(i, vis, adj, st);
            }
        }

        while(!st.isEmpty()){
            ans.add(st.peek());
            st.pop();
        }
        System.out.println(ans);
    }
}
