package com.gildedtros.application;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class NicksGildedTrosTest {

    @Test
    void foo() {
        Item[] items = new Item[]{new Item("foo", 0, 0)};
        GildedTros app = new GildedTros(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
    }

    @ParameterizedTest
    @CsvSource(delimiter = '|', value = {
            "Regular Item | 15 | 20 | 14 | 19",
            "Good Wine | 15 | 20 | 14 | 21",
            "Backstage passes for Re:Factor | 15 | 20 | 14 | 21",
            "Backstage passes for HAXX | 15 | 20 | 14 | 21",
            "B-DAWG Keychain | 15 | 80 | 15 | 80",
    })
    void updateQuality_sellIn15Days(String name, int sellIn, int quality, int expectedSellIn, int expectedQuality) {
        GildedTros gildedTros = createGildedTros(new Item(name, sellIn, quality));

        gildedTros.updateQuality();

        assertSingleItem(gildedTros.items, expectedSellIn, expectedQuality);
    }

    @ParameterizedTest
    @CsvSource(delimiter = '|', value = {
            "Regular Item | 10 | 20 | 9 | 19",
            "Good Wine | 10 | 20 | 9 | 21",
            "Backstage passes for Re:Factor | 10 | 20 | 9 | 22",
            "Backstage passes for HAXX | 10 | 20 | 9 | 22",
            "B-DAWG Keychain | 10 | 80 | 10 | 80",
    })
    void updateQuality_sellIn10Days(String name, int sellIn, int quality, int expectedSellIn, int expectedQuality) {
        GildedTros gildedTros = createGildedTros(new Item(name, sellIn, quality));

        gildedTros.updateQuality();

        assertSingleItem(gildedTros.items, expectedSellIn, expectedQuality);
    }

    @ParameterizedTest
    @CsvSource(delimiter = '|', value = {
            "Regular Item | 5 | 20 | 4 | 19",
            "Good Wine | 5 | 20 | 4 | 21",
            "Backstage passes for Re:Factor | 5 | 20 | 4 | 23",
            "Backstage passes for HAXX | 5 | 20 | 4 | 23",
            "B-DAWG Keychain | 5 | 80 | 5 | 80",
    })
    void updateQuality_sellIn5Days(String name, int sellIn, int quality, int expectedSellIn, int expectedQuality) {
        GildedTros gildedTros = createGildedTros(new Item(name, sellIn, quality));

        gildedTros.updateQuality();

        assertSingleItem(gildedTros.items, expectedSellIn, expectedQuality);
    }

    @ParameterizedTest
    @CsvSource(delimiter = '|', value = {
            "Regular Item | 0 | 20 | -1 | 18",
            "Good Wine | 0 | 20 | -1 | 22",
            "Backstage passes for Re:Factor | 0 | 20 | -1 | 0",
            "Backstage passes for HAXX | 0 | 20 | -1 | 0",
            "B-DAWG Keychain | 0 | 80 | 0 | 80",
    })
    void updateQuality_sellIn0Days(String name, int sellIn, int quality, int expectedSellIn, int expectedQuality) {
        GildedTros gildedTros = createGildedTros(new Item(name, sellIn, quality));

        gildedTros.updateQuality();

        assertSingleItem(gildedTros.items, expectedSellIn, expectedQuality);
    }

    @ParameterizedTest
    @CsvSource(delimiter = '|', value = {
            "Regular Item | 15 | 50 | 14 | 49",
            "Good Wine | 15 | 50 | 14 | 50",
            "Backstage passes for Re:Factor | 15 | 50 | 14 | 50",
            "Backstage passes for HAXX | 15 | 50 | 14 | 50",
            "B-DAWG Keychain | 15 | 80 | 15 | 80",
    })
    void updateQuality_whenItemQuality50(String name, int sellIn, int quality, int expectedSellIn, int expectedQuality) {
        GildedTros gildedTros = createGildedTros(new Item(name, sellIn, quality));

        gildedTros.updateQuality();

        assertSingleItem(gildedTros.items, expectedSellIn, expectedQuality);
    }

    @ParameterizedTest
    @CsvSource(delimiter = '|', value = {
            "Regular Item | 15 | 0 | 14 | 0",
            "Good Wine | 15 | 0 | 14 | 1",
            "Backstage passes for Re:Factor | 15 | 0 | 14 | 1",
            "Backstage passes for HAXX | 15 | 0 | 14 | 1",
            "B-DAWG Keychain | 15 | 80 | 15 | 80",
    })
    void updateQuality_whenItemQualityZero(String name, int sellIn, int quality, int expectedSellIn, int expectedQuality) {
        GildedTros gildedTros = createGildedTros(new Item(name, sellIn, quality));

        gildedTros.updateQuality();

        assertSingleItem(gildedTros.items, expectedSellIn, expectedQuality);
    }

    @ParameterizedTest
    @CsvSource(delimiter = '|', value = {
            "Backstage passes for HAXX | 15 | 49 | 14 | 50",
            "Backstage passes for HAXX | 10 | 49 | 9 | 50",
            "Backstage passes for HAXX | 10 | 48 | 9 | 50",
            "Backstage passes for HAXX | 5 | 49 | 4 | 50",
            "Backstage passes for HAXX | 5 | 47 | 4 | 50",
    })
    void updateQuality_backstagePassesQualityNeverAbove50(String name, int sellIn, int quality, int expectedSellIn, int expectedQuality) {
        GildedTros gildedTros = createGildedTros(new Item(name, sellIn, quality));

        gildedTros.updateQuality();

        assertSingleItem(gildedTros.items, expectedSellIn, expectedQuality);
    }

    @ParameterizedTest
    @CsvSource(delimiter = '|', value = {
            "Duplicate Code | 10 | 20 | 9 | 18",
            "Long Methods | 10 | 20 | 9 | 18",
            "Ugly Variable Names | 10 | 20 | 9 | 18",
            "Duplicate Code | 0 | 20 | -1 | 16",
            "Long Methods | 0 | 20 | -1 | 16",
            "Ugly Variable Names | 0 | 20 | -1 | 16",
            "Ugly Variable Names | 1 | 1 | 0 | 0",
    })
    void updateQuality_smellyItem(String name, int sellIn, int quality, int expectedSellIn, int expectedQuality) {
        GildedTros gildedTros = createGildedTros(new Item(name, sellIn, quality));

        gildedTros.updateQuality();

        assertSingleItem(gildedTros.items, expectedSellIn, expectedQuality);
    }

    private static GildedTros createGildedTros(Item item) {
        return new GildedTros(List.of(item).toArray(new Item[0]));
    }

    private static void assertSingleItem(Item[] items, int expectedSellIn, int expectedQuality) {
        assertThat(items)
                .singleElement()
                .satisfies(it -> {
                    SoftAssertions.assertSoftly(soft -> {
                        soft.assertThat(it.sellIn).isEqualTo(expectedSellIn);
                        soft.assertThat(it.quality).isEqualTo(expectedQuality);
                    });
                });
    }
}
