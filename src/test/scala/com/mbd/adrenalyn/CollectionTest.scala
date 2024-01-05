package com.mbd.adrenalyn

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class CollectionTest extends AnyFlatSpec with Matchers {
  "Collection" should "contain entire pack when empty, with no swaps" in {
    val collection = Collection.empty
    val updatedCollection = collection.addPack(
      Pack(
        List(
          Card(1, "One", Some(Arsenal), BaseCard),
          Card(2, "Two", Some(Arsenal), BaseCard),
          Card(3, "Three", Some(Arsenal), BaseCard),
          Card(4, "Four", Some(Arsenal), BaseCard),
          Card(5, "Five", Some(Arsenal), BaseCard),
          Card(6, "Six", Some(Arsenal), BaseCard),
        )
      )
    )

    updatedCollection.singles.size should be (6)
    updatedCollection.swaps.size should be (0)
    updatedCollection.swapCount should be (0)
  }

  "Collection" should "contain 1 single and 1 swap when a 1 card pack is added which is already in the collection" in {
    val collection = Collection(
      Map(1 -> Card(1, "One", Some(Arsenal), BaseCard)),
      Map.empty
    )

    val updatedCollection = collection.addPack(
      Pack(
        List(
          Card(1, "One", Some(Arsenal), BaseCard)
        )
      )
    )

    updatedCollection.singles.size should be (1)
    updatedCollection.swaps.size should be (1)
    updatedCollection.swapCount should be (1)
  }

  "Collection" should "have multiple swaps of the same card when a pack contains a card already in swap" in {
    val collection = Collection(
      Map(1 -> Card(1, "One", Some(Arsenal), BaseCard)),
      Map(1 -> List(Card(1, "One", Some(Arsenal), BaseCard)))
    )

    val updatedCollection = collection.addPack(
      Pack(
        List(
          Card(1, "One", Some(Arsenal), BaseCard)
        )
      )
    )

    updatedCollection.singles.size should be (1)
    updatedCollection.swaps.size should be (1)
    updatedCollection.swapCount should be (2)
  }

  "Collection" should "contain 5 singles with 1 swaps when pack contains two of the same card" in {
    val collection = Collection.empty
    val updatedCollection = collection.addPack(
      Pack(
        List(
          Card(1, "One", Some(Arsenal), BaseCard),
          Card(2, "Two", Some(Arsenal), BaseCard),
          Card(3, "Three", Some(Arsenal), BaseCard),
          Card(3, "Three", Some(Arsenal), BaseCard),
          Card(4, "Four", Some(Arsenal), BaseCard),
          Card(5, "Five", Some(Arsenal), BaseCard),
        )
      )
    )

    updatedCollection.singles.size should be (5)
    updatedCollection.swaps.size should be (1)
    updatedCollection.swapCount should be (1)
  }

  "Collection" should "handle multiple duplicates in the same pack when already have the card in swap" in {
    val collection = Collection(
      Map(1 -> Card(1, "One", Some(Arsenal), BaseCard)),
      Map(1 -> List(Card(1, "One", Some(Arsenal), BaseCard)))
    )

    val updatedCollection = collection.addPack(
      Pack(
        List(
          Card(1, "One", Some(Arsenal), BaseCard),
          Card(1, "One", Some(Arsenal), BaseCard),
          Card(1, "One", Some(Arsenal), BaseCard),
          Card(1, "One", Some(Arsenal), BaseCard)
        )
      )
    )

    updatedCollection.singles.size should be(1)
    updatedCollection.swaps.size should be(1)
    updatedCollection.swapCount should be(5)
  }

  "Collection" should "handle multiple duplicates in the same pack when we only have one copy of the card" in {
    val collection = Collection(
      Map(1 -> Card(1, "One", Some(Arsenal), BaseCard)),
      Map.empty
    )

    val updatedCollection = collection.addPack(
      Pack(
        List(
          Card(1, "One", Some(Arsenal), BaseCard),
          Card(1, "One", Some(Arsenal), BaseCard),
          Card(1, "One", Some(Arsenal), BaseCard),
          Card(1, "One", Some(Arsenal), BaseCard)
        )
      )
    )

    updatedCollection.singles.size should be(1)
    updatedCollection.swaps.size should be(1)
    updatedCollection.swapCount should be(4)
  }

  "Collection" should "handle multiple duplicates in the same pack starting from an empty collection" in {
    val collection = Collection.empty

    val updatedCollection = collection.addPack(
      Pack(
        List(
          Card(1, "One", Some(Arsenal), BaseCard),
          Card(1, "One", Some(Arsenal), BaseCard),
          Card(1, "One", Some(Arsenal), BaseCard),
          Card(1, "One", Some(Arsenal), BaseCard)
        )
      )
    )

    updatedCollection.singles.size should be(1)
    updatedCollection.swaps.size should be(1)
    updatedCollection.swapCount should be(3)
  }

  "Collection" should "handle multiple things" in {
    val collection = Collection.empty
    val updatedCollection = collection.addPack(
      Pack(
        List(
          Card(1, "One", Some(Arsenal), BaseCard),
          Card(2, "Two", Some(Arsenal), BaseCard),
          Card(3, "Three", Some(Arsenal), BaseCard),
          Card(4, "Four", Some(Arsenal), BaseCard),
          Card(5, "Five", Some(Arsenal), BaseCard),
          Card(6, "Six", Some(Arsenal), BaseCard),
        )
      )
    ).addPack(
      Pack(
        List(
          Card(1, "One", Some(Arsenal), BaseCard),
          Card(2, "Two", Some(Arsenal), BaseCard),
          Card(3, "Three", Some(Arsenal), BaseCard),
          Card(4, "Four", Some(Arsenal), BaseCard),
          Card(5, "Five", Some(Arsenal), BaseCard),
          Card(6, "Six", Some(Arsenal), BaseCard),
        )
      )
    ).addPack(
      Pack(
        List(
          Card(1, "One", Some(Arsenal), BaseCard),
          Card(2, "Two", Some(Arsenal), BaseCard),
          Card(3, "Three", Some(Arsenal), BaseCard),
          Card(7, "Seven", Some(Arsenal), BaseCard),
          Card(8, "Eight", Some(Arsenal), BaseCard),
          Card(9, "Nine", Some(Arsenal), BaseCard),
          Card(10, "Ten", Some(Arsenal), BaseCard),
        )
      )
    )

    updatedCollection.singles.size should be (10)
    updatedCollection.swaps.size should be (6)
    updatedCollection.swapCount should be (9)
  }
}
