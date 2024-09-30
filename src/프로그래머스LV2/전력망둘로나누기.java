package 프로그래머스LV2;

import java.util.ArrayList;
import java.util.Arrays;

public class 전력망둘로나누기 {
    public static ArrayList<ArrayList<Integer>> adjacent =new ArrayList<ArrayList<Integer>>();
    public static boolean[] visited;

    public int solution(int n, int[][] wires) {
        int answer = (int)1e9;
        visited=new boolean[n+1];
        Arrays.fill(visited,false);

        for(int i=0;i<=n;i++){
            adjacent.add(new ArrayList<Integer>());
        }

        for(int i=0;i<wires.length;i++){
            int a=wires[i][0];
            int b=wires[i][1];
            adjacent.get(a).add(b);
            adjacent.get(b).add(a);
        }


        for(int i=0;i<wires.length;i++){
            int a=wires[i][0];
            int b=wires[i][1];

            //와이어 하나씩 끊기
            adjacent.get(a).remove(new Integer(b));
            adjacent.get(b).remove(new Integer(a));



            dfs(1);
            int cnt=0;
            for(int j=0;j<visited.length;j++){ //매우 주의, i, j 인덱스 구분하기

                if(visited[j]){
                    cnt++;
                }
            }
            Arrays.fill(visited,false);
            answer=Math.min(Math.abs((n-cnt)-cnt),answer);
            System.out.println(answer);

            //끊은 와이어 원상복구시키기.

            adjacent.get(a).add(new Integer(b));
            adjacent.get(b).add(new Integer(a));
        }

        return answer;
    }
    public void dfs(int node){


        for(int i=0;i<adjacent.get(node).size();i++){
            int next=adjacent.get(node).get(i);
            if(!visited[next]){
                visited[next]=true;
                dfs(next);
            }
        }

        return;
    }

}
