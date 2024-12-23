package pieces;

public abstract class Piece {
    private String icon;
    private String name;
    private String color;
    private int row;
    private int col;

    public Piece(String name, String icon, String color, int row, int col) {
        this.name = name;
        this.icon = icon;
        this.color = color;
        this.row = row;
        this.col = col;
    }

    public String getIcon() {
        return icon;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }

    public abstract void movement(String[][] board, int rows, int cols);

}
