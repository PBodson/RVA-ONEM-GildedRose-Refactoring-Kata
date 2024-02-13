package com.gildedrose;

import com.gildedrose.updateQualityStrategies.*;

import static com.gildedrose.ItemUtil.*;

class GildedRose {
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
