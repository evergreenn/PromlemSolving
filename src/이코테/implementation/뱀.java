package 이코테.implementation;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

public class 뱀 {
    public static int[][] map;
    public static HashMap<Integer,String> direction=new HashMap<>();
    public static LinkedList<Point> queue=new LinkedList<>();
    public static int direct;
    public static void main(String[] args) {
        //12:31~ 1:11
        Scanner s = new Scanner(System.in);

        int N = s.nextInt();
        map =new int[N+1][N+1];

        int K = s.nextInt();
        s.nextLine(); //엔터 버퍼 제거
        for (int i = 0; i < K; i++) {
            String[] input = s.nextLine().split(" ");
            int row = Integer.valueOf(input[0]);//행
            int col = Integer.valueOf(input[1]);//열
            map[row][col]=2;//사과입력
        }
        int L = s.nextInt();
        s.nextLine();
        for (int i = 0; i < L; i++) {
            String[] input = s.nextLine().split(" ");
            int sec = Integer.valueOf(input[0]);//초
            String direct = input[1];//방향
            direction.put(sec,direct);
        }
        //주의 무조건 dx, dy 은 "행 -> 열 " 순서임. 즉 dx 는 행 임.
        int[] dx={-1,0,+1,0}; //상,우, 하, 좌 [ 행 ]
        int[] dy={0,+1,0,-1};//상,우,하,좌 [ 열 ]
        direct=1; //초기 뱀의 방향은 우
        int cnt=0;
        //뱀의 초기 위치.
        int x=1;
        int y=1;
        map[1][1]=1;// 초기 위치 방문표시
        queue.add(new Point(1,1));

        while (true) {
            int nx=x+dx[direct];
            int ny=y+dy[direct];

            cnt++;
            if(nx<1 || nx>N || ny<1 || ny>N){
                break;
            }
            if(map[nx][ny]==1){
                break;
            }

            if (map[nx][ny] == 2) {
                //사과라면 꼬리 삭제안하고 방문처리
                queue.add(new Point(nx,ny));
                map[nx][ny]=1;
                x=nx;
                y=ny;
            }else {
                Point removeFirst = queue.removeFirst();
                map[removeFirst.x][removeFirst.y]=0; //꼬리 방문해제
                queue.add(new Point(nx,ny));
                map[nx][ny]=1; //새롭게 이동할 곳 방문처리
                x=nx;
                y=ny;
            }

            if (direction.containsKey(cnt)) {
                String order = direction.get(cnt);
                if(order.equals("D")){
                    //시계방향 회전
                    direct=(direct+1)%4;
                }else if(order.equals("L")){
                    //반시계방향 회전
                    direct-=1;
                    if(direct<0){
                        direct=3;
                    }
                }

            }
        }
        System.out.println(cnt);
    }

}
class Point{
    int x;
    int y;
    public Point(int x,int y){
        this.x=x;
        this.y=y;
    }
}
