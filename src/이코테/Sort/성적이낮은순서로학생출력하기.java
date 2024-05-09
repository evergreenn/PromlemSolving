package 이코테.Sort;

import java.util.ArrayList;
import java.util.Scanner;

public class 성적이낮은순서로학생출력하기 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int N = s.nextInt();
        s.nextLine();

        ArrayList<Student> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String[] input = s.nextLine().split(" ");
            Student student = new Student(input[0], Integer.parseInt(input[1]));
            list.add(student);
        }
        list.sort((a, b) -> (a.score-b.score)); //자기자신이 작으면 음수 -> 오름차순
        //복잡하니, 디폴트가 오름차순 ( a-b) 로 정렬된다고 생각하기 !


        for (Student student : list) {
            System.out.print(student.name+" ");
        }


    }
}
class Student{
    String name;
    int score;
    public Student(String name,int score){
        this.name=name;
        this.score=score;
    }
}