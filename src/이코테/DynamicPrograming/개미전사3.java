package 이코테.DynamicPrograming;

import java.util.Arrays;
import java.util.Scanner;

public class 개미전사3 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int N=s.nextInt();
        int[] arr = new int[N];
        int[] dp=new int[N];

        for(int i=0;i<N;i++){
            arr[i] = s.nextInt();
        }
        dp[0]=arr[0];
        dp[1]=Math.max(arr[1],arr[0]);//주의 첫 시작시 큰값 고려
        for (int i = 2; i < arr.length; i++) {

            dp[i]=Math.max(dp[i-2]+arr[i],dp[i-1]);
        }
        System.out.println(Arrays.toString(dp));
        System.out.println(dp[N-1]);

    }
}
/*
5
90 2 3 10 4

4
1 3 1 5
 */