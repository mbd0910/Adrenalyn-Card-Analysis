package com.mbd.adrenalyn
case class Card(id: Card.Id, name: String, maybeClub: Option[Club], cardType: CardType) {
  override def toString: String = s"${id}: ${name}, ${maybeClub.getOrElse("N/A")}, ${cardType}"
}

object Card {
  type Id = Int

  def apply(id: Card.Id): Card = {
    id match {
      // Golden Ballers
      case 1 => Card(1, "Saka", Some(Arsenal), GoldenBaller)
      case 2 => Card(2, "Watkins", Some(AstonVilla), GoldenBaller)
      case 3 => Card(3, "Eze", Some(CrystalPalace), GoldenBaller)
      case 4 => Card(4, "Gakpo", Some(Liverpool), GoldenBaller)
      case 5 => Card(5, "Invincible", None, GoldenBaller)
      case 6 => Card(6, "Haaland", Some(ManchesterCity), GoldenBaller)
      case 7 => Card(7, "Rashford", Some(ManchesterUnited), GoldenBaller)
      case 8 => Card(8, "Isak", Some(NewcastleUnited), GoldenBaller)
      case 9 => Card(9, "Bentancur",Some(TottenhamHotspur), GoldenBaller)

      // AFC Bournemouth
      case 10 => Card(10, "Club Crest", Some(Bournemouth), ClubCrest)
      case 11 => Card(11, "Neto", Some(Bournemouth), BaseCard)
      case 12 => Card(12, "Kelly", Some(Bournemouth), BaseCard)
      case 13 => Card(13, "Mepham", Some(Bournemouth), BaseCard)
      case 14 => Card(14, "Smith", Some(Bournemouth), BaseCard)
      case 15 => Card(15, "Senesi", Some(Bournemouth), BaseCard)
      case 16 => Card(16, "Zabarnyi", Some(Bournemouth), BaseCard)
      case 17 => Card(17, "Cook", Some(Bournemouth), BaseCard)
      case 18 => Card(18, "Brooks", Some(Bournemouth), BaseCard)
      case 19 => Card(19, "Christie", Some(Bournemouth), BaseCard)
      case 20 => Card(20, "Rothwell", Some(Bournemouth), BaseCard)
      case 21 => Card(21, "Tavernier", Some(Bournemouth), BaseCard)
      case 22 => Card(22, "Billing", Some(Bournemouth), BaseCard)
      case 23 => Card(23, "Solanke", Some(Bournemouth), BaseCard)
      case 24 => Card(24, "Ouattara", Some(Bournemouth), BaseCard)
      case 25 => Card(25, "Semenyo", Some(Bournemouth), BaseCard)
      case 26 => Card(26, "Anthony", Some(Bournemouth), BaseCard)
      case 27 => Card(27, "Line-up card", Some(Bournemouth), LineupCard)

      // Arsenal
      case 28 => Card(28, "Club Crest", Some(Arsenal), ClubCrest)
      case 29 => Card(29, "Ramsdale", Some(Arsenal), BaseCard)
      case 30 => Card(30, "White", Some(Arsenal), BaseCard)
      case 31 => Card(31, "Magalhaes", Some(Arsenal), BaseCard)
      case 32 => Card(32, "Saliba", Some(Arsenal), BaseCard)
      case 33 => Card(33, "Tomiyasu", Some(Arsenal), BaseCard)
      case 34 => Card(34, "Zinchenko", Some(Arsenal), BaseCard)
      case 35 => Card(35, "Partey", Some(Arsenal), BaseCard)
      case 36 => Card(36, "Saka", Some(Arsenal), BaseCard)
      case 37 => Card(37, "Odegaard", Some(Arsenal), BaseCard)
      case 38 => Card(38, "Jorginho", Some(Arsenal), BaseCard)
      case 39 => Card(39, "Vieira", Some(Arsenal), BaseCard)
      case 40 => Card(40, "Xhaka", Some(Arsenal), BaseCard)
      case 41 => Card(41, "Jesus", Some(Arsenal), BaseCard)
      case 42 => Card(42, "Martinelli", Some(Arsenal), BaseCard)
      case 43 => Card(43, "Nketiah", Some(Arsenal), BaseCard)
      case 44 => Card(44, "Trossard", Some(Arsenal), BaseCard)
      case 45 => Card(45, "Line-up card", Some(Arsenal), LineupCard)

      // Aston Villa
      case 46 => Card(46, "Club Crest", Some(AstonVilla), ClubCrest)
      case 47 => Card(47, "Martinez", Some(AstonVilla), BaseCard)
      case 48 => Card(48, "Cash", Some(AstonVilla), BaseCard)
      case 49 => Card(49, "Carlos", Some(AstonVilla), BaseCard)
      case 50 => Card(50, "Konsa", Some(AstonVilla), BaseCard)
      case 51 => Card(51, "Mings", Some(AstonVilla), BaseCard)
      case 52 => Card(52, "Moreno", Some(AstonVilla), BaseCard)
      case 53 => Card(53, "Digne", Some(AstonVilla), BaseCard)
      case 54 => Card(54, "Luiz", Some(AstonVilla), BaseCard)
      case 55 => Card(55, "McGinn", Some(AstonVilla), BaseCard)
      case 56 => Card(56, "Buendia", Some(AstonVilla), BaseCard)
      case 57 => Card(57, "Coutinho", Some(AstonVilla), BaseCard)
      case 58 => Card(58, "Bailey", Some(AstonVilla), BaseCard)
      case 59 => Card(59, "Ramsey", Some(AstonVilla), BaseCard)
      case 60 => Card(60, "Kamara", Some(AstonVilla), BaseCard)
      case 61 => Card(61, "Watkins", Some(AstonVilla), BaseCard)
      case 62 => Card(62, "Duran", Some(AstonVilla), BaseCard)
      case 63 => Card(63, "Line-up card", Some(AstonVilla), LineupCard)

      // Brentford
      case 64 => Card(64, "Club Crest", Some(Brentford), ClubCrest)
      case 65 => Card(65, "Raya", Some(Brentford), BaseCard)
      case 66 => Card(66, "Hickey", Some(Brentford), BaseCard)
      case 67 => Card(67, "Henry", Some(Brentford), BaseCard)
      case 68 => Card(68, "Pinnock", Some(Brentford), BaseCard)
      case 69 => Card(69, "Mee", Some(Brentford), BaseCard)
      case 70 => Card(70, "Ajer", Some(Brentford), BaseCard)
      case 71 => Card(71, "Roerslev", Some(Brentford), BaseCard)
      case 72 => Card(72, "Norgaard", Some(Brentford), BaseCard)
      case 73 => Card(73, "Jensen", Some(Brentford), BaseCard)
      case 74 => Card(74, "Dasilva", Some(Brentford), BaseCard)
      case 75 => Card(75, "Wissa", Some(Brentford), BaseCard)
      case 76 => Card(76, "Damsgaard", Some(Brentford), BaseCard)
      case 77 => Card(77, "Baptiste", Some(Brentford), BaseCard)
      case 78 => Card(78, "Janelt", Some(Brentford), BaseCard)
      case 79 => Card(79, "Schade", Some(Brentford), BaseCard)
      case 80 => Card(80, "Mbeumo", Some(Brentford), BaseCard)
      case 81 => Card(81, "Line-up card", Some(Brentford), LineupCard)

      // Brighton
      case 82 => Card(82, "Club Crest", Some(Brighton), ClubCrest)
      case 83 => Card(83, "Steele", Some(Brighton), BaseCard)
      case 84 => Card(84, "Lamptey", Some(Brighton), BaseCard)
      case 85 => Card(85, "Webster", Some(Brighton), BaseCard)
      case 86 => Card(86, "Dunk", Some(Brighton), BaseCard)
      case 87 => Card(87, "Estupinan", Some(Brighton), BaseCard)
      case 88 => Card(88, "Veltman", Some(Brighton), BaseCard)
      case 89 => Card(89, "March", Some(Brighton), BaseCard)
      case 90 => Card(90, "Gross", Some(Brighton), BaseCard)
      case 91 => Card(91, "Lallana", Some(Brighton), BaseCard)
      case 92 => Card(92, "Mitoma", Some(Brighton), BaseCard)
      case 93 => Card(93, "Caicedo", Some(Brighton), BaseCard)
      case 94 => Card(94, "Gilmour", Some(Brighton), BaseCard)
      case 95 => Card(95, "Buonanotte", Some(Brighton), BaseCard)
      case 96 => Card(96, "Welbeck", Some(Brighton), BaseCard)
      case 97 => Card(97, "Enciso", Some(Brighton), BaseCard)
      case 98 => Card(98, "Ferguson", Some(Brighton), BaseCard)
      case 99 => Card(99, "Line-up card", Some(Brighton), LineupCard)

      // Burnley
      case 100 => Card(100, "Club Crest", Some(Burnley), ClubCrest)
      case 101 => Card(101, "", Some(Burnley), BaseCard)
      case 102 => Card(102, "", Some(Burnley), BaseCard)
      case 103 => Card(103, "", Some(Burnley), BaseCard)
      case 104 => Card(104, "", Some(Burnley), BaseCard)
      case 105 => Card(105, "", Some(Burnley), BaseCard)
      case 106 => Card(106, "", Some(Burnley), BaseCard)
      case 107 => Card(107, "", Some(Burnley), BaseCard)
      case 108 => Card(108, "", Some(Burnley), BaseCard)
      case 109 => Card(109, "", Some(Burnley), BaseCard)
      case 110 => Card(110, "", Some(Burnley), BaseCard)
      case 111 => Card(111, "", Some(Burnley), BaseCard)
      case 112 => Card(112, "", Some(Burnley), BaseCard)
      case 113 => Card(113, "", Some(Burnley), BaseCard)
      case 114 => Card(114, "", Some(Burnley), BaseCard)
      case 115 => Card(115, "", Some(Burnley), BaseCard)
      case 116 => Card(116, "", Some(Burnley), BaseCard)
      case 117 => Card(117, "Line-up card", Some(Burnley), LineupCard)

      // Chelsea
      case 118 => Card(118, "Club Crest", Some(Chelsea), ClubCrest)
      case 119 => Card(119, "", Some(Chelsea), BaseCard)
      case 120 => Card(120, "", Some(Chelsea), BaseCard)
      case 121 => Card(121, "", Some(Chelsea), BaseCard)
      case 122 => Card(122, "", Some(Chelsea), BaseCard)
      case 123 => Card(123, "", Some(Chelsea), BaseCard)
      case 124 => Card(124, "", Some(Chelsea), BaseCard)
      case 125 => Card(125, "", Some(Chelsea), BaseCard)
      case 126 => Card(126, "", Some(Chelsea), BaseCard)
      case 127 => Card(127, "", Some(Chelsea), BaseCard)
      case 128 => Card(128, "", Some(Chelsea), BaseCard)
      case 129 => Card(129, "", Some(Chelsea), BaseCard)
      case 130 => Card(130, "", Some(Chelsea), BaseCard)
      case 131 => Card(131, "", Some(Chelsea), BaseCard)
      case 132 => Card(132, "", Some(Chelsea), BaseCard)
      case 133 => Card(133, "", Some(Chelsea), BaseCard)
      case 134 => Card(134, "", Some(Chelsea), BaseCard)
      case 135 => Card(135, "Line-up card", Some(Chelsea), LineupCard)

      // Crystal Palace
      case 136 => Card(136, "Club Crest", Some(CrystalPalace), ClubCrest)
      case 137 => Card(137, "", Some(CrystalPalace), BaseCard)
      case 138 => Card(138, "", Some(CrystalPalace), BaseCard)
      case 139 => Card(139, "", Some(CrystalPalace), BaseCard)
      case 140 => Card(140, "", Some(CrystalPalace), BaseCard)
      case 141 => Card(141, "", Some(CrystalPalace), BaseCard)
      case 142 => Card(142, "", Some(CrystalPalace), BaseCard)
      case 143 => Card(143, "", Some(CrystalPalace), BaseCard)
      case 144 => Card(144, "", Some(CrystalPalace), BaseCard)
      case 145 => Card(145, "", Some(CrystalPalace), BaseCard)
      case 146 => Card(146, "", Some(CrystalPalace), BaseCard)
      case 147 => Card(147, "", Some(CrystalPalace), BaseCard)
      case 148 => Card(148, "", Some(CrystalPalace), BaseCard)
      case 149 => Card(149, "", Some(CrystalPalace), BaseCard)
      case 150 => Card(150, "", Some(CrystalPalace), BaseCard)
      case 151 => Card(151, "", Some(CrystalPalace), BaseCard)
      case 152 => Card(152, "", Some(CrystalPalace), BaseCard)
      case 153 => Card(153, "Line-up card", Some(CrystalPalace), LineupCard)

      // Everton
      case 154 => Card(154, "Club Crest", Some(Everton), ClubCrest)
      case 155 => Card(155, "", Some(Everton), BaseCard)
      case 156 => Card(156, "", Some(Everton), BaseCard)
      case 157 => Card(157, "", Some(Everton), BaseCard)
      case 158 => Card(158, "", Some(Everton), BaseCard)
      case 159 => Card(159, "", Some(Everton), BaseCard)
      case 160 => Card(160, "", Some(Everton), BaseCard)
      case 161 => Card(161, "", Some(Everton), BaseCard)
      case 162 => Card(162, "", Some(Everton), BaseCard)
      case 163 => Card(163, "", Some(Everton), BaseCard)
      case 164 => Card(164, "", Some(Everton), BaseCard)
      case 165 => Card(165, "", Some(Everton), BaseCard)
      case 166 => Card(166, "", Some(Everton), BaseCard)
      case 167 => Card(167, "", Some(Everton), BaseCard)
      case 168 => Card(168, "", Some(Everton), BaseCard)
      case 169 => Card(169, "", Some(Everton), BaseCard)
      case 170 => Card(170, "", Some(Everton), BaseCard)
      case 171 => Card(171, "Line-up card", Some(Everton), LineupCard)

      // Fulham
      case 172 => Card(172, "Club Crest", Some(Fulham), ClubCrest)
      case 173 => Card(173, "", Some(Fulham), BaseCard)
      case 174 => Card(174, "", Some(Fulham), BaseCard)
      case 175 => Card(175, "", Some(Fulham), BaseCard)
      case 176 => Card(176, "", Some(Fulham), BaseCard)
      case 177 => Card(177, "", Some(Fulham), BaseCard)
      case 178 => Card(178, "", Some(Fulham), BaseCard)
      case 179 => Card(179, "", Some(Fulham), BaseCard)
      case 180 => Card(180, "", Some(Fulham), BaseCard)
      case 181 => Card(181, "", Some(Fulham), BaseCard)
      case 182 => Card(182, "", Some(Fulham), BaseCard)
      case 183 => Card(183, "", Some(Fulham), BaseCard)
      case 184 => Card(184, "", Some(Fulham), BaseCard)
      case 185 => Card(185, "", Some(Fulham), BaseCard)
      case 186 => Card(186, "", Some(Fulham), BaseCard)
      case 187 => Card(187, "", Some(Fulham), BaseCard)
      case 188 => Card(188, "", Some(Fulham), BaseCard)
      case 189 => Card(189, "Line-up card", Some(Fulham), LineupCard)

      // Liverpool
      case 190 => Card(190, "Club Crest", Some(Liverpool), ClubCrest)
      case 191 => Card(191, "", Some(Liverpool), BaseCard)
      case 192 => Card(192, "", Some(Liverpool), BaseCard)
      case 193 => Card(193, "", Some(Liverpool), BaseCard)
      case 194 => Card(194, "", Some(Liverpool), BaseCard)
      case 195 => Card(195, "", Some(Liverpool), BaseCard)
      case 196 => Card(196, "", Some(Liverpool), BaseCard)
      case 197 => Card(197, "", Some(Liverpool), BaseCard)
      case 198 => Card(198, "", Some(Liverpool), BaseCard)
      case 199 => Card(199, "", Some(Liverpool), BaseCard)
      case 200 => Card(200, "", Some(Liverpool), BaseCard)
      case 201 => Card(201, "", Some(Liverpool), BaseCard)
      case 202 => Card(202, "", Some(Liverpool), BaseCard)
      case 203 => Card(203, "", Some(Liverpool), BaseCard)
      case 204 => Card(204, "", Some(Liverpool), BaseCard)
      case 205 => Card(205, "", Some(Liverpool), BaseCard)
      case 206 => Card(206, "", Some(Liverpool), BaseCard)
      case 207 => Card(207, "Line-up card", Some(Liverpool), LineupCard)

      // Luton Town
      case 208 => Card(208, "Club Crest", Some(LutonTown), ClubCrest)
      case 209 => Card(209, "", Some(LutonTown), BaseCard)
      case 210 => Card(210, "", Some(LutonTown), BaseCard)
      case 211 => Card(211, "", Some(LutonTown), BaseCard)
      case 212 => Card(212, "", Some(LutonTown), BaseCard)
      case 213 => Card(213, "", Some(LutonTown), BaseCard)
      case 214 => Card(214, "", Some(LutonTown), BaseCard)
      case 215 => Card(215, "", Some(LutonTown), BaseCard)
      case 216 => Card(216, "", Some(LutonTown), BaseCard)
      case 217 => Card(217, "", Some(LutonTown), BaseCard)
      case 218 => Card(218, "", Some(LutonTown), BaseCard)
      case 219 => Card(219, "", Some(LutonTown), BaseCard)
      case 220 => Card(220, "", Some(LutonTown), BaseCard)
      case 221 => Card(221, "", Some(LutonTown), BaseCard)
      case 222 => Card(222, "", Some(LutonTown), BaseCard)
      case 223 => Card(223, "", Some(LutonTown), BaseCard)
      case 224 => Card(224, "", Some(LutonTown), BaseCard)
      case 225 => Card(225, "Line-up card", Some(LutonTown), LineupCard)

      // Manchester City
      case 226 => Card(226, "Club Crest", Some(ManchesterCity), ClubCrest)
      case 227 => Card(227, "", Some(ManchesterCity), BaseCard)
      case 228 => Card(228, "", Some(ManchesterCity), BaseCard)
      case 229 => Card(229, "", Some(ManchesterCity), BaseCard)
      case 230 => Card(230, "", Some(ManchesterCity), BaseCard)
      case 231 => Card(231, "", Some(ManchesterCity), BaseCard)
      case 232 => Card(232, "", Some(ManchesterCity), BaseCard)
      case 233 => Card(233, "", Some(ManchesterCity), BaseCard)
      case 234 => Card(234, "", Some(ManchesterCity), BaseCard)
      case 235 => Card(235, "", Some(ManchesterCity), BaseCard)
      case 236 => Card(236, "", Some(ManchesterCity), BaseCard)
      case 237 => Card(237, "", Some(ManchesterCity), BaseCard)
      case 238 => Card(238, "", Some(ManchesterCity), BaseCard)
      case 239 => Card(239, "", Some(ManchesterCity), BaseCard)
      case 240 => Card(240, "", Some(ManchesterCity), BaseCard)
      case 241 => Card(241, "", Some(ManchesterCity), BaseCard)
      case 242 => Card(242, "", Some(ManchesterCity), BaseCard)
      case 243 => Card(243, "Line-up card", Some(ManchesterCity), LineupCard)

      // Manchester United
      case 244 => Card(244, "Club Crest", Some(ManchesterUnited), ClubCrest)
      case 245 => Card(245, "", Some(ManchesterUnited), BaseCard)
      case 246 => Card(246, "", Some(ManchesterUnited), BaseCard)
      case 247 => Card(247, "", Some(ManchesterUnited), BaseCard)
      case 248 => Card(248, "", Some(ManchesterUnited), BaseCard)
      case 249 => Card(249, "", Some(ManchesterUnited), BaseCard)
      case 250 => Card(250, "", Some(ManchesterUnited), BaseCard)
      case 251 => Card(251, "", Some(ManchesterUnited), BaseCard)
      case 252 => Card(252, "", Some(ManchesterUnited), BaseCard)
      case 253 => Card(253, "", Some(ManchesterUnited), BaseCard)
      case 254 => Card(254, "", Some(ManchesterUnited), BaseCard)
      case 255 => Card(255, "", Some(ManchesterUnited), BaseCard)
      case 256 => Card(256, "", Some(ManchesterUnited), BaseCard)
      case 257 => Card(257, "", Some(ManchesterUnited), BaseCard)
      case 258 => Card(258, "", Some(ManchesterUnited), BaseCard)
      case 259 => Card(259, "", Some(ManchesterUnited), BaseCard)
      case 260 => Card(260, "", Some(ManchesterUnited), BaseCard)
      case 261 => Card(261, "Line-up card", Some(ManchesterUnited), LineupCard)

      // Newcastle United
      case 262 => Card(262, "Club Crest", Some(NewcastleUnited), ClubCrest)
      case 263 => Card(263, "", Some(NewcastleUnited), BaseCard)
      case 264 => Card(264, "", Some(NewcastleUnited), BaseCard)
      case 265 => Card(265, "", Some(NewcastleUnited), BaseCard)
      case 266 => Card(266, "", Some(NewcastleUnited), BaseCard)
      case 267 => Card(267, "", Some(NewcastleUnited), BaseCard)
      case 268 => Card(268, "", Some(NewcastleUnited), BaseCard)
      case 269 => Card(269, "", Some(NewcastleUnited), BaseCard)
      case 270 => Card(270, "", Some(NewcastleUnited), BaseCard)
      case 271 => Card(271, "", Some(NewcastleUnited), BaseCard)
      case 272 => Card(272, "", Some(NewcastleUnited), BaseCard)
      case 273 => Card(273, "", Some(NewcastleUnited), BaseCard)
      case 274 => Card(274, "", Some(NewcastleUnited), BaseCard)
      case 275 => Card(275, "", Some(NewcastleUnited), BaseCard)
      case 276 => Card(276, "", Some(NewcastleUnited), BaseCard)
      case 277 => Card(277, "", Some(NewcastleUnited), BaseCard)
      case 278 => Card(278, "", Some(NewcastleUnited), BaseCard)
      case 279 => Card(279, "Line-up card", Some(NewcastleUnited), LineupCard)

      // Nottingham Forest
      case 280 => Card(280, "Club Crest", Some(NottinghamForest), ClubCrest)
      case 281 => Card(281, "", Some(NottinghamForest), BaseCard)
      case 282 => Card(282, "", Some(NottinghamForest), BaseCard)
      case 283 => Card(283, "", Some(NottinghamForest), BaseCard)
      case 284 => Card(284, "", Some(NottinghamForest), BaseCard)
      case 285 => Card(285, "", Some(NottinghamForest), BaseCard)
      case 286 => Card(286, "", Some(NottinghamForest), BaseCard)
      case 287 => Card(287, "", Some(NottinghamForest), BaseCard)
      case 288 => Card(288, "", Some(NottinghamForest), BaseCard)
      case 289 => Card(289, "", Some(NottinghamForest), BaseCard)
      case 290 => Card(290, "", Some(NottinghamForest), BaseCard)
      case 291 => Card(291, "", Some(NottinghamForest), BaseCard)
      case 292 => Card(292, "", Some(NottinghamForest), BaseCard)
      case 293 => Card(293, "", Some(NottinghamForest), BaseCard)
      case 294 => Card(294, "", Some(NottinghamForest), BaseCard)
      case 295 => Card(295, "", Some(NottinghamForest), BaseCard)
      case 296 => Card(296, "", Some(NottinghamForest), BaseCard)
      case 297 => Card(297, "Line-up card", Some(NottinghamForest), LineupCard)

      // Sheffield United
      case 298 => Card(298, "Club Crest", Some(SheffieldUnited), ClubCrest)
      case 299 => Card(299, "", Some(SheffieldUnited), BaseCard)
      case 300 => Card(300, "", Some(SheffieldUnited), BaseCard)
      case 301 => Card(301, "", Some(SheffieldUnited), BaseCard)
      case 302 => Card(302, "", Some(SheffieldUnited), BaseCard)
      case 303 => Card(303, "", Some(SheffieldUnited), BaseCard)
      case 304 => Card(304, "", Some(SheffieldUnited), BaseCard)
      case 305 => Card(305, "", Some(SheffieldUnited), BaseCard)
      case 306 => Card(306, "", Some(SheffieldUnited), BaseCard)
      case 307 => Card(307, "", Some(SheffieldUnited), BaseCard)
      case 308 => Card(308, "", Some(SheffieldUnited), BaseCard)
      case 309 => Card(309, "", Some(SheffieldUnited), BaseCard)
      case 310 => Card(310, "", Some(SheffieldUnited), BaseCard)
      case 311 => Card(311, "", Some(SheffieldUnited), BaseCard)
      case 312 => Card(312, "", Some(SheffieldUnited), BaseCard)
      case 313 => Card(313, "", Some(SheffieldUnited), BaseCard)
      case 314 => Card(314, "", Some(SheffieldUnited), BaseCard)
      case 315 => Card(315, "Line-up card", Some(SheffieldUnited), LineupCard)

      // Tottenham Hotspur
      case 316 => Card(316, "Club Crest", Some(TottenhamHotspur), ClubCrest)
      case 317 => Card(317, "", Some(TottenhamHotspur), BaseCard)
      case 318 => Card(318, "", Some(TottenhamHotspur), BaseCard)
      case 319 => Card(319, "", Some(TottenhamHotspur), BaseCard)
      case 320 => Card(320, "", Some(TottenhamHotspur), BaseCard)
      case 321 => Card(321, "", Some(TottenhamHotspur), BaseCard)
      case 322 => Card(322, "", Some(TottenhamHotspur), BaseCard)
      case 323 => Card(323, "", Some(TottenhamHotspur), BaseCard)
      case 324 => Card(324, "", Some(TottenhamHotspur), BaseCard)
      case 325 => Card(325, "", Some(TottenhamHotspur), BaseCard)
      case 326 => Card(326, "", Some(TottenhamHotspur), BaseCard)
      case 327 => Card(327, "", Some(TottenhamHotspur), BaseCard)
      case 328 => Card(328, "", Some(TottenhamHotspur), BaseCard)
      case 329 => Card(329, "", Some(TottenhamHotspur), BaseCard)
      case 330 => Card(330, "", Some(TottenhamHotspur), BaseCard)
      case 331 => Card(331, "", Some(TottenhamHotspur), BaseCard)
      case 332 => Card(332, "", Some(TottenhamHotspur), BaseCard)
      case 333 => Card(333, "Line-up card", Some(TottenhamHotspur), LineupCard)

      // West Ham United
      case 334 => Card(334, "Club Crest", Some(WestHamUnited), ClubCrest)
      case 335 => Card(335, "", Some(WestHamUnited), BaseCard)
      case 336 => Card(336, "", Some(WestHamUnited), BaseCard)
      case 337 => Card(337, "", Some(WestHamUnited), BaseCard)
      case 338 => Card(338, "", Some(WestHamUnited), BaseCard)
      case 339 => Card(339, "", Some(WestHamUnited), BaseCard)
      case 340 => Card(340, "", Some(WestHamUnited), BaseCard)
      case 341 => Card(341, "", Some(WestHamUnited), BaseCard)
      case 342 => Card(342, "", Some(WestHamUnited), BaseCard)
      case 343 => Card(343, "", Some(WestHamUnited), BaseCard)
      case 344 => Card(344, "", Some(WestHamUnited), BaseCard)
      case 345 => Card(345, "", Some(WestHamUnited), BaseCard)
      case 346 => Card(346, "", Some(WestHamUnited), BaseCard)
      case 347 => Card(347, "", Some(WestHamUnited), BaseCard)
      case 348 => Card(348, "", Some(WestHamUnited), BaseCard)
      case 349 => Card(349, "", Some(WestHamUnited), BaseCard)
      case 350 => Card(350, "", Some(WestHamUnited), BaseCard)
      case 351 => Card(351, "Line-up card", Some(WestHamUnited), LineupCard)

      // Wolves
      case 352 => Card(352, "Club Crest", Some(Wolves), ClubCrest)
      case 353 => Card(353, "", Some(Wolves), BaseCard)
      case 354 => Card(354, "", Some(Wolves), BaseCard)
      case 355 => Card(355, "", Some(Wolves), BaseCard)
      case 356 => Card(356, "", Some(Wolves), BaseCard)
      case 357 => Card(357, "", Some(Wolves), BaseCard)
      case 358 => Card(358, "", Some(Wolves), BaseCard)
      case 359 => Card(359, "", Some(Wolves), BaseCard)
      case 360 => Card(360, "", Some(Wolves), BaseCard)
      case 361 => Card(361, "", Some(Wolves), BaseCard)
      case 362 => Card(362, "", Some(Wolves), BaseCard)
      case 363 => Card(363, "", Some(Wolves), BaseCard)
      case 364 => Card(364, "", Some(Wolves), BaseCard)
      case 365 => Card(365, "", Some(Wolves), BaseCard)
      case 366 => Card(366, "", Some(Wolves), BaseCard)
      case 367 => Card(367, "", Some(Wolves), BaseCard)
      case 368 => Card(368, "", Some(Wolves), BaseCard)
      case 369 => Card(369, "Line-up card", Some(Wolves), LineupCard)

      // Top Keeper
      case 370 => Card(370, "", Some(Bournemouth), TopKeeper)
      case 371 => Card(371, "", Some(AstonVilla), TopKeeper)
      case 372 => Card(372, "", Some(Everton), TopKeeper)
      case 373 => Card(373, "", Some(Fulham), TopKeeper)
      case 374 => Card(374, "", Some(ManchesterCity), TopKeeper)
      case 375 => Card(375, "", Some(Wolves), TopKeeper)

      // Aerial Ace
      case 376 => Card(376, "", Some(Brentford), AerialAce)
      case 377 => Card(377, "", Some(SheffieldUnited), AerialAce)
      case 378 => Card(378, "", Some(WestHamUnited), AerialAce)

      // Precision
      case 379 => Card(379, "", Some(Burnley), Precision)
      case 380 => Card(380, "", Some(Chelsea), Precision)
      case 381 => Card(381, "", Some(Everton), Precision)
      case 382 => Card(382, "", Some(Fulham), Precision)
      case 383 => Card(383, "", Some(Liverpool), Precision)
      case 384 => Card(384, "", Some(ManchesterUnited), Precision)
      case 385 => Card(385, "", Some(TottenhamHotspur), Precision)
      case 386 => Card(386, "", Some(WestHamUnited), Precision)
      case 387 => Card(387, "", Some(Wolves), Precision)

      // Powerhouse
      case 388 => Card(388, "", Some(AstonVilla), Powerhouse)
      case 389 => Card(389, "", Some(Brentford), Powerhouse)
      case 390 => Card(390, "", Some(Brighton), Powerhouse)
      case 391 => Card(391, "", Some(Chelsea), Powerhouse)
      case 392 => Card(392, "", Some(CrystalPalace), Powerhouse)
      case 393 => Card(393, "", Some(LutonTown), Powerhouse)
      case 394 => Card(394, "", Some(NottinghamForest), Powerhouse)
      case 395 => Card(395, "", Some(SheffieldUnited), Powerhouse)
      case 396 => Card(396, "", Some(Wolves), Powerhouse)

      // Colossus
      case 397 => Card(397, "", Some(Bournemouth), Colossus)
      case 398 => Card(398, "", Some(Arsenal), Colossus)
      case 399 => Card(399, "", Some(Chelsea), Colossus)
      case 400 => Card(400, "", Some(Everton), Colossus)
      case 401 => Card(401, "", Some(LutonTown), Colossus)
      case 402 => Card(402, "", Some(ManchesterCity), Colossus)
      case 403 => Card(403, "", Some(NewcastleUnited), Colossus)
      case 404 => Card(404, "", Some(TottenhamHotspur), Colossus)
      case 405 => Card(405, "", Some(WestHamUnited), Colossus)

      // Fire
      case 406 => Card(406, "", Some(Burnley), Fire)
      case 407 => Card(407, "", Some(ManchesterUnited), Fire)
      case 408 => Card(408, "", Some(NewcastleUnited), Fire)
      case 409 => Card(409, "", Some(TottenhamHotspur), Fire)
      case 410 => Card(410, "", Some(Wolves), Fire)

      // Ice
      case 411 => Card(411, "Zinchenko", Some(Arsenal), Ice)
      case 412 => Card(412, "Silva", Some(Chelsea), Ice)
      case 413 => Card(413, "Grealish", Some(ManchesterCity), Ice)
      case 414 => Card(414, "Son", Some(TottenhamHotspur), Ice)

      // Playmaker
      case 415 => Card(415, "Jorginho", Some(Arsenal), Playmaker)
      case 416 => Card(416, "", Some(AstonVilla), Playmaker)
      case 417 => Card(417, "", Some(Brighton), Playmaker)
      case 418 => Card(418, "", Some(Chelsea), Playmaker)
      case 419 => Card(419, "", Some(Liverpool), Playmaker)
      case 420 => Card(420, "", Some(ManchesterCity), Playmaker)
      case 421 => Card(421, "", Some(ManchesterUnited), Playmaker)
      case 422 => Card(422, "", Some(NottinghamForest), Playmaker)
      case 423 => Card(423, "Paqueta", Some(WestHamUnited), Playmaker)

      // Future Star
      case 424 => Card(424, "", Some(Brighton), FutureStar)
      case 425 => Card(425, "", Some(ManchesterCity), FutureStar)
      case 426 => Card(426, "", Some(ManchesterUnited), FutureStar)

      // Adrenalyn Rush
      case 427 => Card(427, "", Some(Bournemouth), AdrenalynRush)
      case 428 => Card(428, "", Some(Brentford), AdrenalynRush)
      case 429 => Card(429, "", Some(CrystalPalace), AdrenalynRush)
      case 430 => Card(430, "", Some(Fulham), AdrenalynRush)
      case 431 => Card(431, "", Some(SheffieldUnited), AdrenalynRush)
      case 432 => Card(432, "", Some(WestHamUnited), AdrenalynRush)

      // Next level
      case 433 => Card(433, "Odegaard", Some(Arsenal), NextLevel)
      case 434 => Card(434, "Van Dijk", Some(Liverpool), NextLevel)
      case 435 => Card(435, "Foden", Some(ManchesterCity), NextLevel)

      // Ultrasonic
      case 436 => Card(436, "", Some(AstonVilla), Ultrasonic)
      case 437 => Card(437, "", Some(Brentford), Ultrasonic)
      case 438 => Card(438, "", Some(Brighton), Ultrasonic)
      case 439 => Card(439, "", Some(Chelsea), Ultrasonic)
      case 440 => Card(440, "", Some(Fulham), Ultrasonic)
      case 441 => Card(441, "", Some(Liverpool), Ultrasonic)

      // World class
      case 442 => Card(442, "Zabarnyi", Some(Bournemouth), WorldClass)
      case 443 => Card(443, "", Some(Burnley), WorldClass)
      case 444 => Card(444, "", Some(CrystalPalace), WorldClass)
      case 445 => Card(445, "", Some(Everton), WorldClass)
      case 446 => Card(446, "", Some(ManchesterUnited), WorldClass)
      case 447 => Card(447, "", Some(NottinghamForest), WorldClass)
      case 448 => Card(448, "", Some(SheffieldUnited), WorldClass)
      case 449 => Card(449, "", Some(TottenhamHotspur), WorldClass)
      case 450 => Card(450, "Hwang", Some(Wolves), WorldClass)

      // Game changer
      case 451 => Card(451, "Solanke", Some(Bournemouth), GameChanger)
      case 452 => Card(452, "", Some(Arsenal), GameChanger)
      case 453 => Card(453, "", Some(Brighton), GameChanger)
      case 454 => Card(454, "", Some(Burnley), GameChanger)
      case 455 => Card(455, "", Some(CrystalPalace), GameChanger)
      case 456 => Card(456, "", Some(Everton), GameChanger)
      case 457 => Card(457, "", Some(NewcastleUnited), GameChanger)
      case 458 => Card(458, "", Some(NottinghamForest), GameChanger)
      case 459 => Card(459, "Bowen", Some(WestHamUnited), GameChanger)

      // Dynamo
      case 460 => Card(460, "Brownhill", Some(Burnley), Dynamo)
      case 461 => Card(461, "Palhinha", Some(Fulham), Dynamo)
      case 462 => Card(462, "Clark", Some(LutonTown), Dynamo)
      case 463 => Card(463, "Joelinton", Some(NewcastleUnited), Dynamo)

      // Hotshot
      case 464 => Card(464, "Ferguson", Some(Brighton), HotShot)
      case 465 => Card(465, "Salah", Some(Liverpool), HotShot)
      case 466 => Card(466, "Morris", Some(LutonTown), HotShot)
      case 467 => Card(467, "Wilson", Some(NewcastleUnited), HotShot)

      // Trophy
      case 468 => Card(468, "Trophy", None, Trophy)
    }
  }

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
  private val dynamoRange: IndexedSeq[Int] = 460 to 463
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




