package 이코테;

import java.io.BufferedReader;
import java.util.Arrays;
import java.util.Scanner;

public class 큰수의법칙 {
    public static void main(String[] args) {
        //가장 큰수와 그 다음수 저장
        Scanner sc = new Scanner(System.in);
        String space = " ";

        String[] split = sc.nextLine().split(space);
        int N=Integer.valueOf(split[0]);
        int M=Integer.valueOf(split[1]);
        int K=Integer.valueOf(split[2]);

        String space1 = " ";
        int[] arr = Arrays.stream(sc.nextLine().split(space1))
                .mapToInt(Integer::parseInt)
                .toArray();

        Arrays.sort(arr);
        int max1 = arr[N - 1];
        int max2 = arr[N - 2];
        int plus=max1;
        int sum=0;
        for (int i = 1; i <= M; i++) {
            if (i % (K+1) == 0) {
                sum+=max2;
                continue;
            }
            sum+=max1;

        }

        System.out.println(Arrays.toString(arr));
        System.out.println(sum);


    }
}
