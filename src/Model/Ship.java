package Model;

import java.io.Serializable;

public class Ship implements Serializable {

    public Coordinate coordinate = new Coordinate(0,0);
    public Coordinate coordinate2 = new Coordinate(0,1);
    public Coordinate[] coordinates = new Coordinate[2];

    public void setCoordinates() {
        coordinates[0] = coordinate;
        coordinates[1] = coordinate2;
        this.coordinates = coordinates;
    }

    public Coordinate[] getCoordinates() {
        return coordinates;
    }

    boolean isSunken;
}
