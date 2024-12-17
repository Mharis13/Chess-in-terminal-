package pieces;

import java.util.List;
import java.util.Scanner;

public class Queen extends Piece {

    public Queen(String name, String icon, String color) {
        super(name, icon, color);
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

            } else if (letterColumn != cols) {
                if (newRow == rows) {
                    if (!isValidMoveHorizontal(board, rows, cols, newRow, letterColumn, this)) {
                        System.out.println("The move is not valid");
                    } else {
                        isValid = true;
                    }

                }
                if (!isValidMoveDiagonal(board, rows, cols, newRow, letterColumn, this)) {

                    System.out.println("The move is not valid");
                } else {
                    isValid = true;
                }
            }

            else {
                if (!isValidMoveVertical(board, rows, cols, newRow, letterColumn, this)) {
                    System.out.println("The move is not valid");
                    continue;

                } else {

                    isValid = true;
                }

                isValid = true;
            }

        }

        if (getColor().equals("white")) {
            board[newRow][letterColumn] = " ♕ ";
            if (board[rows][cols - 1].equals(" ■ ")) {
                board[rows][cols] = " □ ";
            } else {
                board[rows][cols] = " ■ ";
            }
        } else {
            board[newRow][letterColumn] = " ♛ ";
            if (board[rows][cols - 1].equals(" ■ ")) {
                board[rows][cols] = " □ ";
            } else {
                board[rows][cols] = " ■ ";
            }
        }

        sc.close();

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

    private static boolean isValidMoveDiagonal(String[][] board, int row, int col, int newRow, int newCol,
            Queen queen) {
        // Check if the move is diagonal
        if (Math.abs(newRow - row) != Math.abs(newCol - col)) {
            return false;
        }

        // Determine the direction of the move
        int rowDirection = (newRow - row) > 0 ? 1 : -1;
        int colDirection = (newCol - col) > 0 ? 1 : -1;

        // Check if the path is clear
        int currentRow = row + rowDirection;
        int currentCol = col + colDirection;
        while (currentRow != newRow && currentCol != newCol) {

            currentRow += rowDirection;
            currentCol += colDirection;
        }

        // Check if the destination is valid
        if (queen.getColor().equals("white")) {
            if (containsWhitePiece(board, newRow, newCol)) {
                return false;
            }
        } else {
            if (containsBlackPiece(board, newRow, newCol)) {
                return false;
            }
        }

        return true;
    }

    private static boolean isValidMoveVertical(String[][] board, int row, int col, int newRow, int newCol,
            Queen queen) {

        if (queen.getColor().equals("white")) {
            if ((newRow < 0 || newRow > board.length - 1)) {
                return false;
            } else if (containsWhitePiece(board, newRow, newCol)) {
                return false;
            }
        } else {
            if ((newRow < 0 || newRow > board.length - 1)) {
                return false;
            } else if (containsBlackPiece(board, newRow, newCol)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isValidMoveHorizontal(String[][] board, int row, int col, int newRow, int newCol,
            Queen queen) {

        if (queen.getColor().equals("white")) {

            if ((newCol < 0 || newCol > board.length - 1)) {
                return false;
            } else if (containsWhitePiece(board, newRow, newCol)) {
                return false;
            }
        } else {
            if ((newCol < 0 || newCol > board.length - 1)) {
                return false;
            } else if (containsBlackPiece(board, newRow, newCol)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isPositionValid(String[][] board, int newRow, int newCol) {
        return (newRow < 0 || newRow > board.length - 1)
                || (newCol < 0 || newCol > board.length - 1);
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
