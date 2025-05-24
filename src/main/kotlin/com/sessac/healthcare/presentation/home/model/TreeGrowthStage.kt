package com.sessac.healthcare.presentation.home.model

/**
 * @property SPROUT 새싹 1단계
 * @property SAPLING 어린 2단계
 * @property MATURE_TREE 성숙한 3단계
 * @property FULL_TREE 완전한 4단계
 */

enum class TreeGrowthStage(val tree:String, val stage: String) {
    SPROUT("""
           *
           |
        """.trimIndent(), "새싹"),
    SAPLING("""
          *
         ***
          |
        """.trimIndent(), "어린 나무"),
    MATURE_TREE("""
           *
          ***
         *****
        *******
           |
        """.trimIndent(), "성숙한 나무"),
    FULL_TREE("""
            *
           ***
          *****
         *******
        *********
       ***********
            |
        """.trimIndent(), "세계수")
}