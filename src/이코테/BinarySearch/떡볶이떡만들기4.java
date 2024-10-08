package 이코테.BinarySearch;

import java.util.Arrays;
import java.util.Scanner;

public class 떡볶이떡만들기4 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int N=s.nextInt();
        int M=s.nextInt();
        int[] arr=new int[N];
        for(int i=0;i<N;i++){
            arr[i] = s.nextInt();
        }
        Arrays.sort(arr);

        int start = arr[0];
        int end = arr[arr.length - 1];

        //여기서 조정하는 값은 자를 값임.

        int result=0;
        while(start<=end){
            int mid = (start + end) / 2;
            int sum=0;
            System.out.println("mid = " + mid);

            for(int a : arr){
                int cut=( a-mid)<0 ? 0 : (a-mid);
                sum+=cut;

            }
            if(sum==M){
                //최선책, 딱 맞게 바로 주는 경우
                result=mid;
                break;
            }
            if(sum>=M){
                //손님한테 너무 많이주는 경우 -> 절단기 높이 높이기
                //차선책, 남더라도 주기.
                start=mid+1;
                result=mid;

            }
            else{
                end=mid-1;

            }

        }
        System.out.println(result);

    }
}
