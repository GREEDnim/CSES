import java.io.*;
import java.util.*;
public class GrayCode {

    // gray code of n = n^(n-1)   
    //  let binary = b3 b2 b1 b0
    //   gray =      g3 g2 g1 g0
    //   where g3=b3 , g2= b3^b2 , g1-b2^b1 , g0 = b1^b0 
    // g = b^(b>>1);
    public static void main(String[] args)throws Exception {
        FastReader in=new FastReader();
        BufferedWriter writer=new BufferedWriter(new OutputStreamWriter(System.out));

        long n=in.nextLong();

        for(long i=0;i<(1<<n);i++){
            writer.write(getGrayCode(i,n)+"\n");
        }
        writer.close();
    }
    public static String getGrayCode(long i,long length){

        long gray=i^(i>>1);
        StringBuilder ans=new StringBuilder();
        while(gray>0){
            ans.append(""+gray%2);
            gray/=2;
        }
        while(ans.length()<length) ans.append("0");
        return ans.reverse().toString();
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


