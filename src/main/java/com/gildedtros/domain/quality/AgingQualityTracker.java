package com.gildedtros.domain.quality;

import java.util.List;

public class AgingQualityTracker implements QualityTracker {

    private static final List<String> AGING_ITEMS = List.of(
            "Good Wine"
    );

    @Override
    public boolean canHandle(String itemName) {
        return AGING_ITEMS.contains(itemName);
    }

    @Override
    public int updateQuality(int quality, int sellIn) {
        return Quality.increaseQuality(quality);
    }
}
