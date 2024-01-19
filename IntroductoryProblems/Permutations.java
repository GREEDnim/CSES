import java.util.Scanner;

public class Permutations {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        long n=in.nextLong();
        if(n==2 || n==3) {
            System.out.println("NO SOLUTION");
            return;
        }

        StringBuilder left=new StringBuilder();
        StringBuilder right=new StringBuilder();

        for(long i=1;i<=n;i++){
            if(i%2==1) left.append(i+" ");
            else right.append(i+" ");
        }
        System.out.println(right+""+left);

    }
}
