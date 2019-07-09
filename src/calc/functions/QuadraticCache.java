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

/**
 * Adds a cache to Quadratic to hopefully improve speed
 */
public class QuadraticCache extends Quadratic {
    private Map<Double, Double> cache;

    public QuadraticCache(int a, int b, int c) {
        super(a, b, c);
        this.cache = new HashMap<>();
    }

    public double get(double x) {
        Double result = cache.get(x);
        if (result == null) {
            result = a * x * x + b * x + c;
            cache.put(x, result);
        }
        return result;
    }
}
