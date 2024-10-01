package 프로그래머스LV2;

import java.util.ArrayList;
import java.util.Collections;

public class 모음사전 {
    public static ArrayList<String> wordBook=new ArrayList<>();
    //11:30
    public static int solution(String word) {

        dfs(0,"");
        Collections.sort(wordBook);

        int cnt=1;
        for(String str : wordBook){
            if(str.equals(word)){
                return cnt;
            }
            cnt++;
        }


        return cnt;

    }
    public static void dfs(int depth,String str){

        if(depth > 5){


            return;
        }
        if(str.length()!=0){
            wordBook.add(str);
        }

        dfs(depth+1,str+"A");
        dfs(depth+1,str+"E");
        dfs(depth+1,str+"I");
        dfs(depth+1,str+"O");
        dfs(depth+1,str+"U");
    }


}
