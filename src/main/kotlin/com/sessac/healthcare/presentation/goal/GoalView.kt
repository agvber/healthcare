package com.sessac.healthcare.presentation.goal

import com.sessac.healthcare.data.model.UserDataModel
import com.sessac.healthcare.presentation.goal.constants.GoalStringResource as Res
import com.sessac.healthcare.presentation.home.model.TreeGrowthStage

object GoalView {
    fun printGoalDefaultMessage(user: UserDataModel) {
        println(Res.GOAL_HEADER.format(user.nickname))
    }

    fun printUserTree(tree: TreeGrowthStage) {
        println(Res.TREE_STAGE.format(tree.tree, tree.stage))
    }

    fun printGoal(user: UserDataModel) {
        println(Res.GOAL_TOTAL.format(user.goalDistance))
        println(Res.GOAL_WEEKLY.format(user.weeklyGoalDistance))
        println(Res.GOAL_DAILY.format(user.dailyGoalDistance))
    }

    fun printRemainingBMIDistance(distance: Long) {
        println(Res.REMAINING_BMI_DISTANCE.format(distance))
        println(Res.SEPARATOR)
    }

    fun askWantToInsertGoal(): String {
        println(Res.WANT_TO_INSERT_GOAL)
        println(Res.GOAL_INSERT_OPTION)
        println(Res.GO_BACK_OPTION)
        print(Res.SELECTION_PROMPT)
        return readLine() ?: ""
    }

    fun askGoalDistance(): String {
        println(Res.SEPARATOR2)
        println(Res.SELECT_TOTAL_GOAL)
        println(Res.SELECT_WEEKLY_GOAL)
        println(Res.SELECT_DAILY_GOAL)
        print(Res.SELECTION_PROMPT)

        return readLine() ?: ""
    }

    fun printInvalidInputMessage() {
        println(Res.INVALID_INPUT)
    }

    fun inputTotalGoalDistance(): String {
        println(Res.INPUT_TOTAL_GOAL_GUIDE)
        println(Res.INPUT_TOTAL_EX)
        print(Res.INPUT_PROMPT)
        return readLine() ?: ""
    }

    fun inputWeeklyGoalDistance(): String {
        println(Res.INPUT_WEEKLY_GOAL_GUIDE)
        println(Res.INPUT_WEEKLY_EX)
        print(Res.INPUT_PROMPT)
        return readLine() ?: ""
    }

    fun inputDailyGoalDistance(): String {
        println(Res.INPUT_DAILY_GOAL_GUIDE)
        println(Res.INPUT_DAILY_EX)
        print(Res.INPUT_PROMPT)
        return readLine() ?: ""
    }

    fun printUpdateGoal() {
        println(Res.GOAL_UPDATE_SUCCESS)
    }

}