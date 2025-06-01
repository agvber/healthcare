package com.sessac.healthcare.presentation.userprofile.ui

import com.sessac.healthcare.presentation.userprofile.model.UserProfileUIModel
import com.sessac.healthcare.presentation.userprofile.ui.UserProfileStringResource as Res

object UserProfileView {

    fun displayUserInfo(model: UserProfileUIModel) {
        println(Res.USER_INFO_HEADER)
        println()
        println("\t\t ${Res.USER_NAME_LABEL}  : ${model.nickName}")
        println("\t\t ${Res.USER_HEIGHT_LABEL} : %.1f${Res.CM_UNIT}".format(model.height))
        println("\t\t ${Res.USER_WEIGHT_LABEL} : %.1f${Res.KG_UNIT}".format(model.weight))
        println()
    }

    fun displayEditMenu(): String {
        println(Res.EDIT_MENU_HEADER)
        println(Res.EDIT_MENU_NAME)
        println(Res.EDIT_MENU_HEIGHT)
        println(Res.EDIT_MENU_WEIGHT)
        println(Res.EDIT_MENU_BACK)
        print(Res.EDIT_MENU_PROMPT)
        return readln()
    }

    fun inputNewValue(field: String): String {
        print(Res.INPUT_NEW_VALUE_PROMPT.format(field))
        return readln()
    }

    fun displayUpdateSuccess(field: String) {
        println(Res.UPDATE_SUCCESS.format(field))
    }

    fun displayUpdateFailure(field: String) {
        println(Res.UPDATE_FAILURE.format(field))
    }

    fun displayWrongInput() {
        println(Res.WRONG_INPUT)
    }

    fun displaySaveUserInfo(model: UserProfileUIModel) {
        println(Res.SAVE_USER_INFO.format(model))
    }
}