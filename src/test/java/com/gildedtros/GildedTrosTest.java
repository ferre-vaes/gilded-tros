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

        assertEquals(0, items[0].quality);
    }

    @Test
    @DisplayName("Quality cannot exceed 50")
    void qualityCannotExceedFifty() {
        Item[] items = new Item[] {
            new Item("Good Wine", 0, 50),
        };

        GildedTros app = new GildedTros(items);

        app.updateQuality();

        assertEquals(50, items[0].quality);
    }

    @Test
    @DisplayName("Quality of Good Wine increases by 1 each day")
    void qualityItemsIncreaseInQuality() {
        Item[] items = new Item[] {
            new Item("Good Wine", 2, 10),
        };

        GildedTros app = new GildedTros(items);

        app.updateQuality();

        assertEquals(11, items[0].quality);
    }

    @Test
    @DisplayName("Item decreases in quality and sellIn each day")
    void itemDecreasesInQualityAndSellIn() {
        Item[] items = new Item[] {
            new Item("foo", 2, 10),
        };

        GildedTros app = new GildedTros(items);

        app.updateQuality();

        assertEquals(9, items[0].quality);
        assertEquals(1, items[0].sellIn);
    }

    @Test
    @DisplayName("Item decreases in quality twice as fast after sellIn is zero")
    void itemDecreasesTwiceAsFastAfterSellInIsZero() {
        Item[] items = new Item[] {
            new Item("foo", 0, 10),
        };

        GildedTros app = new GildedTros(items);

        app.updateQuality();

        assertEquals(8, items[0].quality);
    }

    @Test
    @DisplayName("B-DAWG Keychain does not decrease in quality or sellIn")
    void legendaryItemsDoNotDecreaseInQualityOrSellIn() {
        Item[] items = new Item[] {
                new Item("B-DAWG Keychain", 10, 20),
        };

        GildedTros app = new GildedTros(items);

        app.updateQuality();;

        assertEquals(80, items[0].quality);
        assertEquals(10, items[0].sellIn);
    }

    @Test
    @DisplayName("Backstage passes increase in quality by 1 when sellIn is greater than 10")
    void backstagePassesIncreaseInQuality() {
        Item[] items = new Item[] {
            new Item("Backstage passes for Re:Factor", 15, 20),
        };

        GildedTros app = new GildedTros(items);

        app.updateQuality();

        assertEquals(21, items[0].quality);
    }

    @Test
    @DisplayName("Backstage passes increase in quality by 2 when sellIn is less or equal to 10")
    void backstagePassesIncreaseInQualityByTwo() {
        Item[] items = new Item[] {
                new Item("Backstage passes for Re:Factor", 10, 20),
        };

        GildedTros app = new GildedTros(items);

        app.updateQuality();

        assertEquals(22, items[0].quality);
    }

    @Test
    @DisplayName("Backstage passes increase in quality by 3 when sellIn is less or equal to 5")
    void backstagePassesIncreaseInQualityByThree() {
        Item[] items = new Item[] {
                new Item("Backstage passes for Re:Factor", 5, 20),
        };

        GildedTros app = new GildedTros(items);

        app.updateQuality();

        assertEquals(23, items[0].quality);
    }

    @Test
    @DisplayName("Backstage passes drop in quality when sellIn is zero")
    void backstagePassesDropsQuality() {
        Item[] items = new Item[] {
                new Item("Backstage passes for Re:Factor", 0, 20),
        };

        GildedTros app = new GildedTros(items);

        app.updateQuality();

        assertEquals(0, items[0].quality);
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

        assertEquals(4, items[0].quality);
        assertEquals(4, items[1].quality);
        assertEquals(4, items[2].quality);
    }

}
