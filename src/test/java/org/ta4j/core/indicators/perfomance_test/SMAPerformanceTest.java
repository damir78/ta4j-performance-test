package org.ta4j.core.indicators.perfomance_test;

import org.junit.Test;
import org.ta4j.core.Decimal;
import org.ta4j.core.TimeSeries;
import org.ta4j.core.indicators.SMAIndicator;
import org.ta4j.core.indicators.helpers.ClosePriceIndicator;

public class SMAPerformanceTest {


    //on mmy macbook pro mid 2014:
    //average = 5
    //Time elapsed: 22072
    @Test
    public void testIfQuickEnoughOneIteration() {
        long start = System.currentTimeMillis();
        int initialCapacity = 54 * 5 * 24 * 60 * 3;

        double[] input = new double[initialCapacity];
        for (int i = 0; i < input.length; i++) {
            input[i] = 5d;
        }

        // just adding close price instead timestamp with close price:
        //   AnotherMockTimeSeries: ticks.add(new MockTick(data[i]));
        //MockTimeSeries: ticks.add(new MockTick(ZonedDateTime.now().with(ChronoField.MILLI_OF_SECOND, i), data[i]));

        TimeSeries timeSeries = new AnotherMockTimeSeries(input);

        Decimal average = null;
        for (int h = 2; h < 3; h++) {
            SMAIndicator quoteSMA = new SMAIndicator(new ClosePriceIndicator(timeSeries), h);
            for (int i = 0; i < timeSeries.getTickCount(); i++) {
                average = quoteSMA.getValue(i);
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("average = " + average);

        System.out.println("Time elapsed: " + (end - start));
    }


    //on mmy macbook pro mid 2014:
    //average = ...
    //Time elapsed: infinity... ~50 min
    @Test
    public void testIfQuickEnoughFullIteration() {
        long start = System.currentTimeMillis();
        int initialCapacity = 54 * 5 * 24 * 60 * 3;

        double[] input = new double[initialCapacity];
        for (int i = 0; i < input.length; i++) {
            input[i] = 5d;
        }

        // just adding close price instead timestamp with close price:
        //   AnotherMockTimeSeries: ticks.add(new MockTick(data[i]));
        //MockTimeSeries: ticks.add(new MockTick(ZonedDateTime.now().with(ChronoField.MILLI_OF_SECOND, i), data[i]));


        TimeSeries timeSeries = new AnotherMockTimeSeries(input);

        Decimal average = null;
        for (int h = 2; h < 201; h++) {
            SMAIndicator quoteSMA = new SMAIndicator(new ClosePriceIndicator(timeSeries), h);
            for (int i = 0; i < timeSeries.getTickCount(); i++) {
                average = quoteSMA.getValue(i);
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("average = " + average);

        System.out.println("Time elapsed: " + (end - start));
    }
}
