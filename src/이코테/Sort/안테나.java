package 이코테.Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class 안테나 {
    //12:32 ~ 1:11
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.valueOf(br.readLine());
        String space = " ";
        int[] input = Arrays.stream(br.readLine().split(space))
                .mapToInt(Integer::parseInt)
                .toArray();
        Arrays.sort(input);
        System.out.println(input[(input.length-1)/2]);


    }
}
