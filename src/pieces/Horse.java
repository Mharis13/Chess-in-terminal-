package pieces;

import java.util.List;
import java.util.Scanner;

public class Horse extends Piece {

    public Horse(String name, String icon, String color, int row, int col) {
        super(name, icon, color, row, col);
    }

    @Override
    public void movement(String[][] board, int rows, int cols) {
        boolean isValid = false;
        Scanner sc = new Scanner(System.in);
        String newCol = "";
        int newRow = 0;
        int letterColumn = 0;
        while (!isValid) {
            System.out.print("Move: ");
            String move = sc.nextLine();
            String[] moveParts = move.split("");
            newCol = moveParts[0].toUpperCase();
            newRow = Integer.parseInt(moveParts[1]); // aux
            letterColumn = getPosition(board, newCol) + 1;
            if ((newRow < 1 || newRow > 8)
                    || (newCol.charAt(0) < 'A' || newCol.charAt(0) > 'H')) {
                System.out.println("The move is not valid");

            } else if (!isValidShapeInL(board, rows, cols, newRow, letterColumn, this)) {
                System.out.println("The move is not valid");
            } else {

                isValid = true;
            }

        }

        if (getColor().equals("white")) {
            board[newRow][letterColumn] = " ♔ ";
            if (board[rows][cols - 1].equals(" ■ ")) {
                board[rows][cols] = " □ ";
            } else {
                board[rows][cols] = " ■ ";
            }
        } else {
            board[newRow][letterColumn] = " ♚ ";
            if (board[rows][cols - 1].equals(" ■ ")) {
                board[rows][cols] = " □ ";
            } else {
                board[rows][cols] = " ■ ";
            }
        }

        sc.close();
    }

    private static boolean isValidShapeInL(String[][] board, int row, int col, int newRow, int newCol, Horse horse) {

        int rowDiff = Math.abs(newRow - row);
        int colDiff = Math.abs(newCol - col);

        if (horse.getColor().equals("white")) {

            if (containsWhitePiece(board, rowDiff, colDiff)) {
                return false;
            }
            if ((rowDiff == 2 && colDiff == 1) || (rowDiff == 1 && colDiff == 2)) {
                return true;
            }
        } else {
            if (containsBlackPiece(board, rowDiff, colDiff)) {
                return false;
            }
            if ((rowDiff == 2 && colDiff == 1) || (rowDiff == 1 && colDiff == 2)) {
                return true;
            }
        }

        return false;
    }

    private static int getPosition(String[][] board, String s) {
        int position = 0;
        char c = s.charAt(0);
        for (int i = 0; i < board.length; i++) {
            if (board[0][i].equals("  " + c)) {
                position = i;
            }
        }
        return position;
    }

    private static boolean containsWhitePiece(String[][] board, int row, int col) {
        List<String> whitePieces = List.of("♕", "♖", "♗", "♘", "♙");
        return whitePieces.contains(board[row][col]);
    }

    private static boolean containsBlackPiece(String[][] board, int row, int col) {
        List<String> blackPieces = List.of("♛", "♜", "♝", "♞", "♟");
        return blackPieces.contains(board[row][col]);
    }
}
