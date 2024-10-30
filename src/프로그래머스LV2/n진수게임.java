package 프로그래머스LV2;

public class n진수게임 {
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        String[] insert={"0","1","2","3","4","5","6","7","8","9","A","B","C","D","E","F"};

        String str="0";
        for(int i=1;i<=t*m;i++){

            int num=i;
            String number="";

            while(num!=0){
                number=insert[num%n]+number;
                num/=n;
            }

            str+=number;
        }

        for(int i=p-1;i<t*m;i+=m){
            answer+=str.charAt(i);
        }
        return answer;
    }
}
