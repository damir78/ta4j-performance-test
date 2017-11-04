package eu.damir;

import org.junit.Test;

/**
 * Created by damir on 03.11.17.
 */
public class SimpleMovingAverageUsingQueueTest {

    @Test
    public void testIndicator() {
        long start = System.currentTimeMillis();
        int initialCapacity = 54 * 5 * 24 * 60 * 3;

        float[] input = new float[initialCapacity];
        for (int i = 0; i < input.length; i++) {
            input[i] = i + 1;
        }

        //Time elapsed: 4515 on my macbook pro mid 2014

        for (int h = 2; h < 201; h++) {
            SimpleMovingAverageUsingQueue sma = new SimpleMovingAverageUsingQueue(h);
            for (int i = 0; i < initialCapacity; i++) {
                sma.average(input[i]);
            }
        }
        long end = System.currentTimeMillis();

        System.out.println("Time elapsed: " + (end - start));
    }

}
