package com.sessac.healthcare.common.anontation

@RequiresOptIn(
    message = "해당 기능은 불안정한 기능이며, 변경되거나 삭제될 가능성이 존재합니다.",
    level = RequiresOptIn.Level.ERROR
)
annotation class ExperimentalFeatureApi