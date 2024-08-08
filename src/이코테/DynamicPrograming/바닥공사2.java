package 이코테.DynamicPrograming;

import java.util.Scanner;

public class 바닥공사2 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int N = s.nextInt();

        int[] dp = new int[N + 1];

        dp[1] = 1;
        dp[2] = 3;

        for (int i = 3; i <= N; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2] * 2) % 796796;
        }

        System.out.println(dp[N]);

    }


}
