import java.io.*;
import java.util.*;
public class ChessboardandQueens {
    static char[][] board;
    public static void main(String[] args) throws Exception {
        
        board=new char[8][8];
        FastReader in=new FastReader();
        BufferedWriter writer=new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i=0;i<8;i++){
            String line=in.next();
            for(int j=0;j<line.length();j++) board[i][j]=line.charAt(j);
        }
        int ans=dfs(0);

        writer.write(""+ans);
        writer.close();
    }
    public static int dfs(int i){
        if(i==board.length) return 1;
        int ans=0;
        for(int j=0;j<8;j++){
            if(isPossible(i,j)) {
                board[i][j]='Q';
                ans+=dfs(i+1);
                board[i][j]='.';
            }
        }
        return ans;
    }
    public static boolean isPossible(int i,int j){
        //reserved
        if(board[i][j]=='*') return false;

        // top left 
        int x=i,y=j;
        while(x>=0 && y>=0){
            if(board[x][y]=='Q') return false;
            x--;y--;
        }
        // top right
        x=i;y=j;
        while(x>=0 && y<8) {
            if(board[x][y]=='Q') return false;
            x--;y++;
        }
        //top 
        while(i>=0){
            if(board[i][j]=='Q') return false;
            i--;
        }
        return true;
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
