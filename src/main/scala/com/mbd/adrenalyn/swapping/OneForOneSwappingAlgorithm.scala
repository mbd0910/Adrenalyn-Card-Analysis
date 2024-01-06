package com.mbd.adrenalyn.swapping

import com.mbd.adrenalyn.{Card, Collection}

/**
 * Each collector will swap one card for another, regardless of its rarity
 */
object OneForOneSwappingAlgorithm extends SwappingAlgorithm {
  override def executeSwaps(collection1: Collection, collection2: Collection): (Collection, Collection) = {
    // Find cards in collection2 swaps that aren't in collection1
    // Find cards in collection1 swaps that aren't in collection2
    val neededFromCollection2 = findCardsNeededInSwaps(collection1, collection2)
    val neededFromCollection1 = findCardsNeededInSwaps(collection2, collection1)

    val (addToCollection1, addToCollection2) = pairsToSwap(neededFromCollection2, neededFromCollection1)

    val (collection1WithNewCards, collection2WithSwapsRemoved) =
      updateCollection(collection1, collection2, addToCollection1)
    val (collection2WithNewCards, collection1WithSwapsRemoved) =
      updateCollection(collection2WithSwapsRemoved, collection1WithNewCards, addToCollection2)

    (collection1WithSwapsRemoved, collection2WithNewCards)
  }

  def pairsToSwap(needed1: List[Card.Id], needed2: List[Card.Id]): (List[Card.Id], List[Card.Id]) = {
    val shortestSize = Math.min(needed1.size, needed2.size)

    (needed1.take(shortestSize), needed2.take(shortestSize))
  }


}
