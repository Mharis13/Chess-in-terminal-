import pieces.King;

public class Board {

    // FUTURE REFACT :D ESTE CODIGO ES UNA MIERDA
    static String[][] generateBoard() {
        String[][] board = new String[9][9];
        char character = 'A';

        // Creating the chess board
        for (var rows = 0; rows < board.length; rows++) {
            for (var cols = 0; cols < board[rows].length; cols++) {

                if (rows == 0) {
                    if (character == 'I') {
                        board[rows][cols] = "";
                        continue;
                    }
                    board[rows][cols] = "  " + Character.toString(character);
                    character++;
                }

                if (cols == 0 && rows != 0) {
                    board[rows][cols] = Integer.toString(rows);

                }

                if (rows != 0 && cols != 0) {
                    if (rows % 2 == 0 && cols == 1) {

                        board[rows][cols] = " □ ";
                        continue;
                    } else if (rows % 2 != 0 && cols == 1) {
                        board[rows][cols] = " ■ ";

                        continue;
                    }

                    if (board[rows][cols - 1].equals(" □ ")) {
                        board[rows][cols] = " ■ ";
                    } else {
                        board[rows][cols] = " □ ";
                    }
                }

            }

        }
        return board;
    }

    public static void main(String[] args) {
        var board = generateBoard();
        King king = new King("K", "♔", "white");
        board[5][5] = king.getIcon();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        king.movement(board, 5, 5);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }

    }

}