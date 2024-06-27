package 문자열;

import java.util.Arrays;
import java.util.Comparator;

public class 문자열내마음대로정렬하기 {
    //4:04~4:24
    public String[] solution(String[] strings, int n) {


        Arrays.sort(strings,new Comparator<>(){
            @Override
            public int compare(String o1,String o2){

                char c1= o1.charAt(n);
                char c2=o2.charAt(n);

                int judge=c1-c2;

                if(judge==0){
                    return o1.compareTo(o2);
                }else{
                    return judge; //오름차순;
                }

            };

        });


        String[] answer = strings;
        return answer;
    }
}
