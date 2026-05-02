package 백준;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class N과M조합 {
    public static ArrayList<ArrayList<Integer>> output
            = new ArrayList<ArrayList<Integer>>();
    public static boolean[] visited;


    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);

        int N=s.nextInt();
        int M=s.nextInt();
        visited=new boolean[N+1];

        combi(new int[M],1,N+1,0);

        for(int i=0;i< output.size();i++){
                System.out.println(output.get(i).toString());

        }

    }
    public static void combi(int[] now, int start,int end,int depth){
        if(now.length==depth){
            ArrayList<Integer> tmp = new ArrayList<>();

            for (int k = 0; k < now.length; k++) {
                tmp.add(now[k]);
            }
            output.add(tmp);

            return;
        }

        for(int i=start;i<end;i++){
            if (!visited[i]) {
                visited[i]=true;
                now[depth]=i;
                combi(now,i+1,end,depth+1);
                visited[i]=false;
            }
        }



    }


}
