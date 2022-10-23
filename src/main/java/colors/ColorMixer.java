package colors;

import java.util.List;

public class ColorMixer {

    /**
     * Given a list of colors, combine all colors to form a new color.
     * Recall that colors can be combined if their component-wise sum is divisible by
     * the number of colors being combined.
     * @param colors A list of color objects.
     * @return The result of the color combination as a Color object
     * @throws CannotCombineColorsException if the colors cannot be combined
     */
    public Color combine(List<Color> colors) throws CannotCombineColorsException {

        if(colors.size() == 0) throw new CannotCombineColorsException("No colors in the list");

        int red = 0;
        int green = 0;
        int blue = 0;

        for(Color c : colors){
            red = red + c.red;
            blue = blue + c.blue;
            green = green + c.green;
        }

        int n = colors.size();
        if(red % n != 0 || blue % n != 0 || green % n != 0){
            throw new CannotCombineColorsException("Colors can not be combined");
        }
        else{
            return new Color(red / n, green / n, blue / n);
        }
    }

    private boolean check(List<Color> colors, boolean[] choose, Color target, int n, int chooseNum){
        if(chooseNum == 0) return false;

        int red = 0;
        int green = 0;
        int blue = 0;

        for(int i = 0; i < n; i++){
            if(choose[i] == true){
                red += colors.get(i).red;
                blue += colors.get(i).blue;
                green += colors.get(i).green;
            }
        }

        if(red % chooseNum != 0 || blue % chooseNum != 0 || green % chooseNum != 0) return false;
        if(new Color(red / chooseNum, green / chooseNum, blue / chooseNum).equals(target)) return true;
        else return false;
    }

    private boolean dfs(int now, int n, List<Color> colors, int chooseNum, boolean[] choose, Color target){
        if(now == n){
            if(check(colors, choose, target, n, chooseNum) == true) return true;
            else return false;
        }
        choose[now] = true;
        if(dfs(now + 1, n, colors, chooseNum + 1, choose, target) == true) return true;
        choose[now] = false;
        if(dfs(now + 1, n, colors, chooseNum, choose, target) == true) return true;
        else return false;
    }

    /**
     * Given a list of colors and a target color, determine if there is some combination of
     * colors that can be combined to get a target color.
     * @param colors a list of colors.
     * @param target a target color.
     * @return True if there is some combination of colors that can be combined to get target. False otherwise.
     */
    public boolean createColor(List<Color> colors, Color target){
        if(dfs(0, colors.size(), colors, 0, new boolean[colors.size()], target) == true) return true;
        else return false;
    }
}
