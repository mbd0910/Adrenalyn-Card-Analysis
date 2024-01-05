package com.mbd.adrenalyn

object Main {
  def main(args: Array[String]): Unit = {
    println(CardTypeProbability.specialCardProbability)
    println(CardTypeProbability.baseCardProbability)
    println(CardTypeProbability.cumulativeProbabilities)

    println(Pack())
  }
}
