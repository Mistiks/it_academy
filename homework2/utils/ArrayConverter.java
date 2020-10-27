package homeworks.homework2.utils;

public class ArrayConverter {
    public Integer[] intToInteger(int[] array) {
        Integer[] objectsArray = new Integer[array.length];

        for (int i = 0; i < objectsArray.length; i++) {
            objectsArray[i] = array[i];
        }

        return objectsArray;
    }

    public int[] integerToInt(Integer[] array) {
        int[] intArray = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            intArray[i] = array[i];
        }

        return intArray;
    }
}