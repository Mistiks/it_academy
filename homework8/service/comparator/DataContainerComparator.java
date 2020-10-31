package homeworks.homework8.service.comparator;

import java.util.Comparator;

public class DataContainerComparator implements Comparator<String> {
    @Override
    public int compare(String first, String second) {
        int result = Integer.parseInt(first.substring(6,10)) - Integer.parseInt(second.substring(6,10));

        if (result != 0) {
            return result;
        } else {
            result = Integer.parseInt(first.substring(11,13)) - Integer.parseInt(second.substring(11,13));

            if (result != 0) {
                return result;
            } else {
                result = Integer.parseInt(first.substring(14,16)) - Integer.parseInt(second.substring(14,16));

                if (result != 0) {
                    return result;
                }
            }
        }

        return stringValue(first) - stringValue(second);
    }

    public int stringValue(String line) {
        if (line.contains("EUR")) {
            return 0;
        } else if (line.contains("RUB")) {
            return 1;
        } else {
            return 2;
        }
    }
}