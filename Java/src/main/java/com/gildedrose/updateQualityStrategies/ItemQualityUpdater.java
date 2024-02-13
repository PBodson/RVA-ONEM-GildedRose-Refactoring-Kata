package com.gildedrose.updateQualityStrategies;

import com.gildedrose.Item;

public class ItemQualityUpdater {

    ItemQualityStrategy strategy = new CommonItemStrategy();

    public void updateItem(Item item){
        strategy.updateQuality(item);
    }

    public void setStrategy(ItemQualityStrategy strategy) {
        this.strategy = strategy;
    }
}
