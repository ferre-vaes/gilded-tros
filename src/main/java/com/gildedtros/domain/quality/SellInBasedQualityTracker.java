package com.gildedtros.domain.quality;

import com.gildedtros.domain.SellIn;

import java.util.List;

import static com.gildedtros.domain.quality.Quality.ZERO_QUALITY;

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
    public Quality updateQuality(Quality quality, SellIn sellIn) {
        if(sellIn.value() == 0) {
            return ZERO_QUALITY;
        }

        if (sellIn.value() <= 10 && sellIn.value() > 5) {
            return quality.increaseQualityTimes(2);
        }

        if (sellIn.value() <= 5) {
            return quality.increaseQualityTimes(3);
        }

        return quality.increaseQualityByOne();
    }

}
