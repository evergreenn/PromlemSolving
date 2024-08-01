package 이코테.DynamicPrograming;

import java.util.Scanner;

public class 일로만들기2 {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        int X = s.nextInt();
        int[] dp=new int[X+1];
        //dp 배열안에 저장할 값 : 해당 인덱스가 1로 도달하기까지의 연산 시행횟수의 최솟값.

        dp[1]=0;
        for(int i=2;i<=X;i++){

            dp[i]=dp[i-1]+1;
            if (i % 5 == 0) {
                dp[i]=Math.min(dp[i],dp[i/5]+1);
            }
            if (i % 3 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 3]+1);
            }
            if(i%2==0){
                dp[i] = Math.min(dp[i], dp[i / 2]+1);
            }


        }
        System.out.println(dp[X]);



    }
}
