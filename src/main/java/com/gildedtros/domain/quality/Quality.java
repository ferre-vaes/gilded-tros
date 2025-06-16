package com.gildedtros.domain.quality;

public class Quality {

    private static final int DEFAULT_DECREASE_VALUE = 1;
    private static final int DEFAULT_INCREASE_VALUE = 1;

    public static int decreaseQualityByOne(int quantity) {
        if (canQualityBeUpdated(quantity)) {
            return quantity - DEFAULT_DECREASE_VALUE;
        }

        return quantity;
    }

    public static int decreaseQualityTimes(int quantity, int times) {
        if (canQualityBeUpdated(quantity)) {
            return quantity - (DEFAULT_DECREASE_VALUE * times);
        }

        return quantity;
    }

    public static int increaseQualityByOne(int quantity) {
        if (canQualityBeUpdated(quantity)) {
            return quantity + DEFAULT_INCREASE_VALUE;
        }

        return quantity;
    }

    public static int increaseQualityTimes(int quantity, int times) {
        if (canQualityBeUpdated(quantity)) {
            return quantity + (DEFAULT_INCREASE_VALUE * times);
        }

        return quantity;
    }

    private static boolean canQualityBeUpdated(int quality) {
        return quality > 0 && quality < 50;
    }

}
