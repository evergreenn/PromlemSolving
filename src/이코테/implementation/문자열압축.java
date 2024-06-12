package 이코테.implementation;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class 문자열압축 {
    public static void main(String[] args) {
        //6:45 ~ 8: 08 분 1시간 23분 소요.
        String s = "aabbaccc";

        List<String> collect = Arrays.stream(s.split(""))
                .collect(Collectors.toList());

        LinkedList<String> queue = new LinkedList<>(collect);
        int min = (int) 1e9;

        for (int i = 1; i <= s.length() / 2; i++) {
            // 검색할 글자수 1부터 전체 글자의 절반까지 검사.
            String str = "";
            str = s.substring(0, i);
            int cnt = 1;
            String result = "";
            for (int j = i; j < s.length(); j = j + i) {
                String substring = "";
                //만약 마지막 인덱스가 추출 단위를 더했을때 넘어가는 경우, substring 을 나머지 값들로 대체.

                try {

                    substring = s.substring(j, j + i);
                } catch (Exception e) {
                    substring = s.substring(j, s.length());
                }

                if (str.equals(substring)) {
                    cnt++;
                } else {
                    //만약 다음 subset 이 기존의 것과 다르다면 임시저장 str 초기화와 result에 삽입
                    if (cnt > 1) {
                        result += String.valueOf(cnt);
                    }
                    result += str;
                    str = substring;
                    cnt = 1;
                }
            }
            //매우 중요한 과정, 위의 반복문이 끝나며느
            if (cnt > 1) {
                result += String.valueOf(cnt);
                result+=str;
            } else {
                result+=str;
            }
            min = Math.min(min, result.length());
        }
        if (s.length() == 1) {
            System.out.println(1);
        } else {

            System.out.println(min);
        }

    }
}
/*
aabbaccc
ababcdcdababcdcd
 */