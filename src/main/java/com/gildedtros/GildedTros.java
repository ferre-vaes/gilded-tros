package com.gildedtros;

import com.gildedtros.domain.quality.*;

import java.util.List;

class GildedTros {

    private final List<QualityTracker> qualityTrackers;

    Item[] items;

    public GildedTros(Item[] items) {
        this.items = items;

        qualityTrackers = List.of(
                new AgingQualityTracker(),
                new LegendaryQualityTracker(),
                new SellInBasedQualityTracker(),
                new SmellingQualityTracker()
        );
    }

    public void updateQuality() {
        for (Item item : items) {
            QualityTracker qualityTracker = getQualityTracker(item);

            item.quality = qualityTracker.updateQuality(item.quality, item.sellIn);
            item.sellIn = decreaseSellIn(item.sellIn, item.name);
        }
    }

    private int decreaseSellIn(int sellIn, String itemName) {
        if (!itemName.equals("B-DAWG Keychain")) {
            return sellIn - 1;
        }
        return sellIn;

    }

    private QualityTracker getQualityTracker(Item item) {
        return qualityTrackers.stream()
                .filter(tracker -> tracker.canHandle(item.name))
                .findFirst()
                .orElseGet(DefaultQualityTracker::new);
    }

    public Item[] getInventory() {
        return items;
    }
}