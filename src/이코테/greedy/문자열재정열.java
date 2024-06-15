package 이코테.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class 문자열재정열 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        String read = br.readLine();
        int num=0;
        for (int i = 0; i < read.length(); i++) {

            char c = read.charAt(i);

            if (Character.isDigit(c)) {
                read=read.replaceFirst(String.valueOf(c), " "); // 주의 여기서 실수함, 만약 "" 으로 아예삭제되버리면 인덱스 자체가 줄어들어서 바로뒤에 숫자가 연속으로 나올시 판단을 안함.
                //또한 Replace 메서드는 String 자체를 바꾸지 않음.
                num+=c-'0';
            }
        }
        read=read.replaceAll(" ", "");

        char[] charArray = read.toCharArray();
        Arrays.sort(charArray);

        String result=new String(charArray);

        System.out.println(result+String.valueOf(num));



    }
}
/*
K1KA5CB7
AJKDLSI412K4JSJ9D
 */
