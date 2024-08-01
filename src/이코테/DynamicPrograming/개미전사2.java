package 이코테.DynamicPrograming;

import java.util.Scanner;

public class 개미전사2 {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        int N = s.nextInt();
        int[] input = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            input[i]=s.nextInt();
        }
        //dp[i] = i번째 식량창고를 선택하였을때 얻을수 있는 식량의 최댓값.

        int[] dp = new int[N + 1];
        dp[1]=input[1];
        dp[2]=input[2];
        for(int i=3;i<=N;i++){
            dp[i]=Math.max(dp[i-1],dp[i-2]+input[i]);

        }

        System.out.println(dp[N]);
    }
}
/*
4
1 3 1 5
 */
