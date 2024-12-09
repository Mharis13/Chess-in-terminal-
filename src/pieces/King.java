package pieces;

import java.util.Scanner;

public class King extends Piece {

    public King(String name, String icon, String color) {
        super(name, icon, color);
    }

    public void movement(String[][] board, int rows, int cols) {
        boolean isValid = false;
        Scanner sc = new Scanner(System.in);
        String newRow = "";
        int newCol = 0;
        int row2 = 0;
        while (!isValid) {
            System.out.print("Move: ");
            String move = sc.nextLine();
            String[] moveParts = move.split("");
            newRow = moveParts[0].toUpperCase();
            newCol = Integer.parseInt(moveParts[1]);
            row2 = getPosition(board, newRow);

            if (move.length() == 3 || (Integer.parseInt(moveParts[1]) < 1 && Integer.parseInt(moveParts[1]) > 8)
                    || (moveParts[0].charAt(0) > 'A' && moveParts[0].charAt(0) < 'H')) {
                System.out.println("The move is not valid");

            } else if (board[row2][Integer.parseInt(moveParts[1])].equals(" ■ ")
                    || board[row2][Integer.parseInt(moveParts[1])].equals(" □ ")) {
                System.out.println("The move is not valid");
            } else {
                isValid = true;
            }

        }

        if (getColor().equals("white")) {
            board[row2][newCol] = " ♔ ";
            if (board[rows][cols - 1].equals(" ■ ")) {
                board[rows][cols] = " □ ";
            } else {
                board[rows][cols] = " ■ ";
            }
        } else {
            board[row2][newCol] = " ♚ ";
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
            if (board[0][i].equals(Character.toString(c))) {
                position = i;
            }
        }
        return position;
    }
}
