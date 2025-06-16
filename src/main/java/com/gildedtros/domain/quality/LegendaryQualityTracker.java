package com.gildedtros.domain.quality;

import com.gildedtros.domain.SellIn;

import java.util.List;

public class LegendaryQualityTracker implements QualityTracker {

    private static final int LEGENDARY_QUALITY = 80;

    private static final List<String> LEGENDARY_ITEMS = List.of(
            "B-DAWG Keychain"
    );

    @Override
    public boolean canHandle(String itemName) {
        return LEGENDARY_ITEMS.contains(itemName);
    }

    @Override
    public Quality updateQuality(Quality quality, SellIn sellIn) {
        return Quality.LEGENDARY_QUALITY;
    }
}
