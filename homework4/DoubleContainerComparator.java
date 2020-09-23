package homeworks.homework4;

import java.util.Comparator;

public class DoubleContainerComparator implements Comparator<Double> {
    @Override
    public int compare(Double item1, Double item2) {
        double result = Math.abs(item1) - Math.abs(item2);

        if (result > 0) {
            return 1;
        } else if (result < 0) {
            return -1;
        } else {
            return 0;
        }
    }
}
