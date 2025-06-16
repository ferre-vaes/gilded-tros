package com.gildedtros.domain.quality;

import com.gildedtros.domain.SellIn;

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
    public Quality updateQuality(Quality quality, SellIn sellIn) {
        return quality.increaseQualityByOne();
    }
}
