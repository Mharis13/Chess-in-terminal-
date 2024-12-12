package pieces;

import java.util.List;
import java.util.Scanner;

public class Turret extends Piece {
    public Turret(String name, String icon,
            String color) {
        super(name, icon, color);
    }

    @Override
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

            if ((newRow < 1 || newRow > 8)
                    || (newCol.charAt(0) < 'A' || newCol.charAt(0) > 'H')) {
                System.out.println("The move is not valid");

            } else if (newRow == rows) {
                if (!isValidMoveHorizontal(board, letterRow, cols, newRow, cols, this)) {
                    System.out.println("The move is not valid");
                } else {
                    isValid = true;
                }
            } else {
                if (newRow != rows && letterRow == cols) {

                    if (!isValidMoveVertical(board, letterRow, cols, newRow, cols, this)) {
                        System.out.println("The move is not valid");
                    } else {
                        isValid = true;
                    }
                } else {

                    System.out.println("The move is not valid");
                }
            }

        }
        if (getColor().equals("white")) {
            board[newRow][letterRow] = " ♖ ";
            if (board[rows][cols - 1].equals(" ■ ")) {
                board[rows][cols] = " □ ";
            } else {
                board[rows][cols] = " ■ ";
            }
        } else {
            board[newRow][letterRow] = " ♜ ";
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

    private static boolean isValidMoveVertical(String[][] board, int row, int col, int newRow, int newCol,
            Turret king) {

        if (king.getColor().equals("white")) {
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
            Turret king) {

        if (king.getColor().equals("white")) {

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

    private static boolean containsWhitePiece(String[][] board, int row, int col) {
        List<String> whitePieces = List.of("♕", "♖", "♗", "♘", "♙");
        return whitePieces.contains(board[row][col]);
    }

    private static boolean containsBlackPiece(String[][] board, int row, int col) {
        List<String> blackPieces = List.of("♛", "♜", "♝", "♞", "♟");
        return blackPieces.contains(board[row][col]);
    }
}