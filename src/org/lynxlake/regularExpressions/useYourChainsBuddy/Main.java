// https://judge.softuni.bg/Contests/Practice/Index/189#9
package org.lynxlake.regularExpressions.useYourChainsBuddy;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();

        String patternStr = "<p>(.*?(?=<))</p>";
        String patternReplStr = "[^a-z0-9]+";   // all characters which are not small letters and numbers
        String patternSpaceStr = "\\s{2,}";

        StringBuilder sb = new StringBuilder();

        Pattern pattern = Pattern.compile(patternStr);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            String tag = matcher.group(1);
            tag = tag.replaceAll(patternReplStr, " ");
            char[] tagChars = tag.toCharArray();
            for (int i = 0; i < tagChars.length; i++) {
                if (tagChars[i] >= 'a' && tagChars[i] <= 'm') {
                    tagChars[i] = (char) (tagChars[i] + 13);
                } else if (tagChars[i] >= 'n' && tagChars[i] <= 'z') {
                    tagChars[i] = (char) (tagChars[i] - 13);
                }
            }
            sb.append(new String(tagChars));
        }

        text = sb.toString();
        text = text.replaceAll(patternSpaceStr, " ");
        System.out.println(text);
    }
}
