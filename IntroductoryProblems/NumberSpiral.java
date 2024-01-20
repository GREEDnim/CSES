import java.io.*;
import java.io.BufferedReader; 
import java.io.IOException; 
import java.io.InputStreamReader; 
import java.util.StringTokenizer; 
public class NumberSpiral {
    public static void main(String[] args) throws Exception {

        FastReader io=new FastReader();
        BufferedWriter writer=new BufferedWriter(new OutputStreamWriter(System.out));

        long t=io.nextLong();
        for(int i=0;i<t;i++){
            long r=io.nextLong();
            long c=io.nextLong();
            
            long m=Math.max(r,c);
            long direction=getDirection(m);
            long s=getStart(m);

            //left to right
            if(direction==0){
                if(r>=c) writer.write(""+(s+c-1)+"\n");
                else writer.write(""+(s+m-1 + m-r)+"\n");
            }
            // top to bottom
            else{
                if(c>=r) writer.write(""+(s+r-1)+"\n");
                else writer.write(""+(s+m-1 + m-c)+"\n");
            }

        }
        writer.close();
    }
    public static long  getStart(long x){
        x-=1;
        return (x*x) +1;
    }
    public static long getDirection(long m){
        // 0- row start
        // 1- col start
        if(m%2!=0) return 0;
        return 1; 
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
