package 프로그래머스LV2;

import java.util.Arrays;
import java.util.LinkedList;

public class 게임맵최단거리 {
    public static LinkedList<Node> queue=new LinkedList<Node>();
    public static int[][] maps;
    public static int rowSize;
    public static int colSize;
    public static int[][] dp;
    public static int min=-1;


    public int solution(int[][] maps) {
        int answer = 0;
        this.maps=maps;
        rowSize=maps.length;
        colSize=maps[0].length;

        dp=new int[rowSize][colSize];
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i],-1);
        }



        bfs(new Node(0,0));
        answer=dp[rowSize-1][colSize-1];

        // printmap();
        // printmap2();

        return answer;
    }

    public void printmap(){

        for(int i=0;i<maps.length;i++){
            System.out.println(Arrays.toString(maps[i]));

        }
    }
    public void printmap2(){

        for(int i=0;i<maps.length;i++){
            System.out.println(Arrays.toString(dp[i]));

        }
    }



    public void bfs(Node first){

        queue.add(first);
        dp[first.x][first.y]=1;


        while(!queue.isEmpty()){

            Node now=queue.removeFirst();
            maps[now.x][now.y]=2;


            int dx[]={-1,0,+1,0};
            int dy[]={0,+1,0,-1};

            for(int i=0;i<4;i++){

                int nx=now.x+dx[i];
                int ny=now.y+dy[i];
                if(nx<0||ny<0||nx>=rowSize||ny>=colSize){
                    continue;
                }
                if(maps[nx][ny]!=1){
                    continue;
                }

                queue.add(new Node(nx,ny));
                maps[nx][ny]=2;
                dp[nx][ny]=dp[now.x][now.y]+1;



            }


        }



    }
}
class Node{

    int x;
    int y;

    public Node(int x,int y){
        this.x=x;
        this.y=y;
    }
}
