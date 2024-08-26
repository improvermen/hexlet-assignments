package exercise;

import java.awt.desktop.AppReopenedEvent;
import java.util.Date;
import java.util.SplittableRandom;

// BEGIN
public class Flat implements Home {
    private double area;
    private double balconsArea;
    private int floor;

    public Flat(double area, double balconsArea, int floor) {
        this.area = area;
        this.balconsArea = balconsArea;
        this.floor = floor;
    }

    @Override
    public double getArea() {
        return area + balconsArea;
    }

    @Override
    public String toString() {
        return String.format("Квартира площадью %.2f метров на %d этаже", getArea(), floor);
    }

    @Override
    public int compareTo(Home another) {
        if (another == null) {
            throw new IllegalArgumentException("Argument cannot be null");
        }
        double anotherArea = another.getArea();
        return Double.compare(this.getArea(), anotherArea);

    }
}

// END
