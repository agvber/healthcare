package com.sessac.healthcare.presentation.goal

import com.sessac.healthcare.data.model.UserDataModel
import com.sessac.healthcare.presentation.home.model.TreeGrowthStage

object GoalView {
    fun printGoalDefaultMessage(user: UserDataModel) {
        println("\n========${user.nickname}님의 운동 목표\n==========")
    }

    fun printUserTree(tree: TreeGrowthStage) {
        println(tree.tree)
        println("목표 달성으로 자라는 트리입니다. 현재 <<${tree.stage}>> 단계입니다.")
    }

    fun printGoal(user: UserDataModel) {
        println("\n- 총 목표 거리: ${user.goalDistance}")
        println("- 주간 목표 거리: ${user.weeklyGoalDistance}")
        println("- 일간 목표 거리: ${user.dailyGoalDistance}")
    }

    fun printRemainingBMIDistance(distance: Long) {
        println("BMI를 바탕으로 측정된 목표까지 ${distance}m 남았습니다.\n")
        println("==================================")
    }

    fun askWantToInsertGoal(): String {
        println("\n목표를 기록하시겠습니까?")
        println("1. 목표 기록하기")
        println("0. 이전 화면으로")
        println("\n==================================")
        print("선택):  ")
        return readLine() ?: ""
    }

    fun askGoalDistance(): String {
        println("\n==================================")
        println("1. 총 목표 기록하기")
        println("2. 주간 목표 기록하기")
        println("3. 일간 목표 기록하기")
        println("\n==================================")
        print("선택):  ")
        return readLine() ?: ""
    }

    fun printInvalidInputMessage() {
        println("잘못된 입력값입니다.")
    }

    fun inputTotalGoalDistance(): String {
        println("\n새로운 총 목표를 입력해 주세요.")
        println("(예시: 150000 (단위는 m입니다.))")
        print("입력): ")
        return readLine() ?: ""
    }

    fun inputWeeklyGoalDistance(): String {
        println("\n새로운 주간 목표를 입력해 주세요.")
        println("(예시: 10000 (단위는 m입니다.))")
        print("입력): ")
        return readLine() ?: ""
    }

    fun inputDailyGoalDistance(): String {
        println("\n새로운 일간 목표를 입력해 주세요.")
        println("(예시: 3000 (단위는 m입니다.))")
        print("입력): ")
        return readLine() ?: ""
    }

    fun printUpdateGoal() {
        println("\n==================================")
        println("목표가 기록되었습니다.")
    }

}