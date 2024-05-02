package 이코테.greedy;

import java.util.Scanner;

public class 일이될때까지 {
    public static void main(String[] args){
        Scanner s=new Scanner(System.in);
        int N=s.nextInt();
        int K=s.nextInt();
        int cnt=0;

        while (N != 1) {
            if (N % K == 0) {
                N/=K;
                cnt++;
                continue;
            }
            N-=1;
            cnt++;
        }
        System.out.println(cnt);
    }
}
