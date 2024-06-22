package 이코테.Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class 데분프성적 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Student1> list = new ArrayList<>();


        for (int i = 0; i < 54; i++) {
            int[] array = Arrays.stream(br.readLine().split("\t"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

           list.add(new Student1(array[0], array[1]));
            System.out.println("array[0] = " + array[0]);
            System.out.println("i = " + i);


        }

        list.sort(new Comparator<Student1>() {
            @Override
            public int compare(Student1 o1, Student1 o2) {
                int score = o1.score;
                int score1 = o2.score;

                if (score == score1) {
                   return o1.num- o2.num;
                }

                return score1-score;


            }
        });
        int cnt=0;

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
            if (i == 17) {
                System.out.println("i = " + (i+1));
                System.out.println("A 컷트라인");
            }
            cnt++;

        }
        System.out.println("cnt = " + cnt);
        List<Student1> collect = list.stream()
                .filter(i -> i.score != 0)
                .collect(Collectors.toList());
        System.out.println(" 총 학생수 = " +collect.size() );

    }


}
class Student1{
    int num;
    int score;

    public Student1(int num, int score) {
        this.num=num;
        this.score=score;
    }

    @Override
    public String toString() {
        return num+" "+score;
    }
}
