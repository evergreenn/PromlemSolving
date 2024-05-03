package 이코테.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 시각 {
    public static void main(String[] args) throws IOException {

        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int cnt=0;


        int N = Integer.valueOf(br.readLine());
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j < 60; j++) {
                for (int k = 0; k < 60; k++) {
                    String hour= String.valueOf(i);
                    String min = String.valueOf(j);
                    String sec = String.valueOf(k);

                    if (hour.contains("3") || min.contains("3") || sec.contains("3")) {
                        cnt++;
                    }

                }
            }
        }
        System.out.println(cnt);
    }
}
