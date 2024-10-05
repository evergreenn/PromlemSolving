package 이코테.implementation;

import java.util.Arrays;
import java.util.Scanner;

//2:29 ~
public class 게임개발2 {
    public static int N;
    public static int M;
    public static int[][] map;
    public static int x;
    public static int y;
    public static int direction;

    public static void main(String[] args){

        Scanner s=new Scanner(System.in);

        N=s.nextInt();
        M=s.nextInt();
        x=s.nextInt();
        y=s.nextInt();

        direction=s.nextInt();

        map=new int[N][M];
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                map[i][j]=s.nextInt();

            }
        }
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                System.out.print(map[i][j]+" ");

            }
            System.out.println();
        }

        map[x][y]=2;
        simulation();


    }
    public static void simulation(){
        int cnt=1;
        int turncnt=0;


        int[] dx={-1,0,+1,0};
        int[] dy={0,+1,0,-1}; //상우하좌
        //0 1 2 3 ->direction으로 인덱스 사용

        int nx;
        int ny;


        while(true){
            if(turncnt==4){
                //4면이 모두 못가면 빼기

                nx= x-dx[direction];
                ny=y-dy[direction];
                if(map[nx][ny]==1){
                    break;
                }

                x=nx;
                y=ny;
                turncnt=0;
            }
            turnleft();
            turncnt++;
            nx=x+dx[direction];
            ny=y+dy[direction];

            if(nx<0||ny<0||nx>= map.length||ny>=map[0].length){
                continue;
            }
            if(map[nx][ny]!=0){
                continue;
            }
            //비로소 이동
            x=nx;
            y=ny;
            map[x][y]=2;
            cnt++;
            turncnt=0;

        }
        System.out.println(cnt);

    }
    public static void turnleft(){
        direction-=1;
        if(direction<0){
            direction=3;
        }

    }
    public static class Node{
        int x;
        int y;
        int d;
        public Node(int x,int y, int direction){
            this.x=x;
            this.y=y;
            this.d=direction;
        }
    }
}
