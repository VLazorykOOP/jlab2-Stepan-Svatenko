package tasks;

public class Prism {
    private double height;
    private double side;

    public Prism(double height, double side) {
        this.height = height;
        this.side = side;
    }

    public double getVolume() {
        var baseArea = (side * side * Math.sqrt(3)) / 4;
        return baseArea * height;
    }

    public double getSide() {
        return 3 * side * height;
    }
}
