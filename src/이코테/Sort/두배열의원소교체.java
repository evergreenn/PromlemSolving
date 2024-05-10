package 이코테.Sort;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class 두배열의원소교체 {
    public static void main(String[] args) {
        //8:04분 시작
        Scanner s = new Scanner(System.in);

        int N=s.nextInt();
        int K=s.nextInt();

        Integer[] A=new Integer[N];

        Integer[] B =new Integer[N];

        for (int i = 0; i < N; i++) {
            A[i]=s.nextInt();
        }
        for(int i=0;i<N;i++){

            B[i]=s.nextInt();
        }
        Arrays.sort(A);//A는 오름차순(디폴트)
        Arrays.sort(B, Comparator.reverseOrder()); // 주의 Comparator은 Object를 상속한 클래스에 대하여
        //사용가능한 인터페이스이므로, 프리미티브타입(int[]) 가 아니라 (wrapper) 타입 이어야함.

        for (int i = 0; i < K; i++) {
            int a=A[i];
            int b=B[i];
            if(a<b){

                int tmp=A[i];
                A[i]=B[i];
                B[i]=tmp;
            }
            else {
                break;
            }
        }

        int sum = Arrays.stream(A)
                .mapToInt(Integer::intValue)
                .sum();

        System.out.println(sum);


    }
}
