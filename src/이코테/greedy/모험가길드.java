package 이코테.greedy;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class 모험가길드 {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        int N = s.nextInt();
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            queue.add(s.nextInt());
        }

        Collections.sort(queue,Collections.reverseOrder());
        System.out.println(queue.toString());
        int cnt=0;

        while (!queue.isEmpty()) {
            int max = queue.removeFirst();
            cnt++;
            for (int i = 0; i < (max-1); i++) {
                queue.remove();
            }
        }

        System.out.println(cnt);

    }
}
/*
5
2 3 1 2 2
 */
