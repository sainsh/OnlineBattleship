package Model;

import java.io.Serializable;

public class Cell implements Serializable {
    private Coordinate coordinate;

    //Status 1 is not hit, status 2 is hit, status 3 is hit with a ship on it.
    private int Status = 1;
    private Ship ship;

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public int getStatus() {
        if (coordinate.isHit()){
        if (ship != null){
            setStatus(3);
        }
        else
            setStatus(2);
        }
        return Status;
    }

    public void setStatus(int status) {
        Status = status;
    }

    public Ship getShip() {
        return ship;
    }

    public void setShip(Ship ship) {
        this.ship = ship;
    }
}
