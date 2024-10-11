package exercise;

import java.util.HashMap;

import org.junit.jupiter.api.BeforeEach;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

import com.fasterxml.jackson.databind.ObjectMapper;
// BEGIN
import java.util.Map;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
// END


class FileKVTest {

    private static Path filepath = Paths.get("src/test/resources/file").toAbsolutePath().normalize();

    @BeforeEach
    public void beforeEach() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        String content = mapper.writeValueAsString(new HashMap<String, String>());
        Files.writeString(filepath, content, StandardOpenOption.TRUNCATE_EXISTING);
    }

    // BEGIN
    public void getTest() {
        KeyValueStorage actual = new FileKV("src/test/resources/file", Map.of("key", "value"));
        var expected = "value";
        assertEquals(expected, actual.get("key", "default"));
    }

    @Test
    public void setTest() {
        KeyValueStorage expected = new FileKV("src/test/resources/file2", Map.of("key", "value",
                "key2", "value2"));
        KeyValueStorage actual = new FileKV("src/test/resources/file1", Map.of("key", "value"));
        actual.set("key2", "value2");
        assertEquals(Utils.serialize(expected.toMap()), Utils.serialize(actual.toMap()));
    }
    // END
}
