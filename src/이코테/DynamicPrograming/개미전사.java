package 이코테.DynamicPrograming;

import java.util.Arrays;
import java.util.Scanner;

public class 개미전사 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int N = s.nextInt();

        int[] arr=new int[N];
        int[] dp=new int[N];

        for (int i = 0; i < N; i++) {
            arr[i]=s.nextInt();
        }
        dp[0]=arr[0];
        dp[1]=arr[1];
        int maximum=Integer.MIN_VALUE;
        for (int i = 2; i < N; i++) {
            for (int j = 0; j < i - 1; j++) {
                maximum=Math.max(maximum,dp[j]);
            }
            dp[i]+=maximum+arr[i];
            maximum=Integer.MIN_VALUE;
        }
        System.out.println(Arrays.toString(dp));
        int max = Arrays.stream(dp)
                .max()
                .getAsInt();
        System.out.println(max);



    }
}
