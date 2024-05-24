package 소프티어;

import java.util.Arrays;
import java.util.Scanner;

public class 유리수계산기 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

//        String input = s.nextLine();

        String[] input = s.nextLine().split("\\+|\\*|-|/");

        System.out.println(Arrays.toString(input));
        System.out.println("input"+input.length);
        for (String a : input) {
            System.out.println(a);

            System.out.println("--");
        }



    }

}
/*
[1, 2] + [2, 3]
 */