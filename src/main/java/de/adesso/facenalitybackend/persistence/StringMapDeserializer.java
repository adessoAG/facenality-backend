package de.adesso.facenalitybackend.persistence;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class StringMapDeserializer extends StdDeserializer<Map<String, String>> {

    public StringMapDeserializer() {
        this(null);
    }

    protected StringMapDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public Map<String, String> deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        TypeReference<HashMap<String, String>> typeReference = new TypeReference<HashMap<String, String>>() { };

        return mapper.readValue(p.getText(), typeReference);
    }
}
