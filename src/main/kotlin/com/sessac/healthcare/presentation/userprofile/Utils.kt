package com.sessac.healthcare.presentation.userprofile

import com.sessac.healthcare.presentation.userprofile.ui.UserProfileView

inline fun <T> editField(
    fieldName: String,
    inputTransform: (String) -> T?,
    applyChange: (T) -> Unit,
) {
    UserProfileView.inputNewValue(fieldName)
        .trim()
        .let(inputTransform)
        ?.also { applyChange(it) }
        ?.let { UserProfileView.displayUpdateSuccess(fieldName) }
        ?: UserProfileView.displayUpdateFailure(fieldName)
}

const val NICKNAME_EDIT_NUMBER = "1"
const val HEIGHT_EDIT_NUMBER = "2"
const val WEIGHT_EDIT_NUMBER = "3"
const val EXIT_NUMBER = "0"