public class Point {
    public final double x;
    public final double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }


    public static double calcDistance(Point point1, Point point2) {
        return Math.sqrt(
                Math.pow(point2.getX() - point1.getX(), 2) +
                        Math.pow(point2.getY() - point1.getY(), 2)
        );
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public String toString() {
        return "(" + x + "; " + y + ")";
    }
}