package 이코테.DynamicPrograming;

import java.util.Arrays;
import java.util.Scanner;

public class 편집거리 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        String A = s.nextLine();
        String B=s.nextLine();
        //A글자를 B로 바꾸기 위한 최솟값
        int[][] dp=new int[A.length()][B.length()];

        for(int i=0;i< dp.length;i++){
            dp[i][0]=i;
        }
        for(int i=0;i<B.length();i++){
            dp[0][i]=i;
        }

        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[i].length;j++){
                if(A.charAt(i)==B.charAt(j)){
                    dp[i][j]=dp[i-1][j-1];
                }else{
                    dp[i][j]=Math.min(dp[i][j-1],dp[i-1][j-1]);
                    dp[i][j]=Math.min(dp[i][j],dp[i-1][j]);
                    dp[i][j]+=1;
                }
            }
        }
        for(int i=0;i<A.length();i++){
            System.out.println(Arrays.toString(dp[i]));
        }
        System.out.println(dp[A.length()-1][B.length()-1]);

    }
}
