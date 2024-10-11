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

import static org.junit.jupiter.api.Assertions.assertThat;
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
    @Test
    void fileKVTest() {
        KeyValueStorage db = new FileKV("src/test/resources/file", Map.of("key", "value"));
        assertThat(db.get("key2", "default")).isEqualTo("default");
        assertThat(db.get("key", "default")).isEqualTo("value");

        db.set("key3", "value3");
        db.set("key", "10");
        assertThat(db.get("key3", "default")).isEqualTo("value3");
        assertThat(db.get("key", "default")).isEqualTo("10");

        db.unset("key");
        assertThat(db.get("key", "def")).isEqualTo("def");

        assertThat(db.toMap()).isEqualTo(Map.of("key3", "value3"));
    }
    // END
}
