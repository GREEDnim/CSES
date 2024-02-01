import java.io.*;
import java.util.*;
public class GridPaths {
    static String inp;
    static boolean[][] set;
    public static void main(String[] args)throws Exception {
        FastReader in=new FastReader();
        BufferedWriter writer=new BufferedWriter(new OutputStreamWriter(System.out));
        set=new boolean[7][7];
        inp=in.next();
        writer.write(""+dfs(0,0,0));

        writer.close();
    }
    public static boolean isValid(int i,int j){
        if(i<0 || i>=7 || j<0 || j>=7) return false;
        return true;
    }
    public static boolean isValidHeavy(int i,int j){
        if(i<0 || i>=7 || j<0 || j>=7) return false;
        if(set[i][j]) return false;
        return true;
    }
    public static long dfs(int i,int j,int index){
        if(i<0 || i>=7 || j<0 || j>=7) return 0;
        if(set[i][j]) return 0;
        if(i==6 && j==0 ) {
            if(index==inp.length()) return 1;
            return 0;
        } 

        boolean top=isValidHeavy(i-1,j);
        boolean bottom=isValidHeavy(i+1,j);
        boolean left=isValidHeavy(i,j-1);
        boolean right=isValidHeavy(i,j+1);

        if(top && bottom && !left && !right) return 0;
        if(!top && !bottom && left && right) return 0;

        if(isValid(i-1,j-1) && set[i-1][j-1] && isValid(i, j-1) && isValid(i-1, j) && !set[i][j-1] && !set[i-1][j]) return 0; 
        if(isValid(i-1,j+1) && set[i-1][j+1] && isValid(i, j+1) && isValid(i-1, j) && !set[i][j+1] && !set[i-1][j]) return 0; 

        if(isValid(i+1,j-1) && set[i+1][j-1] && isValid(i, j-1) && isValid(i+1, j) && !set[i][j-1] && !set[i+1][j]) return 0;
        if(isValid(i+1,j+1) && set[i+1][j+1] && isValid(i, j+1) && isValid(i+1, j) && !set[i][j+1] && !set[i+1][j]) return 0; 

        set[i][j]=true;

        char cur=inp.charAt(index);
        long ans=0;
        if(cur=='U' || cur=='?' ) ans+=dfs(i-1,j,index+1);
        if(cur=='D' || cur=='?' ) ans+=dfs(i+1,j,index+1);
        if(cur=='L' || cur=='?' ) ans+=dfs(i,j-1,index+1);
        if(cur=='R' || cur=='?' ) ans+=dfs(i,j+1,index+1);

        set[i][j]=false;
        return ans;
        
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