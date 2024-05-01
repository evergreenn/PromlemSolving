package 이코테;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 거스름돈 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int input = Integer.valueOf(br.readLine());
        int cnt=0;

        while (input!=0) {
            System.out.println(input);
            if (input >= 500) {
                input-=500;
                cnt++;
                continue;
            }
            if (input >= 100) {
                input-=100;
                cnt++;
                continue;
            }
            if (input >= 50) {
                input-=50;
                cnt++;
                continue;
            }
            if (input >= 10) {
                input -= 10;
                cnt++;
                continue;
            }

        }
        System.out.println(cnt);



    }
}
