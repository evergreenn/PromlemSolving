package 이코테.BinarySearch;

import java.util.Arrays;
import java.util.Scanner;

public class 떡볶이떡만들기2 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int N = s.nextInt();
        int M = s.nextInt();
        s.nextLine();
        int[] input= Arrays.stream(s.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int max=(int)-1e9;

        for (int i : input) {
            max = Math.max(max, i);
        }
        System.out.println(Arrays.toString(input)
        );
        int start=0;
        int end=max;
//        System.out.println("end = " + end);
        int answer=0;
        while(start<=end){
            int sum=0;
            int mid=(start+end)/2;
            System.out.println("mid = " + mid);

            for(int i :input){
                int calc=i-mid;
                if (calc > 0) {
                    sum+=calc;
                }
            }
            System.out.println("sum = " + sum);

            if (sum == M) {
                answer=mid;
                break;
            }

            if(sum>M){

                start=mid+1;
            }
            if(sum<M){
                end=mid-1;
            }

        }
        System.out.println(answer);


    }
}
/*
4 6
19 15 10 17
 */