package 소프티어;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 수만들기2 {
    public static int []  combi;
    public static String[] input;
    public static int n;
    public static int max=(int) -1e9;
    public static int min=(int) 1e9;

    public static boolean[] visit;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        input = br.readLine().split(" ");

        int flag=0;
        int cnt=0;
        for (int i = 0; i < input.length; i++) {
            if (input[i].length() >= 3) {
                if (input.length > 6) {
                    flag+=1;
                }
                cnt++;
            }
        }
        if (cnt == 0) {
            if (input.length > 9) {
                flag+=1;
            }
        }
        try {
            if (flag != 0) {
                System.out.println(-1);
            } else {
                n = input.length;
                combi = new int[n];
                visit = new boolean[n];
                Arrays.fill(visit, false);

                permutation(0);
                System.out.println(max+min);

            }

        } catch (Exception e) {
            System.out.println(-1);
        }






    }

    public static void permutation(int limit) {

        if (limit == n) {
            String str="";

            for (int i = 0; i < combi.length; i++) {
                int index = combi[i];
                str+=input[index];

            }
            int judge = Integer.valueOf(str);
            max = Math.max(max, judge);
            min=Math.min(min,judge);
            return;
        }
        for (int i = 0; i < n; i++) {
            if(visit[i]) continue;
            combi[limit]=i;
            visit[i]=true;
            permutation(limit + 1);
            visit[i]=false;
        }
    }
}
