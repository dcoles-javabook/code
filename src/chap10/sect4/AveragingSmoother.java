package chap10.sect4;

import chap10.sect3.DataSmoother;

/**
 * Smooths numeric data using a sliding window of recently smoothed measurements. Each submitted
 * measurement is smoothed by averaging it with the contents of the window.
 *
 * @author Drue Coles
 */
public class AveragingSmoother extends DataSmoother {

    private double total = 0.0; // sum of measurements in the window

    /**
     * Constructs an averaging smoother with a given window size.
     */
    public AveragingSmoother(int windowSize) {
        super(windowSize);
    }

    /**
     * Smooths and returns a given measurement by averaging it with the contents of the window.
     */
    @Override
    public double computeSmoothedValue(double measurement) {
        // if window is full, subtract oldest value from total
        if (window.size() == windowSize) {
            total -= window.getFirst(); // getFirst() requires Java 21+
        }
        total += measurement;

        // average of the given measurement and contents of the window
        return total / (window.size() + 1);
    }
}
