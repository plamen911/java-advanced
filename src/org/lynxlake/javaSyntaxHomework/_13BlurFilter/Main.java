// https://judge.softuni.bg/Contests/Practice/Index/383#12
package org.lynxlake.javaSyntaxHomework._13BlurFilter;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int blurAmount = Integer.parseInt(scanner.nextLine());
        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        scanner.nextLine();

        int[][] matrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            String[] numbers = scanner.nextLine().split("\\s+");
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = Integer.parseInt(numbers[j]);
            }
        }


        System.out.println(blurAmount + " / " + rows + " / " + cols);
        //System.out.println("line: " + line);


    }
}
