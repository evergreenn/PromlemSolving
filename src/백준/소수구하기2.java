package 백준;

import java.util.Arrays;
import java.util.Scanner;

public class 소수구하기2 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int M = s.nextInt();
        int N = s.nextInt();

        boolean[] arr = new boolean[N + 1];

        Arrays.fill(arr,true);
        arr[0]=false;
        arr[1]=false;
        for(int i=2;i< Math.sqrt(N)+1;i++){

            if(arr[i]){
                int j=2;
                int num=i*j;
                while (num<=N){
                    arr[num]=false;
                    j++;
                    num=j*i;
                }
            }
        }

        for(int i=M;i<=N;i++){
            if(arr[i]){
                System.out.println(i);
            }
        }
    }
}
