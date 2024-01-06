package com.mbd.adrenalyn.swapping

import com.mbd.adrenalyn.{Card, Collection}

trait SwappingAlgorithm {
  def executeSwaps(collection1: Collection, collection2: Collection): (Collection, Collection)

  def findCardsNeededInSwaps(notInCollection: Collection, areInCollection: Collection): List[Card.Id] = {
    areInCollection.swaps.view.filterKeys(cardId => !notInCollection.singles.contains(cardId)).keys.toList
  }

  def updateCollection(
    collectionToUpdate: Collection,
    fromCollection: Collection,
    cardsTaking: List[Card.Id]): (Collection, Collection) = {
    cardsTaking.foldLeft((collectionToUpdate, fromCollection)) { case ((toUpdate, fromCollection), cardId) =>
      (
        toUpdate.addSingle(fromCollection.swaps(cardId).head),
        fromCollection.removeSwap(cardId)
      )
    }
  }
}
