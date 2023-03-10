package guru.qa;

import static org.assertj.core.api.Assertions.assertThat;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.InputStream;
import java.io.InputStreamReader;
import guru.qa.model.ManJson;
import org.junit.jupiter.api.Test;
public class JsonParseTest {
    ClassLoader cl = JsonParseTest.class.getClassLoader();
    ObjectMapper objectMapper = new ObjectMapper();
    @Test
    void jsonParse() throws Exception {

        try (
                InputStream resource = cl.getResourceAsStream("example/qa_guru_files.json");
                InputStreamReader reader = new InputStreamReader(resource);
        ) {
            ManJson manJson = objectMapper.readValue(reader, ManJson.class);
            assertThat(manJson.name).isEqualTo("Anatoly");
            assertThat(manJson.gender).isEqualTo("Male");
            assertThat(manJson.age).isEqualTo(26);
            assertThat(manJson.subjects).contains("English", "Arts");
        }
    }
}