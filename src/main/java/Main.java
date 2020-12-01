import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {
    private static final String JSON_FILE = "data/inkle.json";
    
//    private static final HashMap<String, String> flags = new HashMap<>();

    public static void main(String[] args) {

        Inkle inkle = new Inkle(JSON_FILE);

        System.out.println("inkle.getTitle() = " + inkle.getTitle());
        System.out.println("inkle.getMap() = " + inkle.getMap());
        System.out.println("inkle.getData() = " + inkle.getData());
        System.out.println("inkle.getStitches() = " + inkle.getStitches());
        System.out.println("inkle.getInitial() = " + inkle.getInitial());

        inkle.start();
//        List<?> current = (List<?>) start.get("content");
//
//        List<String> options = display(current);
//
//        //choose an option
//        int choice = 0;
//        String next = options.get(choice);
//        start = (HashMap<?, ?>) stitches.get(next);
//        current = (List<?>) start.get("content");
//
//        //game loop
//        options = display(current);
//
//        choice = 0;
//        next = options.get(choice);
//        start = (HashMap<?, ?>) stitches.get(next);
//        current = (List<?>) start.get("content");
//
//        options = display(current);
        
    }

//    public static List<String> display(List<?> current) {
//
//        System.out.println("\n===display===\n");
//
//        List<String> options = new ArrayList<>();
//
//        //get content
//        //check divert, if so loop
//        //if not divert, check for options
//
//
//        for (short i = 0; i < current.size(); i++) {
//            HashMap<?, ?> element;
//
//            if (i == 0) {
//                System.out.println(current.get(i));
//            } else {
//                element = (HashMap<?, ?>) current.get(i);
//
//                String divert = (String) element.get("divert");
//                System.out.println("divert = " + divert);
//                //keep diverting, then grab options
//
//                String option = (String) element.get("option");
//                String flag = (String) element.get("flagName");
//                String ifConditions;
//                String ifNotConditions;
//
//                if (option != null) {
//                    System.out.println(i + ": " + option);
//                    options.add((String) element.get("linkPath"));
//                } else if (flag != null) {
//                    flags.put(flag, "true");
//                    System.out.println(flag + " marked");
//                }
//            }
//        }
//
//        System.out.println("\n===display end===\n");
//
//        return options;
//    }
}
