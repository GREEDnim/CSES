import java.io.*;
import java.util.*;
public class CreatingStrings {
    static StringBuilder ans=new StringBuilder();
    public static void main(String[] args) throws Exception{
        FastReader in=new FastReader();
        BufferedWriter writer=new BufferedWriter(new OutputStreamWriter(System.out));
        String str=in.next();
        int[] arr=new int[26];
        for(char c:str.toCharArray()) arr[c-'a']++;

        long val=dfs(arr,new StringBuilder());
        writer.write(""+val+"\n");
        writer.write(ans.toString());
        writer.close();
    }
    public static long dfs(int[] arr,StringBuilder cur){
        if(isEmpty(arr)) {
            ans.append(cur.toString()+"\n");
            return 1;
        }
        long ways=0;
        for(int i=0;i<26;i++){
            if(arr[i]>0) {
                arr[i]--;
                cur.append((char)('a'+i));
                ways+=dfs(arr, cur);
                arr[i]++;
                cur=cur.deleteCharAt(cur.length()-1);
            }
        }
        return ways;
    }
    public static boolean isEmpty(int[] arr){
        for(int ele:arr) if(ele!=0) return false;
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


