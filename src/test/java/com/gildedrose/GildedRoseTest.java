package com.gildedrose;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class GildedRoseTest {

    /*@Test
    void foo() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].name).isEqualTo("fixme");
    }*/


    /* DEFAULT ITEM*/
    @Test
    void testDefaultItemQualityStandard() {
        int quality = 20;
        int sellIn = 10;
        Item[] items = new Item[] { new Item("+5 Dexterity Vest", sellIn, quality) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality).isEqualTo(quality-1);
    }
    @Test
    void testDefaultItemSellIn() {
        int quality = 20;
        int sellIn = 10;
        Item[] items = new Item[] { new Item("+5 Dexterity Vest", sellIn, quality) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].sellIn).isEqualTo(sellIn-1);
    }
    @Test
    void testDefaultItemQualitySellInZero() {
        int quality = 20;
        int sellIn = 0;
        Item[] items = new Item[] { new Item("+5 Dexterity Vest", sellIn, quality) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality).isEqualTo(quality-2);
    }
    @Test
    void testDefaultItemQualitySellInZeroQtyLt2() {
        int quality = 1;
        int sellIn = 0;
        Item[] items = new Item[] { new Item("+5 Dexterity Vest", sellIn, quality) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality).isEqualTo(0);
    }
    @Test
    void testDefaultItemQualitySellInZeroQtyZero() {
        int quality = 0;
        int sellIn = 0;
        Item[] items = new Item[] { new Item("+5 Dexterity Vest", sellIn, quality) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality).isEqualTo(0);
    }

    /* CONJURED*/
    @Test
    void testConjuredQualityStandard() {
        int quality = 20;
        int sellIn = 10;
        Item[] items = new Item[] { new Item("Conjured Mana Cake", sellIn, quality) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality).isEqualTo(quality-2);
    }
    @Test
    void testConjuredQualityStandardQty1() {
        int quality = 1;
        int sellIn = 10;
        Item[] items = new Item[] { new Item("Conjured Mana Cake", sellIn, quality) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality).isEqualTo(0);
    }
    @Test
    void testConjuredQualityStandardSellIn0() {
        int quality = 20;
        int sellIn = 0;
        Item[] items = new Item[] { new Item("Conjured Mana Cake", sellIn, quality) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality).isEqualTo(quality-4);
    }

    @Test
    void testConjuredQualityStandardSellIn0Qty3() {
        int quality = 3;
        int sellIn = 0;
        Item[] items = new Item[] { new Item("Conjured Mana Cake", sellIn, quality) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality).isEqualTo(0);
    }

    /*AGED BRIE*/
    @Test
    void testAgedStandard() {
        int quality = 0;
        int sellIn = 10;
        Item[] items = new Item[] { new Item("Aged Brie", sellIn, quality) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality).isEqualTo(quality+1);
    }
    @Test
    void testAgedStandardQty50() {
        int quality = 50;
        int sellIn = 10;
        Item[] items = new Item[] { new Item("Aged Brie", sellIn, quality) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality).isEqualTo(quality);
    }
    @Test
    void testAgedStandardSellIn0Qty49() {
        int quality = 49;
        int sellIn = 0;
        Item[] items = new Item[] { new Item("Aged Brie", sellIn, quality) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality).isEqualTo(quality+1);
    }

    /*SULFURAS*/
    @Test
    void testSulfurasStandard() {
        int quality = 1;
        int sellIn = 80;
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", sellIn, quality) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality).isEqualTo(quality);
    }
    @Test
    void testSulfurasSellIn0() {
        int quality = 1;
        int sellIn = -1;
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", sellIn, quality) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality).isEqualTo(quality);
    }

    /*BACKSTAGE PASSES*/
    @Test
    void testBackstageStandard() {
        int quality = 10;
        int sellIn = 80;
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", sellIn, quality) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality).isEqualTo(quality+1);
    }
    void testBackstageStandardQty50() {
        int quality = 50;
        int sellIn = 80;
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", sellIn, quality) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality).isEqualTo(quality);
    }
    void testBackstageStandardSellInLt10() {
        int quality = 20;
        int sellIn = 9;
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", sellIn, quality) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality).isEqualTo(quality+2);
    }
    void testBackstageStandardSellInLt5() {
        int quality = 20;
        int sellIn = 4;
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", sellIn, quality) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality).isEqualTo(quality+3);
    }
    void testBackstageStandardSellIn0() {
        int quality = 20;
        int sellIn = 0;
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", sellIn, quality) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality).isEqualTo(0);
    }




}
