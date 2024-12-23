package 백준;

import java.util.Scanner;

public class 일로만들기 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int X=s.nextInt();
        int[] dp=new int[X+1];

        dp[X]=0;
        dp[1]=0;
        for(int i=2;i<=X;i++){
            dp[i]=dp[i-1]+1;
            if(i%2==0){
               dp[i]= Math.min(dp[i],dp[i/2]+1);
            }
            if(i%3==0){
                dp[i]=Math.min(dp[i],dp[i/3]+1);
            }
        }
        System.out.println(dp[X]);
    }
}
