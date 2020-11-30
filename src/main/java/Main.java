import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {

    private static final List<String> flags = new ArrayList<>();

    public static void main(String[] args) throws IOException, ParseException {
        JSONParser parser = new JSONParser();

        FileReader reader = new FileReader("data/inkle.json");

        Object obj = parser.parse(reader);
        HashMap<?,?> map = (HashMap<?, ?>) obj;
        HashMap<?,?> data = (HashMap<?, ?>) map.get("data");
        HashMap<?,?> stitches = (HashMap<?, ?>) data.get("stitches");
        HashMap<?,?> start = (HashMap<?, ?>) stitches.get(data.get("initial"));
        List<?> current = (List<?>) start.get("content");

        System.out.println("map = " + map);
        System.out.println("current = " + current);

        List<String> options = display(current);

        //choose an option
        int choice = 0;
        String next = options.get(choice);
        start = (HashMap<?, ?>) stitches.get(next);
        current = (List<?>) start.get("content");

        //game loop
        options = display(current);

        choice = 0;
        next = options.get(choice);
        start = (HashMap<?, ?>) stitches.get(next);
        current = (List<?>) start.get("content");

        options = display(current);
        
    }

    public static List<String> display(List<?> current) {

        System.out.println("\n===display===\n");

        List<String> options = new ArrayList<>();

        for (short i = 0; i < current.size(); i++) {
            HashMap<?, ?> element;

            if (i == 0) {
                System.out.println(current.get(i));
            } else {
                element = (HashMap<?, ?>) current.get(i);
                String option = (String) element.get("option");
                String flag = (String) element.get("flagName");
                String ifConditions;
                String ifNotConditions;

                if (option != null) {
                    System.out.println(i + ": " + option);
                    options.add((String) element.get("linkPath"));
                } else if (flag != null) {
                    flags.add(flag);
                    System.out.println(flag + " marked");
                }
            }
        }
        
        System.out.println("\n===display end===\n");

        return options;
    }
}
