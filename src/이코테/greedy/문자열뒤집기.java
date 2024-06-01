package 이코테.greedy;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 문자열뒤집기 {
    public static void main(String[] args) {
        // 1 그룹과 0 그룹의 갯수를 카운트 하고, 두 그룹중 작은 그룹의 갯수를 반환
        Scanner s = new Scanner(System.in);
        int zero=0;
        int one=0;

        String[] input = s.nextLine().split("");

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < input.length; i++) {
            int n = Integer.valueOf(input[i]);
            queue.add(n);
        }
        while (!queue.isEmpty()) {
            int n = queue.remove();
            if (n == 0) {
                while (!queue.isEmpty()) {
                    n=queue.peek();
                    if (n != 0) {
                        break;
                    }
                    queue.remove();
                }
                zero++;
            } else {
                while (!queue.isEmpty()) {
                    n=queue.peek();
                    if (n != 0) {
                        break;
                    }
                    queue.remove();
                }
                one++;
            }
        }
        System.out.println("one = " + one);
        System.out.println("zero = " + zero);
        System.out.println(Math.min(zero, one));

    }
}
/*
0001100
 */
