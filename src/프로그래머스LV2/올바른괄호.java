package 프로그래머스LV2;

import java.util.Stack;

public class 올바른괄호 {
    public static Stack<String> stack=new Stack<>();
    boolean solution(String s) {
        boolean answer = true;
        for(int i=0;i<s.length();i++){

            String target=s.charAt(i)+"";
            if(target.equals("(")){

                stack.add(target);
            }else{

                if(stack.isEmpty()){
                    answer=false;
                    break;
                }
                if(stack.peek().equals(")")){
                    answer=false;
                    break;
                }
                stack.pop();
            }

        }

        if(stack.size()>0){
            answer=false;
        }




        return answer;
    }
}
