package 이코테.DynamicPrograming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class 퇴사 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int N = s.nextInt();
        ArrayList<Work> list = new ArrayList<>();
        int[] dp = new int[N + 2];
        dp[0]=0;

        for(int i=0;i<N;i++){
            int T=s.nextInt();
            int P=s.nextInt();
            list.add(new Work(i+1,T, P)); //날짜도 저장
        }
        int max=-(int)1e9;

        for(int i=1;i<=N+1;i++){
            //i는 날짜 1일부터 시작
            for (Work work : list) {
                if (work.date >= i) {
                    break; //직전날짜까지 탐색
                }
                if((work.date+ work.T)==i){
                    dp[i]=Math.max(dp[i],dp[i- work.T]+ work.P);
                    max=Math.max(max,dp[i]);
                }
            }
        }
        



        System.out.println(max);


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
/*
7
3 10
5 20
1 10
1 20
2 15
4 40
2 200
 */
