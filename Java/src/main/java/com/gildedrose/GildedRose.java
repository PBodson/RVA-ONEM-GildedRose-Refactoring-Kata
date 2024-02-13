package com.gildedrose;

import com.gildedrose.updateQualityStrategies.*;

class GildedRose {
    public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    public static final String AGED_BRIE = "Aged Brie";
    public static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        ItemQualityUpdater updater = new ItemQualityUpdater();
        for (Item item : items) {
            switch (item.name) {
                case SULFURAS:
                    updater.setStrategy(new SulfurasItemStrategy());
                    updater.updateItem(item);
                    break;
                case AGED_BRIE:
                    updater.setStrategy(new AgedBrieItemStrategy());
                    updater.updateItem(item);
                    break;
                case BACKSTAGE_PASSES:
                    updater.setStrategy(new BackstagePassesItemStrategy());
                    updater.updateItem(item);
                    break;
                default:
                    updater.setStrategy(new CommonItemStrategy());
                    updater.updateItem(item);
                    break;
            }
        }
    }
}
