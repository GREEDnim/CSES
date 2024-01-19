import java.util.Scanner;

class MissingNumber{
  public static void main(String[] args) {
    Scanner in=new Scanner(System.in);
    long n=in.nextLong();
    long ans=n*(n+1)/2;
    for(int i=1;i<n;i++) ans-=in.nextLong();
    System.out.println(ans);
  }

}