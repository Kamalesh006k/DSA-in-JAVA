import java.util.*;
public class Alien {
    static void topoSort(List<List<Integer>> adj, int[] present){
        Queue<Integer> q = new LinkedList<>();
        int[] indegree = new int[26];
        List<Integer> ans = new ArrayList<>();



        for(int i=0; i<26; i++){
            for(int s : adj.get(i)){
                indegree[s]++;
            }
        }

        for(int i=0; i<26; i++){
            if(indegree[i] == 0 && present[i] == 1){
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
        int count = 0;
        for (int i = 0; i < 26; i++) {
            if (present[i] == 1)
                count++;
        }

        if (ans.size() != count) {
            System.out.println("Invalid (Cycle detected)");
            return;
        }
        for (int s : ans) {
            System.out.print((char) (s + 'a') + " ");
        }

    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] str = new String[n];
        for(int i=0; i<n; i++){
            str[i] = sc.next();
        }
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<26; i++){
            adj.add(new ArrayList<>());
        }
        int[] present = new int[26];

        for(String s: str){
            for(char c : s.toCharArray()){
                present[c - 'a'] = 1;
            }
        }
        for(int i = 0; i < n - 1; i++) {
            StringBuilder sb1 = new StringBuilder(str[i]);
            StringBuilder sb2 = new StringBuilder(str[i + 1]);
            if (str[i].length() > str[i + 1].length() && str[i].startsWith(str[i + 1])) {
                System.out.println("Invalid");
                return;
            }

            int len = Math.min(sb1.length(), sb2.length());
            for (int j = 0; j < len; j++) {
                if(sb1.charAt(j) != sb2.charAt(j)){
                    adj.get(sb1.charAt(j)-'a').add(sb2.charAt(j)-'a');
                    break;
                }
            }
            
        }

        topoSort(adj,present);

    }
}
