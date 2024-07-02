package 이코테.DFSBFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 특정거리의도시찾기 {
    public static ArrayList<ArrayList<Node>> list = new ArrayList<ArrayList<Node>>();
    //4:17~5:40
    public static void main(String[] args) {

        Queue<Node> queue = new LinkedList<>();
        Scanner s = new Scanner(System.in);
        ArrayList<Node> answer = new ArrayList<>();




        int N = s.nextInt();
        int M = s.nextInt();
        int K = s.nextInt();
        int X = s.nextInt();
        int[] d=new int[N+1];

        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
            d[i]=-1;
        }

        for (int i = 0; i < M; i++) {
            int A = s.nextInt();
            int B=s.nextInt();

            list.get(A).add(new Node(B,0));
        }

        queue.add(new Node(X,0));
        d[X]=0;
        int cnt=0;
        while (!queue.isEmpty()) {
            Node remove = queue.remove();
            //매우 중요, 카운트 하는 위치
            //큐에서 빠져나온뒤에 +1해줘야 최단거리가 됨.
            cnt+=1;

            if (remove.cnt == K) {

                answer.add(remove);
            }


            for (int i = 0; i < list.get(remove.num).size(); i++) {
                Node node = list.get(remove.num).get(i);
                if(d[node.num]==-1){
                    d[node.num]=d[remove.num]+1;
                    node.cnt=d[node.num];
                    queue.add(node);
                }
            }
        }
        Collections.sort(answer);

        if (answer.isEmpty()) {
            System.out.println(-1);

        } else {
            for (Node node : answer) {
                System.out.println(node.num);
            }
        }
    }
    static class Node implements Comparable<Node>{
        int num;
        int cnt=0;
        public Node(int num,int cnt){
            this.num=num;
            this.cnt=cnt;
        }

        @Override
        public int compareTo(Node other) {
            return this.num-other.num;
        }
    }
}
