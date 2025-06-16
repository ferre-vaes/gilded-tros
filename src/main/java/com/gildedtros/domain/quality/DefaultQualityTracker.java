package com.gildedtros.domain.quality;

import com.gildedtros.domain.SellIn;

public class DefaultQualityTracker implements QualityTracker {

    @Override
    public boolean canHandle(String itemName) {
        return true;
    }

    @Override
    public Quality updateQuality(Quality quality, SellIn sellIn) {
        if (isSellInNegativeOrZero(sellIn.value())) {
            return quality.decreaseQualityTimes(2);
        }

        return quality.decreaseQualityByOne();
    }

    private static boolean isSellInNegativeOrZero(int sellIn) {
        return sellIn <= 0;
    }

}
