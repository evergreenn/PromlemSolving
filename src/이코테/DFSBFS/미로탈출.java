package 이코테.DFSBFS;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 미로탈출 {
    static int[][] arr;

    static int N;
    static int M;
    static int[] dx={-1,+1,0,0,};
    static int[] dy={0,0,-1,+1};
    static Queue<node> queue=new LinkedList<>();
    public static void main(String[] args) {
        // 1,1 N,M 으로 카운트
        //BFS 는 가까운것을 우선적으로 탐색 = 최종 도착지점까지의 최단거리 구하기 가능
        // 해당 값의 이전 cost 에서 1 더하기
        Scanner s = new Scanner(System.in);

         N=s.nextInt();
         M=s.nextInt();
         s.nextLine();

        arr = new int[N][M];


        for (int i = 0; i < N; i++) {
            arr[i] = Arrays.stream(s.nextLine().split(""))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        bfs(0,0);
        System.out.println(arr[N-1][M-1]);

        for (int[] a : arr) {
            System.out.println(Arrays.toString(a));
        }

    }
    public static void bfs(int x, int y) {
        int nx,ny;
        queue.add(new node(x,y));

        while (!queue.isEmpty()) {
            node cur = queue.remove();
            x = cur.x;
            y = cur.y;

            for (int i = 0; i < 4; i++) {
                nx = x + dx[i];
                ny = y + dy[i];
                if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
                    continue;
                }
                if (arr[nx][ny] == 0) {
                    continue;
                }
                if (arr[nx][ny] == 1) {
                    queue.add(new node(nx, ny));
                    arr[nx][ny]=arr[x][y]+1; //주의 큐에 넣을때, 최솟값 처리 해줘야 가까운 순서를 같은 레벨로 횟수가 처리됨.
                }

            }
        }

    }

    static class node {
        public node(int x, int y) {
            this.x=x;
            this.y=y;
        }

        int x;
        int y;
    }
}
