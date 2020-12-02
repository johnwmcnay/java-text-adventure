public class Main {
    private static final String JSON_FILE = "data/inkle.json";

    public static void main(String[] args) {

        Inkle inkle = new Inkle(JSON_FILE);

        inkle.start();

    }
}
