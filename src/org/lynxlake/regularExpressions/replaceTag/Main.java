// https://judge.softuni.bg/Contests/Practice/Index/189#3
package org.lynxlake.regularExpressions.replaceTag;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        // re = "/<a\s+.*href=["|']*([a-z:\/\/\.\?!=_\-&;]+)["|']*.*>(.*)<\/a>/i";
        StringBuilder builder = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = reader.readLine();
        while (!line.equalsIgnoreCase("end")) {
            builder.append(line);
            line = reader.readLine();
        }

        String result = builder.toString().replaceAll("<a", "[URL");
        result = result.replaceAll("<\\/a>", "[\\/URL]");

        System.out.println(result);
    }
}
