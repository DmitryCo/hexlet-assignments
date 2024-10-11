package exercise;

// BEGIN
import java.util.Map;

public class FileKV implements KeyValueStorage {
    private String filePath;
    private Map<String, String> db;

    public FileKV(String filePath, Map<String, String> initialData) {
        this.filePath = filePath;
        this.db = initialData;
        Utils.writeFile(filePath, Utils.serialize(initialData));
    }

    @Override
    public void set(String key, String value) {
        db.put(key, value);
        Utils.writeFile(filePath, Utils.serialize(db));
    }

    @Override
    public void unset(String key) {
        db.remove(key);
        Utils.writeFile(filePath, Utils.serialize(db));
    }

    @Override
    public String get(String key, String defaultValue) {
        String serializedData = Utils.readFile(filePath);
        Map<String, String> deserializedData = Utils.deserialize(serializedData);

        return deserializedData.getOrDefault(key, defaultValue);
    }

    @Override
    public Map<String, String> toMap() {
        String serializedData = Utils.readFile(filePath);
        return Utils.deserialize(serializedData);
    }
}
// END
