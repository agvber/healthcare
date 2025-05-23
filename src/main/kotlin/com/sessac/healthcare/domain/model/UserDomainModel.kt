package com.sessac.healthcare.domain.model

data class UserDomainModel(
    val nickname: String,
    val weight: Float,
    val height: Float,
    val bmi: Float,
)