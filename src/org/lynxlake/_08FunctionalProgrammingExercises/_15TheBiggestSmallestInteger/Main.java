// https://judge.softuni.bg/Contests/Practice/Index/194#14
package org.lynxlake._08FunctionalProgrammingExercises._15TheBiggestSmallestInteger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        List<Integer> numberList = new ArrayList<>(Arrays.stream(input).boxed().collect(Collectors.toList()));
        String request = reader.readLine();
        String maxOrMin = request.substring(0, 3);
        String evenOrOdd = request.substring(3);

        String number = maxOrMin.equals("max") ? customFunc.apply(maxFunc, numberList, evenOrOdd) : customFunc.apply(minFunc, numberList, evenOrOdd);
        if (number != null) {
            System.out.println(number);
        }
    }

    //Max Function
    private static Function<List<Integer>, Integer> maxFunc = list -> list.stream().max(Integer::compare).get();
    //Min Function
    private static Function<List<Integer>, Integer> minFunc = list -> list.stream().min(Integer::compare).get();
    //General Function
    private static CustomFunc<Function, List<Integer>, String, String> customFunc = (function, numbers, request) -> {
        int remainder = request.equals("Odd") ? 1 : 0;
        numbers = numbers.stream().filter(e -> e % 2 == remainder).collect(Collectors.toList());
        return numbers.size() > 0 ? function.apply(numbers).toString() : null;
    };
}

@FunctionalInterface
interface CustomFunc<A, B, C, R> {
    R apply(A function, B arrayList, C evenOrOdd);
}
