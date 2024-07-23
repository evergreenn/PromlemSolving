package 이코테.Sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class 카드정렬하기 {
    //7:36 ~ 8:29
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        int N = s.nextInt();

        PriorityQueue<Number> queue = new PriorityQueue<>();

        if (N == 1) {
            System.out.println(0);
            return;
        }

        for (int i = 0; i < N; i++) {
            queue.add(new Number(s.nextInt()));
        }

        int sum=0;



        while (true) {
            int remove=0;
            for (int i = 0; i < 2; i++) {

                remove+= queue.remove().bound;
            }
            queue.add(new Number(remove));
            sum+=remove;
            if (queue.size() == 1) {
                break;
            }
        }

        System.out.println(sum);


    }
    static class Number implements Comparable<Number>{
        int bound;
        public Number(int bound){
            this.bound=bound;
        }
        @Override
        public int compareTo(Number other){
            return this.bound-other.bound;
        }


    }
}
