package 문자열;

import java.util.*;
class Solution {
    //11:04 ~ 11:17
    public boolean solution(String s) {

        for(int i=0;i< s.length();i++){
            boolean check = '0'<=s.charAt(i) & s.charAt(i)<='9';

            if(!check){
                return false;
            }
        }

        boolean answer = true;
        if(s.length()==4 || s.length() == 6){

        }else{
            answer=false;
        }
        return answer;
    }
}
