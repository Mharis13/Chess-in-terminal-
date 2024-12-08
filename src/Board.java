public class Board {

    // FUTURE REFACT :D ESTE CODIGO ES UNA MIERDA
    static String[][] generateBoard() {
        String[][] board = new String[8][8]; // 8x8
        char aux = 'A';
        int cont = 0;
        // Creating the chess board
        for (var rows = 0; rows < board.length; rows++) {
            for (var cols = 0; cols < board.length; cols++) {
                if (rows == 0) {
                    if (cont == 0) {

                        for (int i = 1; i < 9; i++) {
                            System.out.print(" " + i + " ");
                        }
                        System.out.println();
                        cont++;
                    }

                    System.out.print(" " + aux + " ");
                    aux++;
                    if (aux == 'I') {
                        System.out.println();
                    }
                }

                if (rows % 2 == 0 && cols == 0) {

                    board[rows][cols] = " □ ";
                    continue;
                } else if (rows % 2 != 0 && cols == 0) {
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
        return board;

    }

}