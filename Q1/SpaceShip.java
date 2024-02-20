package Q1;

import java.util.Arrays;

/**
 * SpaceShip
 * Given:
 * List of engines to be worked on
 * 1 engineer who can split into 2
 * 1 engineer works on 1 engine
 * splitting has cost associated
 * find minimum time by running thigs parallel
 * 
 */
public class SpaceShip {
    int[] engines;
    int engineerCount = 1;
    int splitCost = 1;

    SpaceShip(int[] engineArray, int noOfengineers, int splitCost) {
        this.engines = engineArray;
        this.splitCost = splitCost;
        engineerCount = noOfengineers;
    }

    int buildEngines(int engines[], int noOfengineers) {
        if (engines.length <= 1) {
            return 0; // 1 engineer
        }
        int maxEngine = 0;
        for (int i = 0; i < engines.length; i++) {
            if (engines[i] > engines[maxEngine])
                maxEngine = i;
        }

        if (engines[maxEngine] / splitCost < engines.length) {
            return engines[maxEngine] / splitCost;
        }
        // engine>=splitCost*engineerincreased;
        return engines.length - 1;
    }

    public static void main(String[] args) {
        SpaceShip ship = new SpaceShip(new int[] { 1, 2, 3 }, 1, 1);
        System.out.println();
        int noOfSplits = ship.buildEngines(ship.engines, ship.engineerCount);
        int splitTotal = noOfSplits * ship.splitCost;
        int shipTotal = 0;
        int count = 0;
        Arrays.sort(ship.engines);
        // while (count < ship.engines.length) {
        // int max = ship.engines[count];
        // for (int i = 0; i <= noOfSplits; i++) {
        // if (ship.engines[count] > max) {
        // max = ship.engines[count];
        // }
        // count++;
        // }
        // shipTotal += max;
        // }
        while (count < ship.engines.length) {
            int maxEngine = ship.engines[ship.engines.length - 1];
            for (int engineer = 0; engineer <= noOfSplits; engineer++) {
                if (engineer == 0)
                    maxEngine = ship.engines[ship.engines.length - count - 1];
                count++;
            }
            shipTotal += maxEngine;
        }
        shipTotal += splitTotal;
        System.out.println("ShipBuildallEngineCost is " + shipTotal);

    }

}