package com.mbd.adrenalyn

import scala.util.Random

case class Pack(cards: List[Card]) {
  override def toString: String = cards.mkString("\n")
}

object Pack {
  val size: Int = 6
  val random = new Random

  def apply(): Pack = {
    Pack((1 to 6).map(_ => CardGenerator.getCard()).toList.sortBy(_.id))
  }
}
