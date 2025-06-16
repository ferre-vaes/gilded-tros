package com.gildedtros.domain.quality;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class QualityTest {

    @Test
    void qualityDecreasesByOne() {
        int actual = Quality.decreaseQuality(10);
        assertEquals(9, actual);
    }

    @Test
    void qualityDecreasesCannotBeNegative() {
        int actual = Quality.decreaseQuality(0);
        assertEquals(0, actual);
    }

    @Test
    void qualityDecreasesTimes() {
        int actual = Quality.decreaseQualityTimes(10, 2);
        assertEquals(8, actual);
    }

    @Test
    void qualityDecreasesTimesCannotBeNegative() {
        int actual = Quality.decreaseQualityTimes(0, 2);
        assertEquals(0, actual);
    }

    @Test
    void qualityIncreasesByOne() {
        int actual = Quality.increaseQuality(10);
        assertEquals(11, actual);
    }

    @Test
    void qualityIncreasesCannotExceedFifty() {
        int actual = Quality.increaseQuality(50);
        assertEquals(50, actual);
    }

    @Test
    void qualityIncreasesTimes() {
        int actual = Quality.increaseQualityTimes(10, 2);
        assertEquals(12, actual);
    }

    @Test
    void qualityIncreasesTimesCannotExceedFifty() {
        int actual = Quality.increaseQualityTimes(50, 2);
        assertEquals(50, actual);
    }

}