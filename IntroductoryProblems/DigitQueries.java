import java.io.*;
import java.util.*;
public class DigitQueries {

    public static void main(String[] args)throws Exception {
        FastReader in=new FastReader();
        BufferedWriter writer=new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder ans=new StringBuilder();
        int q=in.nextInt();
        for(int x=0;x<q;x++){

            long k=in.nextLong();
            

            // place=once or tens or 100s
            // count= total numbers in each place
            // first finding 'k' 's number's place
            // start= start of digit of lowest possible place digits number
            // end= end of digit of highest possible place digit number

            long place=1;
            long count=9;
            
            long start=0;
            long end=0;
            for(long i=1;i<=18;i++){
                start=end;
                end=end+(i*count);
                if(k<=end) break;
    
                place*=10;
                count=(place*10)-1 - (place-1);
            }

            // binary searching in count.
            // for each number in count, i find its end -> mend
            // then binary search by seeing if k is either below or aboove it
            
            long s=1;
            long e=count;
            long d=(long)(Math.log10(place)+1);
            
            long m=s;
            while(s<e){
                m=s+(e-s)/2;
                long mend=(m*d)+start;

                if(k<=mend) e=m;
                else s=m+1;

            }

            // after finding the number in count, convert it to actual number.
            // eg if place ==10 and e=2, it means the 2nd number in 2digit numbers => 11

            // find the digit actually required for that number
            long number=e+place-1;
            long finalDigit=(e*d)+start-k;
            while(number>0){
                long rem=number%10;
                if(finalDigit==0) ans.append(""+rem+"\n");
                number/=10;
                finalDigit--;
            }
        }
        writer.write(ans.toString());
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
