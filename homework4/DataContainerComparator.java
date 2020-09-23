package homeworks.homework4;

import java.util.Comparator;

public class DataContainerComparator implements Comparator<Integer> {
    @Override
    public int compare(Integer item1, Integer item2) {
        return item1 - item2;
    }
}
