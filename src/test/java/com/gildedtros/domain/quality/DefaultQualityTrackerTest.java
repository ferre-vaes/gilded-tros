package com.gildedtros.domain.quality;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DefaultQualityTrackerTest {

    private DefaultQualityTracker tracker;

    @BeforeEach
    void setup() {
        tracker = new DefaultQualityTracker();
    }

    @Test
    @DisplayName("updateQuality should decrease by 1 when sellIn is positive")
    void updateQualityDecreasesByOne() {
        int initialQuality = 10;
        int sellIn = 5;

        int updatedQuality = tracker.updateQuality(initialQuality, sellIn);

        assertEquals(9, updatedQuality);
    }

    @Test
    @DisplayName("updateQuality should decrease by 2 when sellIn is less or equal to zero")
    void updateQualityDecreasesByTwo() {
        int initialQuality = 10;
        int sellIn = 0;

        int updatedQuality = tracker.updateQuality(initialQuality, sellIn);

        assertEquals(8, updatedQuality);
    }

}