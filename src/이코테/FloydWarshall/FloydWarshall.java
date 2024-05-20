package 이코테.FloydWarshall;

import java.util.Arrays;
import java.util.Scanner;

public class FloydWarshall {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int N =s.nextInt();
        int M=s.nextInt(); //간선의 수
        s.nextLine();

        int[][] dp=new int[N+1][N+1];



        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i == j) {
                    dp[i][j]=0;
                }else {

                    dp[i][j]=(int) 1e9;
//                    dp[i][j]=Integer.MAX_VALUE;
                    //주의, Integer.MAX_VALUE 하면 더하게 되면 buffer overflow가 남. 그래서 마이너스 값으로 채워짐.
                }
            }
        }
        for (int[] a : dp) {
            System.out.println(Arrays.toString(a));
        }
        for (int i = 0; i < M; i++) {
            int[] input = Arrays.stream(s.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            int row=input[0];
            int col=input[1];
            int cost=input[2];

            dp[row][col]=cost;
        }
        for (int[] a : dp) {
            System.out.println(Arrays.toString(a));
        }
        for (int k = 1; k <= N ; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    dp[i][j]=Math.min(dp[i][j],dp[i][k]+dp[k][j]);
                }
            }
        }
        for (int[] a : dp) {
            System.out.println(Arrays.toString(a));
        }


    }
}
/*
4
7
1 2 4
1 4 6
2 1 3
2 3 7
3 1 5
3 4 4
4 3 2

 */
