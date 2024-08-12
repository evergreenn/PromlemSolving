package 이코테.DynamicPrograming;

import java.util.Arrays;
import java.util.Scanner;

public class 효율적인화폐구성2 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        int M = s.nextInt();
        int[] coin = new int[N];
        int[] dp = new int[M+1];
        Arrays.fill(dp,(int)1e9);
        dp[0]=0;

        for (int i = 0; i < N; i++) {
            coin[i]=s.nextInt();
        }
        //dp[i]=dp[i-k]+1 k는 단위, dp 저장값 : i원을 만드는 최소횟수
        for(int i=0;i<N;i++){
            for(int j=coin[i];j<=M;j++){

                if(dp[j-coin[i]]!=-1){
                    dp[j] = Math.min(dp[j - coin[i]] + 1, dp[j]);
                }
            }
        }
        if(dp[M]==(int)1e9){
            System.out.println(-1);
        }else {
            System.out.println(dp[M]);

        }


    }
}
/*
2 15
2
3
3 4
3
5
7
 */