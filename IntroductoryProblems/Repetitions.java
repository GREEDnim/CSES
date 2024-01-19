import java.util.Scanner;

public class Repetitions {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        String inp=in.next();
        long m=1;
        int s=0,e=0;
        while(e<inp.length()){
            while(e<inp.length() && inp.charAt(e)==inp.charAt(s)) e++;
            m=Math.max(e-s,m);
            s=e;
        }
        System.out.println(m);
    }
}
