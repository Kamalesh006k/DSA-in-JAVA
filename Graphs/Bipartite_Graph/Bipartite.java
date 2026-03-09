import java.util.*;
class pair{
    int node;
    int color;

    pair(int node, int color){
        this.node = node;
        this.color = color;
    }
}
public class Bipartite {
    static boolean check(int st,List<List<Integer>> adj, int[] color){
        Queue<pair> q = new LinkedList<>();
        q.add(new pair(st, 0));
        color[st] = 0;
        while(!q.isEmpty()){
            pair cur = q.poll();
            for(int s: adj.get(cur.node)){
                if(color[s] == -1){
                    color[s] = 1-cur.color;
                    q.add(new pair(s, 1 - cur.color));
                }else{
                    if(cur.color == color[s]){
                        return false;
                    }
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
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
        int[] color = new int[n+1];
        Arrays.fill(color, -1);

        for(int i=0; i<n; i++){
            if(color[i] == -1 && !check(i, adj, color)){
                System.out.println("False");
                return;
            }
        }
        System.out.println("True");
    }
}
