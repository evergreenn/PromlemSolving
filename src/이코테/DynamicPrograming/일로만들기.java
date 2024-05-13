package 이코테.DynamicPrograming;

import java.util.HashMap;
import java.util.Scanner;

public class 일로만들기 {
    public static void main(String[] args) {
        //DP는 반복되는것을 찾기.
        //DP는 무조건 바텀업이 1순위

        HashMap<Integer, Integer> map = new HashMap<>();

        Scanner s = new Scanner(System.in);
        int[] arr = new int[300000];

        int X = s.nextInt();

        for (int i = 2; i <= X; i++) {
            arr[i] = arr[i - 1] + 1;

            if (i % 5 == 0) {
                arr[i] = Math.min(arr[i / 5] + 1,arr[i]);
            }
            if (i % 3 == 0) {
                arr[i] = Math.min(arr[i / 3] + 1, arr[i]);
            }
            if (i % 2 == 0) {
                arr[i] = Math.min(arr[i / 2] + 1, arr[i]);
            }



        }

        System.out.println(arr[X]);
    }
}
