package puckg.data;

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

public class GameDataJson {

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

    public static ArrayList<GameData> readJson(File file) throws FileNotFoundException {

        Reader reader = new FileReader(file);
        Gson gson = getGson();
        Type dataType = new TypeToken<ArrayList<GameData>>(){}.getType();

        return gson.fromJson(reader, dataType);
    }

    public static void addAndSortData(ArrayList<GameData> dataList, GameData newData) {

        dataList.add(newData);
        Comparator<GameData> pointOrder = new Comparator<GameData>() {
            public int compare(GameData gd1, GameData gd2) {
                if(gd2.getWinnerPoints() > gd1.getWinnerPoints()) {
                    return 1;
                } else if(gd2.getWinnerPoints() == gd1.getWinnerPoints()) {
                    return gd2.getDuration().compareTo(gd1.getDuration()) * -1;
                } else {
                    return -1;
                }
            }
        };
        Collections.sort(dataList, pointOrder);
    }
}
