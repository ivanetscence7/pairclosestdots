import java.util.List;

public class BruteForce {

    public static Pair bruteForce(List<Point> points) {
        int numPoints = points.size();
        if (numPoints < 2) {
            return null;
        } else {
            Pair pair = new Pair(points.get(0), points.get(1));
            if (numPoints > 2) {
                for (int i = 0; i < numPoints - 1; ++i) {
                    Point point1 = points.get(i);
                    for (int j = i + 1; j < numPoints; ++j) {
                        Point point2 = points.get(j);
                        double distance = distance(point1, point2);
                        if (distance < pair.distance) {
                            pair.update(point1, point2, distance);
                        }
                    }
                }
            }

            return pair;
        }
    }

    public static double distance(Point point1, Point point2) {
        return Math.hypot((point2.x - point1.x), (point2.y - point1.y));
    }

}