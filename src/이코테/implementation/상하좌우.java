package 이코테.implementation;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class 상하좌우 {
    public static void main(String[] args){
        //맨 왼쪽 위가 1,1 로 시작함
        Scanner s = new Scanner(System.in);

        int N = s.nextInt();
        s.nextLine();

        int[][] arr=new int[N+1][N+1];

        int[] dx={-1,0,+1,0}; //상 우 하 좌 행(높이)
        int[] dy={0,+1,0,-1} ;//상 우 하 좌  열(넓이)

        HashMap<String, Integer> order_map = new HashMap<>();

        order_map.put("U",0);
        order_map.put("R",1);
        order_map.put("D",2);
        order_map.put("L",3);

        int x= 1, y= 1 ;
        int nx,ny;
        String[] orders = s.nextLine().split(" ");

        for (int i = 0; i < orders.length; i++) {
            String order=orders[i];
            int index=order_map.get(order);

            nx=x+dx[index];
            ny=y+dy[index];

            if(nx<1 || nx>N || ny <1 || ny >N){
                continue;
            }
            x=nx;
            y=ny;
        }
        System.out.println(x+" "+y);


    }
}
