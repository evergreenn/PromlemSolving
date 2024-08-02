package 이코테.DynamicPrograming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class 정수삼각형 {
    //7:50 ~ 8: 50
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        s.nextLine();
        int[][] dp = new int[n ][n ];
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();



        for(int i=0;i<n;i++){
            int[] array = Arrays.stream(s.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            ArrayList<Integer> tmp = new ArrayList<>();
            for(int j=0;j< array.length;j++){
                tmp.add(array[j]);

            }
            list.add(tmp);
        }
        dp[0][0] = list.get(0).get(0);
        int answer=dp[0][0];

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < list.get(i).size(); j++) {
                if(j==0){

                    dp[i][j]=dp[i-1][j]+list.get(i).get(j);
                    answer=Math.max(dp[i][j],answer);
                    continue;
                }
                if (j == list.get(i).size() - 1) {
                    dp[i][j] = dp[i - 1][j - 1] + list.get(i).get(j);
                    answer=Math.max(dp[i][j],answer);
                    continue;
                }
                int left=dp[i-1][j-1]+list.get(i).get(j);
                int right=dp[i-1][j]+list.get(i).get(j);
                dp[i][j]=Math.max(left,right);
                answer=Math.max(dp[i][j],answer);
            }
        }
//        for (int i = 0; i < n; i++) {
//            System.out.println(Arrays.toString(dp[i]));
//        }

        System.out.println(answer);

    }
}
