/*
 * Developed by Kyle Chatman
 * kchatman.com
 *
 * Licenced under a Creative Commons Attribution-NonCommercial 4.0 International License
 * https://creativecommons.org/licenses/by-nc/4.0/
 *
 *
 */

package calc.calculators;

import calc.functions.Function;

public class Integrator {
    private Function func;
    private double tolerance = .01;
    private int segments = 3;

    public void setFunc(Function func) {
        this.func = func;
    }

    public void setTolerance(double tolerance) {
        this.tolerance = tolerance;
    }

    public void setSegments(int segments) {
        this.segments = segments;
    }

    public Integrator(Function func) {
        this.func = func;
    }

    public Integrator(Function func, double tolerance) {
        this.func = func;
        this.tolerance = tolerance;
    }

    private double trap(double x1, double x2) {
        return 0.5 * (func.get(x1) + func.get(x2)) * (x2 - x1);
    }

    private double segTrap(double x1, double x2) {
        double interval = (x2 - x1) / segments;
        double area = 0;
        for (int i = 0; i < segments; i++) {
            area += interval * 0.5 * ( func.get(x1 + interval * i) + func.get(x1 + interval * (i + 1)) );
        }
        return area;
    }

    private double error(double base, double better) {
        return Math.abs((better - base) / base);
    }

    public double integrate(double x1, double x2) {
        // if this is first call (no base estimate given) calc rough estimate to get started
        return integrate(x1, x2, trap(x1, x2));
    }

    public double integrate(double x1, double x2, double base) {
        // does breaking down into segments significantly improve accuracy over base prediction? If not, return
        double better = segTrap(x1, x2);
        if (error(base, better) < tolerance) {
            return better;
        }
        // if so, go recursively deeper
        double sum = 0, interval = (x2 - x1) / segments;
        for (int i = 0; i < segments; i++) {
            double x1Temp = x1 + interval * i,
                    x2Temp = x1 + interval * (i + 1);
            sum += integrate(x1Temp, x2Temp, trap(x1Temp, x2Temp));
        }
        return sum;
    }

}
