package guru.drako.examples.gildedrose

import org.junit.jupiter.api.Assertions.*

internal class ShopTest {
// every sell in value is reduced is zero
  @org.junit.jupiter.api.Test
  fun `sellInZeroTestCase`() {
      val shop = Shop(items = listOf(
        Item(name = "+5 Dexterity Vest", sellIn = 0, quality = 20),
        Item(name = "Aged Brie", sellIn = 0, quality = 0),
        Item(name = "Elixir of the Mongoose", sellIn = 0, quality = 7),
        Item(name = "Sulfuras, Hand of Ragnaros", sellIn = 0, quality = 80),
        Item(name = "Backstage passes to a TAFKAL80ETC concert", sellIn = 0 , quality = 20),
        Item(name = "Conjured", sellIn = 0, quality = 6)
      ))

 shop.updateQuality()
        assertEquals(-1, shop.items[0].sellIn)
        assertEquals(18, shop.items[0].quality)
        assertEquals(-1, shop.items[1].sellIn)
        assertEquals(2, shop.items[1].quality)
        assertEquals(-1, shop.items[2].sellIn)
        assertEquals(5, shop.items[2].quality)
        assertEquals(0, shop.items[3].sellIn)
        assertEquals(80, shop.items[3].quality)
        assertEquals(-1, shop.items[4].sellIn)
        assertEquals(0, shop.items[4].quality)
        assertEquals(-1, shop.items[5].sellIn)
        assertEquals(2, shop.items[5].quality)
    }


  // sell in value is greater than zero
  @org.junit.jupiter.api.Test
  fun `generalTestCase`() {
    val shop = Shop(items = listOf(
      Item(name = "+5 Dexterity Vest", sellIn = 10, quality = 20),
      Item(name = "Aged Brie", sellIn = 2, quality = 0),
      Item(name = "Elixir of the Mongoose", sellIn = 5, quality = 7),
      Item(name = "Sulfuras, Hand of Ragnaros", sellIn = 0, quality = 80),
      Item(name = "Backstage passes to a TAFKAL80ETC concert", sellIn = 15 , quality = 20),
      Item(name = "Conjured", sellIn = 3, quality = 6)
    ))

    shop.updateQuality()
    assertEquals(9, shop.items[0].sellIn)
    assertEquals(19, shop.items[0].quality)
    assertEquals(1, shop.items[1].sellIn)
    assertEquals(1, shop.items[1].quality)
    assertEquals(4, shop.items[2].sellIn)
    assertEquals(6, shop.items[2].quality)
    assertEquals(0, shop.items[3].sellIn)
    assertEquals(80, shop.items[3].quality)
    assertEquals(14, shop.items[4].sellIn)
    assertEquals(21, shop.items[4].quality)
    assertEquals(2, shop.items[5].sellIn)
    assertEquals(4, shop.items[5].quality)
  }

//  "Backstage passes", like aged brie, increases in quality as its sellIn value approaches; quality increases by 2 when there are 10 days or less and by 3 when there are 5 days or less but quality drops to 0 after the concert
@org.junit.jupiter.api.Test
fun `backstageTestCase`() {
  val shop = Shop(items = listOf(
    Item(name = "Backstage passes to a TAFKAL80ETC concert", sellIn = 15 , quality = 20),
    Item(name = "Backstage passes to a TAFKAL80ETC concert", sellIn = 3 , quality = 20),
    Item(name = "Backstage passes to a TAFKAL80ETC concert", sellIn = 8 , quality = 20)
  ))

  shop.updateQuality()
  assertEquals(14, shop.items[0].sellIn)
  assertEquals(21, shop.items[0].quality)
  assertEquals(2, shop.items[1].sellIn)
  assertEquals(23, shop.items[1].quality)
  assertEquals(7, shop.items[2].sellIn)
  assertEquals(22, shop.items[2].quality)
}

}