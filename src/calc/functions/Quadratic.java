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

/**
 * models a quadratic function of the form y = ax^2 + bx + c
 */
public class Quadratic implements Function {
    protected int a, b, c;

    public Quadratic(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double get(double x) {
        return a * x * x + b * x + c;
    }

    public double integral(double x1, double x2) {
        return (double) 1/3 * a * (Math.pow(x2, 3) - Math.pow(x1, 3)) + 0.5 * b * (x2 * x2 - x1 * x1) + c * (x2 - x1);
    }

}
