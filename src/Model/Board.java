package Model;

public class Board {
    private Cell[][] playerBoard;
    private Cell[][] enemyBoard;


    public void setShipPlayerBoard(Ship ship){}

    public void setShipEnemyBoard(Ship ship){}

    public Cell shootPlayerBoard(int x, int y){
        Cell shotCell = playerBoard[x][y];
        shotCell.getCoordinate().setHit(true);
        shotCell.getStatus();
        return shotCell;
    }

    public Cell shootEnemyBoard(int x, int y){
        Cell shotCell = enemyBoard[x][y];
        shotCell.getCoordinate().setHit(true);
        shotCell.getStatus();
        return shotCell;
    }

    public Cell[][] getPlayerBoard() {
        return playerBoard;
    }

    public Board() {
        Cell[][] cells = new Cell[5][5];
        for (int i = 0; i <= 4; i++) {
            for (int j = 0; j <= 4; j++) {
                cells[i][j] = new Cell();
                //Sets the coordinate to the position in the array
                cells[i][j].setCoordinate(new Coordinate(i,j));

            }
        }
        Ship ship = new Ship();
        ship.setCoordinates();
        cells[0][1].setShip(ship);
        cells[0][0].setShip(ship);
        this.playerBoard = cells;
        this.enemyBoard = cells;
    }

    public void setPlayerBoard(Cell[][] playerBoard) {
        this.playerBoard = playerBoard;
    }

    public Cell[][] getEnemyBoard() {
        return enemyBoard;
    }

    public void setEnemyBoard(Cell[][] enemyBoard) {
        this.enemyBoard = enemyBoard;
    }
}
