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
import calc.functions.QuadraticCache;

import java.util.Random;

public class Main {

    public static void main(String[] args) {

        // benchmarking if adding cache to function helps speed
        double totalTimeNoCache = 0, totalTimeCache = 0, error = 0, errorCache = 0;
        Random rand = new Random();
        double tolerance = 0.0001;
        int trials = 200000;

        for (int i = 0; i < trials; i++) {
            int a = rand.nextInt();
            int b = rand.nextInt();
            int c = rand.nextInt();
            int limit = rand.nextInt();

            Quadratic quad = new Quadratic(a, b, c);
            QuadraticCache quadCache = new QuadraticCache(a, b, c);
            double exact = quad.integral(0, limit);

            // test no cache
            Integrator in = new Integrator(quad, tolerance);
            double start = System.currentTimeMillis();
            double result = in.integrate(0, limit);
            double end = System.currentTimeMillis();
            totalTimeNoCache += end - start;
            error += Math.abs((result - exact) / exact);

            // test cache
            Integrator inC = new Integrator(quadCache, tolerance);
            start = System.currentTimeMillis();
            result = in.integrate(0, limit);
            end = System.currentTimeMillis();
            totalTimeCache += end - start;
            errorCache += Math.abs((result - exact) / exact);
        }
        System.out.println("After " + trials + " trials:");
        System.out.println("         time   error");
        System.out.println("No Cache " + totalTimeNoCache + "  " + error);
        System.out.println("   cache " + totalTimeCache + "  " + errorCache);



    }
}
