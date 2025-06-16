package com.gildedtros.domain.quality;

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
    public int updateQuality(int quality, int sellIn) {
        return Quality.decreaseQualityTimes(quality, 2);
    }
}
