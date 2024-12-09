package pieces;

public abstract class Piece {
    private String icon;
    private String name;
    private String color;

    public Piece(String name, String icon, String color) {
        this.name = name;
        this.icon = icon;
        this.color = color;
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

    public abstract void movement(String[][] board, int rows, int cols);

}
