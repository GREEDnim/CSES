import java.util.*;
import java.io.*;

public class BitStrings {
    static long mod=1000000007;
    public static void main(String[] args) {
        FastReader io=new FastReader();
        Long n=io.nextLong();
        System.out.println(get2pow(n));
    }
    public static long get2pow(long n){
        if(n==1) return 2;
        long half=get2pow(n/2)%mod;
        long full=(half*half)%mod;
        if(n%2==1) full=(2*full)%mod;

        return full%mod;
        
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

