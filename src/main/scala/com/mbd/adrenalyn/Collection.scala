package com.mbd.adrenalyn

case class Collection(singles: Map[Card.Id, Card], swaps: Map[Card.Id, List[Card]]) {
  def addPack(pack: Pack): Collection = {
    val (got, need) = pack.cards.partition(c => singles.contains(c.id))

    // This can definitely be optimised but it'll do for now
    val duplicateNeeds = need.groupBy(identity).view.mapValues(_.length).filter(_._2 > 1)
    val addToGot = duplicateNeeds.flatMap { case (card, count) =>
      (1 until count).map(_ => card)
    }

    val updatedSwaps = (got ++ addToGot).foldLeft(swaps) { case (accSwaps, card) =>
      val key = card.id
      val updatedList = accSwaps.getOrElse(key, List()) :+ card
      accSwaps.updated(key, updatedList)
    }

    Collection(
      singles ++ need.map(c => c.id -> c),
      updatedSwaps
    )
  }

  def swapCount: Int = swaps.values.map(_.size).sum
}

object Collection {
  def empty: Collection = Collection(Map.empty, Map.empty)
}
