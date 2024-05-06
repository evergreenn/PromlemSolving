package 이코테.implementation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class 왕실의나이트 {
    public static void main(String[] args) {
        // 행은 1부터 시작, 열은 a 부터 시작.

        Scanner s = new Scanner(System.in);
        String input = s.nextLine();
        int y = input.charAt(0)-'a'+1;
        int x = input.charAt(1)-'0';

        int[] dx={-2,-2,-1,+1,+2,+2,-1,+1};//상우 상좌 우상 우하 하우 하좌 좌상 좌하
        int[] dy={-1,+1,+2,+2,-1,+1,-2,-2};
        int cnt=0;

        for (int i = 0; i < dx.length; i++) {
            int nx=x+dx[i];
            int ny=y +dy[i];
            if (nx < 1 || nx > 8 || ny < 1 || nx > 8) {
                continue;
            }
            cnt++;

        }

        System.out.println(cnt);


    }
}
