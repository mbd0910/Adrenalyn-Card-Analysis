package com.mbd.adrenalyn.swapping

import com.mbd.adrenalyn.Collection

trait SwappingAlgorithm {
  def executeSwaps(collection1: Collection, collection2: Collection): (Collection, Collection)
}
