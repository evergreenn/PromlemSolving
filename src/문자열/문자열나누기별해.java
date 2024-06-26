package 문자열;

public class 문자열나누기별해 {
    //2:44~7:03
    public int  solution(String s) {

        int cnt=0;
        int init=s.charAt(0);
        int init_cnt=0;
        int next_cnt=0;
        if(s.length()==1){
            return 1;
        }


        for(int i=0;i<s.length();i++){

            if(i==s.length()-1){
                //마지막 인덱스라면 바로 return, 남은갯수는 1개로 취급.
                cnt++;
                break;
            }
            char c= s.charAt(i);
            if(init!=c){
                next_cnt++;
                if(init_cnt==next_cnt){
                    cnt++;
                    init=s.charAt(i+1);
                    next_cnt=0;
                    init_cnt=0;
                }
            }else{
                init_cnt++;
            }


        }


        int answer = cnt;
        return answer;
    }
}
