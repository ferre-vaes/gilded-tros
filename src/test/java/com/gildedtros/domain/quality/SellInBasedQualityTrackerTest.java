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

class SellInBasedQualityTrackerTest {

    private SellInBasedQualityTracker tracker;

    @BeforeEach
    void setup() {
        tracker = new SellInBasedQualityTracker();
    }

    private static Stream<Arguments> provideItems() {
        return Stream.of(
                Arguments.of("Backstage passes for Re:Factor"),
                Arguments.of("Backstage passes for HAXX")
        );
    }

    @ParameterizedTest
    @MethodSource("provideItems")
    @DisplayName("canHandle should return true for items that can be aged")
    void canHandle(String itemName) {
        assertTrue(tracker.canHandle(itemName));
    }

    @Test
    @DisplayName("canHandle should return false for items that cannot be aged")
    void cannotHandle() {
        assertFalse(tracker.canHandle("Not a backstage pass"));
    }

    @Test
    @DisplayName("updateQuality increases quality by 1 when sellIn is greater than 10")
    void updateQualityIncreasesByOne() {
        Quality initialQuality = new Quality(10);
        SellIn sellIn = new SellIn(15);

        Quality updatedQuality = tracker.updateQuality(initialQuality, sellIn);

        assertEquals(11, updatedQuality.value());
    }

    @Test
    @DisplayName("updateQuality increases quality by 2 when sellIn is less or equal than 10")
    void updateQualityIncreasesByTwo() {
        Quality initialQuality = new Quality(10);
        SellIn sellIn = new SellIn(10);

        Quality updatedQuality = tracker.updateQuality(initialQuality, sellIn);

        assertEquals(12, updatedQuality.value());
    }

    @Test
    @DisplayName("updateQuality increases quality by 3 when sellIn is less or equal than 5")
    void updateQualityIncreasesByThree() {
        Quality initialQuality = new Quality(10);
        SellIn sellIn = new SellIn(5);

        Quality updatedQuality = tracker.updateQuality(initialQuality, sellIn);

        assertEquals(13, updatedQuality.value());
    }

    @Test
    @DisplayName("updateQuality drops quality to zero when sellIn is zero")
    void updateQualityDrops() {
        Quality initialQuality = new Quality(10);
        SellIn sellIn = new SellIn(0);

        Quality updatedQuality = tracker.updateQuality(initialQuality, sellIn);

        assertEquals(0, updatedQuality.value());
    }

}