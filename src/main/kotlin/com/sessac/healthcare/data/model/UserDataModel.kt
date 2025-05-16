package com.sessac.healthcare.data.model

/**
 * User data model
 *
 * @property id
 * @property nickname
 * @property height
 * @property weight
 * @property goalDistance 목표 거리 m단위
 * @constructor Create empty User data model
 */

data class UserDataModel(
    val id: Long,
    val nickname: String,
    val height: Int,
    val weight: Int,
    val goalDistance: Long
)
