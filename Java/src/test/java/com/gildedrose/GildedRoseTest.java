package com.gildedrose;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class GildedRoseTest {

    /**
     * Ensure refactoring doesn't break existing base code
     * 17 days used (17 call of updateQuality) to ensure coverage
     * <p>
     * Should be rewritten with a true test coverage without use of legacy code
     *
     */
    @Test
    void givenLegacyCode_whenNewUpdateQualityFor17Days_thenOuputIsTheSame(){
        Item[] items = new Item[] {
            new Item("Aged Brie", 2, 0), //
            new Item("Sulfuras, Hand of Ragnaros", 0, 80), //
            new Item("Sulfuras, Hand of Ragnaros", -1, 80),
            new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
            new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
            new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
            // this conjured item does not work properly yet
            new Item("Conjured Mana Cake", 3, 6) };
        Item[] itemsForLegacy = Arrays.stream(items).map(item -> new Item(item.name, item.sellIn, item.quality)).toArray(Item[]::new);

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

    @Test
    void givenCommonItem_whenUpdateQuality(){
        Item commonItem = new Item("Elixir of the Mongoose", 5, 7);
        Item[] items = new Item[] { commonItem };
        GildedRose gildedRose = new GildedRose(items);

        gildedRose.updateQuality();
        assertEquals(4, commonItem.sellIn);
        assertEquals(6, commonItem.quality);
        assertEquals("Elixir of the Mongoose", commonItem.name);

        gildedRose.updateQuality();
        assertEquals(3, commonItem.sellIn);
        assertEquals(5, commonItem.quality);
        assertEquals("Elixir of the Mongoose", commonItem.name);

        gildedRose.updateQuality();
        assertEquals(2, commonItem.sellIn);
        assertEquals(4, commonItem.quality);
        assertEquals("Elixir of the Mongoose", commonItem.name);

        gildedRose.updateQuality();
        assertEquals(1, commonItem.sellIn);
        assertEquals(3, commonItem.quality);
        assertEquals("Elixir of the Mongoose", commonItem.name);

        gildedRose.updateQuality();
        assertEquals(0, commonItem.sellIn);
        assertEquals(2, commonItem.quality);
        assertEquals("Elixir of the Mongoose", commonItem.name);

        gildedRose.updateQuality();
        assertEquals(-1, commonItem.sellIn);
        assertEquals(0, commonItem.quality);
        assertEquals("Elixir of the Mongoose", commonItem.name);

        gildedRose.updateQuality();
        assertEquals(-2, commonItem.sellIn);
        assertEquals(0, commonItem.quality);
        assertEquals("Elixir of the Mongoose", commonItem.name);
    }

    @Test
    void givenAgedBrie_whenUpdateQuality(){
        Item agedBrie = new Item("Aged Brie", 2, 45);
        Item[] items = new Item[] { agedBrie };
        GildedRose gildedRose = new GildedRose(items);

        gildedRose.updateQuality();
        assertEquals(1, agedBrie.sellIn);
        assertEquals(46, agedBrie.quality);
        assertEquals("Aged Brie", agedBrie.name);

        gildedRose.updateQuality();
        assertEquals(0, agedBrie.sellIn);
        assertEquals(47, agedBrie.quality);
        assertEquals("Aged Brie", agedBrie.name);

        gildedRose.updateQuality();
        assertEquals(-1, agedBrie.sellIn);
        assertEquals(49, agedBrie.quality);
        assertEquals("Aged Brie", agedBrie.name);

        gildedRose.updateQuality();
        assertEquals(-2, agedBrie.sellIn);
        assertEquals(50, agedBrie.quality);
        assertEquals("Aged Brie", agedBrie.name);

        gildedRose.updateQuality();
        assertEquals(-3, agedBrie.sellIn);
        assertEquals(50, agedBrie.quality);
        assertEquals("Aged Brie", agedBrie.name);
    }

    @Test
    void givenBackstagePasses_whenUpdateQuality(){
        Item backstagePass = new Item("Backstage passes to a TAFKAL80ETC concert", 12, 29);
        Item[] items = new Item[] { backstagePass };
        GildedRose gildedRose = new GildedRose(items);

        gildedRose.updateQuality();
        assertEquals(11, backstagePass.sellIn);
        assertEquals(30, backstagePass.quality);
        assertEquals("Backstage passes to a TAFKAL80ETC concert", backstagePass.name);

        gildedRose.updateQuality();
        assertEquals(10, backstagePass.sellIn);
        assertEquals(31, backstagePass.quality);
        assertEquals("Backstage passes to a TAFKAL80ETC concert", backstagePass.name);

        gildedRose.updateQuality();
        assertEquals(9, backstagePass.sellIn);
        assertEquals(33, backstagePass.quality);
        assertEquals("Backstage passes to a TAFKAL80ETC concert", backstagePass.name);

        gildedRose.updateQuality();
        assertEquals(8, backstagePass.sellIn);
        assertEquals(35, backstagePass.quality);
        assertEquals("Backstage passes to a TAFKAL80ETC concert", backstagePass.name);

        gildedRose.updateQuality();
        assertEquals(7, backstagePass.sellIn);
        assertEquals(37, backstagePass.quality);
        assertEquals("Backstage passes to a TAFKAL80ETC concert", backstagePass.name);

        gildedRose.updateQuality();
        assertEquals(6, backstagePass.sellIn);
        assertEquals(39, backstagePass.quality);
        assertEquals("Backstage passes to a TAFKAL80ETC concert", backstagePass.name);

        gildedRose.updateQuality();
        assertEquals(5, backstagePass.sellIn);
        assertEquals(41, backstagePass.quality);
        assertEquals("Backstage passes to a TAFKAL80ETC concert", backstagePass.name);

        gildedRose.updateQuality();
        assertEquals(4, backstagePass.sellIn);
        assertEquals(44, backstagePass.quality);
        assertEquals("Backstage passes to a TAFKAL80ETC concert", backstagePass.name);

        gildedRose.updateQuality();
        assertEquals(3, backstagePass.sellIn);
        assertEquals(47, backstagePass.quality);
        assertEquals("Backstage passes to a TAFKAL80ETC concert", backstagePass.name);

        gildedRose.updateQuality();
        assertEquals(2, backstagePass.sellIn);
        assertEquals(50, backstagePass.quality);
        assertEquals("Backstage passes to a TAFKAL80ETC concert", backstagePass.name);

        gildedRose.updateQuality();
        assertEquals(1, backstagePass.sellIn);
        assertEquals(50, backstagePass.quality);
        assertEquals("Backstage passes to a TAFKAL80ETC concert", backstagePass.name);

        gildedRose.updateQuality();
        assertEquals(0, backstagePass.sellIn);
        assertEquals(50, backstagePass.quality);
        assertEquals("Backstage passes to a TAFKAL80ETC concert", backstagePass.name);

        gildedRose.updateQuality();
        assertEquals(-1, backstagePass.sellIn);
        assertEquals(0, backstagePass.quality);
        assertEquals("Backstage passes to a TAFKAL80ETC concert", backstagePass.name);

        gildedRose.updateQuality();
        assertEquals(-2, backstagePass.sellIn);
        assertEquals(0, backstagePass.quality);
        assertEquals("Backstage passes to a TAFKAL80ETC concert", backstagePass.name);
    }

    @Test
    void givenSulfuras_whenUpdateQuality(){
        Item sulfuras = new Item("Sulfuras, Hand of Ragnaros", 2, 80);
        Item[] items = new Item[] { sulfuras };
        GildedRose gildedRose = new GildedRose(items);

        gildedRose.updateQuality();
        assertEquals(2, sulfuras.sellIn);
        assertEquals(80, sulfuras.quality);
        assertEquals("Sulfuras, Hand of Ragnaros", sulfuras.name);

        gildedRose.updateQuality();
        assertEquals(2, sulfuras.sellIn);
        assertEquals(80, sulfuras.quality);
        assertEquals("Sulfuras, Hand of Ragnaros", sulfuras.name);
    }
}
