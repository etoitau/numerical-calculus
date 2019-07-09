/*
 * Developed by Kyle Chatman
 * kchatman.com
 *
 * Licenced under a Creative Commons Attribution-NonCommercial 4.0 International License
 * https://creativecommons.org/licenses/by-nc/4.0/
 *
 *
 */

package calc.functions;

import java.util.HashMap;
import java.util.Map;

public class Quadratic implements Function {
    private Map<Double, Double> memory;
    private int a, b, c;

    public Quadratic(int a, int b, int c) {
        this.memory = new HashMap<>();
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double get(double x) {
        Double result = memory.get(x);
        if (result == null) {
            result = a * x * x + b * x + c;
            memory.put(x, result);
        }
        return result;
    }

    public double integral(double x1, double x2) {
        return (double) 1/3 * a * (Math.pow(x2, 3) - Math.pow(x1, 3)) + 0.5 * b * (x2 * x2 - x1 * x1) + c * (x2 - x1);
    }

}
