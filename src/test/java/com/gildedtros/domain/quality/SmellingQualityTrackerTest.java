package com.gildedtros.domain.quality;

import com.gildedtros.domain.SellIn;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class SmellingQualityTrackerTest {

    private SmellingQualityTracker tracker;

    @BeforeEach
    void setup() {
        tracker = new SmellingQualityTracker();
    }

    private static Stream<Arguments> provideSmellyItems() {
        return Stream.of(
                Arguments.of("Duplicate Code"),
                Arguments.of("Long Methods"),
                Arguments.of("Ugly Variable Names")
        );
    }

    @ParameterizedTest
    @MethodSource("provideSmellyItems")
    @DisplayName("canHandle should return true for items that can be aged")
    void canHandle(String itemName) {
        assertTrue(tracker.canHandle(itemName));
    }

    @Test
    @DisplayName("canHandle should return false for items that cannot be aged")
    void cannotHandle() {
        assertFalse(tracker.canHandle("Clean code"));
    }

    @Test
    @DisplayName("updateQuality increases quality by 1")
    void updateQualityDecreasesByTwo() {
        Quality initialQuality = new Quality(10);
        SellIn sellIn = new SellIn(5);

        Quality updatedQuality = tracker.updateQuality(initialQuality, sellIn);

        assertEquals(8, updatedQuality.value());
    }

}