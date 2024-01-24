import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException; 
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer; 
public class CoinPiles {
    public static void main(String[] args) throws Exception {
        FastReader io=new FastReader();
        BufferedWriter writer=new BufferedWriter(new OutputStreamWriter(System.out));

        long t=io.nextLong();
        for(long i=1;i<=t;i++){

            long a=io.nextLong();
            long b=io.nextLong();

            if((a%3 + b%3)%3!=0) writer.write("NO");
            else{
                long min=Math.min(a,b);
                long max=Math.max(a,b);

                if(max/2 <= min) writer.write("YES");
                else writer.write("NO");
            }
            writer.write("\n");
            writer.flush();
        }
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

