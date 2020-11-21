package daogame.data;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.*;
import java.lang.reflect.Type;
import java.time.ZonedDateTime;
import java.util.ArrayList;

public class GameResultJson {

    public static void execute(GameResult newResult) throws IOException {
        //TODO handle new result
    }

    public static ArrayList<GameResult> readJson(File file) throws FileNotFoundException {
        Reader reader = new FileReader(file);
        Gson gson = getGson();
        Type dataType = new TypeToken<ArrayList<GameResult>>(){}.getType();

        return gson.fromJson(reader, dataType);
    }

    public static Gson getGson() {
        return new GsonBuilder()
                .registerTypeAdapter(ZonedDateTime.class, new TypeAdapter<ZonedDateTime>() {
                    @Override
                    public void write(JsonWriter out, ZonedDateTime value) throws IOException {
                        out.value(value.toString());
                    }

                    @Override
                    public ZonedDateTime read(JsonReader in) throws IOException {
                        return ZonedDateTime.parse(in.nextString());
                    }
                })
                .enableComplexMapKeySerialization()
                .setPrettyPrinting()
                .create();
    }
}
