package startup.loga.client.vendor.http;

import com.google.gson.*;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

public class Adapter<T> extends TypeAdapter<T> {

    private final Class<T> entity;

    public Adapter(Class<T> entity){
        this.entity = entity;
    }

    @Override
    public void write(JsonWriter writer, T obj) throws IOException {
        if (obj == null) {
            writer.nullValue();
            return;
        }
        writer.value(obj.toString());
    }

    @Override
    public T read(JsonReader jsonReader) throws IOException {
        Gson gson = new Gson();
        return gson.fromJson(jsonReader,entity);
    }
}