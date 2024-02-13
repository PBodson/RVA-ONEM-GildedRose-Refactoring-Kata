package com.gildedrose.updateQualityStrategies;

import com.gildedrose.Item;

import static com.gildedrose.ItemUtil.decreaseQualityIfPossible;

public class CommonItemStrategy implements ItemQualityStrategy{
    @Override
    public void updateQuality(Item item) {
        decreaseQualityIfPossible(item);

        item.sellIn = item.sellIn - 1;

        if (item.sellIn < 0) {
            decreaseQualityIfPossible(item);
        }
    }
}
