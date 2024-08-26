package exercise;

// BEGIN
public class Cottage implements Home {
    private double area;
    private int floorCount;

    public Cottage(double area, int floorCount) {
        this.area = area;
        this.floorCount = floorCount;
    }

    @Override
    public double getArea() {
        return area;
    }

    @Override
    public String toString() {
        return String.format("%d этажный коттедж площадью %.2f метров", floorCount, area);
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
