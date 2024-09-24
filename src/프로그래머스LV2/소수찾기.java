package 프로그래머스LV2;

import java.util.ArrayList;
import java.util.Arrays;

public class 소수찾기 {
    public static String numbers;
    public static boolean[] visited;


    public static ArrayList<Integer> output=new ArrayList<>();
    public int solution(String numbers) {
        int answer = 0;
        this.numbers=numbers;

        visited=new boolean[numbers.length()];
        Arrays.fill(visited,false);


        for(int i=1;i<=numbers.length();i++){

            permutation(new int[i],0);
            visited=new boolean[numbers.length()];



        }
        printOutput();
        for( Integer num : output){
            answer+=isPrime(num);
        }

        return answer;
    }

    public void printOutput(){

        for(int s : output){
            System.out.println(s);
        }
    }
    public int isPrime(int num){
        if(num==0||num==1){
            return 0;
        }


        for(int i=2;i<=Math.sqrt(num);i++){

            if(num%i==0&&i!=1){
                return 0;
            }
        }

        System.out.println(num+"은 소수로 판정");
        return 1;
    }

    public boolean isExist(int tmp){
        for(int num : output){
            if(num==tmp){
                return true;
            }
        }
        return false;
    }



    public void permutation(int[] now, int depth){
        //1 0
        //start~ end 의 범위에서 size 개를 뽑아서 줄세우는 경우의 수

        if(depth==now.length){
            String tmp="";
            for(int s=0;s<now.length;s++){
                tmp+=numbers.charAt(now[s])+"";
            }
            int number=Integer.valueOf(tmp);
            if(isExist(number)){
                return;
            }
            output.add(number);

            return;
        }

        for(int i=0;i<numbers.length();i++){
            if(!visited[i]){

                visited[i]=true;
                now[depth]=i;
                permutation(now, depth+1);
                visited[i]=false;
            }

        }



    }
}
