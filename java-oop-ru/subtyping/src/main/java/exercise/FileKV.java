package exercise;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

// BEGIN
public class FileKV implements KeyValueStorage{
    private String filePath;
    private Map<String, String> storage;

    public FileKV(String filePath, Map<String, String> initialData) throws IOException{
        this.filePath = filePath;
        this.storage = new HashMap<>();

        if (Utils.readFile(filePath) != null && !Utils.readFile(filePath).isEmpty()){
            String jsonData = Utils.readFile(filePath);
            this.storage = Utils.deserialize(jsonData);
        }
        if (initialData != null) {
            this.storage.putAll(initialData);
            save();
        }
    }
    private void save() throws IOException {
        String jsonData = Utils.serialize(storage);
        Utils.writeFile(filePath, jsonData);
    }
    @Override
    public void set(String key, String value) {
        storage.put(key, value);
        try {
            save();
        } catch (IOException e) {
            throw new RuntimeException("Failed to save data to file", e);
        }
    }

    @Override
    public void unset(String key) {
        storage.remove(key);
        try {
            save();
        } catch (IOException e) {
            throw new RuntimeException("Failed to save data to file", e);
        }
    }

    @Override
    public String get(String key, String defaultValue) {
        return storage.getOrDefault(key, defaultValue);
    }

    @Override
    public Map<String, String> toMap() {
        return new HashMap<>(storage);
    }
}
// END
