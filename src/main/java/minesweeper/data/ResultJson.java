package minesweeper.data;

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

public class ResultJson {

    public static ArrayList<Result> readJson(File file) throws FileNotFoundException {

        Reader reader = new FileReader(file);
        Gson gson = getGson();
        Type dataType = new TypeToken<ArrayList<Result>>(){}.getType();

        return gson.fromJson(reader, dataType);
    }

    public static void addAndSortData(ArrayList<Result> resultList, Result newResult) {

        resultList.add(newResult);
        Comparator<Result> pointOrder = new Comparator<Result>() {
            public int compare(Result r1, Result r2) {
                return r2.getDuration().compareTo(r1.getDuration()) * -1;
            }
        };
        Collections.sort(resultList, pointOrder);
    }

    public static void writeJson(File file, ArrayList<Result> data) throws IOException {

        Gson gson = getGson();
        try (FileWriter writer = new FileWriter(file, false)) {
            if(data.size() > 5) {
                gson.toJson(new ArrayList<>(data.subList(0, 5)), writer);
            } else {
                gson.toJson(data, writer);
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

    public static void execute(Result newResult) throws IOException {
        File file = new File("minesweeper.json");
        if (file.exists() && !file.isDirectory()) {
            ArrayList<Result> resultList = readJson(file);
            addAndSortData(resultList, newResult);
            writeJson(file, resultList);
        } else {
            ArrayList<Result> resultList = new ArrayList<>();
            addAndSortData(resultList, newResult);
            writeJson(file, resultList);
        }
    }
}