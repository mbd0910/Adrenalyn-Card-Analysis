package com.mbd.adrenalyn.swapping

import com.mbd.adrenalyn.{BaseCard, Card, Collection}
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class OneForOneSwappingAlgorithmTest extends AnyFlatSpec with Matchers {
  "OneForOneSwappingAlgorithm" should "swap cards in the simplest scenario" in {
    val collection1 = Collection(
      singles = Map(
        1 -> Card(1, "First card", None, BaseCard)
      ),
      swaps = Map(
        1 -> List(Card(1, "First card", None, BaseCard))
      )
    )
    val collection2 = Collection(
      singles = Map(
        2 -> Card(2, "Second card", None, BaseCard)
      ),
      swaps = Map(
        2 -> List(Card(2, "Second card", None, BaseCard))
      )
    )

    val (updatedCollection1, updatedCollection2) = OneForOneSwappingAlgorithm.executeSwaps(collection1, collection2)

    updatedCollection1.singles.size should be (2)
    updatedCollection1.swapCount should be (0)
    updatedCollection1.singles.contains(2) should be (true)
    updatedCollection2.singles.size should be (2)
    updatedCollection2.swapCount should be (0)
    updatedCollection2.singles.contains(1) should be (true)
  }

  "OneForOneSwappingAlgorithm" should "find cards needed in one collection's swaps that aren't in the other" in {
    val collection1 = Collection(
      singles = Map(
        1 -> Card(1, "First card", None, BaseCard)
      ),
      swaps = Map(
        1 -> List(Card(1, "First card", None, BaseCard))
      )
    )
    val collection2 = Collection(
      singles = Map(
        2 -> Card(2, "Second card", None, BaseCard)
      ),
      swaps = Map(
        2 -> List(Card(2, "Second card", None, BaseCard))
      )
    )

    val needed1 = OneForOneSwappingAlgorithm.findCardsNeededInSwaps(collection1, collection2)
    needed1 should be (List(2))
    val needed2 = OneForOneSwappingAlgorithm.findCardsNeededInSwaps(collection2, collection1)
    needed2 should be (List(1))
  }

  "OneForOneSwappingAlgorithm" should "reduce needed lists to cards that will actually be swappied" in {
    val needed1 = List(1, 2, 3)
    val needed2 = List(4, 5)

    val (updatedNeeded1, updatedNeeded2) = OneForOneSwappingAlgorithm.pairsToSwap(needed1, needed2)

    updatedNeeded1 should be (List(1, 2))
    updatedNeeded2 should be (List(4, 5))
  }

  "OneForOneSwappingAlgorithm" should "update both collections when swaps have been agreed" in {
    val collection1 = Collection(
      singles = Map(
        1 -> Card(1, "First card", None, BaseCard)
      ),
      swaps = Map(
        1 -> List(Card(1, "First card", None, BaseCard))
      )
    )
    val collection2 = Collection(
      singles = Map(
        2 -> Card(2, "Second card", None, BaseCard)
      ),
      swaps = Map(
        2 -> List(Card(2, "Second card", None, BaseCard))
      )
    )

    val (updatedCollection1, updatedCollection2) = OneForOneSwappingAlgorithm.updateCollection(
      collection1, collection2, List(2)
    )

    updatedCollection1.singles should be (
      Map(
        1 -> Card(1, "First card", None, BaseCard),
        2 -> Card(2, "Second card", None, BaseCard)
      )
    )
    updatedCollection1.swaps should be (
      Map(
        1 -> List(Card(1, "First card", None, BaseCard))
      )
    )

    updatedCollection2.singles should be (
      Map(
        2 -> Card(2, "Second card", None, BaseCard)
      )
    )
    updatedCollection2.swapCount should be (0)
    updatedCollection2.swaps should be (Map.empty)
  }
}
