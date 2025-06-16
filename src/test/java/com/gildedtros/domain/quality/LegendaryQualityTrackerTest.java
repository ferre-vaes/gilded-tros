package com.gildedtros.domain.quality;

import com.gildedtros.domain.SellIn;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LegendaryQualityTrackerTest {

    private LegendaryQualityTracker tracker;

    @BeforeEach
    void setup() {
        tracker = new LegendaryQualityTracker();
    }

    @Test
    @DisplayName("canHandle should return true for items that can be aged")
    void canHandle() {
        assertTrue(tracker.canHandle("B-DAWG Keychain"));
    }

    @Test
    @DisplayName("canHandle should return false for items that cannot be aged")
    void cannotHandle() {
        assertFalse(tracker.canHandle("Not legendary item"));
    }

    @Test
    @DisplayName("updateQuality should not change quality for legendary items")
    void updateQualityRemainsSame() {
        Quality initialQuality = new Quality(80);
        SellIn sellIn = new SellIn(5);

        Quality updatedQuality = tracker.updateQuality(initialQuality, sellIn);

        assertEquals(80, updatedQuality.value());
    }

    @Test
    @DisplayName("updateQuality should return legendary quality 80 for any input")
    void updateQualityAlwaysReturnsLegendaryQuality() {
        Quality initialQuality = new Quality(50);
        SellIn sellIn = new SellIn(10);

        Quality updatedQuality = tracker.updateQuality(initialQuality, sellIn);

        assertEquals(80, updatedQuality.value());
    }

}