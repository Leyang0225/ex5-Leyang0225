package colors;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertThrows;


public class TestTask2 {

    @Test
    public void test1() {
        Color c1 = new Color("#050AFF");
        Color c2 = new Color("#0B1011");

        ColorMixer mixer1 = new ColorMixer();
        Color actual = mixer1.combine(new ArrayList<>(Arrays.asList(c1, c2)));
        Color expected = new Color("#080D88");

        assert(actual.equals(expected));
    }

    @Test
    public void test2() {
        Color c1 = new Color("#050AFF");
        ColorMixer mixer1 = new ColorMixer();
        Color actual = mixer1.combine(new ArrayList<>(Arrays.asList(c1)));
        Color expected = new Color("#050AFF");

        assert(actual.equals(expected));
    }

    @Test
    public void test3() {
        Color c1 = new Color("#050AFF");
        Color c2 = new Color("#0B0F10");

        ColorMixer mixer1 = new ColorMixer();
        assertThrows(CannotCombineColorsException.class, () -> mixer1.combine(new ArrayList<>(Arrays.asList(c1, c2))));
    }

    @Test
    public void test4() {
        Color c1 = new Color("#050AFF");
        Color c2 = new Color("#AAF010");
        Color c3 = new Color("#0B0F10");
        Color c4 = new Color("#BF8622");

        ColorMixer mixer1 = new ColorMixer();
        assertThrows(CannotCombineColorsException.class, () -> mixer1.combine(new ArrayList<>(Arrays.asList(c1, c2, c3, c4))));
    }

    @Test
    public void test5() {
        Color c1 = new Color("#0B0F10");
        Color c2 = new Color("#050AFF");
        Color c3 = new Color("#AAF210");
        Color c4 = new Color("#BE0515");

        ColorMixer mixer1 = new ColorMixer();
        Color actual = mixer1.combine(new ArrayList<>(Arrays.asList(c1, c2, c3, c4)));
        Color expected = new Color("#5E444D");

        assert(actual.equals(expected));
    }
}
