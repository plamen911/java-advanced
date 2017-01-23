// https://judge.softuni.bg/Contests/Practice/Index/187#10
package org.lynxlake.stacksAndQueues._11SimpleTextEditor;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Stack<String> result = new Stack<>();
        String currentString = "";
        result.push(currentString);

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().trim().split("\\s+");
            switch (input[0]) {
                case "1":
                    String string = input[1];
                    currentString += string;
                    result.push(currentString);
                    break;

                case "2":
                    try {
                        int count = Integer.parseInt(input[1]);
                        currentString = currentString.substring(0, currentString.length() - count);
                        result.push(currentString);
                    } catch (IndexOutOfBoundsException ignore) {

                    }

                    break;

                case "3":
                    try {
                        int index = Integer.parseInt(input[1]);
                        System.out.println(currentString.charAt(index - 1));
                    } catch (IndexOutOfBoundsException ignore) {

                    }

                    break;

                case "4":
                    result.pop();
                    currentString = result.peek();
                    break;
            }
        }
    }
}
