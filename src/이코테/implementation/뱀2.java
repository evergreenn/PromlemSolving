package 이코테.implementation;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

public class 뱀2 {
    public static int[][] map;
    public static int direction=1;
    public static int snake_x=0;
    public static int snake_y=0;
    public static HashMap<Integer, String> order = new HashMap<>();
    public static LinkedList<Node> queue = new LinkedList<Node>();
    // 9: 49 ~
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int N=s.nextInt();
        map = new int[N][N];
        map[0][0]=2; //현재 뱀의 위치 2
        queue.add(new Node(0, 0));
        //위에서부터 1로 시작


        int K=s.nextInt();
        for (int i = 0; i < K; i++) {
            int x=s.nextInt();
            int y=s.nextInt();

            map[x-1][y-1]=1;
            //사과 입력
        }
        int L=s.nextInt();
        for(int i=0;i<L;i++){
            int time=s.nextInt();
            String d=s.next();
            order.put(time,d);
        }
//        for (Entry<Integer, String> t :order.entrySet()) {
//            System.out.println(t.getKey() + " : " + t.getValue());
//        }

        int cnt=0;
        // 인덱스, 0 : 상, 1 : 우, 2: 하, 3 : 좌
        int[] dx={-1,0,+1,0};
        int[] dy={0,+1,0,-1};
        while(true){

            int nx=snake_x+dx[direction];
            int ny = snake_y + dy[direction];
            //한칸이동(시간증가)
            cnt++;
//            System.out.println("이동전=============================================");
//            printmap();
            if (nx < 0 || ny < 0 || nx >= map.length || ny >= map.length) {
                //벽에 부딪힐 경우
                break;
            }
            if(map[nx][ny]==2){
                //자기자신과 부딪힐 경우
                break;
            }
            if(map[nx][ny]==1){
                //사과를 먹은 경우
                queue.add(new Node(nx,ny));// 실수주의 !! 큐에 넣는것은 이동후 좌표(즉 다음에 이동한 머리부분)을 넣는 것임.
                //아직 뱀이 이동 안했으므로, 현재값인 snake_x, snake_y 를 넣으면 안됨.
                //현재값을 넣으면, 도돌이표 될 뿐임. queue.add(new Node(snake_x,snake_y)) 이렇게 넣으면 안됨.

                snake_x=nx;
                snake_y=ny;
                map[nx][ny]=2;

            }else{
                //사과를 먹지 않은 경우


                Node output= queue.removeFirst();
                map[output.x][output.y]=0;
//                System.out.println(output.x+" : "+ output.y +"삭제");


                queue.add(new Node(nx, ny));

                snake_x=nx;
                snake_y=ny;
                map[nx][ny]=2;
            }

            if(order.containsKey(cnt)){
                String new_direction=order.get(cnt);
                order.remove(cnt);
                if(new_direction.equals("D")){
                    direction=(direction+1)%4;
                }else if(new_direction.equals("L")){
                    direction-=1;
                    if(direction<0){
                        direction=3;
                    }
                }
            }
//            System.out.println("이동후=============================================");
//            printmap();
        }
        System.out.println(cnt);

    }
    public static void printmap(){
        for (int i = 0; i < map.length; i++) {
            System.out.println(Arrays.toString(map[i]));
        }

    }
    public static class Node{
        int x;
        int y;
        public Node(int x, int y){
            this.x=x;
            this.y=y;
        }
    }
}
