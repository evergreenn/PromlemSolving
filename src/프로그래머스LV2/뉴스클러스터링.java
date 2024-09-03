package 프로그래머스LV2;

import java.util.ArrayList;

public class 뉴스클러스터링 {
    public static ArrayList<String> A=new ArrayList<String>();
    public static ArrayList<String> B=new ArrayList<String>();
    public static ArrayList<String> inter=new ArrayList<String>();
    public static ArrayList<String> union=new ArrayList<String>();

    public int solution(String str1, String str2) {

        makeArr(str1,str2);
        if(A.isEmpty()&&B.isEmpty()){
            return 65536;
        }
        int answer = 0;
        System.out.println(A.toString());

        for(int i=0;i<A.size();i++){
            String target=A.get(i);
            if(B.contains(target)){
                B.remove(target);
                inter.add(target);
            }
            union.add(target);
        }
        union.addAll(B);

        answer=(int)((double)inter.size()/union.size()*65536);



        return answer;
    }
    public static void makeArr(String str1,String str2){
        str1=str1.toLowerCase();
        str2=str2.toLowerCase();

        for(int i=0;i<str1.length()-1;i++){
            char target1=str1.charAt(i);
            char target2=str1.charAt(i+1);
            if(('a'<=target1&&target1<='z')&&('a'<=target2&&target2<='z')){
                A.add(target1+""+target2);
            }
        }

        for(int i=0;i<str2.length()-1;i++){
            char target1=str2.charAt(i);
            char target2=str2.charAt(i+1);
            if(('a'<=target1&&target1<='z')&&('a'<=target2&&target2<='z')){
                B.add(target1+""+target2);
            }
        }
    }



}
