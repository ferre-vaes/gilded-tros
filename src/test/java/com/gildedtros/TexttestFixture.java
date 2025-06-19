package com.gildedtros;


import com.gildedtros.application.GildedTros;
import com.gildedtros.application.Item;

public class TexttestFixture {
    public static String testDays(Integer days) {
        System.out.println("AXXES CODE KATA - GILDED TROS");

        Item[] items = new Item[] {
                new Item("Ring of Cleansening Code", 10, 20),
                new Item("Good Wine", 2, 0),
                new Item("Elixir of the SOLID", 5, 7),
                new Item("B-DAWG Keychain", 0, 80),
                new Item("B-DAWG Keychain", -1, 80),
                new Item("Backstage passes for Re:Factor", 15, 20),
                new Item("Backstage passes for Re:Factor", 10, 49),
                new Item("Backstage passes for HAXX", 5, 49),
                // these smelly items do not work properly yet
                new Item("Duplicate Code", 3, 6),
                new Item("Long Methods", 3, 1),
                new Item("Ugly Variable Names", 0, 6) };

        GildedTros app = new GildedTros(items);

        final StringBuilder result = new StringBuilder();
        for (int i = 0; i < days; i++) {
            result.append("-------- day " + i + " -------- \n");
            result.append("name, sellIn, quality \n");
            for (Item item : items) {
                result.append(item);
                result.append("\n");
            }
            result.append("\n");
            app.updateQuality();
        }

        return result.toString();
    }

}

