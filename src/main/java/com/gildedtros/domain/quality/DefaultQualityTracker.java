package com.gildedtros.domain.quality;

import static com.gildedtros.domain.quality.Quality.decreaseQualityByOne;
import static com.gildedtros.domain.quality.Quality.decreaseQualityTimes;

public class DefaultQualityTracker implements QualityTracker {

    @Override
    public boolean canHandle(String itemName) {
        return true;
    }

    @Override
    public int updateQuality(int quality, int sellIn) {
        if (isSellInNegativeOrZero(sellIn)) {
            return decreaseQualityTimes(quality, 2);
        }

        return decreaseQualityByOne(quality);
    }

    private static boolean isSellInNegativeOrZero(int sellIn) {
        return sellIn <= 0;
    }

}
