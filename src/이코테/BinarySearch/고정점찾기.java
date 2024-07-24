package 이코테.BinarySearch;

import java.util.Arrays;
import java.util.Scanner;

public class 고정점찾기 {
    static int[] input;
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        int N = s.nextInt();
        s.nextLine();

       input = Arrays.stream(s.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        System.out.println(binarysearch(0,N-1));
    }
    public static int binarysearch(int start, int end){

        while(start<=end){
            //매우중요, 즉 종료조건은 start>end 이니까, 실행조건은 start<=end 임.

            int mid=(start+end)/2;

            System.out.println("mid = " + mid);
            if(input[mid]==mid){

                return mid;
            }
            if(input[mid]<mid){
                start=mid+1;
            }
            if(input[mid]>mid){
                end=mid-1;
            }
        }

        return -1;
    }
}
/*
5
-15 -6 1 3 7


7
-15 -4 2 8 9 13 15
 */
