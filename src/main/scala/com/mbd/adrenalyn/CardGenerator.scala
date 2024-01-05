package com.mbd.adrenalyn

import scala.collection.immutable.ListMap
import scala.util.Random

object CardGenerator {
  val random = new Random()
  def getCard(): Card = {
    Card(randomCardId())
  }

  def randomCardId(): Card.Id = randomCardIdOfType(randomCardType())

  def randomCardType(): CardType = {
    randomCardType(random.nextDouble(), CardTypeProbability.cumulativeProbabilities)
  }

  def randomCardType(randomNumber: Double, cumulativeProbabilities: ListMap[CardType, Double]): CardType = {
    cumulativeProbabilities.filter { case (_, cumulativeProbability) => cumulativeProbability >= randomNumber }
      .minBy { case (_, cumulativeProbability) => cumulativeProbability }
      ._1
  }

  def randomCardIdOfType(cardType: CardType): Card.Id = {
    val cardIdsForType = Card.cardIds(cardType)
    val r = random.nextInt(cardIdsForType.length)
    cardIdsForType(r)
  }
}
