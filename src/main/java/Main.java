import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException, ParseException {
        JSONParser parser = new JSONParser();

        FileReader reader = new FileReader("data/inkle.json");

        Object obj = parser.parse(reader);
        HashMap<?,?> map = (HashMap<?, ?>) obj;
        HashMap<?,?> data = (HashMap<?, ?>) map.get("data");
        HashMap<?,?> stitches = (HashMap<?, ?>) data.get("stitches");
        HashMap<?,?> start = (HashMap<?, ?>) stitches.get(data.get("initial"));
        List<?> list = (List<?>) start.get("content");

        System.out.println("list = " + list);
        
        for (short i = 0; i < list.size(); i++) {
            HashMap<?, ?> element;

            if (i == 0) {
                System.out.println(list.get(i));
            } else {
                element = (HashMap<?, ?>) list.get(i);
                String option = (String) element.get("option");

                if (option != null) {
                    System.out.println(option);
                }
                
            }

        }
    }
}
