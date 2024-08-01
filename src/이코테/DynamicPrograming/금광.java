package 이코테.DynamicPrograming;

import java.util.Scanner;

public class 금광 {
    //5:28 ~
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        int T = s.nextInt();
        for (int t = 0; t < T; t++) {
            int N=s.nextInt();
            int M=s.nextInt();
            int[][] arr=new int[N+1][M+1];

            for(int i=1;i<=N;i++){

                for(int j=1;j<=M;j++){
                    arr[i][j]=s.nextInt();

                }
            }
            //dp[i][j]= i, j 번째 인덱스까지 더했을때의 최댓값.
            //즉, 일차원 배열의 dp 처럼 여기에서는 열의 값을 더하면서 가기.
            int[][] dp = new int[N + 1][M + 1];

            for(int i=1;i<=N;i++){

                dp[i][1]=arr[i][1];
            }

            int max=-(int)1e9;

            for(int Y=2;Y<=M;Y++){

                for(int X=1;X<=N;X++){
                    //X= 1 , 2 , 3
                    //오른쪽으로 가는 경우.
                    dp[X][Y]=dp[X][Y-1]+arr[X][Y];

                    if((X-1)>=1){
                        //오른쪽 위
                        dp[X][Y]=Math.max(dp[X][Y],dp[X-1][Y-1]+arr[X][Y]);
                    }
                    if((X+1)<=N){
                        //오른쪽 아래
                        dp[X][Y]=Math.max(dp[X][Y],dp[X+1][Y-1]+arr[X][Y]);
                    }
                    max = Math.max(max, dp[X][Y]);

                }

            }
            System.out.println(max);


        }

    }
}
/*
2
3 4
1 3 3 2 2 1 4 1 0 6 4 7
4 4
1 3 1 5 2 2 4 1 5 0 2 3 0 6 1 2
 */
