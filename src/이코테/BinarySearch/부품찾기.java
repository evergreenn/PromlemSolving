package 이코테.BinarySearch;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class 부품찾기 {
    public static void main(String[] args) {
        //10시 30분 시작. 10시 43분 마감.
        Scanner s = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();


        int N = s.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i]=s.nextInt();
        }
        Arrays.sort(arr);


        int M=s.nextInt();


        for (int i = 0; i < M; i++) {
            int target=s.nextInt();
            int result=binarysearch(arr,0,N-1,target);
            if (result == -1) {
                sb.append("no"+" ");
            } else {
                sb.append("yes" + " ");
            }
        }

        System.out.println(sb.toString());



    }

    //binarysearch 반환값 인덱스 위치
    public static int binarysearch(int[] arr, int start, int end, int target) {
        if (start > end) {
            return -1;
        }
        int mid = (start + end) / 2;

        if (arr[mid] == target) {
            return mid;
        } else if (arr[mid] > target) {
            return binarysearch(arr, start, mid - 1, target);
        } else {
            return binarysearch(arr, mid + 1, end, target);
        }

    }
}
