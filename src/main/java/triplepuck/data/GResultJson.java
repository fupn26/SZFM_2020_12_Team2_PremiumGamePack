package triplepuck.data;

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
import java.util.Collections;
import java.util.Comparator;

public class GResultJson {

    public static ArrayList<GResult> readJson(File file) throws FileNotFoundException {

        Reader reader = new FileReader(file);
        Gson gson = getGson();
        Type dataType = new TypeToken<ArrayList<GResult>>(){}.getType();

        return gson.fromJson(reader, dataType);
    }
}
