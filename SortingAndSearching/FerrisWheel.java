package SortingAndSearching;
import java.io.*;
import java.util.*;
public class FerrisWheel {
    public static void main(String[] args) throws Exception{
        FastReader in= new FastReader();
        BufferedWriter writer=new BufferedWriter(new OutputStreamWriter(System.out));
        int n=in.nextInt();
        long max=in.nextLong();

        long[] w=new long[n];
        for(int i=0;i<w.length;i++) w[i]=in.nextLong();
        Arrays.sort(w);

        long ans=0;
        int s=0;
        int e=w.length-1;

        while(s<e){
            if(w[e]+w[s]<=max) s++;
            e--;
            ans++;
        }
        if(s==e) ans++;
        writer.write(""+ans);
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

