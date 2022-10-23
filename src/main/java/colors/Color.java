package colors;

import java.util.ArrayList;
import java.util.List;

public class Color {

    int red;
    int blue;
    int green;

    private String toHex(int x){
        String s = "";
        while(x != 0){
            int tmp = x % 16;
            if(tmp < 10) s = s + ('0' + tmp);
            else s = s + ('A' + tmp - 10);
        }
        return new StringBuffer(s).reverse().toString();
    }

    private int toDec(String s){
        int n = s.length();
        int tmp = 0;
        for(int i = 0; i < n; i++){
            if(s.charAt(i) <= '9') tmp = tmp * 16 + s.charAt(i) - '0';
            else tmp = tmp * 16 + s.charAt(i) - 'A' + 10;
        }
        return tmp;
    }

    /**
     * First constructor for color
     * @param color of the form '#uvwxyz'
     */
    public Color(String color){
        red = toDec(color.substring(1, 3));
        green = toDec(color.substring(3, 5));
        blue = toDec(color.substring(5, 7));
    }

    /**
     * Second constructor for color
     * @param red the units of red (0 <= red <= 255>
     * @param green the units of green (0 <= green <= 255)
     * @param blue the units of blue (0 <= blue <= 255)
     */
    public Color(int red, int green, int blue){
        this.red = red;
        this.green = green;
        this.blue = blue;
    }

    /**
     * Create a list of components for the current color.
     * @return A list of integers L where L[0], L[1] and L[2] are the red, green and blue
     * components of the color respectively.
     */
    public List<Integer> components(){
        List<Integer> list = new ArrayList<>();
        list.add(red);
        list.add(green);
        list.add(blue);
        return list;
    }


    @Override
    public boolean equals(Object obj) {
        Color that = (Color) obj;
        return (this.red == that.red && this.green == that.green && this.blue == that.blue);
    }
}
