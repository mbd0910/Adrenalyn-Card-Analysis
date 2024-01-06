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

  "OneForOneSwappingAlgorithm" should "swap cards in a more complicated scenario" in {
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

    // They'll swap a 1 for a 6
    val (updatedCollection1, updatedCollection2) = OneForOneSwappingAlgorithm.executeSwaps(collection1, collection2)

    updatedCollection1.singles.size should be (6)
    updatedCollection1.swapCount should be (5)
    updatedCollection1.swaps.contains(1) should be (true)
    updatedCollection1.swaps.contains(2) should be (true)
    updatedCollection1.swaps(2).size should be (1)
    updatedCollection1.swaps(3).size should be (3)

    updatedCollection2.singles.size should be (7)
    updatedCollection2.swapCount should be (3)
    updatedCollection2.swaps.contains(6) should be (false)
    updatedCollection2.swaps(3).size should be (3)
  }

  "OneForOneSwappingAlgorithm" should "swap cards in an even more complicated scenario" in {
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
        6 -> List(Card(6, "Six", None, BaseCard)),
        8 -> List(Card(8, "Eight", None, BaseCard))
      )
    )

    // They'll swap a 1 and 2 for a 6 and 8
    val (updatedCollection1, updatedCollection2) = OneForOneSwappingAlgorithm.executeSwaps(collection1, collection2)

    updatedCollection1.singles.size should be (7)
    updatedCollection1.swapCount should be (4)
    updatedCollection1.swaps.contains(1) should be (true)
    updatedCollection1.swaps.contains(2) should be (false)
    updatedCollection1.swaps(3).size should be (3)

    updatedCollection2.singles.size should be (8)
    updatedCollection2.swapCount should be (3)
    updatedCollection2.swaps.contains(6) should be (false)
    updatedCollection2.swaps(3).size should be (3)
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
