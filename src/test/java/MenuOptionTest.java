import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MenuOptionTest {

    MenuOption option;

    @Before
    public void setUp() {
        option = new MenuOption("text to display");
    }

    @Test
    public void testIfClassExists() {
        assertNotNull(option);
    }

    @Test
    public void testClassProperties() {
        assertEquals(option.getDisplayText(), "text to display");
    }

    @Test
    public void testInterfaceImplementation() {

    }
}
