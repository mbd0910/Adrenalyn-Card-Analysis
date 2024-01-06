package com.mbd.adrenalyn

import com.mbd.adrenalyn.swapping.OneForOneSwappingAlgorithm

import scala.annotation.tailrec

object Main {
  def main(args: Array[String]): Unit = {
//    println(CardTypeProbability.specialCardProbability)
//    println(CardTypeProbability.baseCardProbability)
//    println(CardTypeProbability.cumulativeProbabilities)

//    val results = openUntilPackLimit(0, Collection.empty, 500)
//    println(results)
//    println(results.singles.size)
//    println(results.swapCount)
//    println(results.singles.size + results.swapCount)
//    println(CollectionCompletionChecker.missingCards(results))

    val results = openUntilComplete(0, Collection.empty)
    println(results._2)
    println(results._1)

//    val results = keepSimulating(0, 10000, List.empty)
//    println(results)
//    println()
//    println(results.max)
//    println(results.min)
//    println(results.sum / results.size)


  }

  def keepSimulating(simulationCount: Int, simulationLimit: Int, packsOpenedList: List[Int]): List[Int] = {
    if (simulationCount == simulationLimit)
      packsOpenedList
    else {
      val singleResult = openUntilComplete(0, Collection.empty)
      keepSimulating(simulationCount + 1, simulationLimit, packsOpenedList :+ singleResult._1)
    }
  }

  @tailrec
  def openUntilComplete(packsOpened: Int, collection: Collection): (Int, Collection) = {
    if (CollectionCompletionChecker.isCollectionComplete(collection))
      (packsOpened, collection)
    else
      openUntilComplete(packsOpened + 1, collection.addPack(Pack()))
  }

  def openUntilPackLimit(packsOpened: Int, collection: Collection, packLimit: Int): Collection = {
    if (packsOpened == packLimit)
      collection
    else
      openUntilPackLimit(packsOpened + 1, collection.addPack(Pack()), packLimit)
  }
}
