package 이코테.DynamicPrograming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class 퇴사re {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int N = s.nextInt();
        int[] dp = new int[N + 1];
        ArrayList<Work> list = new ArrayList<>();



        for (int i = 0; i < N; i++) {
            int T=s.nextInt();
            int P=s.nextInt();

            list.add(new Work(i + 1, T, P));
        }

        for(int i=0;i<N;i++){

            Work work=list.get(i);
                if((i+ work.T)<=N){
                    dp[i+ work.T]=Math.max(dp[i+ work.T],dp[i]+ work.P);
                }
                dp[i+1]=Math.max(dp[i+1],dp[i]);
        }
        System.out.println(dp[N]);
    }
    static class Work{
        int date;
        int T;
        int P;
        public Work(int date,int T,int P){
            this.date=date;
            this.T=T;
            this.P=P;
        }

    }

}
