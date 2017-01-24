// https://judge.softuni.bg/Contests/Practice/Index/187#11
package org.lynxlake.stacksAndQueuesHomework._12InfixToPostfix;

import java.util.*;

public class Main {

    private static final int LEFT_ASSOC = 0;
    private static final int RIGHT_ASSOC = 1;
    private static final Map<String, int[]> ARITH_OPERATORS = new HashMap<>();
    private static final Map<String, int[]> REL_OPERATORS = new HashMap<>();
    private static final Map<String, int[]> LOG_OPERATORS = new HashMap<>();
    private static final Map<String, int[]> OPERATORS = new HashMap<>();

    static {
        ARITH_OPERATORS.put("+", new int[]{25, LEFT_ASSOC});
        ARITH_OPERATORS.put("-", new int[]{25, LEFT_ASSOC});
        ARITH_OPERATORS.put("*", new int[]{30, LEFT_ASSOC});
        ARITH_OPERATORS.put("/", new int[]{30, LEFT_ASSOC});
        ARITH_OPERATORS.put("%", new int[]{30, LEFT_ASSOC});
        ARITH_OPERATORS.put("^", new int[]{35, RIGHT_ASSOC});
        ARITH_OPERATORS.put("**", new int[]{30, LEFT_ASSOC});

        REL_OPERATORS.put("<", new int[]{20, LEFT_ASSOC});
        REL_OPERATORS.put("<=", new int[]{20, LEFT_ASSOC});
        REL_OPERATORS.put(">", new int[]{20, LEFT_ASSOC});
        REL_OPERATORS.put(">=", new int[]{20, LEFT_ASSOC});
        REL_OPERATORS.put("==", new int[]{20, LEFT_ASSOC});
        REL_OPERATORS.put("!=", new int[]{20, RIGHT_ASSOC});

        LOG_OPERATORS.put("!", new int[]{15, RIGHT_ASSOC});

        LOG_OPERATORS.put("&&", new int[]{10, LEFT_ASSOC});

        LOG_OPERATORS.put("||", new int[]{5, LEFT_ASSOC});

        LOG_OPERATORS.put("EQV", new int[]{0, LEFT_ASSOC});
        LOG_OPERATORS.put("NEQV", new int[]{0, LEFT_ASSOC});

        OPERATORS.putAll(ARITH_OPERATORS);
        OPERATORS.putAll(REL_OPERATORS);
        OPERATORS.putAll(LOG_OPERATORS);
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        String inputExpression = scanner.nextLine();

        String[] input = inputExpression.split("\\s+");
        List<String> output = infixToRPN(input);

        for (String s : output) {
            System.out.printf("%s ", s);
        }
    }

    private static boolean isAssociative(String token, int type) {
        if (!isOperator(token)) {
            System.out.println("");
        }

        return OPERATORS.get(token)[1] == type;
    }

    private static boolean isOperator(String token) {
        return OPERATORS.containsKey(token);
    }

    private static int cmpPrecedence(String token1, String token2) {
        if (!isOperator(token1) || !isOperator(token2)) {
            System.out.println("");
        }
        return OPERATORS.get(token1)[0] - OPERATORS.get(token2)[0];
    }

    private static ArrayList<String> infixToRPN(String[] inputTokens) {
        ArrayList<String> out = new ArrayList<>();
        Stack<String> stack = new Stack<>();
        // For all the input tokens [S1] read the next token [S2]
        for (String token : inputTokens) {
            if (isOperator(token)) {
                // If token is an operator (x) [S3]
                while (!stack.empty() && isOperator(stack.peek())) {
                    // [S4]
                    if ((isAssociative(token, LEFT_ASSOC) && cmpPrecedence(token, stack.peek()) <= 0)
                            || (isAssociative(token, RIGHT_ASSOC) && cmpPrecedence(token, stack.peek()) < 0)) {
                        out.add(stack.pop()); // [S5] [S6]
                        continue;
                    }
                    break;
                }
                // Push the new operator on the stack [S7]
                stack.push(token);
            } else if (token.equals("(")) {
                stack.push(token); // [S8]
            } else if (token.equals(")")) {
                // [S9]
                while (!stack.empty() && !stack.peek().equals("(")) {
                    out.add(stack.pop()); // [S10]
                }
                stack.pop(); // [S11]
            } else {
                out.add(token); // [S12]
            }
        }
        while (!stack.empty()) {
            out.add(stack.pop()); // [S13]
        }
        return out;
    }
}