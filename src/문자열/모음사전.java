package 문자열;

import java.util.*;



class 모음사전 {
    static String result;
    static Boolean[] visit;
    static String[] arr;
    static LinkedList<String> linkedList;

    public static void main(String[] args) {
        //11:09
        arr= new String[]{"A", "E", "I", "O", "U"};
        int answer = 0;

        String word="AAAAE";

        result="";
        visit=new Boolean[5];
        Arrays.fill(visit,false);
        linkedList =new LinkedList<>();

        for (int i = 1; i <= 5; i++) { // 1자리 부터 5자리까지 각각의 자리에 들어갈수 있는 모든 값을 완전탐색함.
            dfs("",i);
        }

        //처음에 해맸던 부분 당연히 5 C 5 이면 뽑는 조합의 수는 1개임. 당연히 AEIOU 1개임.(중복을 허용하지 않기 때문임)
        //내 의도대로 할려면 중복 순열을 사용해야함.
        // 차라리 dfs의 백트레킹을 이용한 완전탐색으로 풀면 됨.

        Collections.sort(linkedList);

        answer= linkedList.indexOf(word)+1;

        System.out.println(answer);
    }

    public static void dfs(String result,int end) {
        if (result.length() == end) {
            linkedList.add(result);
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            dfs(result + arr[i],end);
        }




    }

}