import java.util.Scanner;
 
public class IncreasingArray {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        long ans=0;
        long prev=in.nextLong();
 
        for(int i=1;i<n;i++) {
            long cur=in.nextLong();
            if(cur<prev) {
                ans+=prev-cur;
            }
            else prev=cur;
        }
        System.out.println(ans);
        in.close();
    }
}
