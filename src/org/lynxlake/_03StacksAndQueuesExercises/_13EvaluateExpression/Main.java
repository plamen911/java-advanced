// https://judge.softuni.bg/Contests/Practice/Index/187#12
package org.lynxlake._03StacksAndQueuesExercises._13EvaluateExpression;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] input = scan.nextLine().split("\\s+");
        ArrayDeque<String> operators = new ArrayDeque<>();
        ArrayDeque<String> expression = new ArrayDeque<>();
        Map<String, Integer> priorities = new HashMap<>();
        priorities.put("*", 3);
        priorities.put("/", 3);
        priorities.put("+", 2);
        priorities.put("-", 2);
        priorities.put("(", 1);

        for (String anInput : input) {
            try {
                double num = Double.parseDouble(anInput);
                expression.addLast(anInput);
            } catch (Exception e) {
                switch (anInput) {
                    case "(":
                        operators.push(anInput);
                        break;
                    case ")":
                        String symbol = operators.pop();
                        while (!symbol.equals("(")) {
                            expression.addLast(symbol);
                            symbol = operators.pop();
                        }
                        break;
                    default:
                        while (!operators.isEmpty() && priorities.get(operators.peek()) >= priorities.get(anInput)) {
                            expression.addLast(operators.pop());
                        }
                        operators.push(anInput);
                        break;
                }
            }
        }
        while (!operators.isEmpty()) {
            expression.addLast(operators.pop());
        }

        while (expression.size() >= 1) {
            String token = expression.pop();
            try {
                double a = Double.parseDouble(token);
                operators.push(token);
            } catch (Exception e) {
                String operand1 = operators.pop();
                String operand2 = operators.pop();
                String result = doMath(token, operand1, operand2);
                operators.push(result);
            }
        }
        System.out.printf("%.2f", Double.parseDouble(operators.peek()));
    }

    private static String doMath(String token, String operand1, String operand2) {
        switch (token) {
            case "*":
                return Double.toString(Double.parseDouble(operand1) * Double.parseDouble(operand2));
            case "/":
                return Double.toString(Math.max(Double.parseDouble(operand2), Double.parseDouble(operand2)) /
                        Math.min(Double.parseDouble(operand1), Double.parseDouble(operand2)));
            case "+":
                return Double.toString(Double.parseDouble(operand1) + Double.parseDouble(operand2));
            default:
                return Double.toString((Double.parseDouble(operand2) - Double.parseDouble(operand1)));
        }
    }
}