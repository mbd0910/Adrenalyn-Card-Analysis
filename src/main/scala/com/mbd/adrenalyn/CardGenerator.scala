package com.mbd.adrenalyn

import scala.util.Random

object CardGenerator {
  val random = new Random()
  def getCard(): Card = {
    val r = random.nextDouble()
    ???
  }
}
