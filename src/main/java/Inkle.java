import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Inkle {

    private final HashMap<String, String> flags = new HashMap<>();
    private String title;
    private String initial;
    private HashMap <?, ?> map = new HashMap<>();
    private final HashMap <?, ?> data;
    private final HashMap <?, ?> stitches;


    public Inkle(String fileName) {

        JSONParser parser = new JSONParser();
        FileReader reader = null;

        try {
             reader = new FileReader(fileName);
        } catch (FileNotFoundException e) {
            System.err.println("Error loading file'" + fileName + "' into FileReader: file may not exist or path is wrong");
            e.printStackTrace();
        }

        try {
             this.map = (HashMap<?, ?>) parser.parse(reader);
        } catch (ParseException | IOException e) {
            System.err.println("Error parsing contents of '" + fileName + "' into JSON");
            e.printStackTrace();
        }

        this.title = (String) this.map.get("title");
        this.data = (HashMap <?, ?>) this.map.get("data");
        this.stitches = (HashMap <?, ?>) this.data.get("stitches");
        this.initial = (String) this.data.get("initial");

//        HashMap<?,?> data = (HashMap<?, ?>) map.get("data");
//        HashMap<?,?> stitches = (HashMap<?, ?>) data.get("stitches");
//        HashMap<?,?> start = (HashMap<?, ?>) stitches.get(data.get("initial"));
//        List<?> current = (List<?>) start.get("content");

    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public HashMap<?, ?> getMap() {
        return map;
    }

    public HashMap<?, ?> getData() {
        return data;
    }

    public HashMap<?, ?> getStitches() {
        return stitches;
    }

    public String getInitial() {
        return initial;
    }
}
