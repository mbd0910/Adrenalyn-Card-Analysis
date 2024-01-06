package com.mbd.adrenalyn.swapping
import com.mbd.adrenalyn.Collection
import com.mbd.adrenalyn.swapping.OneForOneSwappingAlgorithm.{findCardsNeededInSwaps, pairsToSwap, updateCollection}

/**
 * Each collector will give all the cards the other person needs to them
 */
object GenerousSwappingAlgorithm extends SwappingAlgorithm {
  override def executeSwaps(collection1: Collection, collection2: Collection): (Collection, Collection) = {
    val neededFromCollection2 = findCardsNeededInSwaps(collection1, collection2)
    val neededFromCollection1 = findCardsNeededInSwaps(collection2, collection1)

    val (collection1WithNewCards, collection2WithSwapsRemoved) =
      updateCollection(collection1, collection2, neededFromCollection2)
    val (collection2WithNewCards, collection1WithSwapsRemoved) =
      updateCollection(collection2WithSwapsRemoved, collection1WithNewCards, neededFromCollection1)

    (collection1WithSwapsRemoved, collection2WithNewCards)
  }
}
