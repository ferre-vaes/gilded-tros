package com.gildedtros.domain.quality;

public interface QualityTracker {

    boolean canHandle(String itemName);

    int updateQuality(int quality, int sellIn);

}
