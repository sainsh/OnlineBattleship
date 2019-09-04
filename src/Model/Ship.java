package Model;

import java.io.Serializable;
import java.util.List;

//This class needs to be changed
public class Ship implements Serializable {
    private int length;
    private List<Coordinate> coordinates;

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public List<Coordinate> getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(List<Coordinate> coordinates) {
        this.coordinates = coordinates;
    }

    public boolean isSunken() {
        for (Coordinate c: coordinates) {
            if (!c.isHit()){
                return false;
            }
        }
        return true;
    }
}
