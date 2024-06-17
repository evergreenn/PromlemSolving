package 문자열;

import java.util.*;



class 문자열사전 {
    static String result;
    static int n = 5;
    static boolean[] visit;
    static String[] arr;
    static LinkedList<String> list;

    public static void main(String[] args) {
        //11:09
        arr= new String[]{"A", "E", "I", "O", "U"};
        int answer = 0;

        String word="AAAAE";

        result="";
        visit=new boolean[5];
        Arrays.fill(visit,false);
        list=new LinkedList<>();

        permutaion(0,5,5);

        Collections.sort(list);
        answer=list.indexOf(word)+1;

        System.out.println("answer = " + answer);

    }
    public static void permutaion(int start, int end, int depth){

        if(depth == 0){
            for(int i=0;i<end;i++){
                if(visit[i]){
                    result+=arr[i];
                }
            }
            System.out.println("result = " + result);
            list.add(result);
            result="";
            return;
        }
        for(int i=start;i<end;i++){
            visit[i]=true;
            System.out.println("start = " + start+" end = "+end+" depth = "+depth);
            permutaion(i+1,end,depth-1);
            visit[i]=false;
        }

    }
}