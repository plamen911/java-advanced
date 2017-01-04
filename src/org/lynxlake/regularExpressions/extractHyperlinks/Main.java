// https://judge.softuni.bg/Contests/Practice/Index/189#7
package org.lynxlake.regularExpressions.extractHyperlinks;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        StringBuilder builder = new StringBuilder();

        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();

        while (!line.equalsIgnoreCase("END")) {
            builder.append(line);
            line = scanner.nextLine();
        }

        // href\s*=\s*["|']*([A-Za-z:\/\.\?!#\(\)]+)["|']*
        // <a\b.*href\s*=\s*["|']*([A-Za-z:\/\.\?!#\(\)'\s+]*)["|']*.*?>
        // <a\b.*?href\s*=\s*["|']*([A-Za-z:\/\.\?!#\(\)'\s+]*)["|']*.*?>
        //String regex = "<a[^>]+href\\s*=\\s*(?:\"([^\"]*)\"|\'([^\']*)\'|([^\\s>]*))";
        String regex = "<a[^>]+href\\s*=\\s*(?:\"([^\"]*)\"|'([^']*)'|([^\\s>]*))[^>]*>";

        String text = builder.toString();

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            if (matcher.group(1) != null) {
                System.out.println(matcher.group(1));
            } else if (matcher.group(2) != null) {
                System.out.println(matcher.group(2));
            } else if (matcher.group(3) != null) {
                System.out.println(matcher.group(3));
            }
        }
    }
}
