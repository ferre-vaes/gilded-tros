package com.gildedtros.domain.quality;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AgingQualityTrackerTest {

    private AgingQualityTracker tracker;

    @BeforeEach
    void setup() {
        tracker = new AgingQualityTracker();
    }

    @Test
    @DisplayName("canHandle should return true for items that can be aged")
    void canHandle() {
        assertTrue(tracker.canHandle("Good Wine"));
    }

    @Test
    @DisplayName("canHandle should return false for items that cannot be aged")
    void cannotHandle() {
        assertFalse(tracker.canHandle("Good Package"));
    }

    @Test
    @DisplayName("updateQuality increases quality by 1")
    void updateQualityIncreasesByOne() {
        int initialQuality = 10;

        int updatedQuality = tracker.updateQuality(initialQuality, 5);

        assertEquals(11, updatedQuality);
    }

    @Test
    @DisplayName("updateQuality should not increase quality beyond 50")
    void updateQualityCannotExceedFifty() {
        int initialQuality = 50;

        int updatedQuality = tracker.updateQuality(initialQuality, 5);

        assertEquals(50, updatedQuality);
    }

}