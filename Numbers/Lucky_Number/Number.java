import java.util.*;
public class Number {
    static boolean isLucky(int n){
        while(n>0){
            int dig = n%10;
            if(dig != 4 && dig !=7){
                return false;
            }
            n/=10;
        }
        return true;
    }
    public static void main(String[] arg){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int found = 0;
        for(int i=n; i<=m; i++){
            if(isLucky(i)){
                System.out.print(i+" ");
                found = 1;
            }
        }

        if(found == 0){
            System.out.println(-1);
        }
    }
}
