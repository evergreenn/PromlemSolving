package 문자열;

import java.util.*;



class 모음사전 {
    static String result;
    static int n = 5;
    static Boolean[] visit;
    static String[] arr;
    static LinkedList<String> list;

    public static void main(String[] args) {
        //11:09
        arr= new String[]{"A", "E", "I", "O", "U"};
        int answer = 0;

        String word="AAAAE";

        result="";
        visit=new Boolean[5];
        Arrays.fill(visit,false);
        list=new LinkedList<>();

        dfs("");

        //처음에 해맸던 부분 당연히 5 C 5 이면 뽑는 조합의 수는 1개임. 당연히 AEIOU 1개임.(중복을 허용하지 않기 때문임)
        //내 의도대로 할려면 중복 순열을 사용해야함.

        Collections.sort(list);
        answer=list.indexOf(word)+1;

        System.out.println("answer = " + answer);

    }

    public static void dfs(String result) {
        if (result.length() == 5) {
            list.add(result);
            result="";
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            dfs(result + arr[i]);
        }




    }

}