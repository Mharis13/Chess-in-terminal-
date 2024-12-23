import java.util.HashMap;
import java.util.Map;
import pieces.Bishop;
import pieces.Horse;
import pieces.King;
import pieces.Pawn;
import pieces.Piece;
import pieces.Queen;
import pieces.Turret;

public class Game {
    public Game() {
    }

    public static void main(String[] args) {
        game();
    }

    private static void game() {
        Board board = new Board();
        String[][] boardArray = board.generateBoard();
        HashMap<String, Piece> whitePieces = putPieces(true);
        HashMap<String, Piece> blackPieces = putPieces(false);
        boardArray = putPiecesInBoard(boardArray, whitePieces, blackPieces);
        board.refresh(boardArray);
    }

    static HashMap<String, Piece> putPieces(boolean isWhite) {
        Pawn pawn1, pawn2, pawn3, pawn4, pawn5, pawn6, pawn7, pawn8;
        Horse horse1, horse2;
        Turret turret1, turret2;
        Bishop bishop1, bishop2;
        Queen queen;
        King king;
        HashMap<String, Piece> pieces = new HashMap<>();

        if (isWhite) {
            pawn1 = new Pawn("a7", " ♙ ", "white", 7, 1);
            pawn2 = new Pawn("b7", "♙", "white", 7, 2);
            pawn3 = new Pawn("c7", " ♙  ", "white", 7, 3);
            pawn4 = new Pawn("d7", "♙", "white", 7, 4);
            pawn5 = new Pawn("e7", " ♙", "white", 7, 5);
            pawn6 = new Pawn("f7", " ♙", "white", 7, 6);
            pawn7 = new Pawn("g7", " ♙ ", "white", 7, 7);
            pawn8 = new Pawn("h7", " ♙", "white", 7, 8);
            horse1 = new Horse("Nc8", " ♘", "white", 8, 3);
            horse2 = new Horse("Nf8", " ♘", "white", 8, 6);
            turret1 = new Turret("Ta8", " ♖ ", "white", 8, 1);
            turret2 = new Turret("Th8", " ♖", "white", 8, 8);
            bishop1 = new Bishop("Bb7", "♗", "white", 8, 2);
            bishop2 = new Bishop("Bg7", "  ♗", "white", 8, 7);
            queen = new Queen("Qd8", " ♕ ", "white", 8, 4);
            king = new King("Ke8", " ♔", "white", 8, 5);
        } else {
            pawn1 = new Pawn("a2", " ♟ ", "black", 2, 1);
            pawn2 = new Pawn("b2", "♟", "black", 2, 2);
            pawn3 = new Pawn("c2", " ♟", "black", 2, 3);
            pawn4 = new Pawn("d2", " ♟ ", "black", 2, 4);
            pawn5 = new Pawn("e2", " ♟", "black", 2, 5);
            pawn6 = new Pawn("f2", " ♟", "black", 2, 6);
            pawn7 = new Pawn("g2", " ♟", "black", 2, 7);
            pawn8 = new Pawn("h2", "  ♟", "black", 2, 8);
            horse1 = new Horse("Nc1", " ♞", "black", 1, 3);
            horse2 = new Horse("Nf1", " ♞", "black", 1, 6);
            turret1 = new Turret("Ta1", " ♜ ", "black", 1, 1);
            turret2 = new Turret("Th1", " ♜", "black", 1, 8);
            bishop1 = new Bishop("Bb2", "♝", "black", 1, 2);
            bishop2 = new Bishop("Bg2", "  ♝", "black", 1, 7);
            queen = new Queen("Qd1", " ♛ ", "black", 1, 4);
            king = new King("Ke1", " ♚", "black", 1, 5);
        }

        pieces.put(pawn1.getName(), pawn1);
        pieces.put(pawn2.getName(), pawn2);
        pieces.put(pawn3.getName(), pawn3);
        pieces.put(pawn4.getName(), pawn4);
        pieces.put(pawn5.getName(), pawn5);
        pieces.put(pawn6.getName(), pawn6);
        pieces.put(pawn7.getName(), pawn7);
        pieces.put(pawn8.getName(), pawn8);
        pieces.put(horse1.getName(), horse1);
        pieces.put(horse2.getName(), horse2);
        pieces.put(turret1.getName(), turret1);
        pieces.put(turret2.getName(), turret2);
        pieces.put(bishop1.getName(), bishop1);
        pieces.put(bishop2.getName(), bishop2);
        pieces.put(queen.getName(), queen);
        pieces.put(king.getName(), king);

        return pieces;
    }

    static String[][] putPiecesInBoard(String[][] board, Map<String, Piece> whitePieces,
            Map<String, Piece> blackPieces) {
        whitePieces.forEach((name, piece) -> {
            board[piece.getRow()][piece.getCol()] = "" + piece.getIcon();
        });
        blackPieces.forEach((name, piece) -> {
            board[piece.getRow()][piece.getCol()] = "" + piece.getIcon();
        });
        return board;
    }
}
