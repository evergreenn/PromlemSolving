package 이코테.greedy;

import java.util.Arrays;
import java.util.Scanner;

public class 숫자카드게임 {
    public static void main(String[] args) {
        //각 행별로 최솟값을 저장하는 배열 생성

        //해당 행에서 가장 큰 값 의 인덱스로 행 선택

        Scanner sc = new Scanner(System.in);
        int N=sc.nextInt();
        int M=sc.nextInt();
        // nextInt 는 개행문자를 남기고 입력받음 그래서 그 다음 바로 nextLin()이 오면 아무값도 입력 받지 못하게 됨
        sc.nextLine();

        int[][] arr =new int[N][];
        for (int i = 0; i < N; i++) {
            arr[i]= Arrays.stream(sc.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        for (int[] a : arr ) {
            System.out.println(Arrays.toString(a));
        }

        int maximum=Integer.MIN_VALUE;
        for (int[] a : arr ){
            int[] temp = Arrays.copyOf(a, a.length);

            Arrays.sort(temp);
            maximum=maximum<temp[0]?temp[0]:maximum;
        }
        //아이디어 : 각 열들의 최솟값 중 가장 큰 값을 출력
        System.out.println(maximum);




    }
}
