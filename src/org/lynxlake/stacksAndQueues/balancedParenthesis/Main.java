// https://judge.softuni.bg/Contests/Practice/Index/187#6
package org.lynxlake.stacksAndQueues.balancedParenthesis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine().trim();

        System.out.printf("%s", (isParenthesisMatch(input)) ? "YES" : "NO");
    }

    private static boolean isParenthesisMatch(String str) {
        Stack<Character> stack = new Stack<>();

        char c;
        for (int i = 0; i < str.length(); i++) {
            c = str.charAt(i);

            if (c == '(')
                stack.push(c);
            else if (c == '{')
                stack.push(c);
            else if (c == '[')
                stack.push(c);
            else if (c == ')')
                if (stack.empty())
                    return false;
                else if (stack.peek() == '(')
                    stack.pop();
                else
                    return false;
            else if (c == '}')
                if (stack.empty())
                    return false;
                else if (stack.peek() == '{')
                    stack.pop();
                else
                    return false;
            else if (c == ']')
                if (stack.empty())
                    return false;
                else if (stack.peek() == '[')
                    stack.pop();
                else
                    return false;

        }

        return stack.empty();
    }
}
