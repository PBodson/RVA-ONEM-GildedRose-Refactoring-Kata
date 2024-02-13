package com.gildedrose.updateQualityStrategies;

import com.gildedrose.Item;

import static com.gildedrose.ItemUtil.increaseQualityIfPossible;

public class AgedBrieItemStrategy implements ItemQualityStrategy{
    @Override
    public void updateQuality(Item item) {
        increaseQualityIfPossible(item);

        item.sellIn = item.sellIn - 1;

        if (item.sellIn < 0) {
            increaseQualityIfPossible(item);
        }
    }
}
