package com.gildedrose;

class GildedRose {
    public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    public static final String AGED_BRIE = "Aged Brie";
    public static final String BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT = "Backstage passes to a TAFKAL80ETC concert";
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            if (SULFURAS.equals(item.name)) {
                continue;
            }

            if (AGED_BRIE.equals(item.name)
                || BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT.equals(item.name)) {
                    if (item.quality < 50) {
                        item.quality = item.quality + 1;

                        if (BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT.equals(item.name)) {
                            if (item.sellIn < 11) {
                                if (item.quality < 50) {
                                    item.quality = item.quality + 1;
                                }
                            }

                            if (item.sellIn < 6) {
                                if (item.quality < 50) {
                                    item.quality = item.quality + 1;
                                }
                            }
                        }
                    }
                } else {
                if (item.quality > 0) {
                    item.quality = item.quality - 1;
                }
            }


            item.sellIn = item.sellIn - 1;


            if (item.sellIn < 0) {
                if (AGED_BRIE.equals(item.name)) {
                    if (item.quality < 50) {
                        item.quality = item.quality + 1;
                    }
                } else {
                    if (BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT.equals(item.name)) {
                        item.quality = 0;
                    } else {
                        if (item.quality > 0) {
                            item.quality = item.quality - 1;
                        }
                    }
                }
            }
        }
    }
}
