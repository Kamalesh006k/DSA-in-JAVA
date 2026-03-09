import java.util.*;

public class Cycle {
    static boolean detectCycle(int node, List<List<Integer>> adj, int[] vis, int[] path){
        vis[node] = 1;
        path[node] = 1;
        for (int s : adj.get(node)) {
            if (vis[s] == 0) {
                if (detectCycle(s, adj, vis, path))
                    return true;
            } else {
                if (path[s] == 1)
                    return true;
            }
        }
        path[node] = 0;
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();

            adj.get(u).add(v);
        }

        int[] vis = new int[n];
        int[] path = new int[n];

        for (int i = 0; i < n; i++) {
            if (vis[i] == 0) {
                if (detectCycle(i, adj, vis, path)) {
                    System.out.println("True");
                    return;
                }
            }
        }

        System.out.println("False");
    }
}
