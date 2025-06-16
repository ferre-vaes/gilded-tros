package com.gildedtros.domain.quality;

import java.util.List;

import static com.gildedtros.domain.quality.Quality.decreaseQualityTimes;

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
        return decreaseQualityTimes(quality, 2);
    }
}
