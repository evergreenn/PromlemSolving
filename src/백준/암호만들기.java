package 백준;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class 암호만들기 {
    static String[] input;
    static boolean[] visit;
    static int L;
    static int C;
    static ArrayList<ArrayList<String>> output = new ArrayList<ArrayList<String>>();
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

         L = s.nextInt();
         C = s.nextInt();
         s.nextLine(); //버퍼제거
        input=s.nextLine().split(" ");

        visit=new boolean[C+1];

        combination(new int[L],0,input.length,0);
        ArrayList<String> answerlist = new ArrayList<>();

        for(int i=0;i<output.size();i++){

            ArrayList<String> list = output.get(i);
            String answer="";

            for (String str : list) {
                answer+=str;
            }
            if (isAeiou(answer) && isnonAeiou(answer)) {
                answerlist.add(answer);
            }
        }
        Collections.sort(answerlist);

        for (String str : answerlist) {
            System.out.println(str);
        }

    }
    public static void printarr(){

        for(int i=0;i<output.size();i++){
            ArrayList<String> list = output.get(i);
            System.out.println(list.toString());
        }
    }
    public static boolean isAeiou(String str){
        if( str.contains("a")||str.contains("e")||str.contains("i")||str.contains("o")||str.contains("u")){
            return true;
        }

        return false;
    }
    public static boolean isnonAeiou(String str){
        int cnt=0;
        for(int i=0;i<str.length();i++){

            if(str.charAt(i)!='a' && str.charAt(i)!='e'&& str.charAt(i)!='i'&& str.charAt(i)!='o'&&
                    str.charAt(i)!='u'){
                cnt++;
            }
        }
        if (cnt >= 2) {
            return true;
        }else {
            return false;
        }
    }
    public static void combination(int[] now, int start, int end, int depth){
        //start 부터 end 까지의 범위에서 depth(now.length)개를 뽑는 경우의 수 (depth는 인덱스로 now에 저장)

        if(depth==L){
            ArrayList<String> tmp = new ArrayList<>();
            for(int i=0;i< now.length;i++){
                tmp.add(input[now[i]]);
            }
            Collections.sort(tmp);
            output.add(tmp);
            return;
        }

        for (int i=start;i<end;i++){
            if(!visit[i]){
                visit[i]=true;
                now[depth]=i;
                combination(now,i+1,end,depth+1);
                visit[i]=false;
            }
        }


    }
}
