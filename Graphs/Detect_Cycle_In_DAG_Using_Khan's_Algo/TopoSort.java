import java.util.*;
public class TopoSort {

    static void Topo(List<List<Integer>> adj,int n){
        Queue<Integer> q = new LinkedList<>();
        int[] indegree = new int[n];
        List<Integer> ans = new ArrayList<>();

        for(int i=0; i<n; i++){
            for(int s : adj.get(i)){
                indegree[s]++;
            }
        }

        for(int i=0; i<n; i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int cur = q.poll();
            ans.add(cur);

            for(int s: adj.get(cur)){
                indegree[s]--;
                if(indegree[s] == 0){
                    q.add(s);
                }
            }
        }

        if (ans.size() == n)
            System.out.println("No Cycle");
        else
            System.out.println("Cycle detected");
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
        Topo(adj, n);


    }
}
