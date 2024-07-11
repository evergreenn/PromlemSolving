package 이코테.DFSBFS;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class 블록이동하기 {
    //9:48~12:14 2시간 30분 풀이.
    public int solution(int[][] board) {
        int answer = 0;
        int N=board.length;

        int[][] newboard=new int[N+2][N+2];

        for(int i=0;i<newboard.length;i++){
            for(int j=0;j<newboard[i].length;j++){
                newboard[i][j]=1;
            }
        }
        for(int i=1;i<board.length+1;i++){
            for(int j=1;j<board[i-1].length+1;j++){
                newboard[i][j]=board[i-1][j-1];
            }
        }

        Node pos=new Node(1,1,1,2,0);
        ArrayList<Node> visited=new ArrayList<>();
        Queue<Node> queue=new LinkedList<>();

        visited.add(pos);
        queue.add(pos);
        while(!queue.isEmpty()){
            pos=queue.remove();
            if((pos.x1==N&& pos.y1==N)|| (pos.x2==N&& pos.y2==N)){
                answer=pos.distance;
                return answer;
            }

            ArrayList<Node> possiblepos=getNextPos(pos,newboard);

            for(int i=0;i<possiblepos.size();i++){
                pos=possiblepos.get(i);
                boolean check=true;

                for(int j=0;j<visited.size();j++){
                    Node visitnode=visited.get(j);

                    if((pos.x1==visitnode.x1)&&(pos.y1==visitnode.y1)&&(pos.x2==visitnode.x2)&&(pos.y2==visitnode.y2)){
                        check=false;
                        break;
                    }
                }
                if(check){
                    queue.add(pos);
                    visited.add(pos);
                }
            }

        }

        return answer;
    }

    public ArrayList<Node> getNextPos(Node pos,int[][] board){

        ArrayList<Node> possible=new ArrayList<>();
        int x1=pos.x1;
        int y1=pos.y1;
        int x2=pos.x2;
        int y2=pos.y2;
        int distance=pos.distance;

        int[] dx={-1,0,+1,0};
        int[] dy={0,+1,0,-1};

        //회전하지않고 상하좌우 움직일수 있는 경우
        for(int i=0;i<dx.length;i++){
            int nx1=x1+dx[i];
            int ny1=y1+dy[i];
            int nx2=x2+dx[i];
            int ny2=y2+dy[i];

            if(board[nx1][ny1]==1||board[nx2][ny2]==1){
                continue;
            }
            possible.add(new Node(nx1,ny1,nx2,ny2,distance+1));

        }

        //수직으로 서있는 경우 회전
        int[] vertic={+1,-1};

        if(y1==y2){
            for(int i=0;i<2;i++){
                int ny1=y1+vertic[i];
                int ny2=y2+vertic[i];

                if(board[x1][ny1]==0 &&board[x2][ny2]==0){
                    possible.add(new Node(x1,y1,x1,ny1,distance+1));
                    possible.add(new Node(x2,y2,x2,ny2,distance+1));
                }
            }
        }
        //수평으로 있는 경우 회전
        if(x1==x2){
            for(int i=0;i<2;i++){
                int nx1=x1+vertic[i];
                int nx2=x2+vertic[i];

                if(board[nx1][y1]==0 &&board[nx2][y2]==0){
                    possible.add(new Node(x1,y1,nx1,y1,distance+1));
                    possible.add(new Node(x2,y2,nx2,y2,distance+1));
                }
            }
        }
        return possible;

    }
    class Node{
        int x1;
        int y1;
        int x2;
        int y2;
        int distance;

        public Node(int x1,int y1,int x2,int y2,int distance){
            this.x1=x1;
            this.y1=y1;
            this.x2=x2;
            this.y2=y2;
            this.distance=distance;
        }
    }
}

