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

    public static void addAndSortResult(ArrayList<GResult> resultList, GResult newResult) {

        resultList.add(newResult);
        Comparator<GResult> pointOrder = new Comparator<GResult>() {
            public int compare(GResult gr1, GResult gr2) {
                if (gr2.getDuration().compareTo(gr1.getDuration()) == 0) {
                    return gr2.getSteps() - gr1.getSteps();
                } else {
                    return gr2.getDuration().compareTo(gr1.getDuration()) * -1;
                }
            }
        };
        Collections.sort(resultList, pointOrder);
    }


    public static void writeJson(File file, ArrayList<GResult> results) throws IOException {

        Gson gson = getGson();
        try (FileWriter writer = new FileWriter(file, false)) {
            if(results.size() > 5) {
                gson.toJson(new ArrayList<>(results.subList(0, 5)), writer);
            } else {
                gson.toJson(results, writer);
            }
        }

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
