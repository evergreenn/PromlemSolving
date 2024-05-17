package 이코테.Dijkstra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Dijkstraheap {
    static int N;
    static int M;
    static ArrayList<ArrayList<Node1>> linked;
    static PriorityQueue<Node1> queue;// 각 단계마다 해당 타겟까지의 최단거리를 가지는 노드부터 선택

    static int[] d_array; //특정 노드로부터의 최단거리를 저장하는 배열

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        N = s.nextInt(); //노드의 수
        M = s.nextInt(); // 간선의 수
        linked = new ArrayList<>();
        queue = new PriorityQueue<>();
        int start= s.nextInt();
        d_array=new int[N+1];
        Arrays.fill(d_array, Integer.MAX_VALUE);
        s.nextLine();

        for (int i = 0; i <= N; i++) {
            linked.add( new ArrayList<>()); //실수주의 초기화 시켜야함.
        }

        for (int i = 0; i < M; i++) {
            int[] input = Arrays.stream(s.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int node =input[0]; //해당 노드로부터
            int target = input[1]; //해당 타겟 까지의
            int distance=input[2]; //거리
            linked.get(node).add(new Node1(target,distance)); // 인접 리스트에 삽입
        }
        //최초 시작 노드 삽입
        queue.add(new Node1(start, 0));
        d_array[start]=0;

        dijkstra(start);
        System.out.println(Arrays.toString(d_array));

    }

    public static void dijkstra(int start) {
        while (!queue.isEmpty()) {
            Node1  now= queue.remove();//해당 타겟까지의 가장 작은 거리를 가지는 노드 반환
            int now_index= now.target;
            int distance= now.distance;

            if (d_array[now_index] < distance) {
                continue;
            }

            for (int i = 0; i < linked.get(now_index).size(); i++) {
                Node1 linked_node = linked.get(now_index).get(i);
                int cost = d_array[now_index]+ linked_node.distance;// 현재 방문한 노드까지의 비용과 타겟 노드까지의 거리의 합

                if (d_array[linked_node.target] > cost) { // 새롭게 연결된 노드까지의 합이 더 작을경우 갱신
                    d_array[linked_node.target]= cost;
                    queue.add(linked_node);
                }

            }


        }

    }
}
class Node1 implements Comparable<Node1>{
    int target;
    int distance;
    public Node1(int target, int distance){
        this.target=target;
        this.distance=distance;

    }

    @Override
    public int compareTo(Node1 oter) {
        return this.distance-oter.distance;
    }
}
