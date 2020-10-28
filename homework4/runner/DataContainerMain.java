package homeworks.homework4.runner;

import homeworks.homework4.entity.DataContainer;
import homeworks.homework4.service.comparator.DataContainerComparator;
import homeworks.homework4.service.comparator.DoubleContainerComparator;

public class DataContainerMain {
    public static void main(String[] args) {
        DataContainer<Integer> dataContainer = new DataContainer<>(Integer.class, 4);
        DataContainer<Double> doubleContainer = new DataContainer<>(Double.class, 5);
        DataContainerComparator comparator = new DataContainerComparator();
        DoubleContainerComparator doubleComparator = new DoubleContainerComparator();

        System.out.println(dataContainer.add(36));
        System.out.println(dataContainer.add(21));
        System.out.println(dataContainer.add(187));
        System.out.println(dataContainer.toString());

        System.out.println(dataContainer.add(1000));
        System.out.println(dataContainer.add(21));
        System.out.println(dataContainer.toString());

        dataContainer.sort(comparator);
        System.out.println(dataContainer.toString());

        System.out.println(dataContainer.delete(1));
        System.out.println(dataContainer.toString());

        System.out.println(dataContainer.delete(Integer.valueOf(6754)));
        System.out.println(dataContainer.toString());

        System.out.println(dataContainer.delete(Integer.valueOf(36)));
        System.out.println(dataContainer.toString());

        System.out.println(dataContainer.delete(Integer.valueOf(21)));
        System.out.println(dataContainer.toString());

        doubleContainer.add(56.34);
        doubleContainer.add(27.0);
        doubleContainer.add(174.3);
        doubleContainer.add(29.4);
        doubleContainer.add(14.764);
        dataContainer.sort(doubleContainer);
        System.out.println(doubleContainer.toString());

        doubleContainer.add(-100.34);
        doubleContainer.add(2.76);
        //dataContainer.sort(doubleContainer, comparator); // компаратор Integer несовместим с Double

        // NB: компаратор Double сортирует не значения, а их модули
        dataContainer.sort(doubleContainer, doubleComparator);
        System.out.println(doubleContainer.toString());
    }
}
