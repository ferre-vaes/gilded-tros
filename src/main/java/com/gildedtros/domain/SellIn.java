package com.gildedtros.domain;

public record SellIn(int value) {

    public SellIn decreaseSellIn() {
        if (value == 0) {
            return this;
        }

        return new SellIn(value - 1);
    }

}
