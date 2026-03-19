import java.util.*;
public class Alien {

    Map<Character, Integer> map = new  HashMap<>();
    map.put('a',1);
    map.put('b',2);
    void topoSort(List<List<Character>> adj, int n){
        Queue<Character> q = new LinkedList<>();
        int[] indegree = new int[n];
        List<Character> ans = new ArrayList<>();

        for(int i=0; i<n; i++){
            for(char s : adj.get(i)){
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
            System.out.println(ans);
        else
            System.out.println("Cycle detected");
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] str = new String[n];
        for(int i=0; i<n; i++){
            str[i] = sc.next();
        }

        int[] vis = new int[n];
        List<List<Character>> adj = new ArrayList<>();
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0; i<n-1; i++){
            StringBuilder sb1 = new StringBuilder(str[i]);
            StringBuilder sb2 = new StringBuilder(str[i+1]);

            while(sb1.charAt(0) == sb2.charAt(0)){
                sb1.deleteCharAt(0);
                sb2.deleteCharAt(0);
            }
            adj.get(sb1.charAt(0)).add(sb2.charAt(0));
        }

    }
}
