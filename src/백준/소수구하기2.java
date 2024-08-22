package 백준;

import java.util.Scanner;

public class 소수구하기2 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int M = in.nextInt();
        int N = in.nextInt();

        boolean[] check=new boolean[N+1];
        int cnt=0;

        for(int i=2;i<Math.sqrt(N);i++){

            if(check[i]){

                for(int j=2;j<N;j++){

                    int num=i*j;
                    check[num]=false;
                    cnt++;
                }
            }
        }
        System.out.println(N-cnt);
    }
}
