package com.gildedrose;

public class ItemUtil {

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
