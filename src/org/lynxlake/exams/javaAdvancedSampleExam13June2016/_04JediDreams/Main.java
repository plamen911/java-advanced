// https://judge.softuni.bg/Contests/Practice/Index/216#3
package org.lynxlake.exams.javaAdvancedSampleExam13June2016._04JediDreams;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    private static final String regex = "static\\s.*?([A-Za-z]+)\\s*\\(.*?\\)";

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(reader.readLine());
        }

        HashMap<String, ArrayList<String>> result = new HashMap<>();

        // get method names

        String[] methodsBodies = sb.toString().split(regex);
        ArrayList<String> tmp = new ArrayList<>();
        for (int i = 0; i < methodsBodies.length; i++) {
            String methodsBody = methodsBodies[i];
            if (!"".equals(methodsBody)) {
                tmp.add(methodsBody);
            }
        }

//        for (int i = 0; i < methodsBodies.length; i++) {
//            String methodsBody = methodsBodies[i];
//            System.out.println(methodsBody + "\n\n");
//        }

        int i = 0;
        ArrayList<String> methodNames = getMethodNames(sb.toString());
        for (String methodName : methodNames) {
            result.put(methodName, getMethodCalls(tmp.get(i)));
            i++;
        }

        String debug = "";
        // System.out.println(sb);
    }

    private static ArrayList<String> getMethodNames(String string) {
        ArrayList<String> results = new ArrayList<>();
        final Pattern pattern = Pattern.compile(regex);
        final Matcher matcher = pattern.matcher(string);

        while (matcher.find()) {
            results.add(matcher.group(1));
        }

        return results;
    }

    private static ArrayList<String> getMethodCalls(String string) {
        // final String re = "([A-Za-z]+)\\s*\\(.*?\\)";
        final String re = "([A-Za-z]+)\\s*\\([^\\(\\)]\\)";

        ArrayList<String> results = new ArrayList<>();
        final Pattern pattern = Pattern.compile(re);
        final Matcher matcher = pattern.matcher(string);

        while (matcher.find()) {
            results.add(matcher.group(1));
        }

        return results;
    }




}
