import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        int countTest = rnd(3, 5);
        //for (int k = 0; k < countTest; k++) {
        //int numPoints = 10;
        //int numPoints = rnd(10, 20);

        //points.stream().forEach(c -> System.out.println(c));

        int num = 8000;
        long allTimeBr = 0;
        long allTimeDiv =0;

        for(int j = 1000; j <= num; j*=2){
            List<Point> points = new ArrayList<>();

            for (int i = 0; i <=j; i++) {
                points.add(new Point(rnd(1, 20000), rnd(1, 20000)));
                // points.add(new Point(dbl(0, 1), dbl(0, 1)));
            }

            //System.out.println("Test: " + (k + 1) + "/" + countTest);
            System.out.println("Сгенерировано " + j + " точек");
            long startTime = System.currentTimeMillis();
            BruteForce brute = new BruteForce();
            Pair bruteForceClosestPair = brute.bruteForce(points);
            long endTime = System.currentTimeMillis() - startTime;
            System.out.println("Brute force (" + endTime + " ms): " + bruteForceClosestPair);

            allTimeBr+=endTime;

            long startTimeT = System.currentTimeMillis();
            DivideAndConquer divideAndConquer = new DivideAndConquer();
            Pair pair = divideAndConquer.find(points);
            long endTimeT = System.currentTimeMillis() - startTimeT;
            System.out.println("Divide and conquer  (" + endTimeT + " ms): " + pair);
            System.out.println("-=--=-=-=-=-=-=-");

            allTimeDiv+=endTimeT;
        }

        System.out.println("Среднее время для Brute Force: " + allTimeBr);
        System.out.println("Среднее время для Divide And Conquer: " + allTimeDiv);

//            System.out.println("Test: " + (k + 1) + "/" + countTest);
//            System.out.println("Сгенерировано " + numPoints + " точек");
//            long startTime = System.currentTimeMillis();
//            BruteForce brute = new BruteForce();
//            Pair bruteForceClosestPair = brute.bruteForce(points);
//            long endTime = System.currentTimeMillis() - startTime;
//            System.out.println("Brute force (" + endTime + " ms): " + bruteForceClosestPair);


//            startTime = System.currentTimeMillis();
//            DivideAndConquer divideAndConquer = new DivideAndConquer();
//            Pair pair = divideAndConquer.find(points);
//            endTime = System.currentTimeMillis() - startTime;
//            System.out.println("Divide and conquer  (" + endTime + " ms): " + pair);
//            System.out.println("-=--=-=-=-=-=-=-");
        // }
    }

    private static int rnd(int min, int max) {
        max -= min;
        return (int) (Math.random() * ++max) + min;
    }

    private static double dbl(int min, int max) {
        Random r = new Random();
        double randomValue = min + (max - min) * r.nextDouble();
        return randomValue;
    }

}

