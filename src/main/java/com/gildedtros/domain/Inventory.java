package com.gildedtros.domain;

import com.gildedtros.domain.quality.*;

import java.util.List;

public class Inventory {

    private final List<QualityTracker> qualityTrackers;

    public Inventory() {
        this.qualityTrackers = List.of(
                new AgingQualityTracker(),
                new LegendaryQualityTracker(),
                new SellInBasedQualityTracker(),
                new SmellingQualityTracker()
        );
    }

    public InventoryItem updateQualityAndSellInFor(InventoryItem inventoryItem) {
        QualityTracker qualityTracker = getQualityTracker(inventoryItem);
        inventoryItem.updateQuality(qualityTracker);
        inventoryItem.updateSellIn();
        return inventoryItem;
    }

    private QualityTracker getQualityTracker(InventoryItem inventoryItem) {
        return qualityTrackers.stream()
                .filter(tracker -> tracker.canHandle(inventoryItem.getName()))
                .findFirst()
                .orElseGet(DefaultQualityTracker::new);
    }

}
