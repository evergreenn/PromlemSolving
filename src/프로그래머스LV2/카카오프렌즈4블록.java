package 프로그래머스LV2;

import java.util.ArrayList;
import java.util.Arrays;

public class 카카오프렌즈4블록 {
    public static ArrayList<Square> list=new ArrayList<Square>();
    public static int row;
    public static int col;
    public static String[][] map;
    public static int answer=0;

    public int solution(int m, int n, String[] board) {
        //m 행(높이), n 열(폭)


        row=m;
        col=n;
        map=new String[row][col];
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                map[i][j]=board[i].charAt(j)+"";
            }
        }
//         printmap();

//         System.out.println("===================");

        detection();
        while(!list.isEmpty()){

            for(Square square : list){

                makeZero(square.x1,square.y1);
                makeZero(square.x2,square.y2);
                makeZero(square.x3,square.y3);
                makeZero(square.x4,square.y4);

            }
            // printmap();
            // System.out.println("===================");

            down();
            // printmap();
            // System.out.println("===================");
            list.clear();
            detection();


        }
        return answer;
    }
    public void makeZero(int x,int y){
        if(!map[x][y].equals("0")){
            System.out.println(x+" "+y);
            answer++;
        }
        map[x][y]="0";


    }
    public void detection(){
        for(int i=0;i<row-1;i++){
            for(int j=0;j<col-1;j++){
                if(map[i][j].equals("0")){
                    continue;
                }
                if(map[i][j].equals(map[i][j+1])&&map[i][j].equals(map[i+1][j])
                        &&map[i][j].equals(map[i+1][j+1])){
                    list.add(new Square(i,j));
                }
            }
        }


    }
    public void down(){
        for(int i=0;i<row-1;i++){
            for(int j=0;j<col;j++){
                if(map[i][j].equals("0")){
                    continue;
                }
                if(map[i+1][j].equals("0")){
                    map[i+1][j]=map[i][j];
                    map[i][j]="0";
                    i=0;
                    j=0;
                }
            }
        }

    }
    public void printmap(){

        for(int i=0;i<map.length;i++){
            System.out.println(Arrays.toString(map[i]));
        }
    }
    static class Square{

        int x1;
        int y1;
        int x2;
        int y2;
        int x3;
        int y3;
        int x4;
        int y4;
        public Square(int x1,int y1){

            this.x1=x1;
            this.y1=y1;

            this.x2=x1;
            this.y2=y1+1;

            this.x3=x1+1;
            this.y3=y1;

            this.x4=x1+1;
            this.y4=y1+1;


        }
        @Override
        public String toString(){

            return "["+x1+" "+x2+" "+x3+" "+x4+"]";
        }
    }
}
