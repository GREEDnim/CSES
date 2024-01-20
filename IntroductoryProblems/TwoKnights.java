import java.io.*;
import java.util.*;
public class TwoKnights {
    public static long[] dp;
    public static void main(String[] args)throws Exception {
        FastReader inp=new FastReader();
        BufferedWriter writer=new BufferedWriter(new OutputStreamWriter(System.out));

        int n=inp.nextInt();
        dp=new long[n+1];
        for(int i=1;i<=n;i++){
            long allWays=getAllWays(i);
            long allKnightsSpace=getAllKnights(i);
            writer.write(""+(allWays-allKnightsSpace)+"\n");
        }

        writer.close();
    }
    public static long getAllWays(int n){
        long t=n*n;
        return t*(t-1)/2;
    }
    public static long getAllKnights(int n){
        if(n<=2) return 0;
        if(dp[n]!=0) return dp[n];
        long p=getAllKnights(n-1);
        long count=0;
        //vertical 
        for(int i=1;i<=n;i++){
            
            // giving out
            if(i+1<=n && n-2>=1) count++;
            if(i+2<=n && n-1>=1) count++;
            //taking in
            if(i-1>=1 && n-2>=1) count++;
            if(i-2>=1 && n-1>=1) count++;
        }

        // horizontal
        for(int j=1;j<n;j++){

            if(n-2>=1 && j-1>=1) count++;
            if(n-2>=1 && j+1<n) count++;

            if(n-1>=1 && j-2>=1) count++;
            if(n-1>=1 && j+2<n) count++;
        }
        return dp[n]=(p+count);

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

