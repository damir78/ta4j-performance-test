package eu.damir;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Simple moving average.
 */
public class SimpleMovingAverageUsingQueue {

    private final Queue<Float> window;
    private final int period;
    private float sum;

    public SimpleMovingAverageUsingQueue(int period) {
        this.period = period;
        window = new ArrayDeque<>(period);
    }

    public float average(float num) {
        sum += num;
        window.add(num);
        if (window.size() > period) {
            sum -= window.remove();
        }
        return sum / window.size();
    }
}
