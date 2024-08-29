package exercise;

import java.io.IOException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

// BEGIN
public class App {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static void save(Path filePath, Car car) {
        try {
            String jsonString = car.serialize();
            if (jsonString != null) {
                Files.writeString(filePath, jsonString);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Car extract(Path filePath) {
        try {
            String jsonString = Files.readString(filePath);
            return Car.deserialize(jsonString);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
// END
