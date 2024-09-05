package 프로그래머스LV2;

import java.util.LinkedList;

public class 카카오캐시 {
    public static int size;
    public static LinkedList<String> queue=new LinkedList<>();

    public int solution(int cacheSize, String[] cities) {
        //10:22 ~ 10:55
        int answer = 0;
        size=cacheSize;
        if(size==0){
            answer=cities.length*5;
            return answer;
        }

        for(int i=0;i<cities.length;i++){
            String city=cities[i].toLowerCase();
            if(queue.contains(city)){
                answer+=1;
                queue.remove(city);
                queue.add(city);
            }else{
                answer+=5;
                if(queue.size()==cacheSize){

                    queue.removeFirst();
                }
                queue.add(city);
            }

        }

        return answer;
    }
}
