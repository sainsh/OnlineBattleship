package Model;

public class Board {
    private Cell[][] Board1;
    private Cell[][] Board2;

    public void setShipBoard1(Ship ship){}

    public void setShipBoard2(Ship ship){}

    public void shotBoard1(int x, int y){}

    public void shotBoard2(int x, int y){}

    public Cell[][] getBoard1() {
        return Board1;
    }

    public void setBoard1(Cell[][] board1) {
        Board1 = board1;
    }

    public Cell[][] getBoard2() {
        return Board2;
    }

    public void setBoard2(Cell[][] board2) {
        Board2 = board2;
    }
}
