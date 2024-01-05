package com.mbd.adrenalyn
case class Card(id: Card.Id, name: String, maybeClub: Option[Club])

object Card {
  type Id = Int

  private val goldenBallerRange: IndexedSeq[Int] = 1 to 9
  private val baseCardRange: IndexedSeq[Int] = { // One row per team
    (11 to 26) ++
    (29 to 44) ++
    (47 to 62) ++
    (65 to 80) ++
    (83 to 98) ++
    (101 to 116) ++
    (119 to 134) ++
    (137 to 152) ++
    (155 to 170) ++
    (173 to 188) ++
    (191 to 206) ++
    (209 to 224) ++
    (227 to 242) ++
    (245 to 260) ++
    (263 to 278) ++
    (281 to 296) ++
    (299 to 314) ++
    (317 to 332) ++
    (335 to 350) ++
    (353 to 368)
  }
  private val clubCrestRange: IndexedSeq[Int] = Vector( // One row per team
    10,
    28,
    46,
    64,
    82,
    100,
    118,
    136,
    154,
    172,
    190,
    208,
    226,
    244,
    262,
    280,
    298,
    316,
    334,
    352
  )
  private val lineupCardRange: IndexedSeq[Int] = Vector( // One row per team
    27,
    45,
    63,
    81,
    99,
    117,
    135,
    153,
    171,
    189,
    207,
    225,
    243,
    261,
    279,
    297,
    315,
    333,
    351,
    369
  )
  private val topKeeperRange: IndexedSeq[Int] = 370 to 375
  private val aerialAceRange: IndexedSeq[Int] = 376 to 378
  private val precisionRange: IndexedSeq[Int] = 379 to 387
  private val powerHouseRange: IndexedSeq[Int] = 388 to 396
  private val colossusRange: IndexedSeq[Int] = 397 to 405
  private val fireRange: IndexedSeq[Int] = 406 to 410
  private val iceRange: IndexedSeq[Int] = 411 to 414
  private val playMakerRange: IndexedSeq[Int] = 415 to 423
  private val futureStarRange: IndexedSeq[Int] = 424 to 426
  private val adrenalynRushRange: IndexedSeq[Int] = 427 to 432
  private val nextLevelRange: IndexedSeq[Int] = 433 to 435
  private val ultraSonicRange: IndexedSeq[Int] = 436 to 441
  private val worldClassRange: IndexedSeq[Int] = 442 to 450
  private val gameChangerRange: IndexedSeq[Int] = 451 to 459
  private val dynamoRange: IndexedSeq[Int] = 460 to 461
  private val hotShotRange: IndexedSeq[Int] = 464 to 467
  private val trophyRange: IndexedSeq[Int] = Vector(468)

  def cardIds(cardType: CardType): IndexedSeq[Int] = {
    cardType match {
      case GoldenBaller => goldenBallerRange
      case BaseCard => baseCardRange
      case ClubCrest => clubCrestRange
      case LineupCard => lineupCardRange
      case TopKeeper => topKeeperRange
      case AerialAce => aerialAceRange
      case Precision => precisionRange
      case Powerhouse => powerHouseRange
      case Colossus => colossusRange
      case Fire => fireRange
      case Ice => iceRange
      case Playmaker => playMakerRange
      case FutureStar => futureStarRange
      case AdrenalynRush => adrenalynRushRange
      case NextLevel => nextLevelRange
      case Ultrasonic => ultraSonicRange
      case WorldClass => worldClassRange
      case GameChanger => gameChangerRange
      case Dynamo => dynamoRange
      case HotShot => hotShotRange
      case Trophy => trophyRange
    }
  }
}




