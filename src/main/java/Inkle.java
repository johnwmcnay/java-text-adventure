import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Inkle {

    private HashMap<String, String> flags = new HashMap<>();
    private final String title;
    private final String initial;
    private HashMap<?, ?> map = new HashMap<>();
    private final HashMap<?, ?> data;
    private final HashMap<?, ?> stitches;
    private List<?> currentContent;
    private List<Option> options = new ArrayList<>();


    public Inkle(String fileName) {

        FileReader reader = loadFile(fileName);

        this.map = parseFileContents(reader);
        this.title = (String) this.map.get("title");
        this.data = (HashMap<?, ?>) this.map.get("data");
        this.stitches = (HashMap<?, ?>) this.data.get("stitches");
        this.initial = (String) this.data.get("initial");
        this.currentContent = getContent();
    }

    private HashMap<?, ?> parseFileContents(FileReader reader) {

        JSONParser parser = new JSONParser();
        HashMap<?, ?> map = null;

        try {
            map = (HashMap<?, ?>) parser.parse(reader);
        } catch (ParseException | IOException e) {
            System.err.println("Error parsing contents into JSON");
            e.printStackTrace();
        }
        return map;
    }

    private FileReader loadFile(String fileName) {
        FileReader reader = null;

        try {
            reader = new FileReader(fileName);
        } catch (FileNotFoundException e) {
            System.err.println("Error loading file'" + fileName + "' into FileReader: file may not exist or path is wrong");
            e.printStackTrace();
        }
        return reader;
    }

    public void start() {

        Scanner sc = new Scanner(System.in);
        int choice = 0;

        while (choice != -1) {

            setFlags();
            displayParagraphs();
            displayOptions();

            System.out.print("\n>> ");
            choice = sc.nextInt() - 1;
            setContent(options.get(choice).getLinkPath());

        }

    }

    private void setFlags() {

        for (int i = this.currentContent.size() - 1; i > 0; i--) {
            HashMap<?, ?> obj = (HashMap<?, ?>) this.currentContent.get(i);
            if (obj.get("flagName") != null) {

                String str = (String) obj.get("flagName");
                String[] strArray = str.split("=");

                String key = strArray[0].trim();
                String value = null;
                if (strArray.length > 1) {
                    value = strArray[1].trim();
                }

                this.flags.put(key, value);
            } else {
                break;
            }
        }
        System.out.println("this.flags.toString() = " + this.flags.toString());
    }

    private void displayParagraphs() {
        while (displayParagraph() != null) {
            setContent(getDivert());
        }
    }

    private void displayOptions() {
        int num = 1;

        for (Option option : getOptions()) {
            System.out.println(num + ": " + option.getOption());
            num++;
        }
    }

    private List<Option> getOptions() {
        this.options = new ArrayList<>();

        for (short i = 1; i < this.currentContent.size(); i++) {
            HashMap<?, ?> obj = (HashMap<?, ?>) this.currentContent.get(i);

            if (obj.get("option") != null) {
                System.out.println("obj.get(\"ifConditions\") = " + obj.get("ifConditions"));

                options.add(new Option(
                        obj.get("option").toString(),
                        obj.get("linkPath").toString(),
                        obj.get("ifConditions") == null ? "": obj.get("ifConditions").toString(),
                        obj.get("notIfConditions") == null ? "": obj.get("notIfConditions").toString())
                );
            }
        }
        return options;
    }

    private String getDivert() {

        if (this.currentContent.size() > 1) {
            HashMap<?, ?> obj = (HashMap<?, ?>) this.currentContent.get(1);

            return (String) obj.get("divert");
        }
        return null;
    }

    private String displayParagraph() {

        String paragraph = (String) this.currentContent.get(0);

        if (checkParagraphConditions()){
            System.out.println(paragraph);
        }

        return getDivert();
    }

    private boolean checkParagraphConditions() {
        for (int i = 2; i < this.currentContent.size(); i++) {
            HashMap <?, ?> condition = (HashMap<?, ?>) this.currentContent.get(i);

            if (condition.get("ifCondition") != null) {

                String str = (String) condition.get("ifCondition");
                String[] strArray = str.split("=");
                String key = strArray[0].trim();
                String value = strArray.length > 1 ? strArray[1].trim() : null;
                
                if (!this.flags.containsKey(key)) {
                    return false;
                } else if (value != null && !this.flags.get(key).equals(value)) {
                    return false;
                }

            } else if (condition.get("notIfCondition") != null) {

                String str = (String) condition.get("notIfCondition");
                String[] strArray = str.split("=");
                String key = strArray[0].trim();
                String value = strArray.length > 1 ? strArray[1].trim() : null;

                if (this.flags.containsKey(key) && this.flags.get(key).equals(value)) {
                    return false;
                }
            }
        }
        return true;
    }

    public List<?> getContent() {
        return getContent(this.initial);
    }

    public List<?> getContent(String key) {
        HashMap<?, ?> obj = (HashMap<?, ?>) this.stitches.get(key);
        return (List<?>) obj.get("content");
    }

    public void setContent(String key) {
        this.currentContent = getContent(key);
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

    public List<?> getCurrentContent() {
        return currentContent;
    }
}
