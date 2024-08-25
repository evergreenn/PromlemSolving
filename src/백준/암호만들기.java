package 백준;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class 암호만들기 {
    static String[] input;
    static boolean[] visit;
    static int L;
    static int C;
    static ArrayList<ArrayList<String>> output = new ArrayList<ArrayList<String>>();
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

         L = s.nextInt();
         C = s.nextInt();
        input=s.nextLine().split(" ");
        visit=new boolean[C+1];


    }
    public static void combination(int[] now, int start, int end, int depth){
        //start 부터 end 까지의 범위에서 depth개를 뽑는 경우의 수 (depth는 인덱스로 now에 저장)

        if(depth==L){
            ArrayList<String> tmp = new ArrayList<>();
            for(int i=0;i< now.length;i++){
                tmp.add(input[now[i]]);
            }
            Collections.sort(tmp);
            output.add(tmp);
            return;
        }

        for (int i=start;i<end;i++){
            if(!visit[i]){
                visit[i]=true;
                now[depth]=i;
                combination(now,i+1,end,depth+1);
                visit[i]=false;
            }
        }


    }
}
