package 이코테.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class 럭키스트레이트 {

    //11:27 ~11:50
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

       List<Integer> list = Arrays.stream(br.readLine().split(""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        Queue<Integer> queue = new LinkedList<Integer>(list);

        int half= queue.size()/2;
        int l_sum=0;

        while (!(queue.size()==half)) {

            Integer remove = queue.remove();
            l_sum+=remove;

        }
        int r_sum = queue.stream()
                .mapToInt(Integer::valueOf)
                .sum();
        if (l_sum != r_sum) {
            System.out.println("READY");
        } else {
            System.out.println("LUCKY");
        }


    }

}
