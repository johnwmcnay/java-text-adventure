public class MenuOption {

    private static String displayText;

    public MenuOption(String text) {
        setDisplayText(text);
    }

    public String getDisplayText() {
        return displayText;
    }

    public void setDisplayText(String displayText) {
        MenuOption.displayText = displayText;
    }
}
