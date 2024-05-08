package 이코테.DFSBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class 음료수얼려먹기 {
    public static int[][] arr ;
    static int N;
   static int M;

    public static void main(String[] args) throws IOException {
        // 감염, 퍼짐 -> DFS 로 간다.

        BufferedReader br= new BufferedReader(new InputStreamReader(System.in)); //Scanner와 버퍼 같이 사용하면 안됨.


         Scanner sc= new Scanner(System.in);

         N=sc.nextInt();
         M=sc.nextInt();
         sc.nextLine();

         arr=new int[N][M];

        for (int i = 0; i < arr.length; i++) {
            arr[i]=Arrays.stream(sc.nextLine().split(""))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        for (int[] row : arr) {
            System.out.println(Arrays.toString(row));

        }
        int cnt=0;

        for (int i=0;i<arr.length;i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if(dfs(i,j)){
                    cnt++;
                }
            }
        }
        System.out.println(cnt);

    }
    public static boolean dfs(int x, int y) {

        if(x<0||y<0||x>=N||y>=M){
            return false;
        }
        if (arr[x][y] == 1 || arr[x][y] == 2) {
            return false;
        }
        arr[x][y]=2;// 방문처리
        System.out.println("x = " + x);
        System.out.println("y = " + y);
        System.out.println("방문처리");

        for (int[] row : arr) {
            System.out.println(Arrays.toString(row));

        }

        dfs(x+1,y);
        dfs(x-1,y);
        dfs(x,y+1);
        dfs(x,y-1);

        return true;

    }
}
