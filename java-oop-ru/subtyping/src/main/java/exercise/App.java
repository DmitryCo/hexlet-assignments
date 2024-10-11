package exercise;

import java.util.Map;
import java.util.Map.Entry;

// BEGIN
public class App {
    public static void swapKeyValue(KeyValueStorage db) {
        Map<String, String> originalData = db.toMap();

        for (Map.Entry<String, String> entry : originalData.entrySet()) {
            db.unset(entry.getKey());
            db.set(entry.getValue(), entry.getKey());
        }
    }
}
// END
