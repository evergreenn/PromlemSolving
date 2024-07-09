package 이코테.DFSBFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 인구이동 {
    //문제풀이 핵심 : 전염시키는것과 똑같음. 배열순회하면서 노드 하나하나씩 BFS의 시작값으로 탐색
    // 각 BFS로 탐색하며 연합의 결성조건이 되면 연합에 추가 -> 방문에 연합의 인덱스 표시
    // 첫 번째 배열 순회시, 이미 연합이 있다면 pass(방문처리)
    // 만약 더이상 인구이동이 없을 경우, index의 값은 N*N 이 되므로 break.

    static int[][] map;
    static int[][] union;
    static int N;
    static int L;
    static int R;
    static Queue<Node> queue = new LinkedList<>();


    //8:45 ~ 9: 28 (11: 00)
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        N = s.nextInt();
         L = s.nextInt();
         R = s.nextInt();
        map = new int[N][N];
        union=new int[N][N];


        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int input = s.nextInt();
                map[i][j] = input;
            }
        }
        int cnt=0;
        while (true) {
            int index=1;
            //첫 시작값 방문 처리, DFS든 BFS든 첫 시작값은 넣고 시작함.
            //단 DFS는 시뮬레이션이 아니기에 최초 x 가 변화하면 안됨.

            //매번 초기화
            union=new int[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (union[i][j] == 0) { //방문 안한 곳만 처리.

                        bfs(i,j,index);
                        index++;
                    }
                }
            }
            if ((index-1) == N * N) {
                break;
            }

            cnt++;



        }
        System.out.println(cnt);

    }


    public static void bfs(int x,int y,int index) {
        ArrayList<Node> unionArray = new ArrayList<>();



        //시작 값 넣기
        queue.add(new Node(x, y));
        unionArray.add(new Node(x, y));
        union[x][y]=index;

        int sum=0;
        sum+=map[x][y];

        int[] dx = {-1, 0, +1, 0,}; //상 하 좌우
        int[] dy = {0, +1, 0, -1};

        while (!queue.isEmpty()) {
            Node remove = queue.remove();

             x= remove.x;
              y= remove.y;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
                    continue;
                }
                if (union[nx][ny]!=0) {
                    //이미 소속이 있는 경우 (pass )
                    continue;
                }
                int people = map[x][y];
                int others = map[nx][ny];

                if (Math.abs(people - others) >= L && Math.abs(people - others) <= R) {
                    union[nx][ny]=index;
                    sum += map[nx][ny];

                    unionArray.add(new Node(nx, ny));
                    queue.add(new Node(nx, ny));
                }

                }
            }


        for (Node union : unionArray) {
            map[union.x][union.y]=(sum/unionArray.size());
        }

        }


    static class Node{
        int x;
        int y;

        public Node(int x, int y) {
            this.x=x;
            this.y=y;
        }
    }

    static void printmap() {
        System.out.println("==========================");

        for (int i = 0; i < union.length; i++) {
            System.out.println(Arrays.toString(union[i]));

        }
    }

}
