package com.gildedtros.application;

import com.gildedtros.domain.Inventory;
import com.gildedtros.domain.InventoryItem;
import com.gildedtros.domain.SellIn;
import com.gildedtros.domain.quality.Quality;

public class GildedTros {

    private final Inventory inventory;

    Item[] items;

    public GildedTros(Item[] items) {
        this.items = items;
        this.inventory = new Inventory();
    }

    public void updateQuality() {
        for (Item item : items) {
            InventoryItem inventoryItem = mapToInventoryItem(item);
            updateInventory(inventoryItem);
            syncItemWithInventory(item, inventoryItem);
        }
    }

    public InventoryItem mapToInventoryItem(Item item) {
        return new InventoryItem(
                item.name,
                new SellIn(item.sellIn),
                new Quality(item.quality)
        );
    }

    private void updateInventory(InventoryItem inventoryItem) {
        inventory.updateQualityAndSellInFor(inventoryItem);
    }

    private void syncItemWithInventory(Item item, InventoryItem inventoryItem) {
        item.quality = inventoryItem.getQuality().value();
        item.sellIn = inventoryItem.getSellIn().value();
    }

}