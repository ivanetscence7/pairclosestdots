import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class DivideAndConquer {

    private Pair findPair(List<Point> points) {
        if (points.size() <= 6) {
            BruteForce bruteForce = new BruteForce();
            return bruteForce.bruteForce(points);
        }
        int middleIndex = points.size() / 2;
        Pair left = findPair(points.subList(0, middleIndex));
        Pair right = findPair(points.subList(middleIndex, points.size()));

        Pair currentResult = Pair.min(left, right);

        double middleLineMin = points.get(middleIndex).getX() - currentResult.getDistance();
        double middleLineMax = points.get(middleIndex).getX() + currentResult.getDistance();

        List<Point> pointsM = new ArrayList<>();

        for(Point point : points){
            if (point.getX() >= middleLineMin && point.getX() <= middleLineMax)
                pointsM.add(point);
        }

        Pair middleLineResult = null;
        double min = currentResult.getDistance();
        pointsM.sort(Comparator.comparingDouble(Point::getY));
        for (int i = 0; i < pointsM.size(); i++) {
            /* (pointsM.get(j).getY() - pointsM.get(i).getY() < min)*/;
            for (int j = i + 1; j < pointsM.size();  j++) {
                double dist = Point.calcDistance(pointsM.get(j), pointsM.get(i));
                if (dist < min) {
                    middleLineResult = new Pair(pointsM.get(i), pointsM.get(j), dist);
                }
            }
        }
        if (middleLineResult != null)
            currentResult = Pair.min(currentResult, middleLineResult);

        return currentResult;
    }

    public Pair find(List<Point> points) {
        points.sort(Comparator.comparingDouble(Point::getX));
        Pair result = findPair(points);
        return result;
    }

}