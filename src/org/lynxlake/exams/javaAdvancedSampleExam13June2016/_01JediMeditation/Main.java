// https://judge.softuni.bg/Contests/Practice/Index/216#0
package org.lynxlake.exams.javaAdvancedSampleExam13June2016._01JediMeditation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        List<String> masters = new ArrayList<>();
        List<String> knights = new ArrayList<>();
        List<String> padawans = new ArrayList<>();
        List<String> others = new ArrayList<>();
        boolean isYodaThere = false;

        for (int i = 0; i < n; i++) {
            String[] people = reader.readLine().split("\\s+");
            for (String person : people) {
                if (person.startsWith("m")) {
                    masters.add(person);
                } else if (person.startsWith("k")) {
                    knights.add(person);
                } else if (person.startsWith("p")) {
                    padawans.add(person);
                } else if (person.startsWith("y")) {
                    isYodaThere = true;
                } else {
                    others.add(person);
                }
            }
        }

        List<String> jedi = new LinkedList<>();
        if (!isYodaThere) {
            jedi.addAll(others);
            jedi.addAll(masters);
            jedi.addAll(knights);
            jedi.addAll(padawans);
        } else {
            jedi.addAll(masters);
            jedi.addAll(knights);
            jedi.addAll(others);
            jedi.addAll(padawans);
        }

        System.out.printf("%s", String.join(" ", jedi));
    }
}
