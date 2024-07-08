package 이코테.DFSBFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class 백트래킹별해연산자끼워넣기 {
    static int[] arr;
    static int plus;
    static int minus;
    static int multiplex;
    static int divide;

    static int max=-(int)1e9;
    static int min=(int) 1e9;

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        int N = s.nextInt();

        arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i]=s.nextInt();
        }
        plus=s.nextInt();
        minus=s.nextInt();
        multiplex=s.nextInt();
        divide=s.nextInt();
        //첫번째 값을 sum에 넣고 시작.
        dfs(arr[0], 1);
        System.out.println(max);
        System.out.println(min);
    }

    public static void dfs(int sum, int depth) {
        if (depth == arr.length) {

            min = Math.min(sum, min);
            max = Math.max(sum, max);
            return;
        }

        if (plus > 0) {
            plus-=1;
            dfs(sum + arr[depth], depth + 1);
            plus+=1;
        }
        if (minus > 0) {
            minus-=1;
            dfs(sum - arr[depth], depth + 1);
            minus+=1;
        }
        if (multiplex > 0) {
            multiplex-=1;
            dfs(sum * arr[depth], depth + 1);
            multiplex+=1;
        }
        if (divide > 0) {
            divide-=1;
            dfs(sum / arr[depth], depth + 1);
            divide+=1;
        }



    }
}
