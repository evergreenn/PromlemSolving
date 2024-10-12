package 이코테.DynamicPrograming;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class 효율적인화폐구성3 {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        int N=s.nextInt();
        int M=s.nextInt();

        int[] dp = new int[10001];
        Arrays.fill(dp,(int)1e9);
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = s.nextInt();


            dp[arr[i]]=1;
        }
        for (int i = 1; i <= M; i++) {
            for(int j=0;j<N;j++){
                int num =i-arr[j];
                if(num<0){
                    continue;
                }

                dp[i]=Math.min(dp[num]+1,dp[i]);

                System.out.println("dp["+i+"] = " + dp[i]);

            }

        }

        System.out.println(dp[M]);

    }
}
