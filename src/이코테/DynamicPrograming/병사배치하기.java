package 이코테.DynamicPrograming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class 병사배치하기 {
    static ArrayList<ArrayList<Integer>> output;
    static boolean[] visit;
    static int[] arr;
    //9:07~10:26
    static int size;
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        int N = s.nextInt();
        visit = new boolean[N + 1];
         arr = new int[N];

        for(int i=0;i<N;i++){
            arr[i] = s.nextInt();
        }
        int max=-1;
        for(int i=1;i<=N;i++){

            size=i;
            output=new ArrayList<ArrayList<Integer>>();
            dfs(new int[size],0,N,0);
//            print();

            for(int j=0;j< output.size();j++){
                ArrayList<Integer> list = output.get(j);
                if(isDescend(list)){
                    max=Math.max(max, list.size());
                }
            }
        }
        System.out.println(N-max);

    }
    public static void print(){

        for(int i=0;i< output.size();i++){

            System.out.println(output.get(i).toString());
        }
    }
    public static boolean isDescend(ArrayList<Integer> list){
        Integer first = list.get(0);
        for(int i=1;i< list.size();i++){
            if(first<=list.get(i)){
                return false;
            }
            first=list.get(i);
        }
        return true;


    }
    public static void dfs(int[] now, int start, int end, int depth){
        //start ~ end 범위에서 depth 개수를 뽑는 조합
        //해당 조합은 now에 저장
        if (depth == size) {
            ArrayList<Integer> tmp = new ArrayList<>();

            for(int j=0;j< now.length;j++){
                tmp.add(arr[now[j]]);
            }
            output.add(tmp);

            return;
        }
        for(int i=start;i<end;i++){
            if(!visit[i]){
                visit[i]=true;
                now[depth]=i;
                dfs(now,i+1,end,depth+1 );
                visit[i]=false;
            }
        }
    }
}
