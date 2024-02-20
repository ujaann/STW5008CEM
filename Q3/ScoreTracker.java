package Q3;

import java.util.ArrayList;
import java.util.List;

// import java.util.LinkedList;
// import java.util.PriorityQueue;
// import java.util.Queue;

public class ScoreTracker {

    List<Double> scores = new ArrayList<>();

    void addScore(Double score) {
        scores.add(score);
    }

    double getMedianScore() {
        scores.sort(null);
        // note that we sort the scores in ascending order to get median
        // chck if no elements is even
        switch (scores.size() % 2) {
            case 0:
                return (scores.get(scores.size() / 2) + scores.get(scores.size() / 2 - 1)) / 2;
            // if even then middle two numbers average
            default:
                return scores.get(scores.size() / 2);
            // odd then middle number
        }
    }

    public static void main(String[] args) {
        ScoreTracker sc = new ScoreTracker();
        sc.addScore(85.5);
        sc.addScore(92.3);
        sc.addScore(77.8);
        sc.addScore(90.1);
        double median1 = sc.getMedianScore();
        // [ 95.5 , 92.3 , 77.8, 90.1 ]
        // so average of n/2=4/2=2 and n/2-1=4/2-1=2-1=1
        System.out.println(median1);
        sc.addScore(81.2);
        sc.addScore(88.7);

        double median2 = sc.getMedianScore();
        System.out.println(median2);
    }
}
