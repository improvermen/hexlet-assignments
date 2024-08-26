package exercise;

// BEGIN
public class Flat implements Home {
    private double area;
    private double balconyArea;
    private int floor;

    public Flat(double area, double balconyArea, int floor) {
        this.area = area;
        this.balconyArea = balconyArea;
        this.floor = floor;
    }

    @Override
    public double getArea() {
        return area + balconyArea;
    }

    @Override
    public String toString() {
       return String.format("Квартира площадью %.1f метров на %d этаже", getArea(), floor);
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
