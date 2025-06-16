package com.gildedtros.domain.quality;

import java.util.List;

import static com.gildedtros.domain.quality.Quality.increaseQualityByOne;

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
        return increaseQualityByOne(quality);
    }
}
