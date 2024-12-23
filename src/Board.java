
public class Board {

    // FUTURE REFACT :D ESTE CODIGO ES UNA MIERDA
    String[][] generateBoard() {
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

    static void refresh(String[][] board) {
        for (String row[] : board) {
            for (String col : row) {
                System.out.print(col);
            }
            System.out.println();
        }
    }
}