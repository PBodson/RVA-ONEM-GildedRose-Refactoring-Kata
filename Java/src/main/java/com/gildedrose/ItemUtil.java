package com.gildedrose;

public class ItemUtil {

    public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    public static final String AGED_BRIE = "Aged Brie";
    public static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";

    private ItemUtil() {}

    public static void increaseQualityIfPossible(Item item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1;
        }
    }

    public static void decreaseQualityIfPossible(Item item){
        if (item.quality > 0) {
            item.quality = item.quality - 1;
        }
    }
}
