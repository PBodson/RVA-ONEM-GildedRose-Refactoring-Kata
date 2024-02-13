package com.gildedrose.updateQualityStrategies;

import com.gildedrose.Item;

import static com.gildedrose.ItemUtil.decreaseQuality;

public class CommonItemStrategy implements ItemQualityStrategy{
    @Override
    public void updateQuality(Item item) {
        if (item.quality > 0) {
            decreaseQuality(item);
        }

        item.sellIn = item.sellIn - 1;

        if (item.sellIn < 0 && item.quality > 0) {
            decreaseQuality(item);
        }
    }
}
