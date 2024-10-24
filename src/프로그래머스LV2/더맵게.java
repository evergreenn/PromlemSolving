package 프로그래머스LV2;

import java.util.PriorityQueue;

public class 더맵게 {
    public static PriorityQueue<Integer> food=new PriorityQueue<>();
    public static int k;
    public int solution(int[] scoville, int K) {
        int answer = -1;
        this.k=K;
        for(int i=0;i<scoville.length;i++){
            food.add(scoville[i]);
        }

        int cnt=0;

        while(!food.isEmpty()&& food.size() !=1){

            if(check(food)){
                answer=cnt;

                break;
            }

            int first=food.remove();
            int second=food.remove();

            food.add(first+second*2);
            cnt++;

        }
        if(food.peek()>=k){
            answer=cnt;
        }

        return answer;
    }
    public static boolean check(PriorityQueue<Integer> q){

        int a=q.peek();


        if(a<k){
            return false;
        }

        return true;



    }
    class Food{

        int scovile;
        public Food(int scovile){
            this.scovile=scovile;
        }
    }

}
