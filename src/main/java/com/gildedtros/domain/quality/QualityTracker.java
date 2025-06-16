package com.gildedtros.domain.quality;

import com.gildedtros.domain.SellIn;

public interface QualityTracker {

    boolean canHandle(String itemName);

    Quality updateQuality(Quality quality, SellIn sellIn);

}
