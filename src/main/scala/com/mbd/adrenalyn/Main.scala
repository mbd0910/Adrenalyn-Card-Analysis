package com.mbd.adrenalyn

import com.mbd.adrenalyn.swapping.OneForOneSwappingAlgorithm

import java.security.spec.RSAMultiPrimePrivateCrtKeySpec
import scala.annotation.tailrec

object Main {
  def main(args: Array[String]): Unit = {
//    val results = openUntilPackLimit(0, Collection.empty, 500)
//    println(results)
//    println(results.singles.size)
//    println(results.swapCount)
//    println(results.singles.size + results.swapCount)
//    println(CollectionCompletionChecker.missingCards(results))

//    val results = openUntilComplete(0, Collection.empty)
//    println(results._2)
//    println(results._1)

//    val results = keepSimulating(0, 10000, List.empty)
//    println(results)
//    println()
//    println(results.max)
//    println(results.min)
//    println(results.sum / results.size)

    val twoCollectorsResults = keepSimulatingTwoCollectors(0, 10000, List.empty)
    println(twoCollectorsResults.max)
    println(twoCollectorsResults.min)
    println(twoCollectorsResults.sum / twoCollectorsResults.size)

    val singleCollectorResults = keepSimulating(0, 10000, List.empty)
    println(singleCollectorResults.max)
    println(singleCollectorResults.min)
    println(singleCollectorResults.sum / singleCollectorResults.size)
  }

  def keepSimulatingTwoCollectors(simulationCount: Int, simulationLimit: Int, packsOpenedList: List[Int]): List[Int] = {
    if (simulationCount == simulationLimit)
      packsOpenedList
    else {
      val singleResult = twoCollectors(Collector(), Collector())
      keepSimulating(simulationCount + 1, simulationLimit, packsOpenedList :+ singleResult)
    }
  }

  def twoCollectors(collector1: Collector, collector2: Collector): Int = {
    if (CollectionCompletionChecker.isCollectionComplete(collector1))
      collector1.packsOpened
    else if (CollectionCompletionChecker.isCollectionComplete(collector2))
      collector2.packsOpened
    else {
      val updatedCollection1 = collector1.collection.addPack(Pack())
      val updatedCollection2 = collector2.collection.addPack(Pack())

      val (collection1AfterSwaps, collection2AfterSwaps) =
        OneForOneSwappingAlgorithm.executeSwaps(updatedCollection1, updatedCollection2)

      twoCollectors(
        Collector(collection1AfterSwaps, collector1.packsOpened + 1),
        Collector(collection2AfterSwaps, collector2.packsOpened + 1)
      )
    }
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
