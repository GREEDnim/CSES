import java.io.*;
import java.util.*;
public class AppleDivision {

    static long half=0;
    static long mid=0;
    public static void main(String[] args) throws Exception{
        FastReader in=new FastReader();
        BufferedWriter writer=new BufferedWriter(new OutputStreamWriter(System.out));

        int n=in.nextInt();
        long sum=0;
        long[] arr=new long[n];
        for(int i=0;i<n;i++){
            arr[i]=in.nextLong();
            sum+=arr[i];
        } 
        mid=sum/2;
        dfs(0,arr,0);
        writer.write(""+Math.abs(half-(sum-half))+"\n");
        writer.close();
    }
    public static void dfs(int i,long[] arr,long cur){

        if(i==arr.length || cur>mid) return;

        dfs(i+1,arr,cur);
        long comp=arr[i]+cur;
        if(Math.abs(mid-half)>Math.abs(mid-comp)){
            half=comp;
        }
        dfs(i+1,arr,comp);
        return;

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