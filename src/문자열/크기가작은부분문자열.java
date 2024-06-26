package 문자열;
import java.util.*;

public class 크기가작은부분문자열 {

        //12:12 ~ 1:22
        public int solution(String t, String p) {
            int cnt=0;
            int p_size=p.length();
            for(int i=0;i<t.length()-p_size+1;i++){
                String substr=t.substring(i,i+p_size);


                Long t_num= Long.valueOf(substr);
                long p_num=Long.valueOf(p);
                if(t_num<=p_num){
                    cnt++;
                }
            }


            int answer = cnt;
            return answer;
        }

}
