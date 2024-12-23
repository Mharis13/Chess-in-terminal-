package pieces;

import java.util.Scanner;

public class Bishop extends Piece {

    public Bishop(String name, String icon, String color, int row, int col) {
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
            newRow = Integer.parseInt(moveParts[1]);
            letterColumn = getPosition(board, newCol) + 1;

            if ((newRow < 1 || newRow > 8)
                    || (newCol.charAt(0) < 'A' || newCol.charAt(0) > 'H')) {
                System.out.println("The move is not valid");
                continue;
            }

            if (Math.abs(newRow - rows) == Math.abs(letterColumn - cols)) {
                if (isPathClear(board, rows, cols, newRow, letterColumn)) {
                    isValid = true;
                } else {
                    System.out.println("The path is not clear");
                }
            } else {
                System.out.println("The move is not valid");
            }
        }

        if (getColor().equals("white")) {
            board[newRow][letterColumn] = " ♗ ";
        } else {
            board[newRow][letterColumn] = " ♝ ";
        }

        if (board[rows][cols - 1].equals(" ■ ")) {
            board[rows][cols] = " □ ";
        } else {
            board[rows][cols] = " ■ ";
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

    private static boolean isPathClear(String[][] board, int startRow, int startCol, int endRow, int endCol) {
        int rowStep = (endRow - startRow) > 0 ? 1 : -1;
        int colStep = (endCol - startCol) > 0 ? 1 : -1;

        int currentRow = startRow + rowStep;
        int currentCol = startCol + colStep;

        while (currentRow != endRow && currentCol != endCol) {
            if (!board[currentRow][currentCol].equals(" □ ") && !board[currentRow][currentCol].equals(" ■ ")) {
                return false;
            }
            currentRow += rowStep;
            currentCol += colStep;
        }

        return true;
    }

}