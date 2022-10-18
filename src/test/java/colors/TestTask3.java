package colors;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class TestTask3 {

    @Test
    public void test1() {
        Color c1 = new Color("#0B0F10");
        Color c2 = new Color("#050AFF");
        Color c3 = new Color("#AAF210");
        Color c4 = new Color("#BE0515");
        Color target = new Color("#5E444D");

        // all colors can be combined to get target
        ColorMixer mixer1 = new ColorMixer();
        assertTrue(mixer1.createColor(new ArrayList<>(Arrays.asList(c1, c2, c3, c4)), target));
    }

    @Test
    public void test2() {
        Color c1 = new Color("#0C1010");
        Color c2 = new Color("#050AFF");
        Color c3 = new Color("#AAF210");
        Color c4 = new Color("#324319");
        Color target = new Color("#5B8110");

        // c1 and c3 can be combined to get the target
        ColorMixer mixer1 = new ColorMixer();
        assertTrue(mixer1.createColor(new ArrayList<>(Arrays.asList(c1, c2, c3, c4)), target));
    }

    @Test
    public void test3() {
        Color c1 = new Color("#FF0F10");
        Color c2 = new Color("#EF0AFF");
        Color c3 = new Color("#DAF210");
        Color c4 = new Color("#FE0515");
        Color c5 = new Color("#F9AE04");
        Color target = new Color("#059803");

        // no possible combination will give target
        ColorMixer mixer1 = new ColorMixer();
        assertFalse(mixer1.createColor(new ArrayList<>(Arrays.asList(c1, c2, c3, c4, c5)), target));
    }

    @Test
    public void test4() {
        Color c1 = new Color("#FF0F10");
        Color c2 = new Color("#AA293F");
        Color target = new Color("#FF0F10");

        // c1 doesn't have to be combined
        ColorMixer mixer1 = new ColorMixer();
        assertTrue(mixer1.createColor(new ArrayList<>(Arrays.asList(c1, c2)), target));
    }

}
