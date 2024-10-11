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

import java.util.Map;
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
    public void testSetAndGet() {
        fileKV.set("key1", "value1");
        assertEquals("value1", fileKV.get("key1", null));
    }

    @Test
    public void testUnset() {
        fileKV.set("key2", "value2");
        fileKV.unset("key2");
        assertEquals(null, fileKV.get("key2", null));
    }

    @Test
    public void testDefaultValue() {
        assertEquals("default", fileKV.get("nonExistentKey", "default"));
    }

    @Test
    public void testToMap() {
        fileKV.set("key3", "value3");
        Map<String, String> map = fileKV.toMap();
        assertEquals("value3", map.get("key3"));
    }
    // END
}
