package com.gildedrose;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class GildedRose {
    final Logger logger = LoggerFactory.getLogger(GildedRose.class);
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {

        logger.info("Updating quality...");
        for (Item item : items){

            String itemName = item.name;
            itemName = itemName.contains("Conjured") && !itemName.contains("Like Conjured") ? "Conjured" : itemName;
            int itemQuality = item.quality;
            int itemSellIn = item.sellIn;

            switch (itemName){
                case "Aged Brie":
                    item.quality  += itemQuality < 50 ? (itemSellIn > 0 ? 1 : ( itemQuality < 49 ? 2 : 1)) :  0 ;
                    item.sellIn  -= 1 ;
                    logger.debug("Item {} quality was {}, is now {}", itemName, itemQuality, item.quality);
                    break;

                case "Sulfuras, Hand of Ragnaros":
                        logger.debug("Item {} quality was {}, is now {}", itemName, itemQuality, item.quality);
                    break;

                case "Backstage passes to a TAFKAL80ETC concert":
                    item.quality  += itemSellIn > 0 ? (itemSellIn <11 ? (itemSellIn < 6 ? 3 : 2) : 1) : item.quality* (-1) ;
                    item.quality = item.quality>50 ? 50 : item.quality;
                    item.sellIn  -= 1 ;
                    logger.debug("Item {} quality was {}, is now {}", itemName, itemQuality, item.quality);
                    break;

                case "Conjured":
                    item.quality  -= itemQuality > 0 ? (itemSellIn > 0 ? ( itemQuality > 1 ? 2 : 1) : ( itemQuality > 3 ? 4 : item.quality)) :  0 ;
                    item.sellIn  -= 1 ;
                    logger.debug("Item {} quality was {}, is now {}", itemName, itemQuality, item.quality);
                    break;

                default:
                    item.quality  -= itemQuality > 0 ? (itemSellIn > 0 ? 1 : ( itemQuality > 1 ? 2 : 1)) :  0 ;
                    item.sellIn  -= 1 ;
                    logger.debug("Item {} quality was {}, is now {}", itemName, itemQuality, item.quality);

            }
        }



        /*for (int i = 0; i < items.length; i++) {
            if (!items[i].name.equals("Aged Brie")
                    && !items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                if (items[i].quality > 0) {
                    if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                        items[i].quality = items[i].quality - 1;
                    }
                }
            } else {
                if (items[i].quality < 50) {
                    items[i].quality = items[i].quality + 1;

                    if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (items[i].sellIn < 11) {
                            if (items[i].quality < 50) {
                                items[i].quality = items[i].quality + 1;
                            }
                        }

                        if (items[i].sellIn < 6) {
                            if (items[i].quality < 50) {
                                items[i].quality = items[i].quality + 1;
                            }
                        }
                    }
                }
            }

            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                items[i].sellIn = items[i].sellIn - 1;
            }

            if (items[i].sellIn < 0) {
                if (!items[i].name.equals("Aged Brie")) {
                    if (!items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (items[i].quality > 0) {
                            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                                items[i].quality = items[i].quality - 1;
                            }
                        }
                    } else {
                        items[i].quality = items[i].quality - items[i].quality;
                    }
                } else {
                    if (items[i].quality < 50) {
                        items[i].quality = items[i].quality + 1;
                    }
                }
            }
        }*/// ENDFOR
    }

    public Item[] getItems() {
        return items;
    }
}