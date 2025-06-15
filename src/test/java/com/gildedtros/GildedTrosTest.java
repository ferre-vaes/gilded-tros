package com.gildedtros;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedTrosTest {

    @Test
    @DisplayName("Quality cannot be negative")
    void qualityCannotBeNegative() {
        Item[] items = new Item[] {
            new Item("foo", 0, 0),
        };

        GildedTros app = new GildedTros(items);

        app.updateQuality();
        app.updateQuality();
        app.updateQuality();

        Item[] inventory = app.getInventory();

        assertEquals(0, inventory[0].quality);
    }

    @Test
    @DisplayName("Quality cannot exceed 50")
    void qualityCannotExceedFifty() {
        Item[] items = new Item[] {
            new Item("Good Wine", 0, 50),
        };

        GildedTros app = new GildedTros(items);

        app.updateQuality();

        Item[] inventory = app.getInventory();

        assertEquals(50, inventory[0].quality);
    }

    @Test
    @DisplayName("Quality of Good Wine increases by 1 each day")
    void qualityItemsIncreaseInQuality() {
        Item[] items = new Item[] {
            new Item("Good Wine", 2, 0),
        };

        GildedTros app = new GildedTros(items);

        app.updateQuality();

        Item[] inventory = app.getInventory();

        assertEquals(1, inventory[0].quality);
    }

    @Test
    @DisplayName("Item decreases in quality and sellIn each day")
    void itemDecreasesInQualityAndSellIn() {
        Item[] items = new Item[] {
            new Item("foo", 2, 10),
        };

        GildedTros app = new GildedTros(items);

        app.updateQuality();

        Item[] inventory = app.getInventory();

        assertEquals(9, inventory[0].quality);
        assertEquals(1, inventory[0].sellIn);
    }

    @Test
    @DisplayName("Item decreases in quality twice as fast after sellIn is zero")
    void itemDecreasesTwiceAsFastAfterSellInIsZero() {
        Item[] items = new Item[] {
            new Item("foo", 0, 10),
        };

        GildedTros app = new GildedTros(items);

        app.updateQuality();

        Item[] inventory = app.getInventory();

        assertEquals(8, inventory[0].quality);
    }

    @Test
    @DisplayName("B-DAWG Keychain does not decrease in quality or sellIn")
    void legendaryItemsDoNotDecreaseInQualityOrSellIn() {
        Item[] items = new Item[] {
                new Item("B-DAWG Keychain", 10, 20),
        };

        GildedTros app = new GildedTros(items);

        app.updateQuality();

        Item[] inventory = app.getInventory();

        assertEquals(20, inventory[0].quality);
        assertEquals(10, inventory[0].sellIn);
    }

    @Test
    @DisplayName("Backstage passes increase in quality by 1 when sellIn is greater than 10")
    void backstagePassesIncreaseInQuality() {
        Item[] items = new Item[] {
            new Item("Backstage passes for Re:Factor", 15, 20),
        };

        GildedTros app = new GildedTros(items);

        app.updateQuality();

        Item[] inventory = app.getInventory();

        assertEquals(21, inventory[0].quality);
    }

    @Test
    @DisplayName("Backstage passes increase in quality by 2 when sellIn is less or equal to 10")
    void backstagePassesIncreaseInQualityByTwo() {
        Item[] items = new Item[] {
                new Item("Backstage passes for Re:Factor", 10, 20),
        };

        GildedTros app = new GildedTros(items);

        app.updateQuality();

        Item[] inventory = app.getInventory();

        assertEquals(22, inventory[0].quality);
    }

    @Test
    @DisplayName("Backstage passes increase in quality by 3 when sellIn is less or equal to 5")
    void backstagePassesIncreaseInQualityByThree() {
        Item[] items = new Item[] {
                new Item("Backstage passes for Re:Factor", 5, 20),
        };

        GildedTros app = new GildedTros(items);

        app.updateQuality();

        Item[] inventory = app.getInventory();

        assertEquals(23, inventory[0].quality);
    }

    @Test
    @DisplayName("Backstage passes drop in quality when sellIn is zero")
    void backstagePassesDropsQuality() {
        Item[] items = new Item[] {
                new Item("Backstage passes for Re:Factor", 0, 20),
        };

        GildedTros app = new GildedTros(items);

        app.updateQuality();

        Item[] inventory = app.getInventory();

        assertEquals(0, inventory[0].quality);
    }

    @Test
    @DisplayName("Smelly items decrease twice as fast in quality")
    void smellyItems() {
        Item[] items = new Item[] {
                new Item("Duplicate Code", 3, 6),
                new Item("Long Methods", 3, 6),
                new Item("Ugly Variable Names", 3, 6),
        };

        GildedTros app = new GildedTros(items);

        app.updateQuality();

        Item[] inventory = app.getInventory();

        assertEquals(4, inventory[0].quality);
        assertEquals(4, inventory[1].quality);
        assertEquals(4, inventory[2].quality);
    }

}
