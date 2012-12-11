package robort.util;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;

public class JsonParser<T> {
    public T parse(String jsonString, Class clazz) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return (T)objectMapper.readValue(jsonString, clazz);
    }
}
