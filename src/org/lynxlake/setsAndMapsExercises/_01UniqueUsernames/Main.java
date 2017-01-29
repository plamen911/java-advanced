// https://judge.softuni.bg/Contests/Practice/Index/188#0
package org.lynxlake.setsAndMapsExercises._01UniqueUsernames;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        LinkedHashSet<String> userList = new LinkedHashSet<>();
        for (int i = 0; i < n; i++) {
            String username = reader.readLine().trim();
            userList.add(username);
        }
        for (String username : userList) {
            System.out.println(username);
        }
    }
}
