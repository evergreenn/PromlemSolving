package 소프티어;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class 암호화 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        if (input[0].equals("encrypt")) {
            String secretword = input[1];
            int[] secretword_int = new int[secretword.length()];
            for (int i = 0; i < secretword.length(); i++) {
                secretword_int[i] = (int) secretword.charAt(i) - 'a';
            }

            String helloword = input[3];

            int[] helloword_int = new int[helloword.length()];
            int[] sum = new int[helloword.length()];
            for (int i = 0; i < helloword.length(); i++) {
                helloword_int[i] = (int) helloword.charAt(i) - 'a';
                sum[i] = (helloword_int[i] + secretword_int[i]) % 26;
            }

            Queue<Integer> queue = new LinkedList<>();

            for (int i = 0; i < sum.length; i++) {
                queue.add(sum[i]);
            }

            int order = Integer.valueOf(input[2]);
            if (order > 0) {
                for (int i = 0; i < order; i++) {
                    Integer remove = queue.remove();
                    queue.add(remove);
                }
            }

            ArrayList<Integer> list = new ArrayList<>(queue);
            char[] answer = new char[list.size()];

            for (int i = 0; i < list.size(); i++) {
                int target = list.get(i) + 'a';
                answer[i] = (char) target;
            }
            System.out.println(answer);

        } else {

            String secretword = input[1];
            int[] secretword_int = new int[secretword.length()];
            for (int i = 0; i < secretword.length(); i++) {
                secretword_int[i] = (int) secretword.charAt(i) - 'a';
            }

            String crypto = input[3];

            int[] crypto_int = new int[crypto.length()];
            for (int i = 0; i < crypto_int.length; i++) {
                crypto_int[i] = (int) crypto.charAt(i) - 'a';
            }

            int order = Integer.valueOf(input[2]);
            LinkedList<Integer> queue = new LinkedList<>();

            for (int i = 0; i < crypto_int.length; i++) {
                queue.add(crypto_int[i]);
            }

            if (order > 0) {
                for (int i = 0; i < order; i++) {
                    Integer remove = queue.removeLast();
                    queue.addFirst(remove);
                }
            }
            ArrayList<Integer> list = new ArrayList<>(queue);
            int[] message=new int[queue.size()];
            for (int i = 0; i < list.size(); i++) {
                message[i] = list.get(i);
            }

            int[] minus = new int[message.length];

            for (int i = 0; i < message.length; i++) {
                int num = message[i] - secretword_int[i];
                if (num < 0) {
                    num=26+num;
                }
                minus[i]=num;
            }

            char[] answer = new char[minus.length];

            for (int i = 0; i < answer.length; i++) {
                answer[i]=(char) (minus[i] +'a');
            }
            System.out.println(answer);




        }
    }
}
