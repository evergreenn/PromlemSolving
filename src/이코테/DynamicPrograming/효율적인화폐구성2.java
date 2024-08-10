package 이코테.DynamicPrograming;

import java.util.Scanner;

public class 효율적인화폐구성2 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int N = s.nextInt();

        int M=s.nextInt();
        int[] dp = new int[M + 1];

        int[] arr = new int[N + 1];

        for(int i=1;i<=N;i++){
            arr[i] = s.nextInt();
        }


    }
}
