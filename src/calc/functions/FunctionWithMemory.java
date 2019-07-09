package calc.functions;

import java.util.HashMap;
import java.util.Map;

public class FunctionWithMemory implements Function {
    private Map<Double, Double> memory;

    public FunctionWithMemory() {
        this.memory = new HashMap<>();
    }

    @Override
    public double get(double x) {
        double fromMemory = memory.get(x);
        return 0;
    }
}
