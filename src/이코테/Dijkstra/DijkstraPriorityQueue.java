package 이코테.Dijkstra;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

class Node implements Comparable<Node>{
    int target_node; //start(특정 한 노드에서 ) 해당 노드로 가는
    int distance;// 거리(비용)

    public Node(int target_node, int distance) {
        this.distance=distance;
        this.target_node = target_node;
    }

    @Override
    public int  compareTo(Node other) { // 디폴트로 내림차순 정렬방식을 그대로 따라감
        // 본인 - 비교대상
        return this.distance-other.distance;
    }
}
public class DijkstraPriorityQueue {
    //다익스트라 이해가 안되면 노트에 그려보면서 이해하자.
    static int N;
    static int M;
    static ArrayList<ArrayList<Node>> list;
    static PriorityQueue<Node> heap;
    static int[] distance_arr;
    static Boolean[] visit;

    static int start;


    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        N = s.nextInt(); //노드의 갯수
        M = s.nextInt(); // 간선의 갯수

        list = new ArrayList<>();
        //자바의 2차원 리스트 초기화 방법 주의
        heap = new PriorityQueue<>();

        distance_arr = new int[N + 1];
        Arrays.fill(distance_arr,Integer.MAX_VALUE);
        visit = new Boolean[N + 1]; //사실 필요는 없음. 이미 갱신이 이루어졌는가로 판단 가능 (아래 조건 참고)
        Arrays.fill(visit,false);


        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<Node>());
        }

        start=s.nextInt();// 시작값
        heap.add(new Node(start,0));
        distance_arr[start]=0;
        //시작값 추가 (start 노드에서 start 로 가는 값은 0임)

        s.nextLine();
        for (int i = 0; i < M; i++) {
            int[] input = Arrays.stream(s.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            int node = input[0];
            int target = input[1];
            int distance = input[2];

            list.get(node).add(new Node(target,distance));
            heap.add(new Node(target,distance));
        }

        dijkstra(start);

        System.out.println(Arrays.toString(distance_arr));


    }
    public static void dijkstra(int start) {
        while (!heap.isEmpty()) {
            Node node = heap.remove();

            int distance = node.distance;
            int now = node.target_node;

            //방문( 큐에 들어갔던 것인지 체크)
            //만약 현재 노드까지의 거리가 더 크다면 갱신이 이루어 진 것이므로 (무한대가 아니므로) 방문 할 필요 없음
            //시간복잡도 E (간선의 갯수) 만 카운트 되도록 가지치기. 아래의 코드가 없어도 정답은 똑같음. 단지 복잡도가 늘어남.
            if (distance > distance_arr[now]) {
                continue;
            }


            //현재 노드에서 연결된 노드로의 거리 계산(만약 최솟값이라면 갱신후 큐에 삽입)
            for (int i = 0; i < list.get(now).size(); i++) {
                Node linked_node = list.get(now).get(i);
                int cost= distance_arr[now]+ linked_node.distance;

                if (cost < distance_arr[linked_node.target_node]) {
                    distance_arr[linked_node.target_node]=cost;

                    heap.add(linked_node);
                }
            }
        }



    }

}
/*입력 예시

6 11
1
1 2 2
1 3 5
1 4 1
2 3 3
2 4 2
3 2 3
3 6 5
4 3 3
4 5 1
5 3 1
5 6 2
 */
