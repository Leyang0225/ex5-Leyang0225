package colors;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class TestTask1 {

    @Test
    public void test1() {
        Color c1 = new Color("#FF00AA");
        assert(c1.components().equals(new ArrayList<>(Arrays.asList(255, 0, 170))));
    }

    @Test
    public void test2() {
        Color c1 = new Color("#A0960F");
        assert(c1.components().equals(new ArrayList<>(Arrays.asList(160, 150, 15))));
    }

    @Test
    public void test3() {
        Color c1 = new Color(160, 150, 15);
        assert(c1.components().equals(new ArrayList<>(Arrays.asList(160, 150, 15))));
    }

    @Test
    public void testEquals1() {
        Color c1 = new Color("#A0960F");
        Color c2 = new Color("#A0960F");
        assertTrue(c1.equals(c2));
    }

    @Test
    public void testEquals2() {
        Color c1 = new Color("#A0960F");
        Color c2 = new Color("#A0960E");
        assertFalse(c1.equals(c2));
    }

    @Test
    public void testEquals3() {
        Color c1 = new Color(255, 255, 23);
        Color c2 = new Color(255, 255, 23);
        assertTrue(c1.equals(c2));
    }
}
