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

        Collections.sort(queue);
        System.out.println(queue.toString());
        int cnt=0;
        int result=0;

        while (!queue.isEmpty()) {
            int max = queue.removeFirst();
            cnt++;
            if (cnt >= max) {
                //마지막으로 그룹에 포함된 공포도보다 크거나 같다면 +1
                result+=1;
                cnt=0;
            }

        }

        System.out.println(result);

    }
}
/*
5
2 3 1 2 2
 */
