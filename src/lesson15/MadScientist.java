package lesson15;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MadScientist {

    public Map<Details, Integer> warehouse = new HashMap<>();

    public int getRobots(Map<Details, Integer> warehouse) {
        int min = 0;
        Set<Details> keySet = warehouse.keySet();
        Object[] keysArray = keySet.toArray();
        if (keysArray.length == 9) {
            for (int i = 0; i < keysArray.length; i++) {
                Integer value = warehouse.get(keysArray[i]);
                if (i == 0) {
                    min = value;
                } else if (min > value) {
                    min = value;
                }
            }
        }
        return min;
    }

    public static class Minion {

        public void takeFromDump(Map<Details, Integer> dump, Map<Details, Integer> warehouse) {
            int getDetailsOnce = Util.getRandom(Util.MIN, Util.MAX);
            int dumpDetailsCount = 0;
            for (int i : dump.values()) {
                dumpDetailsCount += i;
            }
            if (getDetailsOnce > dumpDetailsCount) {
                getDetailsOnce = dumpDetailsCount;
            }
            for (int i = 0; i < getDetailsOnce; i++) {
                Set<Details> keySet = Dump.dump.keySet();
                if (keySet.size() > 0) {
                    Object[] details = keySet.toArray();
                    Details detail = (Details) details[Util.getRandom(0, Dump.dump.size() - 1)];
                    dump.replace(detail, Dump.dump.get(detail) - 1);
                    if (Dump.dump.get(detail) == 0) {
                        Dump.dump.remove(detail);
                    }
                    Util.putInStorage(warehouse, detail);
                }
            }
        }
    }
}