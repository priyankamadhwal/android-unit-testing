package com.techyourchance.unittestingfundamentals.exercise3;

import com.techyourchance.unittestingfundamentals.example3.Interval;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class IntervalsAdjacencyDetectorTest {

    IntervalsAdjacencyDetector SUT;

    @Before
    public void setUp() throws Exception {
        SUT = new IntervalsAdjacencyDetector();
    }

    // interval1 is before interval2 and not adjacent
    @Test
    public void isAdjacent_interval1BeforeInterval2NotAdjcent_falseReturned() {
        Interval interval1 = new Interval(-3, -1);
        Interval interval2 = new Interval(1,3);
        boolean result = SUT.isAdjacent(interval1, interval2);
        assertThat(result, is(false));
    }

    // interval1 is before interval2 and adjacent
    @Test
    public void isAdjacent_interval1BeforeInterval2Adjcent_trueReturned() {
        Interval interval1 = new Interval(-3, -1);
        Interval interval2 = new Interval(-1,3);
        boolean result = SUT.isAdjacent(interval1, interval2);
        assertThat(result, is(true));
    }

    // interval1 overlaps intervel2 on start
    @Test
    public void isAdjacent_interval1OverlapsInterval2OnStart_falseReturned() {
        Interval interval1 = new Interval(-3, 0);
        Interval interval2 = new Interval(-1,3);
        boolean result = SUT.isAdjacent(interval1, interval2);
        assertThat(result, is(false));
    }

    // interval1 contains interval2
    @Test
    public void isAdjacent_interval1ContainsInterval2_falseReturned() {
        Interval interval1 = new Interval(-1, 1);
        Interval interval2 = new Interval(-3,3);
        boolean result = SUT.isAdjacent(interval1, interval2);
        assertThat(result, is(false));
    }

    // interval1 is contained in interval2
    @Test
    public void isAdjacent_interval1ContainedInInterval2_falseReturned() {
        Interval interval1 = new Interval(-3, 3);
        Interval interval2 = new Interval(-1,1);
        boolean result = SUT.isAdjacent(interval1, interval2);
        assertThat(result, is(false));
    }

    // interval1 overlaps interval2 at end
    @Test
    public void isAdjacent_interval1OverlapsInterval2AtEnd_falseReturned() {
        Interval interval1 = new Interval(-1, 1);
        Interval interval2 = new Interval(0,3);
        boolean result = SUT.isAdjacent(interval1, interval2);
        assertThat(result, is(false));
    }

    // interval1 is after interval2 and adjacent
    @Test
    public void isAdjacent_interval1AfterInterval2Adjacent_trueReturned() {
        Interval interval1 = new Interval(1, 3);
        Interval interval2 = new Interval(-1, 1);
        boolean result = SUT.isAdjacent(interval1, interval2);
        assertThat(result, is(true));
    }

    // interval1 is after interval2 and not adjacent
    @Test
    public void isAdjacent_interval1AfterInterval2NotAdjacent_falseReturned() {
        Interval interval1 = new Interval(2, 3);
        Interval interval2 = new Interval(-1, 1);
        boolean result = SUT.isAdjacent(interval1, interval2);
        assertThat(result, is(false));
    }
    
    // interval1 is same as interval2
    @Test
    public void isAdjacent_interval1SameAsInterval2_falseReturned() {
        Interval interval1 = new Interval(2, 3);
        Interval interval2 = new Interval(2, 3);
        boolean result = SUT.isAdjacent(interval1, interval2);
        assertThat(result, is(false));
    }
}