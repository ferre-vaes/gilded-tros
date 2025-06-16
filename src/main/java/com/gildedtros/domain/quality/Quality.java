package com.gildedtros.domain.quality;

public record Quality(int value) {

    private static final int DEFAULT_DECREASE_VALUE = 1;
    private static final int DEFAULT_INCREASE_VALUE = 1;

    public static Quality LEGENDARY_QUALITY = new Quality(80);
    public static Quality ZERO_QUALITY = new Quality(0);

    public Quality decreaseQualityByOne() {
        if (canQualityBeUpdated()) {
            return new Quality(value - DEFAULT_DECREASE_VALUE);
        }

        return this;
    }

    public Quality decreaseQualityTimes(int times) {
        if (canQualityBeUpdated()) {
            return new Quality(value - (DEFAULT_DECREASE_VALUE * times));
        }

        return this;
    }

    public Quality increaseQualityByOne() {
        if (canQualityBeUpdated()) {
            return new Quality(value + DEFAULT_INCREASE_VALUE);
        }

        return this;
    }

    public Quality increaseQualityTimes(int times) {
        if (canQualityBeUpdated()) {
            return new Quality(value + (DEFAULT_INCREASE_VALUE * times));
        }

        return this;
    }

    private boolean canQualityBeUpdated() {
        return value > 0 && value < 50;
    }

}
