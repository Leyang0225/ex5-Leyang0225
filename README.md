# Mixing Colors

Colors are often represented using hex color codes. A hex color code is made up of seven characters, `#uvwxyz`, where 
each pair of characters `uv`, `wx`, and `yz` is a hexadecimal (base 16) number representing how much red, green and blue (respectively) is in the color.
Each pair of characters is called a component of the hex color code.

For example, the color `#FF00AA` means that there are $256 (FF_{16})$ units of red, $0 (00_{16})$ units of green and $170 (AA_{16})$ units of blue.
The result is a pink color: 

![#FF00AA](https://via.placeholder.com/15/FF00AA/FF00AA.png) `#FF00AA`

When we add $150 (96_{16})$ units of green, we get a more pastel tone of pink: 

![#FF96AA](https://via.placeholder.com/15/FF96AA/FF96AA.png) `#FF96AA`
 
### Task 1
Recall that a component of a color code is the value represented by a pair of characters.
Implement the Color class. 

1) `constructor`: Implement the constructor that takes in a string and determine how you will represent a color. The input
string will be of the form `#uvwxyz`.
2) `constructor`: Implement the second constructor that takes in each component value. The component values will be in base 10.
3) `components()`: Return a list of components of the current color. The list should have a length of 3 since each color
only has 3 components (red, green and blue).
4) `equals()`: Override the equals method so that two color classes can be compared.

##### Example:
If color is `#FF00AA`, return `[255, 0, 170]` since $FF_{16} = 255$, $00_{16} = 0$, $AA_{16} = 170$

### Task 2

We can combine colors given two color codes. Let $x_i$, $y_i$ and $z_i$ be the first, second and third
components respectively of color $c_i$. We can combine colors $c_1, c_2, ..., c_n$ into color $c$ where 
- the first component of $c$ is $$x = \frac{1}{n} \sum_{i=1}^{n} x_i$$
- the second component of $c$ is $$y = \frac{1}{n} \sum_{i=1}^{n} y_i$$
- the third component of $c$ is $$z = \frac{1}{n} \sum_{i=1}^{n} z_i$$

If the sum of any component is not divisible by $n$, we cannot combine the colors since it would produce a color 
that isn't representable by hex color codes. For example, when calculating $x$, if $$\sum_{i=1}^{n} x_i$$ is not divisible by $n$, we would get a decimal value which cannot be represented using hex color codes.

1) `combine()`: Given a list of colors, combine the colors and return the combined Color. If the colors cannot be combined, throw a CannotCombineColorsException.

### Task 3
1) `createColor(colors, target)`: Given a list of colors and a target color, determine if there is a subset of colors such that they can be 
combined to form the target color.

Hint: You might want to use recursion. Think about what parameters you want to pass into your helper method and think about
the base case.

### Grading

| Tasks | Grade |
| ----- | :---: |
| Completing all three tasks | A |
| Completing Tasks 1 and 2 | B |
| Completing only Task 1 | C |
| Not completing any task | F |

Any task must be **completed fully** to get credit. Make sure you write additional tests. The provided tests are only to give you a sense that you are moving in the correct direction.
