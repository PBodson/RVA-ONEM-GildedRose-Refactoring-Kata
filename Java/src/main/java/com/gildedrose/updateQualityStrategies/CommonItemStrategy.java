package com.gildedrose.updateQualityStrategies;

import com.gildedrose.Item;

public class CommonItemStrategy implements ItemQualityStrategy{
    @Override
    public void updateQuality(Item item) {
        decreaseQualityIfPossible(item);

        item.sellIn = item.sellIn - 1;

        if (item.sellIn < 0) {
            decreaseQualityIfPossible(item);
        }
    }

    private static void decreaseQualityIfPossible(Item item){
        if (item.quality > 0) {
            item.quality = item.quality - 1;
        }

        if(item.name.startsWith("Conjured") && item.quality > 0){
            item.quality = item.quality - 1;
        }
    }
}
