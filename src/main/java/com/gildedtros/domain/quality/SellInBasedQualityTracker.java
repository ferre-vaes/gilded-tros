package com.gildedtros.domain.quality;

import java.util.List;

public class SellInBasedQualityTracker implements QualityTracker{

    private static final List<String> SELL_IN_BASED_ITEMS = List.of(
            "Backstage passes for Re:Factor",
            "Backstage passes for HAXX"
    );

    @Override
    public boolean canHandle(String itemName) {
        return SELL_IN_BASED_ITEMS.contains(itemName);
    }

    @Override
    public int updateQuality(int quality, int sellIn) {
        if(sellIn == 0) {
            return 0;
        }

        if (sellIn <= 10 && sellIn > 5) {
            return Quality.increaseQualityTimes(quality, 2);
        }

        if (sellIn <= 5) {
            return Quality.increaseQualityTimes(quality, 3);
        }

        return Quality.increaseQuality(quality);
    }

}
