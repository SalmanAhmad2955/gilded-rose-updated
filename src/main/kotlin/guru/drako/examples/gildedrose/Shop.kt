package guru.drako.examples.gildedrose

class Shop(val items: List<Item>) {
  fun updateQuality() {
    for (item in items) {
      when {
        item.name.contains("Conjured") -> item.quality -= 2
        item.name != "Aged Brie" && item.name != "Backstage passes to a TAFKAL80ETC concert" && item.quality > 0 && item.name != "Sulfuras, Hand of Ragnaros" -> item.quality--
        item.name.contains("Aged") -> ++item.quality
        item.name == "Backstage passes to a TAFKAL80ETC concert" && item.sellIn < 6  && item.quality < 50 -> item.quality +=3
        item.name == "Backstage passes to a TAFKAL80ETC concert" && item.sellIn < 11 && item.quality < 50 -> item.quality +=2
        item.name == "Backstage passes to a TAFKAL80ETC concert" && item.sellIn > 11 && item.quality < 50 -> item.quality++
      }
      if (item.name != "Sulfuras, Hand of Ragnaros") {
        --item.sellIn
      }
      if (item.sellIn < 0) {
        when {
          item.name.contains("Conjured") -> item.quality -= 2
          item.name != "Aged Brie" && item.name != "Backstage passes to a TAFKAL80ETC concert" && item.quality > 0 && item.name != "Sulfuras, Hand of Ragnaros" -> item.quality--
          item.name.contains("Aged") -> ++item.quality
          item.name == "Backstage passes to a TAFKAL80ETC concert"  -> item.quality = 0

        }
      }
    }
  }
}
