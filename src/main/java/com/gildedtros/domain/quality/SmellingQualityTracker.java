package com.gildedtros.domain.quality;

import com.gildedtros.domain.SellIn;

import java.util.List;

public class SmellingQualityTracker implements QualityTracker {

    private static final List<String> SMELLY_ITEMS = List.of(
            "Duplicate Code",
            "Long Methods",
            "Ugly Variable Names"
    );

    @Override
    public boolean canHandle(String itemName) {
        return SMELLY_ITEMS.contains(itemName);
    }

    @Override
    public Quality updateQuality(Quality quality, SellIn sellIn) {
        return quality.decreaseQualityTimes(2);
    }
}
