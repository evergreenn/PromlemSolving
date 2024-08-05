package 이코테.DFSBFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 특정거리의도시찾기2 {
    static int[][] map;
    static ArrayList<ArrayList<Integer>> list= new ArrayList<ArrayList<Integer>>();
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int N = s.nextInt();
        int M = s.nextInt();
        int K = s.nextInt();
        int X = s.nextInt();
        boolean[] visit = new boolean[N + 1];
       int[] dp = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }



        for (int i = 0; i < M; i++) {
            int x=s.nextInt();
            int y=s.nextInt();
            list.get(x).add(y);
        }
        //첫 시작 노드
        Integer first = list.get(X).get(0);

        Queue<Integer> queue = new LinkedList<>();

        queue.add(X);
        visit[X]=true;
        dp[X]=0;

        ArrayList<Integer> answer = new ArrayList<>();

        while (!queue.isEmpty()) {
            Integer node = queue.remove();
            for (int i = 0; i < list.get(node).size(); i++) {
                Integer adjcent = list.get(node).get(i);

                if (!visit[adjcent]) {
                    dp[adjcent]=dp[node]+1;
                    if (dp[adjcent] == K) {
                        answer.add(adjcent);
                    }
                    visit[adjcent]=true;
                    queue.add(adjcent);
                }
            }

        }

        if (answer.size() == 0) {
            System.out.println(-1);

        }else{

            for (int i : answer) {
                System.out.println(i);
            }
        }

    }
    public static void BFS(int X){



    }
}
