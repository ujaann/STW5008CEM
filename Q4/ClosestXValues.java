import java.util.ArrayList;
import java.util.Arrays;

public class ClosestXValues {
    public static void main(String[] args) {
        BST t = new BST();
        BST.Node root = t.createBST(null, 4);
        root = t.createBST(root, 5);
        root = t.createBST(root, 3);
        root = t.createBST(root, 2);
        root = t.createBST(root, 1);
        root = t.createBST(root, 6);
        t.inOrder(root);
        double number = 3.8;
        // Maybe checking if it was closer to which number can make it so that i can go
        // in forwards direction(increasing) or backwards (decreasing))
        System.out.println(t.inorderList);
        int closestIndex = 0;
        for (int i = 1; i < t.inorderList.size(); i++) {
            double diff = number - t.inorderList.get(i);
            diff = Math.abs(diff);
            if (diff < Math.abs(number - t.inorderList.get(closestIndex))) {
                closestIndex = i;
            }
        }

        // No of values
        int valuesCount = 4;
        if (valuesCount >= t.inorderList.size()) {
            System.out.println(t.inorderList);
            t.inorderList.toArray();
            return;
        }
        int[] valuesClosest = new int[valuesCount];
        int counting = 0;
        for (int i = 0, j = closestIndex; i < valuesCount && j < t.inorderList.size(); j++, i++) {
            valuesClosest[i] = t.inorderList.get(j);
            // System.out.println(valuesClosest[i]);
            counting++;
        }
        for (int i = 1, j = valuesCount - 1; i <= counting
                && j > (valuesCount > 2 ? valuesCount / 2 : valuesCount / 2 - 1); j--, i++) {
            valuesClosest[j] = t.inorderList.get(closestIndex - i);
            // System.out.println((closestIndex));
        }
        System.out.println(Arrays.toString(valuesClosest));
    }

    Integer[] findValuesClosestTo(double number, ArrayList<Integer> list, int numberOfValues) {
        // Maybe checking if it was closer to which number can make it so that i can go
        // in forwards direction(increasing) or backwards (decreasing))
        System.out.println(list);
        int closestIndex = 0;
        for (int i = 1; i < list.size(); i++) {
            double diff = number - list.get(i);
            diff = Math.abs(diff);
            if (diff < Math.abs(number - list.get(closestIndex))) {
                closestIndex = i;
            }
        }
        if (numberOfValues >= list.size()) {
            System.out.println(list);

            return ((Integer[]) list.toArray());
        }
        Integer[] valuesClosest = new Integer[numberOfValues];
        int counting = 0;
        for (int i = 0, j = closestIndex; i < numberOfValues && j < list.size(); j++, i++) {
            valuesClosest[i] = list.get(j);
            // System.out.println(valuesClosest[i]);
            counting++;
        }
        for (int i = 1, j = numberOfValues - 1; i <= counting
                && j > (numberOfValues > 2 ? numberOfValues / 2 : numberOfValues / 2 - 1); j--, i++) {
            valuesClosest[j] = list.get(closestIndex - i);
            // System.out.println((closestIndex));
        }
        System.out.println(Arrays.toString(valuesClosest));
        return valuesClosest;
    }

}
