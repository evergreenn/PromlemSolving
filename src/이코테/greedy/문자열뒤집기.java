package 이코테.greedy;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 문자열뒤집기 {
    public static void main(String[] args) {
        // 1 그룹과 0 그룹의 갯수를 카운트 하고, 두 그룹중 작은 그룹의 갯수를 반환
        // -> 답을 다시 보고 의역하자면 0을 1로 바꾸는 경우와 1을 0으로 바꾸는 경우중 작은 것을 반환
        Scanner s = new Scanner(System.in);
        int[] result = new int[2];

        String input = s.nextLine();
        for (int i = 0; i < (input.length()-1); i++) {
            char c=input.charAt(i);
            if (input.charAt(i) != input.charAt(i+1)) {
//                int n=  Integer.valueOf(c); 실수주의 , valueOf는 유니코드 값으로 바꿔버림
                int n = Character.getNumericValue(c);
                result[n]+=1;
            }
        }
        System.out.println("result[0] = " + result[0]);
        System.out.println("resuot[1] = " + result[1]);

        System.out.println(Math.min(result[0], result[1]));

    }
}
/*
0001100
01001
 */
