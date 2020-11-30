import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException, ParseException {
        JSONParser parser = new JSONParser();

        FileReader reader = new FileReader("data/inkle.json");

        Object obj = parser.parse(reader);
        HashMap<?,?> map = (HashMap<?, ?>) obj;
        HashMap<?,?> data = (HashMap<?, ?>) map.get("data");

        System.out.println("obj = " + obj);
        System.out.println("map.get(\"data\") = " + data.get("initial"));

    }
}
