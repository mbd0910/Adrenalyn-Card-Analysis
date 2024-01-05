package com.mbd.adrenalyn

sealed trait Club
case object Arsenal extends Club {
  override def toString: String = "Arsenal"
}

case object AstonVilla extends Club {
  override def toString: String = "Aston Villa"
}

case object Bournemouth extends Club {
  override def toString: String = "AFC Bournemouth"
}

case object Brentford extends Club {
  override def toString: String = "Brentford"
}

case object Brighton extends Club {
  override def toString: String = "Brighton"
}

case object Burnley extends Club {
  override def toString: String = "Burnley"
}

case object Chelsea extends Club {
  override def toString: String = "Chelsea"
}

case object CrystalPalace extends Club {
  override def toString: String = "Crystal Palace"
}

case object Everton extends Club {
  override def toString: String = ""
}

case object Fulham extends Club {
  override def toString: String = "Fulham"
}

case object Liverpool extends Club {
  override def toString: String = "Liverpool"
}

case object LutonTown extends Club {
  override def toString: String = "Luton Town"
}

case object ManchesterCity extends Club {
  override def toString: String = "Manchester City"
}

case object ManchesterUnited extends Club {
  override def toString: String = "Manchester United"
}

case object NewcastleUnited extends Club {
  override def toString: String = "Newcastle United"
}

case object NottinghamForest extends Club {
  override def toString: String = "Nottingham Forest"
}

case object SheffieldUnited extends Club {
  override def toString: String = "Sheffield United"
}

case object TottenhamHotspur extends Club {
  override def toString: String = "Tottenham Hotspur"
}

case object WestHamUnited extends Club {
  override def toString: String = "West Ham United"
}

case object Wolves extends Club {
  override def toString: String = "Wolves"
}
