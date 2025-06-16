package com.gildedtros.domain;

import com.gildedtros.domain.quality.AgingQualityTracker;
import com.gildedtros.domain.quality.Quality;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InventoryItemTest {

    @Test
    @DisplayName("updateQuality should update quality with a given QualityTracker")
    void updateQuality() {
        InventoryItem inventoryItem = new InventoryItem("Aged Brie", new SellIn(10), new Quality(20));
        inventoryItem.updateQuality(new AgingQualityTracker());

        assertEquals(new Quality(21), inventoryItem.getQuality());
    }

    @Test
    @DisplayName("updateSellIn should decrease sellIn by 1 for non-legendary items")
    void updateSellIn() {
        InventoryItem inventoryItem = new InventoryItem("Aged Brie", new SellIn(10), new Quality(20));
        inventoryItem.updateSellIn();

        assertEquals(new SellIn(9), inventoryItem.getSellIn());
    }

    @Test
    @DisplayName("updateSellIn should not change sellIn for legendary items")
    void updateSellInLegendaryItem() {
        InventoryItem inventoryItem = new InventoryItem("B-DAWG Keychain", new SellIn(10), new Quality(20));
        inventoryItem.updateSellIn();

        assertEquals(new SellIn(10), inventoryItem.getSellIn());
    }

}