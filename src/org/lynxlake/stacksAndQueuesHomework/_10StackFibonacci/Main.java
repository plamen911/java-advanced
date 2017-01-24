// https://judge.softuni.bg/Contests/Practice/Index/187#9
package org.lynxlake.stacksAndQueuesHomework._10StackFibonacci;

import java.math.BigInteger;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        Stack<BigInteger> fib = new Stack<>();
        fib.push(BigInteger.ONE);
        fib.push(BigInteger.ONE);

        for (int i = 1; i < n; i++) {
            // pop() - Removes the object at the top of this stack and returns that object as the value of this function.
            BigInteger tmp = fib.pop();
            // peek() - Looks at the object at the top of this stack without removing it from the stack
            BigInteger num = fib.peek().add(tmp);
            fib.push(tmp);
            fib.push(num);
        }

        System.out.println(fib.peek());
    }
}
