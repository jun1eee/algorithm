import java.io.*;
import java .util.*;
 
public class Solution {
   static int[] sets, size;
   public static void main(String[] args) throws IOException {
      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
      int T = Integer.parseInt(in.readLine());
 
      StringBuilder sb = new StringBuilder();
 
      for(int tc=1;tc<=T;tc++){
         sb.append("#").append(tc).append(" ");
 
         StringTokenizer st = new StringTokenizer(in.readLine());
         int N = Integer.parseInt(st.nextToken());
         int M = Integer.parseInt(st.nextToken());
 
         size = new int[N+1];
         sets = new int[N+1];
         for(int i=1;i<=N;i++) sets[i] = i;
 
 
         for(int m=0;m<M;m++){
 
            st = new StringTokenizer(in.readLine());
 
            int operator = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
 
            switch(operator){
               case 0://합집합
                  union(a,b);
                  break;
               case 1://같은집합인지 확인
                  if(find(a)==find(b)) sb.append(1);
                  else sb.append(0);
                  break;
            }
         }
         sb.append("\n");
      }
      System.out.print(sb);
   }
 
   private static int find(int x){
      if(sets[x]==x) return x;
      sets[x] = find(sets[x]);
      return sets[x];
   }
 
   private static void union(int a, int b){
      int pa = find(a);
      int pb = find(b);
 
      if(pa==pb) return;
 
      if(size[pa]>size[pb]) sets[pb] = pa;
      else if(size[pa]==size[pb]) size[pb]++;
 
      if(size[pb]>size[pa]) sets[pa] = pb;
 
   }
}