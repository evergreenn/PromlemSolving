package 소프티어;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class 수만들기 {
    public static void main(String[] args) {

        // 맨 앞지리의 그리디 이용

        Scanner s = new Scanner(System.in);
        String[] input = s.nextLine().split(" ");
        String[] copy=input.clone();

        Arrays.sort(copy,(a,b)->b.charAt(0)-a.charAt(0)); //첫번째수 기준으로 내림차순 -> 가장 큰 수

        Arrays.sort(copy, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                int judge = b.charAt(0) - a.charAt(0);
                if (judge == 0) {
                    //앞자리가 같다면 숫자 자체의 크기순 내림차순

                    judge=b.charAt(1);

                }
                return judge;
            }
        });

        String str = "";
        for (int i = 0; i < copy.length; i++) {
            str += copy[i];
        }
        int max = Integer.valueOf(str);

        System.out.println(max);

        Arrays.sort(input, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                int judge = a.charAt(0) - b.charAt(0);
                if (judge == 0) {
                    //앞자리가 같다면 숫자 자체의 크기순 오름차순
                    int a_n = Integer.valueOf(a);
                    int b_n = Integer.valueOf(b);
                    return a_n-b_n;

                }
                return judge;
            }
        }); //첫번째수 기준으로 오름차순 -> 가장 작은 수

        str="";
        for (int i = 0; i < input.length; i++) {
            str+=input[i];
        }
        int min = Integer.valueOf(str);
        System.out.println(min);

        System.out.println(max+min);





        System.out.println(Arrays.toString(input));

        int[] arr = Arrays.stream(input)
                .mapToInt(Integer::parseInt)
                .toArray();




    }
}
/*
1 2 3
 */
/*

2 9 10 21 24
 */
