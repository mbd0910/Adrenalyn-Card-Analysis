package com.mbd.adrenalyn.swapping

import com.mbd.adrenalyn.{BaseCard, Card, Collection}
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class GenerousSwappingAlgorithmTest extends AnyFlatSpec with Matchers {
  "GenerousSwappingAlgorithm" should "give the other collector all the cards they need" in {
    val collection1 = Collection(
      singles = Map(
        1 -> Card(1, "One", None, BaseCard),
        2 -> Card(2, "Two", None, BaseCard),
        3 -> Card(3, "Three", None, BaseCard),
        4 -> Card(4, "Four", None, BaseCard),
        5 -> Card(5, "Five", None, BaseCard)
      ),
      swaps = Map(
        1 -> List(Card(1, "One", None, BaseCard), Card(1, "One", None, BaseCard)),
        2 -> List(Card(2, "Two", None, BaseCard)),
        3 -> List(Card(3, "Three", None, BaseCard), Card(3, "Three", None, BaseCard), Card(3, "Three", None, BaseCard))
      )
    )
    val collection2 = Collection(
      singles = Map(
        3 -> Card(3, "Three", None, BaseCard),
        4 -> Card(4, "Four", None, BaseCard),
        5 -> Card(5, "Five", None, BaseCard),
        6 -> Card(6, "Six", None, BaseCard),
        7 -> Card(7, "Seven", None, BaseCard),
        8 -> Card(8, "Eight", None, BaseCard)
      ),
      swaps = Map(
        3 -> List(Card(3, "Three", None, BaseCard), Card(3, "Three", None, BaseCard), Card(3, "Three", None, BaseCard)),
        6 -> List(Card(6, "Six", None, BaseCard))
      )
    )

    // Collection 1 will gain the 6, collection 2 will gain the 1 and 2
    val (updatedCollection1, updatedCollection2) = GenerousSwappingAlgorithm.executeSwaps(collection1, collection2)

    updatedCollection1.singles.size should be(6)
    updatedCollection1.swapCount should be(4)
    updatedCollection1.swaps.contains(1) should be(true)
    updatedCollection1.swaps.contains(2) should be(false)
    updatedCollection1.swaps(1).size should be(1)
    updatedCollection1.swaps(3).size should be(3)

    updatedCollection2.singles.size should be(8)
    updatedCollection2.swapCount should be(3)
    updatedCollection2.swaps.contains(6) should be(false)
    updatedCollection2.swaps(3).size should be(3)
  }

}
