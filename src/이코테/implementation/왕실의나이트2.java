package 이코테.implementation;

import java.util.Scanner;

public class 왕실의나이트2 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        String input = s.nextLine();
        //열 a
         int col = Integer.valueOf(input.charAt(0)-'a'+1);
         //행 1
         int row=Character.getNumericValue(input.charAt(1));
        System.out.println("col = " + col);
        System.out.println("row = " + row);

         int[][] map=new int[9][9];

         int[] dx={-2,-2,+2,+2,-1,+1,-1,+1};//행 수직
         int[] dy={+1,-1,+1,-1,+2,+2,-2,-2};//상 우 하 좌 //수평

        int x=row;
        int y=col;
        int cnt=0;
        for (int i = 0; i < 8; i++) {
            int nx=x+dx[i];
            int ny=y+dy[i];

            if(nx<1||ny<1||nx>8||ny>8){
                continue;
            }
            cnt++;
        }

        System.out.println(cnt);




    }
}
