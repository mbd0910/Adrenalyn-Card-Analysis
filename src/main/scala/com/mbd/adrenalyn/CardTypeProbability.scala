package com.mbd.adrenalyn

import scala.collection.immutable.ListMap


object CardTypeProbability {
  // Lineups - 1 in 5 packets
  // Club crests - 1 in 3 packets
  // Powerhouse - 1 in 6.5 packets
  // Precision - 1 in 7 packets
  // Game changers - 1 in 7 packets
  // World class - 1 in 7 packets
  // Playmakers - 1 in 7 packets
  // Colossus - 1 in 15 packets
  // Top keepers - 1 in 8.5 packets
  // Adrenalyn rush - 1 in 20 packets
  // Ultrasonic - 1 in 10 packets
  // Dynamos - 1 in 15 packets
  // Future stars - 1 in 21 packets
  // Next level - 1 in 21 packets
  // Hotshots - 1 in 15.5 packets
  // Aerial aces - 1 in 20 packets
  // Fire - 1 in 12 packets
  // Ice - 1 in 15 packets
  // Trophy - 1 in 50 packets
  // Golden ballers - 1 in 50 packets

  val specialCardProbabilities: Map[CardType, Double] = Map(
    LineupCard -> probabilityFromPerXPacketValue(5),
    ClubCrest -> probabilityFromPerXPacketValue(3),
    Powerhouse -> probabilityFromPerXPacketValue(6.5),
    Precision -> probabilityFromPerXPacketValue(7),
    GameChanger -> probabilityFromPerXPacketValue(7),
    WorldClass -> probabilityFromPerXPacketValue(7),
    Playmaker -> probabilityFromPerXPacketValue(7),
    Colossus -> probabilityFromPerXPacketValue(15),
    TopKeeper -> probabilityFromPerXPacketValue(8.5),
    AdrenalynRush -> probabilityFromPerXPacketValue(20),
    Ultrasonic -> probabilityFromPerXPacketValue(10),
    Dynamo -> probabilityFromPerXPacketValue(15),
    FutureStar -> probabilityFromPerXPacketValue(21),
    NextLevel -> probabilityFromPerXPacketValue(21),
    HotShot -> probabilityFromPerXPacketValue(15.5),
    AerialAce -> probabilityFromPerXPacketValue(20),
    Fire -> probabilityFromPerXPacketValue(12),
    Ice -> probabilityFromPerXPacketValue(15),
    Trophy -> probabilityFromPerXPacketValue(50),
    GoldenBaller -> probabilityFromPerXPacketValue(50)
  )

  val specialCardProbability: Double = specialCardProbabilities.values.sum
  val baseCardProbability: Double = 1.0 - specialCardProbability

  val cumulativeProbabilities: ListMap[CardType, Double] = specialCardProbabilities.foldLeft((ListMap[CardType, Double](BaseCard -> baseCardProbability), baseCardProbability)) {
    case ((cumulativeMap, cumulativeProbability), (cardType, probability)) =>
      val updatedCumulativeProbability = cumulativeProbability + probability
      (cumulativeMap + (cardType -> updatedCumulativeProbability), updatedCumulativeProbability)
  }._1

  // Calculate binomial coefficient
  def binomialCoefficient(n: Int, k: Int): BigInt = {
    if (k == 0 || k == n) 1
    else binomialCoefficient(n - 1, k - 1) * n / k
  }

  def probabilityFromPerXPacketValue(perXPacket: Double): Double = {
    1.0 / (perXPacket * Pack.size)
  }

  def probabilityOfExactNumberOfCards(k: Int, probability: Double, packSize: Int): Double = {
    binomialCoefficient(packSize, k).toDouble * math.pow(probability, k) * math.pow(1 - probability, packSize - k)
  }

  def randomCardType(randomNumber: Double): CardType = {
    cumulativeProbabilities.filter { case (_, cumulativeProbability) => cumulativeProbability > randomNumber}
      .minBy { case (_, cumulativeProbability) => cumulativeProbability }
      ._1
  }
}
