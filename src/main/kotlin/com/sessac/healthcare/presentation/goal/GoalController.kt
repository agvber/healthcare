package com.sessac.healthcare.presentation.goal

import com.sessac.healthcare.data.datasource.impl.UserDataSourceImpl
import com.sessac.healthcare.data.model.NewHistoryDataModel
import com.sessac.healthcare.data.model.NewUserDataModel
import com.sessac.healthcare.presentation.common.ViewController

class GoalController(private val user: NewUserDataModel, private val userRecords: List<NewHistoryDataModel>) : ViewController {
    private lateinit var goalView: GoalView
    private lateinit var goalMapper: GoalMapper
    private lateinit var presentationModel: GoalPresentationModel

    override fun run() {
        goalMapper = GoalMapper()
        presentationModel = goalMapper.dataModelToPresentation(user, userRecords)
        goalView = GoalView()
        showGoalScreen()
        handleUserInput()
    }

    private fun showGoalScreen() {
        goalView.printGoalDefaultMessage(user)
        goalView.printUserTree(presentationModel.tree)
        goalView.printGoal(user)
        goalView.printRemainingBMIDistance(presentationModel.remainingBMIDistance)
    }

    private fun handleUserInput() {
        when (goalView.askWantToInsertGoal()) {
            "1" -> handleGoalInsertion()
            "2" -> return // 이전 화면으로 이동
            else -> goalView.printInvalidInputMessage()
        }
    }

    private fun handleGoalInsertion() {
        when (goalView.askGoalDistance()) {
            "1" -> insertTotalGoalDistance()
            "2" -> insertWeeklyGoalDistance()
            "3" -> insertDailyGoalDistance()
            else -> goalView.printInvalidInputMessage()
        }
    }

    private fun insertTotalGoalDistance() {
        val goalInput = goalView.inputTotalGoalDistance()
        val updatedUser = user.copy(goalDistance = goalInput.toLong())
        UserDataSourceImpl.updateUser(updatedUser)
        goalView.printUpdateGoal()
        goalView.printGoal(updatedUser)
    }

    private fun insertWeeklyGoalDistance() {
        val goalInput = goalView.inputWeeklyGoalDistance()
        val updatedUser = user.copy(weeklyGoalDistance = goalInput.toLong())
        UserDataSourceImpl.updateUser(updatedUser)
        goalView.printUpdateGoal()
        goalView.printGoal(updatedUser)
    }

    private fun insertDailyGoalDistance() {
        val goalInput = goalView.inputDailyGoalDistance()
        val updatedUser = user.copy(dailyGoalDistance = goalInput.toLong())
        UserDataSourceImpl.updateUser(updatedUser)
        goalView.printUpdateGoal()
        goalView.printGoal(updatedUser)
    }
}