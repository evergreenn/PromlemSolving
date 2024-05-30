package 이코테.greedy;

import java.util.Scanner;
import java.util.StringTokenizer;

public class 곱하기혹은더하기 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        String[] input = s.nextLine().split("");
        int sum=0;

        for (int i = 0; i < input.length; i++) {
            int n = Integer.valueOf(input[i]);
            System.out.println(n);
            if (n <= 1 || sum ==0) {
                sum += n;
            } else {
                sum*=n;
            }
        }


        System.out.println(sum);
    }
}
/*
02984
 */