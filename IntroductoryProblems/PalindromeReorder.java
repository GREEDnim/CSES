import java.util.*;
import java.io.*;
public class PalindromeReorder {
    public static void main(String[] args) throws Exception {
        FastReader in=new FastReader();
        BufferedWriter writer=new BufferedWriter(new OutputStreamWriter(System.out));
        long[] map=new long[26];

        String inp = in.next();
        for(char c:inp.toCharArray()){
            map[c-'A']++;
        }
        boolean sawOddyet=false;
        StringBuilder middle=new StringBuilder();
        StringBuilder left=new StringBuilder();
        StringBuilder right=new StringBuilder();

        for(int i=0;i<26;i++){
            if(map[i]%2!=0) {
                if(sawOddyet) {
                    writer.write("NO SOLUTION");
                    writer.close();
                    return;
                }
                sawOddyet=true;
                middle.append((char)('A'+i));
                map[i]--;
            }

            while(map[i]>0){
                left.append((char)('A'+i));
                right.append((char)('A'+i));
                map[i]-=2;
            }
        }
        writer.write(left.toString()+middle.toString()+right.reverse().toString());
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


