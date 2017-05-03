// https://judge.softuni.bg/Contests/Compete/Index/549#2
package org.lynxlake.exams.retakeExam03May2017._03ChessKnight;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Plamen Markov on 5/3/17.
 */
public class Main {
    private static final int chessSize = 8;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[][] matrix = new String[chessSize][chessSize];
        List<String> piecesTaken = new ArrayList<>();
        int invalidMoves = 0;
        int movesOutOfBoard = 0;

        // fill-in the chess board
        for (int i = 0; i < chessSize; i++) {
            String[] params = reader.readLine().trim().split("\\|");
            System.arraycopy(params, 0, matrix[i], 0, chessSize);
        }

        String startPosition = reader.readLine();
        int row = Integer.parseInt(startPosition.substring(0, 1));
        int col = Integer.parseInt(startPosition.substring(1));

        String line = "";

        while (!"END".equals(line = reader.readLine())) {
            String[] params = line.split(" -> ");

            int startRow = Integer.parseInt(params[0].substring(0, 1));
            int startCol = Integer.parseInt(params[0].substring(1));

            int endRow = Integer.parseInt(params[1].substring(0, 1));
            int endCol = Integer.parseInt(params[1].substring(1));

            if (!isValidMove(startRow, startCol, endRow, endCol)) {
                invalidMoves++;
            } else if (isOutOfBoard(endRow, endCol)) {
                movesOutOfBoard++;
            } else if (!matrix[endRow][endCol].equals(" ")) {
                piecesTaken.add(matrix[endRow][endCol]);
            }
        }

        System.out.printf("Pieces take: %s%n", String.join(", ", piecesTaken));
        System.out.printf("Invalid moves: %d%n", invalidMoves);
        System.out.printf("Board out moves: %d%n", movesOutOfBoard);
    }

    private static boolean isOutOfBoard(int row, int col) {
        return (row >= chessSize || col >= chessSize);
    }

    private static boolean isValidMove(int r1, int c1, int r2, int c2) {
        int row = Math.abs(r2 - r1);
        int col = Math.abs(c2 - c1);
        return ((row == 2 && col == 1) || (row == 1 && col == 2));
    }
}

