package 이코테.DFSBFS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 경쟁적전염 {
    public static int[][] map;
    public static ArrayList<Virus> virusArrayList = new ArrayList<Virus>();
    public static Queue<Virus> queue = new LinkedList<>();
    public static int S;
    public static int N;

    //6:48~
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        N = s.nextInt();
        int K = s.nextInt();
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int virus = s.nextInt();
                //실수한 부분 저장해야되는데 안함.
                map[i][j]=virus;
                if (virus != 0) {
                    virusArrayList.add(new Virus(i, j, virus,0));
                }
            }
        }
        Collections.sort(virusArrayList);

        S = s.nextInt();
        int X = s.nextInt();
        int Y = s.nextInt();
        //매우중요, 모든 바이러스를 시작점으로 (순차적으로) BFS의 큐에 넣음.
        for (int i = 0; i < virusArrayList.size(); i++) {
            Virus virus = virusArrayList.get(i);
            queue.add(virus);

        }

        //또한 시간을 증가하는것을 직전 큐에서 나온 바이러스의 시간 +1 을 해줌 -> 마치 BFS의 최단거리문제 처럼 풀이

        bfs();

        //주의 마지막은 -1 해줘야함, 1부터 시작이므로.
        System.out.println(map[X - 1][Y - 1]);

    }

    public static void bfs() {

        int[] dx = {-1, 0, +1, 0};
        int[] dy = {0, +1, 0, -1};



        while (!queue.isEmpty()) {

            Virus remove = queue.remove();
            if (remove.sec == S) {
                break;
            }

            int x= remove.x;
            int y= remove.y;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
                    continue;
                }

                if (map[nx][ny] == 0) {
                    map[nx][ny] = remove.num;
                    //매우 중요, 마치 최단거리를 BFS로 풀때처럼, 직전에 나온 초 +1 한 값을 넣음.
                    queue.add(new Virus(nx,ny, remove.num, remove.sec+1));
                }

            }

        }

    }

    public static class Virus implements Comparable<Virus> {
        int x;
        int y;
        int sec;
        int num;

        public Virus(int x, int y, int num,int sec) {
            this.x = x;
            this.y = y;
            this.num = num;
            this.sec=sec;

        }

        @Override
        public int compareTo(Virus o) {

            return this.num-o.num;

        }
    }

}
