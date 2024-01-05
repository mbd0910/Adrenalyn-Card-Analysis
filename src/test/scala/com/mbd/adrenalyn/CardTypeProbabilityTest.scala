package com.mbd.adrenalyn

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class CardTypeProbabilityTest extends AnyFlatSpec with Matchers {
  "CardTypeProbability" should "calculate the probability of getting a card type from the per x packets value" in {
    val probability1 = CardTypeProbability.probabilityFromPerXPacketValue(4.0/3.0)
    probability1 should be (0.125)
  }

  "CardTypeProbability" should "return 50% probability of 1 special card in 50/50 single card pack" in {
    CardTypeProbability.probabilityOfExactNumberOfCards(1, 0.5, 1) should be (0.5)
  }

  "CardTypeProbability" should "return 25% probability of 0 special cards in 50/50 two card pack" in {
    CardTypeProbability.probabilityOfExactNumberOfCards(0, 0.5, 2) should be (0.25)
  }

  "CardTypeProbability" should "return 44.3625% probability of 1 special cards in 65/35 three card pack" in {
    CardTypeProbability.probabilityOfExactNumberOfCards(1, 0.35, 3) should be (0.443625)
  }
}
