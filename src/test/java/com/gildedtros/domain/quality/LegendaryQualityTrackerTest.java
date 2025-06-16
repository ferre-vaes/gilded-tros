package com.gildedtros.domain.quality;

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
        int initialQuality = 10;

        int updatedQuality = tracker.updateQuality(initialQuality, 5);

        assertEquals(10, updatedQuality);
    }

}