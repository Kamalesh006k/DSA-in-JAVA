import java.util.*;
public class Prime {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        boolean isPrime = true;
        int n =  sc.nextInt();
        for(int i = 2; i<n; i++){
            if(n % i == 0) isPrime = false; 
        }

        if(isPrime){
            System.out.println("Prime Number");
        }else{
            System.out.println("It is not a prime number");
        }
    }
}
