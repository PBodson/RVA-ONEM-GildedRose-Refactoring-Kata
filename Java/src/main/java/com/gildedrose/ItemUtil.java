package com.gildedrose;

public class ItemUtil {

    public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    public static final String AGED_BRIE = "Aged Brie";
    public static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";

    private ItemUtil() {}

    public static void increaseQualityIfPossible(Item item) {
        if (item.quality < 50) {
            increaseQuality(item);
        }
    }

    public static void decreaseQuality(Item item) {
        item.quality = item.quality - 1;
    }

    private static void increaseQuality(Item item) {
        item.quality = item.quality + 1;
    }
}
