package com.sessac.healthcare.presentation.home.model

/**
 * @property SPROUT 새싹 1단계
 * @property SAPLING 어린 2단계
 * @property MATURE_TREE 성숙한 3단계
 * @property FULL_TREE 완전한 4단계
 */

enum class TreeGrowthStage(val tree:String) {
    SPROUT("""
           *
           |
        """.trimIndent()),
    SAPLING("""
          *
         ***
          |
        """.trimIndent()),
    MATURE_TREE("""
           *
          ***
         *****
        *******
           |
        """.trimIndent()),
    FULL_TREE("""
            *
           ***
          *****
         *******
        *********
       ***********
            |
        """.trimIndent())
}