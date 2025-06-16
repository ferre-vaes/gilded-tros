package com.gildedtros.domain.quality;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class QualityTest {

    @Test
    void qualityDecreasesByOne() {
        Quality quality = new Quality(10);

        Quality actual = quality.decreaseQualityByOne();

        assertEquals(9, actual.value());
    }

    @Test
    void qualityDecreasesCannotBeNegative() {
        Quality quality = new Quality(0);

        Quality actual = quality.decreaseQualityByOne();

        assertEquals(0, actual.value());
    }

    @Test
    void qualityDecreasesTimes() {
        Quality quality = new Quality(10);

        Quality actual = quality.decreaseQualityTimes(2);

        assertEquals(8, actual.value());
    }

    @Test
    void qualityDecreasesTimesCannotBeNegative() {
        Quality quality = new Quality(0);

        Quality actual = quality.decreaseQualityTimes(2);

        assertEquals(0, actual.value());
    }

    @Test
    void qualityIncreasesByOne() {
        Quality quality = new Quality(10);

        Quality actual = quality.increaseQualityByOne();

        assertEquals(11, actual.value());
    }

    @Test
    void qualityIncreasesCannotExceedFifty() {
        Quality quality = new Quality(50);

        Quality actual = quality.increaseQualityByOne();

        assertEquals(50, actual.value());
    }

    @Test
    void qualityIncreasesTimes() {
        Quality quality = new Quality(10);

        Quality actual = quality.increaseQualityTimes(2);

        assertEquals(12, actual.value());
    }

    @Test
    void qualityIncreasesTimesCannotExceedFifty() {
        Quality quality = new Quality(50);

        Quality actual = quality.increaseQualityTimes(2);

        assertEquals(50, actual.value());
    }

}