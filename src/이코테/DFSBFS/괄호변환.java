package 이코테.DFSBFS;

import java.util.*;
class 괄호변환 {
    //5:13~ 7: 05
    public String solution(String p) {

        String answer = "";
        if(p.length()==0){
            return answer;
        }
        String u=p.substring(0,balancedString(p)+1);
        String v=p.substring(balancedString(p)+1);
        if(checkCollectString(u)){


            return u+solution(v);
        }else{
            String tmp= "(";

            tmp+=solution(v);

            tmp+=")";

            u=u.substring(1,u.length()-1);


            String nu="";
            for(int i=0;i<u.length();i++){
                char c= u.charAt(i);
                if(c=='('){
                    nu+=")";
                }else if (c==')'){
                    nu+="(";
                }
            }
            tmp+=nu;
            answer=tmp;
        }
        return answer;

    }
    public boolean checkCollectString(String str){
        int cnt=0;
        for(int i=0;i<str.length();i++){
            char c= str.charAt(i);
            if( c == '('){
                cnt++;
            }else{
                cnt--;
            }
            if(cnt<0){
                return false;
            }
        }

        return true;

    }

    public int balancedString(String str){

        int cnt=0;

        for(int i=0;i<str.length();i++){
            char c=str.charAt(i);
            if(c=='('){
                cnt++;
            }else{
                cnt--;
            }
            if(cnt==0){
                return i;
            }
        }
        return -1;
    }
}
