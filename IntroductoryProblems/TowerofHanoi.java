import java.io.*;
import java.util.*;
public class TowerofHanoi {
    static StringBuilder moves=new StringBuilder();
    public static void main(String[] args)throws Exception {
        BufferedWriter writer=new BufferedWriter(new OutputStreamWriter(System.out));
        FastReader in=new FastReader();
        int n=in.nextInt();
        long ans=toh("1","2","3",n);
        writer.write(ans+"\n");
        writer.write(moves.toString());
        writer.close();
        
    }
    public static long toh(String one,String two,String three,int disks) {
        if(disks==0) return 0;
        long done=toh(one,three,two,disks-1);
        moves.append(one+" "+three+"\n");
        done++;
        done+=toh(two,one,three,disks-1);

        return done;
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


