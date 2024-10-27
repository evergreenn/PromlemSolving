package 이코테.DFSBFS;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class 연구소조합풀이법 {

    public static ArrayList<Node> empty = new ArrayList<>();
    public static int N;
    public static int M;
    public static int[][] map;
    public static boolean[] visit;

    public static ArrayList<Node> virus = new ArrayList<>();
    public static ArrayList<ArrayList<Node>> combination = new ArrayList<ArrayList<Node>>();
    //6:00~
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);

         N = s.nextInt();
         M = s.nextInt();

         map=new int[N][M];


        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int input=s.nextInt();
                map[i][j]=input;
                if (input == 0) {
                    empty.add(new Node(i, j));
                    continue;
                }
                if (input == 2) {
                    virus.add(new Node(i, j));
                    continue;
                }
            }

        }
        visit = new boolean[empty.size() + 1];
        Arrays.fill(visit,false);

        int max=-(int)1e9;
        int[] now=new int[3];
        Arrays.fill(now, -1);
        combi(now,0, empty.size(),0);
//        System.out.println("조합목록");
//        for (int i = 0; i < combination.size(); i++) {
//
//            System.out.println(combination.get(i).toString());
//        }



        for (int i = 0; i < combination.size(); i++) {
            int[][] temp=new int[N][M];
            for (int c = 0; c < map.length; c++) {

                for (int k = 0; k < map[c].length; k++) {
                    temp[c][k]= map[c][k];
//                    System.out.print(temp[c][k]+" ");
                }
            }

            //한 조합별로 벽 세우기
            for (int j = 0; j < combination.get(i).size(); j++) {
                Node node = combination.get(i).get(j);

                temp[node.x][node.y]=1;
            }

            for (Node virus : virus) {

                dfs(virus.x, virus.y,temp);

            }
            max=Math.max(count(temp),max);


        }
        System.out.println(max);



    }

    public static int count(int[][] tmp) {
        int cnt=0;
        for(int i=0;i<tmp.length;i++){
            for (int j = 0; j < tmp[i].length; j++) {
                if (tmp[i][j] == 0) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public static void dfs(int x, int y,int[][] tmp) {
        //매우 중요, 시뮬레이션 처럼, 시작 점을 "이동" 하는 것이 아님.
        //시작점은 무조건 고정이고, nx,ny룰 큐에 넣거나 재귀호출 하는 것임.
        //이유: 재귀 호출이 끝나고 return 되었을때, 처음 시작점인 x,y 값이
        //변화해 버림.


        int[] dx={-1,0,+1,0};//상 우 하 좌
        int[] dy={0,+1,0,-1};

        for (int i = 0; i < 4; i++) {
            int nx=x+dx[i];
            int ny=y+dy[i];

            if(nx<0||ny<0||nx>=N||ny>=M){
                continue;
            }
            if (tmp[nx][ny] == 0) { //빈방일 경우에만 방문.

                tmp[nx][ny]=2;

                dfs(nx,ny,tmp);
            }

        }
        return;


    }
    public static void combi(int[] now, int start, int end, int depth){
        //start ~ end 까지의 범위에서 3개를 뽑는 조합.(depth는 뽑는 조합의 인덱스임)
        if (depth == now.length) {
            //3개를 다 뽑았으면 저장 후 return,

            ArrayList<Node> temp = new ArrayList<>();
            for (int i = 0; i < now.length; i++) {
                temp.add(empty.get(now[i]));
            }
            combination.add(temp);

            return;
        }

        for (int i = start; i < end; i++) {
            if (!visit[i]) {
                visit[i]=true;
                now[depth] = i;
                combi(now,i+1,end,depth+1);
                visit[i]=false;
            }
        }
    }
    static class Node{
        int x;
        int y;
        public Node(int x,int y){
            this.x=x;
            this.y=y;
        }
        @Override
        public String toString(){
            return "( "+x+" )"+"( "+y+" )";

        }
    }
}
