package com.mbd.adrenalyn

object CollectionCompletionChecker {
  def isCollectionComplete(collection: Collection): Boolean = collection.singles.size == 468
  def isCollectionComplete(collector: Collector): Boolean = isCollectionComplete(collector.collection)
  def missingCards(collection: Collection): List[Card] =
    (1 to 468).filterNot(id => collection.singles.contains(id)).map(id => Card(id)).toList
}
