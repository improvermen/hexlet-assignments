package exercise;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.Value;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

// BEGIN

@Value
@AllArgsConstructor
// END
class Car {
    int id;
    String brand;
    String model;
    String color;
    User owner;

    // BEGIN
    private static final ObjectMapper objectMapper = new ObjectMapper();
    public String serialize(){
        try {
            return objectMapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }
    @SneakyThrows
    public static Car deserialize(String json) {
        try {
            return objectMapper.readValue(json, Car.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }
    // END
}
