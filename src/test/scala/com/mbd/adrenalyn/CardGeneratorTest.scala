package com.mbd.adrenalyn

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

import scala.collection.immutable.ListMap
class CardGeneratorTest extends AnyFlatSpec with Matchers {
  "CardGenerator" should "choose the appropriate card type when given a random number and cumulative probabilities" in {
    val cumulativeProbabilities: ListMap[CardType, Double] = ListMap(
      BaseCard -> 0.5,
      GoldenBaller -> 0.55,
      LineupCard -> 0.70,
      ClubCrest -> 1.00
    )

    CardGenerator.randomCardType(0.3, cumulativeProbabilities) should be (BaseCard)
    CardGenerator.randomCardType(0.5, cumulativeProbabilities) should be (BaseCard)

    CardGenerator.randomCardType(0.52, cumulativeProbabilities) should be (GoldenBaller)
    CardGenerator.randomCardType(0.55, cumulativeProbabilities) should be (GoldenBaller)

    CardGenerator.randomCardType(0.69, cumulativeProbabilities) should be (LineupCard)
    CardGenerator.randomCardType(0.70, cumulativeProbabilities) should be (LineupCard)

    CardGenerator.randomCardType(0.94, cumulativeProbabilities) should be (ClubCrest)
    CardGenerator.randomCardType(1.00, cumulativeProbabilities) should be (ClubCrest)
  }
}
