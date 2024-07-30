package 백준;

import java.util.Scanner;

public class 웰컴키트 {
    public static void main(String[] args){

        Scanner s = new Scanner(System.in);

        int N = s.nextInt();

        int[] arr=new int[6];

        for(int i=0;i<6;i++){

            arr[i]=s.nextInt();
        }

        int T=s.nextInt();
        int P=s.nextInt();


        // 반례 : i 가 2T나 3T 인 경우 안됨.
        int cnt=0;
        for(int i: arr){

            cnt+=i/T;
            if (i % T > 0) {
                cnt++;
            }
        }

        int pen_hold=N/P;
        int pen_one=N%P;

        System.out.println(cnt);
        System.out.print(pen_hold + " " + pen_one);
    }
}
