package com.sessac.healthcare.presentation.userprofile.ui

import com.sessac.healthcare.presentation.userprofile.model.UserProfileUIModel

object UserProfileView {

    fun displayUserInfo(model: UserProfileUIModel) {
        println("============= 사용자 정보 =============")
        println()
        println("\t\t 사용자 이름  : ${model.nickName}")
        println("\t\t 키         : ${model.height}cm")
        println("\t\t 체중        : ${model.weight}kg")
        println()
    }

    fun displayEditMenu(): String {
        println("======= 사용자 정보 수정 메뉴 =======")
        println("1. 이름 수정")
        println("2. 키 수정")
        println("3. 체중 수정")
        println("0. 뒤로가기")
        print("원하는 작업 번호를 입력하세요: ")
        return readln()
    }

    fun inputNewValue(field: String): String {
        print("새로운 $field 입력: ")
        return readln()
    }

    fun displayUpdateSuccess(field: String) {
        println("${field}(이)가 성공적으로 수정되었습니다.")
    }

    fun displayUpdateFailure(field: String, reason: String) {
        println("$field 수정에 실패했습니다. 이유: $reason")
    }
}