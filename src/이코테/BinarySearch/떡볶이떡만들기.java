package 이코테.BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class 떡볶이떡만들기 {
    public static void main(String[] args)  {
        Scanner s = new Scanner(System.in);

        int N = s.nextInt();
        int M=s.nextInt();
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i]=s.nextInt();
        }

        int max = Arrays.stream(arr)
                .max()
                .getAsInt();//배열을 정렬할 필요 없이 바로 최댓값을 구하기
        //배열 자체를 탐색하는것이 아님.

        int start=0;
        int end=max;
        int sum=0;
        int result=0;

        while (start <= end) {

            int mid=(start+end)/2; // 중간 자르는 막대의 높이를 mid 값으로 계속 줄여나가는것임.

            for (int a : arr) {
                if (a > mid) {

                    sum+=(a-mid);
                }
            }

//            if (sum == M) {
//                System.out.println(mid);
//                break;
//            }
            if (sum < M) {
                end=mid-1;

            } else {
                start = mid + 1;
                result=mid; //즉, 문제에서 정확하게 값이 일치하지 않을경우
                //최댓값을 구하는 것이므로, sum> M 일 경우에 result 값을 저장.
            }
            sum=0;

        }
        System.out.println(result);

    }


}
