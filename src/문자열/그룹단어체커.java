package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class 그룹단어체커 {

    //11:29 ~ 11:49
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int cnt=0;

        for(int i=0;i<n;i++){
            String input = br.readLine();

            if(checker(input)){
                cnt++;
            }
        }
        System.out.println(cnt);

    }
    public static boolean checker(String input){
        LinkedList<Character> set = new LinkedList<Character>();
        //맨 첫번째 값은 미리 저장하기. -> 카카오 문자열 압축 문제 모티브
        set.add(input.charAt(0));

        for (int i = 1; i < input.length(); i++) {
            char c = input.charAt(i);
            if(set.getLast()==c){
                continue;
            }
            else {
                if(set.contains(c)){
                    return false;
                }else {
                    set.add(c);
                }
            }
        }
        return true;

    }
}
