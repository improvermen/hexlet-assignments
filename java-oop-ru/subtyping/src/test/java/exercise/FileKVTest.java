package exercise;

import java.util.HashMap;
import org.junit.jupiter.api.BeforeEach;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import com.fasterxml.jackson.databind.ObjectMapper;
// BEGIN
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
// END


class FileKVTest {

    private static Path filepath = Paths.get("src/test/resources/file").toAbsolutePath().normalize();
    private FileKV fileKV;

    @BeforeEach
    public void beforeEach() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        String content = mapper.writeValueAsString(new HashMap<String, String>());
        Files.writeString(filepath, content, StandardOpenOption.TRUNCATE_EXISTING);

        fileKV = new FileKV(filepath.toString(), new HashMap<>());
    }

    // BEGIN
    @Test
    public void testInitialData() {
        // Проверяем начальные данные, которые должны быть пустыми
        assertEquals("default", fileKV.get("nonExistingKey", "default"));
    }

    @Test
    public void testSetValue() {
        // Устанавливаем новое значение
        fileKV.set("key", "value");

        // Проверяем установленное значение
        assertEquals("value", fileKV.get("key", "default"));
    }

    @Test
    public void testUnsetValue() {
        // Устанавливаем и затем удаляем значение
        fileKV.set("key", "value");
        fileKV.unset("key");

        // Проверяем, что значение удалено
        assertEquals("default", fileKV.get("key", "default"));
    }
    // END
}
