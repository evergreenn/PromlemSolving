package 이코테.BinarySearch;

import java.util.Arrays;
import java.util.Scanner;

public class 정렬된배열에서특정수의개수구하기 {
    static int[] input;
    static int N;

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

         N = s.nextInt();
        int x = s.nextInt();
        s.nextLine();

        input = Arrays.stream(s.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        System.out.println(Arrays.toString(input));

        System.out.println(upperbound(0, input.length, x) -
                lowerbound(0, input.length, x));

        System.out.println("upperbound(0, input.length, x) = " + upperbound(0, input.length, x));
        System.out.println("lowerbound(0, input.length, x) = " + lowerbound(0, input.length, x));

    }

    public int binarysearch(int start, int end, int target) {

        while (start <= end) {

            int mid = (start + end) / 2;
            if (input[mid] == target) {
                return mid;
            }
            if (input[mid] < target) {
                start = mid + 1;
            }
            if (input[mid] > target) {
                end = mid - 1;
            }

        }
        return -1;


    }

    public static int lowerbound(int start, int end, int target) {
        int mid = (start + end) / 2;

        if (start > end) {
            return -1;
        }

        if (input[mid] == target && (mid == 0 || input[mid - 1] < target)) {

            return mid;
        }
        if (input[mid] >= target) {
            //왼쪽탐색
            return lowerbound(start, mid - 1, target);
        } else {
           return lowerbound(mid + 1, end, target);
        }

    }

    public static int upperbound(int start, int end, int target) {
        int mid=(start+end)/2;

        if(start>end){
            return -1;
        }

        if(input[mid]==target && (mid ==N-1 ||input[mid+1]>target)){

            return mid;
        }

        if(input[mid]>target){
            //타겟보다 클 경우 왼쪽탐색
           return upperbound(start,mid-1,target);

        }else{

            return upperbound(mid+1,end,target);
        }

    }
}
/*
7 2
1 1 2 2 2 2 3
 */
