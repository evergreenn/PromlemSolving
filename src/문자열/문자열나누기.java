package 문자열;

import java.util.HashMap;
import java.util.LinkedList;

public class 문자열나누기 {
    public static LinkedList<Character> queue = new LinkedList<Character>();
    public static HashMap<Character,Integer> map =new HashMap<Character,Integer>();
    public static void main(String[] args) {
        int cnt=0;
        String s="banana";

        System.out.println(1);


        while(s.length()!=0){

            Character init = s.charAt(0);
            map.put(init,1);
            if(s.length()==1){
                cnt++;
                break;
            }


            for(int i=1;i<s.length();i++){
                Character c= s.charAt(i);
                System.out.println("c = " + c);
                if(c!=init){

                    if(map.get(init)==1){

                        cnt++;
                        String substr=s.substring(0,i+1);
                        System.out.println("substr = " + substr);
                        //가장 중요한 부분, string 문자열은 변경이 불가능함.
                        //그래서 새롭게 수정한 것을 다시 주솟값에 할당해 주어야함.
                         s = s.replaceFirst(substr, "");

                        map.clear();
                        System.out.println("s = " + s);
                        break;

                    }else{
                        if(map.containsKey(c)){
                            map.put(c,map.get(c)+1);

                        }else{
                            map.put(c,1);
                        }

                        if(map.get(init)==map.get(c)){
                            cnt++;
                            String substr=s.substring(0,i+1);
                            s=s.replaceFirst(substr,"");
                            map.clear();
                            break;
                        }
                    }
                }else{
                    map.put(c,map.get(c)+1);
                }
            }

        }



        int answer = cnt;
        System.out.println(answer);;

    }
}
