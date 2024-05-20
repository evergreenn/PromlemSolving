package 이코테.FloydWarshall;

import java.util.Arrays;
import java.util.Scanner;

public class 미래도시 {
    public static void main(String[] args) {
        //10시 22분 ~ 11시 15분.53분 수행함.

        Scanner s = new Scanner(System.in);

        int N = s.nextInt();
        int M = s.nextInt();

        int[][] dp = new int[N + 1][N + 1];

        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i],(int)9);
        }
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp.length; j++) {
                if (i == j) {
                    dp[i][j]=0;
                }
            }
        }
        for (int i = 0; i < M; i++) {
            int start=s.nextInt();
            int end= s.nextInt();


            dp[start][end]=1;
            //매우 중요 !! 아래의 한줄을 안넣어서 틀림. 양방향 이동 가능 이므로, end 부터 start 까지도 연결해야함.
            dp[end][start]=1;

        }

        int X=s.nextInt();
        int K=s.nextInt();


        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j]);
                }
            }
        }
        for (int i=1;i<=N ; i++
        ) {
            for (int j=1;j<=N;j++) {
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("K = " + K);
        System.out.println("X = " + X);
        System.out.println("dp[1][K] = " + dp[1][K]);
        System.out.println("dp[K][X] = " + dp[K][X]);
        int result=dp[1][K]+dp[K][X];
        if (result >= 1e9 || result<=0) {
            System.out.println(-1);
        } else {
            System.out.println(result);
        }


    }
}
/*
5 7
1 2
1 3
1 4
2 4
3 4
3 5
4 5
4 5
 */
