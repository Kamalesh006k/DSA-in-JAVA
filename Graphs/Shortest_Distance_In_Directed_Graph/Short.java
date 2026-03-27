import java.util.*;

class Pair{
    int node;
    int dist;

    Pair(int node, int dist){
        this.node = node;
        this.dist  = dist;
    }
}
public class Short {
    static void topo(int src, List<List<Pair>> adj, Stack<Integer> st, int[] vis){
        vis[src]  = 1;
        for(Pair s : adj.get(src)) {
            if (vis[s.node] == 0) {
                topo(s.node, adj, st, vis);
            }
        }
        st.add(src);
    }
    static void ShortestPath(List<List<Pair>> adj, Stack<Integer> st, int[] dist) {
        dist[st.peek()] = 0;
        while (!st.isEmpty()) {
            int node = st.pop();
            if (dist[node] != Integer.MAX_VALUE) {
                for (Pair p : adj.get(node)) {
                    if (dist[node] + p.dist < dist[p.node]) {
                        dist[p.node] = dist[node] + p.dist;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        List<List<Pair>> adj = new ArrayList<>();

        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }
        Stack<Integer> st = new Stack<>();
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        for(int i=0; i<m; i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            adj.get(u).add(new Pair(v, w));
        }
        int src = sc.nextInt();
        int[] vis = new int[n];

        for (int i = 0; i < n; i++) {
            if (vis[i] == 0) {
                topo(i, adj, st, vis);
            }
        }
        ShortestPath(adj, st, dist);

        for(int s: dist){
            System.out.print(s+" ");
        }
    }

}
