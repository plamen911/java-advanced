// https://judge.softuni.bg/Contests/Practice/Index/187#4
package org.lynxlake._03StacksAndQueuesExercises._05CalculateSequenceWithQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Long n = Long.parseLong(reader.readLine());

        ArrayDeque<Long> queue = new ArrayDeque<>();
        queue.addFirst(n);

        for (int i = 0; i < 50; i++) {
            Long current = queue.removeFirst();
            System.out.printf("%d ", current);

            Long s1 = current + 1;
            Long s2 = 2 * current + 1;
            Long s3 = current + 2;

            queue.addLast(s1);
            queue.addLast(s2);
            queue.addLast(s3);
        }
    }
}
