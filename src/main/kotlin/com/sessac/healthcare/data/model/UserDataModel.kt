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

/**
 * 수정해야할 것
 * 유저가 작성한 목표 거리랑 기본 목표 거리를 구별해야해서 기본 목표거리 추가해야함.
 * 로그인할 때 id랑 PK id 구별해야함.
 */

data class UserDataModel(
    val id: Long,
    val nickname: String,
    val height: Int,
    val weight: Int,
    val goalDistance: Long,
)
