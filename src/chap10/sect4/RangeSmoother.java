package chap10.sect4;

import chap10.sect3.DataSmoother;

/**
 * Smooths numeric data using a sliding window of recently smoothed measurements. Each measurement
 * is added as-is to the window unless it falls outside a prescribed range, in which case the
 * previous smoothed value is used.
 *
 * @author Drue Coles
 */
public class RangeSmoother extends DataSmoother {
    private final double lowerThreshold;
    private final double upperThreshold;

    /**
     * Constructs a RangeSmoother with a given window size, lower threshold, and upper threshold.
     */
    public RangeSmoother(int windowSize, double lowerThreshold, double upperThreshold) {
        super(windowSize);
        this.lowerThreshold = lowerThreshold;
        this.upperThreshold = upperThreshold;
    }

    /**
     * Returns the lower and upper thresholds for this range smoother.
     */
    public double[] getRange() {
        return new double[]{lowerThreshold, upperThreshold};
    }

    /**
     * Smooths and returns a given measurement. If the measurement is within the prescribed range,
     * it is returned as-is, otherwise the most recent smoothed value is returned; if no previous
     * value exists, the midpoint of the range is returned.
     */
    @Override
    public double computeSmoothedValue(double measurement) {
        if (measurement >= lowerThreshold && measurement <= upperThreshold) {
            return measurement;
        }

        // measurement is outside prescribed range
        return window.isEmpty()
                ? (lowerThreshold + upperThreshold) / 2
                : window.getLast(); // requires Java 21+
    }
}
