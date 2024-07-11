package 이코테.Sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class 국영수 {
    //12:06 ~ 12:21
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<Student>();


        int N = s.nextInt();
        s.nextLine();
        for (int i = 0; i < N; i++) {
            String[] input = s.nextLine().split(" ");
            students.add(new Student(input[0], Integer.parseInt(input[1]), Integer.valueOf(input[2]),
                    Integer.valueOf(input[3])));

        }
        Collections.sort(students,new Comparator<Student>(){ //매우 중요, 괄호 빼먹지 않기.
            @Override
            public int compare(Student o1,Student o2){

                //국어 내림차순(오름차순이 디폴트)
                int judge=o2.korean- o1.korean;
                if (judge == 0) {
                    //영어 오름차순
                    judge=o1.english-o2.english;
                    if (judge == 0) {
                        //수학 내림차순
                        judge=o2.math-o1.math;
                        if (judge == 0) {
                            judge=o1.name.compareTo(o2.name);
                            return judge;
                        }
                        return judge;
                    }
                    return judge;
                }
                return judge;
            }
        });

        for (Student student : students) {
            System.out.println(student.name);
        }




    }
    static class Student{

        String name;
        int korean;
        int english;
        int math;

        public Student(String name, int korean, int english, int math) {
            this.name=name;
            this.korean=korean;
            this.english=english;
            this.math=math;
        }
    }
}
