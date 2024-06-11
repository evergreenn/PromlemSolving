package 이코테.greedy;

import java.util.LinkedList;

public class 무지의먹방라이브 {
    //11:40
    public static void main(String[] args) {

        int[] food_times={3, 1, 2};
        long k=5;

        LinkedList<Food> table=new LinkedList<Food>();

        for (int i = 0; i < food_times.length; i++) {
            table.add(new Food(food_times[i]));
        }
        int cnt=0;
        for (int i = 0; i < k; i++) {
            while (true) {

                Food first = table.getFirst();
                if (first.time != 0) {
                    Food food = table.removeFirst();
                    food.time-=1;
                    table.add(food);
                    cnt=0;
                    break;
                }
                table.add(table.removeFirst());
                cnt++;
                if (cnt == food_times.length) {
                    break;
                }
            }
        }
        if (cnt != 0) {
            System.out.println(-1);
        } else {
            for (int i = 0; i < table.size(); i++) {
                Food food = table.get(i);

                if (food.time != 0) {
                    System.out.println(i);
                }
                return;
            }
        }
        System.out.println(-1);

    }


}
class Food{
    int time;

    public Food(int time) {
        this.time=time;
    }

}
