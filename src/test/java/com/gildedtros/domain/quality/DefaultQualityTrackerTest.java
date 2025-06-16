package com.gildedtros.domain.quality;

import com.gildedtros.domain.SellIn;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DefaultQualityTrackerTest {

    private DefaultQualityTracker tracker;

    @BeforeEach
    void setup() {
        tracker = new DefaultQualityTracker();
    }

    @Test
    @DisplayName("updateQuality should decrease by 1 when sellIn is positive")
    void updateQualityDecreasesByOne() {
        Quality initialQuality = new Quality(10);
        SellIn sellIn = new SellIn(5);

        Quality updatedQuality = tracker.updateQuality(initialQuality, sellIn);

        assertEquals(9, updatedQuality.value());
    }

    @Test
    @DisplayName("updateQuality should decrease by 2 when sellIn is less or equal to zero")
    void updateQualityDecreasesByTwo() {
        Quality initialQuality = new Quality(10);
        SellIn sellIn = new SellIn(0);

        Quality updatedQuality = tracker.updateQuality(initialQuality, sellIn);

        assertEquals(8, updatedQuality.value());
    }

}