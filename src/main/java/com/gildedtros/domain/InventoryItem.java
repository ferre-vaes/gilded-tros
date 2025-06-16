package com.gildedtros.domain;

import com.gildedtros.domain.quality.Quality;
import com.gildedtros.domain.quality.QualityTracker;

public class InventoryItem {

    private final String name;
    private SellIn sellIn;
    private Quality quality;

    public InventoryItem(String name, SellIn sellIn, Quality quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    public void updateQuality(QualityTracker qualityTracker) {
        this.quality = qualityTracker.updateQuality(this.quality, this.sellIn);
    }

    public void updateSellIn() {
        if (!isLegendaryItem()) {
            this.sellIn = this.sellIn.decreaseSellIn();
        }
    }

    public String getName() {
        return name;
    }

    public SellIn getSellIn() {
        return sellIn;
    }

    public Quality getQuality() {
        return quality;
    }

    private boolean isLegendaryItem() {
        return "B-DAWG Keychain".equals(name);
    }
}
