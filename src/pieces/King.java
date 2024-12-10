package pieces;

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
}
