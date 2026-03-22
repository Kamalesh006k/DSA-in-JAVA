import java.util.*;

class Pair{
    int node;
    int dist;

    Pair(int node, int dist){
        this.node = node;
        this.dist = dist;
    }
}
public class Short {

    static void ShortDist(int st,List<List<Pair>> adj, int[] dist){
        PriorityQueue<Pair> q = new PriorityQueue<>((a,b) -> a.dist - b.dist);
        q.add(new Pair(st, 0));
        dist[st] = 0;

        while(!q.isEmpty()){
            Pair cur = q.poll();
            if(cur.dist > dist[cur.node]) continue;
            for(Pair s : adj.get(cur.node)){
                if(dist[cur.node] + s.dist < dist[s.node]){
                    dist[s.node] = dist[cur.node] + s.dist;
                    q.add(new Pair(s.node, dist[s.node]));
                }
            }
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        List<List<Pair>> adj = new ArrayList<>();

        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0; i<m; i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();

            adj.get(u).add(new Pair(v, w));
        }
        int st = sc.nextInt();
        int[] dis = new int[n];
        Arrays.fill(dis, Integer.MAX_VALUE);

        ShortDist(st, adj, dis);
        for(int s: dis){
            System.out.print(s+" ");
        }
    }
}
