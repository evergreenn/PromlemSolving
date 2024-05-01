package 이코테;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 거스름돈 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int input = Integer.valueOf(br.readLine());
        int cnt=0;
        int[] arr = {500, 100, 50, 10};

        for (int coin : arr) {
            cnt+=input/coin;
            input%=coin;

        }


        System.out.println(cnt);



    }
}
