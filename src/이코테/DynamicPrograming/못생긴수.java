package 이코테.DynamicPrograming;

import java.util.LinkedList;
import java.util.Scanner;

public class 못생긴수 {
    //5:10~
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        int n = s.nextInt();

        int[] dp=new int[1001];
        dp[1]=1;
        LinkedList<Integer> queue = new LinkedList<>();

        queue.add(dp[1]);
        int cnt=2;
        while (!queue.isEmpty()){
            Integer first = queue.remove();



            dp[cnt]=first*2;
            if(cnt>=n){
                break;
            }
            dp[cnt+1]=first*3;
            if(cnt>=n){
                break;
            }
            dp[cnt+2]=first*5;
            if(cnt>=n){
                break;
            }
            cnt=cnt+3;
            queue.add(first*2);
            queue.add(first*3);
            queue.add(first*5);

        }
        System.out.println(dp[n]);

    }
}
