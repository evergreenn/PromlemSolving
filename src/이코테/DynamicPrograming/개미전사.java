package 이코테.DynamicPrograming;

import java.util.Arrays;
import java.util.Scanner;

public class 개미전사 {
    public static void main(String[] args) {
        //dp -> 바텀 업
        Scanner s = new Scanner(System.in);

        int N = s.nextInt();

        int[] arr=new int[N];
        int[] dp=new int[N];

        for (int i = 0; i < N; i++) {
            arr[i]=s.nextInt();
        }
        dp[0]=arr[0];
        dp[1]=Math.max(arr[1],dp[0]);// 핵심 아이디어 -> 만약 이전값을 그대로 사용할수 있다면
        // 특히 그대로 사용하는 값이 더 크다면 해당 값을 최댓값으로 정하기.

        int maximum=Integer.MIN_VALUE;
        for (int i = 2; i < N; i++) {
            dp[i]=Math.max(dp[i-1],dp[i-2]+arr[i]);

        }
        System.out.println(Arrays.toString(dp));
        int max = Arrays.stream(dp)
                .max()
                .getAsInt();
        System.out.println(max);



    }
}
