package lesson15;

import java.util.Map;
import java.util.Random;

public final class Util {

    public static final int MIN = 1;
    public static final int MAX = 4;

    public static int getRandom(int min, int max) {
        return new Random().nextInt((max - min) + 1) + min;
    }

    public static void putInStorage(Map<Details, Integer> warehouse, Details detail) {
        if (warehouse.containsKey(detail)) {
            warehouse.replace(detail, warehouse.get(detail) + 1);
        } else {
            warehouse.put(detail, 1);
        }
    }
}