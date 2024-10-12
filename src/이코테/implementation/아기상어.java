package 이코테.implementation;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class 아기상어 {
    //7:42 ~ 9: 29
    public static int[][] map;
    public static int[][] visited;
    public static LinkedList<Node> queue = new LinkedList<>();
    public static int size=2;
    public static int shark_x;
    public static int shark_y;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int N = s.nextInt();
        map=new int[N][N];
        visited=new int[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(visited[i], -1);
        }



        int time=0;
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                map[i][j]=s.nextInt();
                if (map[i][j] == 9) {
                    shark_x=i;
                    shark_y=j;
                }
            }
        }
        int eatcount=0;
        while (true){
            target fish = bfs(shark_x, shark_y);

            if(fish.distance==(int) 1e9){
                break;
            }


            time+= fish.distance;
            map[shark_x][shark_y]=0;
            map[fish.x][fish.y]=0;
            shark_y= fish.y;
            shark_x= fish.x;
            //먹은곳은 0으로 돌리기.
            //기존에 시작할대 상어가 있었던 곳 0으로 돌리기
            eatcount++;
            if(size==eatcount){
                size++;
                eatcount=0;
            }


            for (int i = 0; i < N; i++) {
                Arrays.fill(visited[i], -1);
            }

        }
        System.out.println(time);
    }
    public static target bfs(int x,int y){
        int min=(int)1e9;
        int min_x=0;
        int min_y=0;
        queue.add(new Node(x,y));
        visited[x][y]=0;

        int[] dx={-1,0,1,0}; //상 우 하 좌
        int[] dy={0,+1,0,-1};
        while(!queue.isEmpty()){
            Node output=queue.removeFirst();

            int nowx= output.x;
            int nowy= output.y;

            for(int i=0;i<4;i++){

                int nx = nowx + dx[i];
                int ny = nowy + dy[i];

                if (nx < 0 || ny < 0 || nx >= map.length || ny >= map.length) {
                    continue;
                }
                if(map[nx][ny]>size){
                    continue;
                }
                if (visited[nx][ny]!=-1) {
                    continue;
                }
                queue.add(new Node(nx,ny));
                visited[nx][ny]=visited[nowx][nowy]+1;

                if(map[nx][ny]!=0&& map[nx][ny]<size){
                    //0이 아닌 경우(물고기인 경우)
                    //방문 가능하므로 최단거리 업데이트

                    if (min > visited[nx][ny]) {
                        //확실하게 거리가 더 작은 경우 (해당 물고기 먹음)
                        min=visited[nx][ny];
                        min_x=nx;
                        min_y=ny;

                    }else if(min==visited[nx][ny]){
                        //거리가 같아서 따져봐야하는 경우
                        if(min_x>nx){ //위에 있으면 업데이트
                            min_x=nx;
                            min=visited[nx][ny];
                            min_y=ny;
                        }else if(min_x==nx){
                            //위에 자리가 같으면 왼쪽에 있으면 업데이트
                            if(min_y>ny){
                                min_x=nx;
                                min=visited[nx][ny];
                                min_y=ny;
                            }
                        }

                    }
                }

            }

        }
        return new target(min_x, min_y, min);



    }
    public static class Node{

        int x;
        int y;
        public Node(int x,int y){
            this.x=x;
            this.y=y;
        }
    }
    public static class target{
        int x;
        int y;
        int distance;
        public target(int x,int y, int distance){
            this.x=x;
            this.y=y;
            this.distance=distance;
        }
    }
}
