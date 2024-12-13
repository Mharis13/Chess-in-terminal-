package pieces;

import java.util.List;
import java.util.Scanner;

public class Pawn extends Piece {

    public Pawn(String name, String icon, String color) {
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

            }
            if (!isValidMoveVertical(board, rows, cols, newRow, letterColumn, this)) {
                System.out.println("The move is not valid");

            } else {

                isValid = true;
            }

        }

        if (newRow == 8 && this.getColor().equals("white")) {

        }

        if (getColor().equals("white")) {
            String piece = " ♙ ";
            if (newRow == 1) {
                piece = convertPawn(piece, this);

            }
            board[newRow][letterColumn] = piece;
            if (board[rows][cols - 1].equals(" ■ ")) {
                board[rows][cols] = " □ ";
            } else {
                board[rows][cols] = " ■ ";
            }
        } else {
            String piece = " ♟ ";
            if (newRow == 8) {
                piece = convertPawn(piece, this);

            }
            board[newRow][letterColumn] = piece;
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

    private static boolean isValidMoveVertical(String[][] board, int row, int col, int newRow, int newCol, Pawn king) {
        int rowDiff = 0;
        boolean isPositionZero = false;

        rowDiff = Math.abs(row - newRow);

        if (row == 7) {
            isPositionZero = true;
        }

        if (king.getColor().equals("white")) {
            if (row < newRow) {
                return false;
            }
            if (((newRow < 0 || newRow > board.length - 1)
                    || (rowDiff != 1)) && !isPositionZero) {
                return false;
            } else if (containsWhitePiece(board, newRow, newCol) || containsBlackPiece(board, newRow, newCol)) {
                return false;
            } else if (isPositionZero) {
                if (((newRow < 0 || newRow > board.length - 1)
                        || (rowDiff == 2))) {
                    return true;
                } else {
                    return false;
                }
            }
        } else {
            if (row > newRow) {
                return false;
            }

            if ((newRow < 0 || newRow > board.length - 1)
                    || (rowDiff != 1)) {
                return false;
            } else if (containsBlackPiece(board, newRow, newCol) || containsWhitePiece(board, newRow, newCol)) {
                return false;
            } else if (isPositionZero) {
                if (((newRow < 0 || newRow > board.length - 1)
                        || (rowDiff == 2))) {
                    return true;
                }
            }
        }
        return true;
    }

    private static String convertPawn(String piece, Pawn pawn) {
        Scanner sc = new Scanner(System.in);
        if (pawn.getColor().equals("white")) {

            do {
                System.out.println("Tell what piece you want:");
                piece = sc.nextLine();
                switch (piece) {
                    case "horse":
                        piece = "♘";

                        break;
                    case "queen":
                        piece = "♕";
                        break;
                    case "bishop":
                        piece = "♗";
                        break;
                    case "tower":
                        piece = "♖";
                        break;

                    default:
                        piece = "";
                        break;
                }
            } while (piece == "");

        } else {
            do {
                System.out.println("Tell what piece you want:");
                piece = sc.nextLine();
                switch (piece) {
                    case "horse":
                        piece = "♞";

                        break;
                    case "queen":
                        piece = "♛";
                        break;
                    case "bishop":
                        piece = "♝";
                        break;
                    case "tower":
                        piece = "♜";

                    default:
                        piece = "";
                        break;
                }
            } while (piece == "");

        }
        sc.close();
        return piece;
    }

    private static boolean containsWhitePiece(String[][] board, int row, int col) {
        List<String> whitePieces = List.of("♕", "♖", "♗", "♘", "♙", "♔");
        return whitePieces.contains(board[row][col]);
    }

    private static boolean containsBlackPiece(String[][] board, int row, int col) {
        List<String> blackPieces = List.of("♛", "♜", "♝", "♞", "♟", "♚");
        return blackPieces.contains(board[row][col]);
    }

}
