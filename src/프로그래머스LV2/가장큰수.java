package 프로그래머스LV2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class 가장큰수 {
    public static ArrayList<String> arr=new ArrayList<>();

    public String solution(int[] numbers) {
        String answer="";
        for(int i=0;i<numbers.length;i++){
            arr.add(String.valueOf(numbers[i]));
        }
        Collections.sort(arr,new Comparator<String>(){

                    @Override
                    public int compare(String o1,String o2){
                        return (o2+o1).compareTo(o1+o2);


                    }
                }
        );
        for(String str:arr){
            answer+=str;
        }
        if(answer.charAt(0)=='0'){
            return "0";
        }


        return answer;

    }
}
