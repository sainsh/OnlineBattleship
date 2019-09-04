package Model;

import java.io.Serializable;

public class Cell implements Serializable {
    private Coordinate coordinate;

    //Status 1 is not hit, status 2 is hit, status 3 is hit with a ship on it.
    private int status = 1;
    private Ship ship;

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus() {
        if (coordinate.isHit()){
            if (ship != null){
                status = 3;
            }
            else
                status = 2;
        }
    }

    public Ship getShip() {
        return ship;
    }

    public void setShip(Ship ship) {
        this.ship = ship;
    }
}
