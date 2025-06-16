package com.gildedtros.domain.quality;

public class Quality {

    private static final int DEFAULT_DECREASE_VALUE = 1;
    private static final int DEFAULT_INCREASE_VALUE = 1;

    public static int decreaseQuality(int quantity) {
        if (quantity == 0) {
            return quantity;
        }

        return quantity - DEFAULT_DECREASE_VALUE;
    }

    public static int decreaseQualityTimes(int quantity, int times) {
        if (quantity == 0) {
            return quantity;
        }

        return quantity - (DEFAULT_DECREASE_VALUE * times);
    }

    public static int increaseQuality(int quantity) {
        if (quantity >= 50) {
            return quantity;
        }

        return quantity + DEFAULT_INCREASE_VALUE;
    }

    public static int increaseQualityTimes(int quantity, int times) {
        if (quantity >= 50) {
            return quantity;
        }

        return quantity + (DEFAULT_INCREASE_VALUE * times);
    }

}
