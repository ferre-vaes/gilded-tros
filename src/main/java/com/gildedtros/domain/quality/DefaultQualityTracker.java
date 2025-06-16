package com.gildedtros.domain.quality;

public class DefaultQualityTracker implements QualityTracker {

    @Override
    public boolean canHandle(String itemName) {
        return true;
    }

    @Override
    public int updateQuality(int quality, int sellIn) {
        if (sellIn <= 0) {
            return Quality.decreaseQualityTimes(quality, 2);
        }

        return Quality.decreaseQuality(quality);
    }

}
