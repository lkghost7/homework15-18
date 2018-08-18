package lesson15;

import java.util.HashMap;
import java.util.Map;

public class Dump {

    public static Map<Details, Integer> dump = new HashMap<>();

    static {
        for (int i = 0; i < 20; i++) {
            Details detail = Details.getRandomDetail();
            Util.putInStorage(dump, detail);
        }
    }
}