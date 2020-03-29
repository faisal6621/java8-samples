package github.faisal6621.bean;

import github.faisal6621.enums.Color;

/**
 * Color
 */
public class Circle {

    private Color color;

    public Circle() {
        System.out.println("default: " + Color.WHITE);
        this.color = Color.WHITE;
    }

    public Circle(Color color) {
        System.out.println("color: " + color);
        this.color = color;
    }

    @Override
    public String toString() {
        return "Circle [color=" + color + "]";
    }

}
