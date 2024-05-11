package 이코테.BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class 떡볶이떡만들기 {
    public static void main(String[] args) throws IOException {
        //10시 51분, 11시 15분  제한시간 40분
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] input = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();


        int N = input[0];
        int M = input[1];

        int[] arr;

        arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .sorted() //comparator 가능 ?
                .toArray();


        //아이디어 큰것부터 구하기 -> 최솟값이므로.

        for (int i = arr.length-1; i >= 0; i--) {
            int target=arr[i];

            int index = binarysearch(arr, 0, N - 1, target);
            int sum =sum(arr, index);
            if (sum >= M) {
                System.out.println(target);
                break;
            }
        }


    }

    public static int binarysearch(int[] arr, int start, int end, int target) {
        if (start > end) {
            return -1;
        }
        int mid=(start+end)/2;

        if (arr[mid] == target) {
            return mid;
        } else if (arr[mid] > target) {
            return binarysearch(arr, start, mid - 1, target);
        } else {
            return binarysearch(arr, mid + 1, end, target);
        }
    }

    // 총 들고갈 양을 반환하는 함수.
    public static int sum(int[] arr, int index) {

        int slice= arr[index];
        int sum=0;

        for (int i = index; i < arr.length; i++) {
            sum+=arr[i]-slice;
        }
        return sum;
    }
}
