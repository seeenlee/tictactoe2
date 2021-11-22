public class Board {
    private int[][] array;

    public Board() {
        array = new int[3][3];
    }

    public void clicked (boolean player1, int x, int y) {
        if (player1) {
            array[x][y] = 1;
        } else {
            array [x][y] = -1;
        }
    }

    public void reset() {
        array = new int[3][3];
    }

    public int[][] getArray() {
        return array;
    }
}
