package SortingAndSearching;
import java.io.*;
import java.util.*;

public class DistinctNumbers {
    public static void main(String[] args) throws Exception{
        FastReader in=new FastReader();
        BufferedWriter writer=new BufferedWriter(new OutputStreamWriter(System.out));

        long n=in.nextLong();
        HashSet<Long>set=new HashSet<>();
        for(long i=0;i<n;i++){
            set.add(in.nextLong());
        }
        writer.write(""+set.size());
        writer.close();
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


