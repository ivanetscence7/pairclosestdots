public class Pair {
    public Point point1;
    public Point point2;
    public double distance;

    public Pair(Point point1, Point point2) {
        this.point1 = point1;
        this.point2 = point2;
        this.calcDistance();
    }

    public Pair(Point point1, Point point2, double distance) {
        this.point1 = point1;
        this.point2 = point2;
        this.distance = distance;
    }

    public void update(Point point1, Point point2, double distance) {
        this.point1 = point1;
        this.point2 = point2;
        this.distance = distance;
    }

    public void calcDistance() {
        this.distance = distance(this.point1, this.point2);
    }


    public static double distance(Point point1, Point point2) {
        return Math.hypot((point2.x - point1.x), (point2.y - point1.y));
    }

    public Point getPoint1() {
        return point1;
    }

    public Point getPoint2() {
        return point2;
    }

    public double getDistance() {
        return distance;
    }

    public String toString() {
        return "Ближайшая пара точек: " +
                "( " + this.point1 + ", " + this.point2 + " ) " +
                " Расстояние между ними = " + this.distance;
    }

    public static Pair min(Pair res1, Pair res2) {
        return res1.getDistance() < res2.getDistance() ? res1 : res2;
    }
}
