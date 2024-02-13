package com.gildedrose;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class GildedRoseTest {

    static Item[] items;
    static Item[] itemsForLegacy;

    @BeforeAll
    static void setUp(){
        items = new Item[] {
            new Item("+5 Dexterity Vest", 10, 20), //
            new Item("Aged Brie", 2, 0), //
            new Item("Elixir of the Mongoose", 5, 7), //
            new Item("Sulfuras, Hand of Ragnaros", 0, 80), //
            new Item("Sulfuras, Hand of Ragnaros", -1, 80),
            new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
            new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
            new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
            // this conjured item does not work properly yet
            new Item("Conjured Mana Cake", 3, 6) };

        // Deep array copy, could be refactored with exiting framework
        itemsForLegacy = Arrays.stream(items).map(item -> new Item(item.name, item.sellIn, item.quality)).toArray(Item[]::new);
    }

    /**
     * Ensure refactoring doesn't break existing base code
     * 17 days used (17 call of updateQuality) to ensure coverage
     * <p>
     * Should be rewritten with a true test coverage without use of legacy code
     *
     */
    @Test
    void givenLegacyCode_whenNewUpdateQualityFor17Days_thenOuputIsTheSame(){
        LegacyGildedRose legacyGildedRose = new LegacyGildedRose(itemsForLegacy);
        GildedRose gildedRose = new GildedRose(items);

        for(int day = 0; day < 17; day++){
            legacyGildedRose.updateQuality();
            gildedRose.updateQuality();

            assertTrue(compareItems(gildedRose.items, legacyGildedRose.items));
        }
    }

    /**
     * TODO Existing framework may exists to compare array of non comparable Objects
     */
    private boolean compareItems(Item[] items, Item[] itemsToCompare) {
        if(items.length != itemsToCompare.length){
            return false;
        }

        for(int i = 0; i < items.length ; i++){
            // Let's assume items have notnull name
            if(!items[i].name.equals(itemsToCompare[i].name)){
                return false;
            }
            if(items[i].sellIn != itemsToCompare[i].sellIn){
                return false;
            }
            if(items[i].quality != itemsToCompare[i].quality){
                return false;
            }
        }
        return true;
    }

}
