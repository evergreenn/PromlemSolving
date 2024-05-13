package 이코테.DynamicPrograming;

import java.util.HashMap;
import java.util.Scanner;

public class 일로만들기 {
    public static void main(String[] args) {
        //11시 45분

        HashMap<Integer, Integer> map = new HashMap<>();

        Scanner s = new Scanner(System.in);
        int[] arr=new int[300000];

        int X = s.nextInt();


        while ( X!=1 ) {
            if (X % 5 == 0) {
                arr[X]=arr[X/5]+1;
                X/=5;

            } else if (X % 3 == 0) {
                arr[X] = arr[X / 3] + 1;
                X /= 3;
            } else {
                arr[X]=arr[X-1]+1;
                X-=1;
            }
        }
        System.out.println(arr[X]);
    }
}
