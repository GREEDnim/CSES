import java.io.*;
import java.util.*;
public class TwoSets {
    public static void main(String[] args) {

        FastReader inp=new FastReader();
        long n=inp.nextLong();
        long total=n*(n+1)/2;
        if(total%2==1) {
            System.out.println("NO");
            return;
        }
        System.out.println("YES");
        total/=2;
        long setA=0;
        StringBuffer a=new StringBuffer();
        StringBuffer b=new StringBuffer();
        for(long i=n;i>=1;i--){
            if(i<=total){
                setA++;
                a.append(""+i+" ");
                total-=i;
            }
            else b.append(""+i+" ");
        }
        System.out.println(""+setA+"\n"+a+"\n"+(n-setA)+"\n"+b);
    }
}
class FastReader { 
    BufferedReader br; 
    StringTokenizer st; 

    public FastReader() 
    { 
        br = new BufferedReader( 
            new InputStreamReader(System.in)); 
    } 

    String next() 
    { 
        while (st == null || !st.hasMoreElements()) { 
            try { 
                st = new StringTokenizer(br.readLine()); 
            } 
            catch (IOException e) { 
                e.printStackTrace(); 
            } 
        } 
        return st.nextToken(); 
    } 

    int nextInt() { return Integer.parseInt(next()); } 

    long nextLong() { return Long.parseLong(next()); } 

    double nextDouble() 
    { 
        return Double.parseDouble(next()); 
    } 

    String nextLine() 
    { 
        String str = ""; 
        try { 
            if(st.hasMoreTokens()){ 
                str = st.nextToken("\n"); 
            } 
            else{ 
                str = br.readLine(); 
            } 
        } 
        catch (IOException e) { 
            e.printStackTrace(); 
        } 
        return str; 
    } 
}

