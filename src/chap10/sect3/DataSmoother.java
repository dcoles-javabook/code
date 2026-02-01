package chap10.sect3;

import java.util.ArrayList;
import java.util.List;

/**
 * Smooths numeric data using a sliding window of recently smoothed measurements.
 *
 * @author Drue Coles
 */
public abstract class DataSmoother {

    protected final int windowSize;
    protected final List<Double> window;

    /**
     * Constructs a DataSmoother with a given window size (assumed to be positive).
     */
    public DataSmoother(int windowSize) {
        this.windowSize = windowSize;
        this.window = new ArrayList<>(windowSize);
    }

    /**
     * Smooths a new measurement and adds it to the window. If the window is full, the oldest
     * measurement is discarded.
     *
     * @return the smoothed measurement
     */
    public double addMeasurement(double measurement) {
        double smoothedValue = computeSmoothedValue(measurement);
        window.add(smoothedValue);
        if (window.size() > windowSize) {
            window.removeFirst(); // requires Java 21+
        }
        return smoothedValue;
    }

    /**
     * Smooths and returns a given measurement.
     */
    protected abstract double computeSmoothedValue(double measurement);
}
