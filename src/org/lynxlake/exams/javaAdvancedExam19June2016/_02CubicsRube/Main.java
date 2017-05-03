// https://judge.softuni.bg/Contests/Practice/Index/227#1
package org.lynxlake.exams.javaAdvancedExam19June2016._02CubicsRube;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Plamen Markov on 4/30/17.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());    // 3 dimensions of The Rube
        String line = "";
        List<Point> points = new ArrayList<>();

        int sumOfAllCells = 0;

        while (!"Analyze".equals(line = reader.readLine())) {
            String[] input = line.split("\\s+");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);
            int z = Integer.parseInt(input[2]);
            int particle = Integer.parseInt(input[3]);

            Point point = new Point(x, y, z);
            if (!points.contains(point) && point.isInsideCube(n)) {
                sumOfAllCells += particle;
                points.add(point);
            }
        }

        int cubeVolume = n * n * n;
        int amountOfChangedCells = points.size();
        int amountOfNotChangedCells = cubeVolume - amountOfChangedCells;

        System.out.println(sumOfAllCells);
        System.out.println(amountOfNotChangedCells);
    }
}

class Point {
    private int x;
    private int y;
    private int z;

    Point(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    boolean isInsideCube(int n) {
        return !(this.x < 0 || this.x > n || this.y < 0 || this.y > n || this.z < 0 || this.y > n);
    }

    @Override
    public String toString() {
        return String.format("%d_%d_%d", this.x, this.y, this.z);
    }
}

