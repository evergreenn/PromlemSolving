package 이코테.DynamicPrograming;

import java.util.Arrays;
import java.util.Scanner;

public class 병사배치하기2 {
    //10:40 ~
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int N = s.nextInt();

        int[] dp=new int[N];
        Arrays.fill(dp,1);

        int[] arr = new int[N];
        int[] reverse = new int[N];

        for(int i=0;i<N;i++){
            arr[i] = s.nextInt();
        }
        for(int i=0;i<N;i++){
            reverse[i] = arr[(N-1) - i];
        }
        int max=0;
        for(int i=0;i<N;i++){
            for(int j=0;j<i;j++){
                if(reverse[i]>reverse[j]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
                max=Math.max(max,dp[i]);
            }
        }
        if(N==1){
            System.out.println(0);
        }{

            System.out.println(N-max);
        }




    }
}
