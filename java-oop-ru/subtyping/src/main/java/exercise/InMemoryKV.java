package exercise;

import java.util.Map;
import java.util.HashMap;

// BEGIN
public class InMemoryKV implements KeyValueStorage {
    private Map<String, String> db;

    public InMemoryKV(Map<String, String> initialdb) {
        this.db = new HashMap<>(initialdb);
    }

    @Override
    void set(String key, String value) {
        db.put(key, value);
    }
    @Override
    void unset(String key) {
        db.remove(key);
    }

    @Override
    String get(String key, String defaultValue) {
        return db.getOrDefault(key, defaultValue);
    }

    @Override
    Map<String, String> toMap() {
        return new HashMap<>(db);
    }
}
// END
