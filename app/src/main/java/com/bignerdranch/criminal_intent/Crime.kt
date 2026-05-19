package com.bignerdranch.criminal_intent

import java.util.UUID
import java.util.Date

class Crime{
    val id: UUID=UUID.randomUUID()
    var title: String=""
    var date: Date=Date()
    var isSolved: Boolean = false
    var isLanguageSelected: Boolean = false
}