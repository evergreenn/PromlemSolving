package 이코테.DFSBFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class 음료수얼려먹기2 {
    //8:00~
    public static int[][] map;
    public static void main(String[] args) {
       Scanner s= new Scanner(System.in);

       int N=s.nextInt();
       int M=s.nextInt();
       map=new int[N][M];
       s.nextLine();
       for(int i=0;i<N;i++){
           map[i]= Arrays.stream(s.nextLine().split(""))
                   .mapToInt(Integer::parseInt)
                   .toArray();
       }
       int cnt=0;
       for(int i=0;i<N;i++){
           for(int j=0;j<M;j++){
               if(map[i][j]==0){
                   cnt++;

                   dfs(new Node(i,j));
               }
           }
       }
        System.out.println(cnt);

    }
    public static void dfs(Node first){
        int x= first.x;
        int y= first.y;
        map[x][y]=2;

        int[] dx={-1,0,+1,0};
        int[] dy={0,+1,0,-1};

        for(int i=0;i<4;i++){
            int nx=x+dx[i];
            int ny=y+dy[i];

            if(nx<0||ny<0||nx>=map.length||ny>=map[0].length){
                continue;
            }
            if(map[nx][ny]==1||map[nx][ny]==2){
                continue;
            }

            map[nx][ny]=2;
            dfs(new Node(nx,ny));

        }


    }
    static class Node{
        int x;
        int y;
        public Node(int x,int y){
            this.x=x;
            this.y=y;

        }
    }
}
