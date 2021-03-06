// https://judge.softuni.bg/Contests/Practice/Index/195#14
package org.lynxlake._06ManualStringProcessingExercises._15MelrahShake;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder input = new StringBuilder(reader.readLine());
        StringBuilder target = new StringBuilder(reader.readLine());

        while (true) {
            int firstIndex = input.indexOf(target + "");
            int lastIndex = input.lastIndexOf(target + "");
            if (firstIndex == lastIndex || "".equals(target + "")) {
                System.out.println("No shake.");
                break;
            }
            input = input.replace(firstIndex, firstIndex + target.length(), "");
            input = input.replace(lastIndex - target.length(), lastIndex - target.length() + target.length(), "");
            int indexForRemove = target.length() / 2;
            target = target.replace(indexForRemove, indexForRemove + 1, "");
            System.out.println("Shaked it.");
        }

        System.out.println(input);
    }
}
