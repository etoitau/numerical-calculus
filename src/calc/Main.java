/*
 * Developed by Kyle Chatman
 * kchatman.com
 *
 * Licenced under a Creative Commons Attribution-NonCommercial 4.0 International License
 * https://creativecommons.org/licenses/by-nc/4.0/
 *
 *
 */

package calc;

import calc.calculators.Integrator;
import calc.functions.Quadratic;

public class Main {

    public static void main(String[] args) {
        Quadratic quad = new Quadratic(-1, 3, -4);
        System.out.println(quad.integral(-1, 3)); // -13.3333
        Integrator in = new Integrator(quad, 0.001);
        System.out.println(in.integrate(-1, 3));
    }
}
