package com.gildedrose.updateQualityStrategies;

import com.gildedrose.Item;

import static com.gildedrose.ItemUtil.increaseQualityIfPossible;

public class BackstagePassesItemStrategy implements ItemQualityStrategy{
    @Override
    public void updateQuality(Item item) {
        increaseQualityIfPossible(item);

        if (item.sellIn < 11) {
            increaseQualityIfPossible(item);
        }

        if (item.sellIn < 6) {
            increaseQualityIfPossible(item);
        }


        item.sellIn = item.sellIn - 1;
        if (item.sellIn < 0) {
            item.quality = 0;
        }
    }
}
