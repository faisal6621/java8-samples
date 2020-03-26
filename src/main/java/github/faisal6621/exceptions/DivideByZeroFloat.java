package github.faisal6621.exceptions;

/**
 * DivideByZeroFloat
 */
public class DivideByZeroFloat {
    static float f = 10;
    static int i = 20;

    public static void main(String[] args) {
        // int b = i / 0;
        // System.out.println(b);
        float f2 = f / 0;
        System.out.println(Float.isInfinite(f2));
    }
}
