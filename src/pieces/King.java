package pieces;

import java.util.List;
import java.util.Scanner;

public class King extends Piece {

    public King(String name, String icon, String color) {
        super(name, icon, color);
    }

    public void movement(String[][] board, int rows, int cols) {
        boolean isValid = false;
        Scanner sc = new Scanner(System.in);
        String newCol = "";
        int newRow = 0;
        int letterRow = 0;
        while (!isValid) {
            System.out.print("Move: ");
            String move = sc.nextLine();
            String[] moveParts = move.split("");
            newCol = moveParts[0].toUpperCase();
            newRow = Integer.parseInt(moveParts[1]); // aux
            letterRow = getPosition(board, newCol) + 1;

            if ((newRow < 1 && newRow > 8)
                    || (moveParts[0].charAt(0) >= 'A' && moveParts[0].charAt(0) <= 'H')) {
                System.out.println("The move is not valid");

            } else if (letterRow != cols) {
                if (!isValidMoveHorizontal(board, rows, cols, newRow, letterRow, this)) {

                    System.out.println("The move is not valid");
                } else {
                    isValid = true;
                }
            }

            else {

                isValid = true;
            }

        }

        if (getColor().equals("white")) {
            board[newRow][letterRow] = " ♔ ";
            if (board[rows][cols - 1].equals(" ■ ")) {
                board[rows][cols] = " □ ";
            } else {
                board[rows][cols] = " ■ ";
            }
        } else {
            board[newRow][letterRow] = " ♚ ";
            if (board[rows][cols - 1].equals(" ■ ")) {
                board[rows][cols] = " □ ";
            } else {
                board[rows][cols] = " ■ ";
            }
        }

        sc.close();

    }

    static int getPosition(String[][] board, String s) {
        int position = 0;
        char c = s.charAt(0);
        for (int i = 0; i < board.length; i++) {
            if (board[0][i].equals("  " + c)) {
                position = i;
            }
        }
        return position;
    }

    static boolean isValidMoveHorizontal(String[][] board, int row, int col, int newRow, int newCol, King king) {

        if (newRow == 0) {
            return false;
        }
        int rowDiff = Math.abs(row - newRow);
        int colDiff = Math.abs(col - newCol);
        if (king.getColor().equals("white")) {

            if (isPositionValid(board, newRow, newCol, rowDiff, colDiff)) {
                return false;
            } else if (containsWhitePiece(board, rowDiff, colDiff)) {
                return false;
            }
        } else {
            if (isPositionValid(board, newRow, newCol, rowDiff, colDiff)) {
                return false;
            } else if (containsBlackPiece(board, rowDiff, colDiff)) {
                return false;
            }

        }
        return true;
    }

    private static boolean isPositionValid(String[][] board, int newRow, int newCol, int rowDiff, int colDiff) {
        return (rowDiff & colDiff) != 1 || (newRow < 0 && newRow > board.length)
                || (newCol < 0 && newCol > board.length);
    }

    static boolean containsWhitePiece(String[][] board, int row, int col) {
        List<String> whitePieces = List.of("♕", "♖", "♗", "♘", "♙");
        return whitePieces.contains(board[row][col]);
    }

    static boolean containsBlackPiece(String[][] board, int row, int col) {
        List<String> blackPieces = List.of("♛", "♜", "♝", "♞", "♟");
        return blackPieces.contains(board[row][col]);
    }

}
